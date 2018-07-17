/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dto.NastavnikDTO;
import dto.TitulaDTO;
import dto.ZvanjeDTO;
import hibernate.HibernateUtil;
import java.time.LocalDate;
import java.util.List;
import model.Nastavnik;
import model.Titula;
import model.TitulaNastavnika;
import model.Zvanje;
import model.ZvanjeNastavnika;
import org.hibernate.Session;
import org.hibernate.type.IntegerType;
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

                if (now.isBefore(datumPoslednjegZvanja) || now.isEqual(datumPoslednjegZvanja)) {
                    throw new Exception("Датум новог звања мора бити после датума последњег звања");
                }
            }

            List<ZvanjeNastavnika> istaZvanjaNastavnika = session.createQuery("from ZvanjeNastavnika zn WHERE zn.nastavnikID = :nastavnikId AND zn.zvanjeID = :zvanjeId", ZvanjeNastavnika.class)
                    .setParameter("nastavnikId", nastavnik.getId(), IntegerType.INSTANCE)
                    .setParameter("zvanjeId", zvanje.getId(), IntegerType.INSTANCE)
                    .getResultList();

            if (!istaZvanjaNastavnika.isEmpty()) {
                throw new Exception("Наставник већ има изабрано звање");
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
            throw new Exception("Дошло је до грешке приликом чувања звања наставника");
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Nastavnik dodajTituluNastavniku(Integer nastavnikId, TitulaDTO titulaDTO) throws Exception {
        try {
            Validator.validate(titulaDTO);

            if (nastavnikId <= 0) {
                throw new Exception("Идентификациони број наставника није валидан");
            }

            if (titulaDTO.getId() == null || titulaDTO.getId() <= 0) {
                throw new Exception("Изаберите титулу");
            }

            Nastavnik nastavnik = session.get(Nastavnik.class, nastavnikId);

            if (nastavnik == null) {
                throw new Exception("Наставник са идентификационим бројем " + nastavnikId + " не постоји");
            }

            Titula titula = session.get(Titula.class, titulaDTO.getId());
            if (titula == null) {
                throw new Exception("Титула са идентификационим бројем " + titulaDTO.getId() + " не постоји");
            }

            LocalDate now = LocalDate.now();

            if (!nastavnik.getTituleNastavnika().isEmpty()) {
                LocalDate datumPoslednjeTitule = nastavnik.getTituleNastavnika().iterator().next().getDatumOd();

                if (now.isBefore(datumPoslednjeTitule) || now.isEqual(datumPoslednjeTitule)) {
                    throw new Exception("Датум нове титуле мора бити после датума последње");
                }
            }

            List<TitulaNastavnika> isteTituleNastavnika = session.createQuery("from TitulaNastavnika tn WHERE tn.nastavnikID = :nastavnikId AND tn.titulaID = :titulaId", TitulaNastavnika.class)
                    .setParameter("nastavnikId", nastavnik.getId(), IntegerType.INSTANCE)
                    .setParameter("titulaId", titula.getId(), IntegerType.INSTANCE)
                    .getResultList();

            if (!isteTituleNastavnika.isEmpty()) {
                throw new Exception("Наставник већ има изабрану титулу");
            }

            nastavnik.getZvanjaNastavnika().isEmpty();

            TitulaNastavnika titulaNastavnika = new TitulaNastavnika();
            titulaNastavnika.setDatumOd(now);
            titulaNastavnika.setNastavnikID(nastavnik.getId());
            titulaNastavnika.setTitulaID(titula.getId());

            session.getTransaction().begin();
            session.save(titulaNastavnika);
            session.getTransaction().commit();

            return nastavnik;
        } catch (RuntimeException rtex) {
            session.getTransaction().rollback();
            throw new Exception("Дошло је до грешке приликом чувања титуле наставника");
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

}
