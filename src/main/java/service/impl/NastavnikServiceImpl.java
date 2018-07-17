/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dto.NastavnikDTO;
import dto.ZvanjeDTO;
import hibernate.HibernateUtil;
import java.time.LocalDate;
import java.util.List;
import model.Nastavnik;
import model.Zvanje;
import model.ZvanjeNastavnika;
import org.hibernate.Session;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import service.INastavnikService;
import validator.Validator;

/**
 *
 * @author edis
 */
@Service
@RequestScope
public class NastavnikServiceImpl implements INastavnikService {

    private Session session;

    public NastavnikServiceImpl() {
        session = HibernateUtil.getInstance().getNewSession();
    }

    @Override
    public List<Nastavnik> loadAll() throws Exception {
        try {
            List<Nastavnik> nastavnici = session.createNamedQuery("Nastavnik.LoadAll").getResultList();
            return nastavnici;
        } catch (Exception e) {
            throw new Exception("Грешка приликом учитавања наставника");
        }
    }

    @Override
    public Nastavnik getById(Integer id) throws Exception {
        try {
            Nastavnik nastavnik = session.get(Nastavnik.class, id);
            if (nastavnik == null) {
                throw new Exception("Наставник са идентификационим бројем " + id + " не постоји.");
            }
            return nastavnik;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Nastavnik save(NastavnikDTO nastavnikDTO) throws Exception {
        try {
            Validator.validate(nastavnikDTO);

            List<Nastavnik> nastavniciSaBrojemRadneKnjizice
                    = session.createNamedQuery("Nastavnik.LoadByBrojRadneKnjizice", Nastavnik.class)
                            .setParameter("brojRadneKnjizice", nastavnikDTO.getBrojRadneKnjizice(), StringType.INSTANCE)
                            .getResultList();

            if (!nastavniciSaBrojemRadneKnjizice.isEmpty()) {
                throw new Exception("Наставник са бројем радне књижице " + nastavnikDTO.getBrojRadneKnjizice() + " већ постоји");
            }

            Nastavnik nastavnik = new Nastavnik();
            nastavnik.setIme(nastavnikDTO.getIme());
            nastavnik.setPrezime(nastavnikDTO.getPrezime());
            nastavnik.setBrojRadneKnjizice(nastavnikDTO.getBrojRadneKnjizice());

            session.getTransaction().begin();
            session.save(nastavnik);
            session.getTransaction().commit();

            return nastavnik;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Nastavnik dodajZvanjeNastavniku(Integer nastavnikId, ZvanjeDTO zvanjeDTO) throws Exception {
        try {
            Validator.validate(zvanjeDTO);

            if (nastavnikId <= 0) {
                throw new Exception("Идентификациони број наставника није валидан");
            }

            if (zvanjeDTO.getId() == null || zvanjeDTO.getId() <= 0) {
                throw new Exception("Изаберите звање");
            }

            Nastavnik nastavnik = session.get(Nastavnik.class, nastavnikId);

            if (nastavnik == null) {
                throw new Exception("Наставник са идентификационим бројем " + nastavnikId + " не постоји");
            }

            Zvanje zvanje = session.get(Zvanje.class, zvanjeDTO.getId());
            if (zvanje == null) {
                throw new Exception("Звање са идентификационим бројем " + zvanjeDTO.getId() + " не постоји");
            }

            LocalDate now = LocalDate.now();

            if (!nastavnik.getZvanjaNastavnika().isEmpty()) {
                LocalDate datumPoslednjegZvanja = nastavnik.getZvanjaNastavnika().iterator().next().getDatumOd();

                if (now.isBefore(datumPoslednjegZvanja)) {
                    throw new Exception("Датум новог звања мора бити после датума последњег звања");
                }
            }

            nastavnik.getTituleNastavnika().isEmpty();

            ZvanjeNastavnika zvanjeNastavnika = new ZvanjeNastavnika();
            zvanjeNastavnika.setDatumOd(now);
            zvanjeNastavnika.setNastavnikID(nastavnik.getId());
            zvanjeNastavnika.setZvanjeID(zvanje.getId());

            session.getTransaction().begin();
            session.save(zvanjeNastavnika);
            session.getTransaction().commit();

            return nastavnik;
        } catch (RuntimeException rtex) {
            session.getTransaction().rollback();
            throw new Exception("Наставник већ има изабрано звање");
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

}
