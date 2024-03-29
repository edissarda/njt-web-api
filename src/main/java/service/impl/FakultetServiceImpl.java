/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dto.FakultetDTO;
import hibernate.HibernateUtil;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import model.Fakultet;
import model.NaucnaOblast;
import model.PodatakOFakultetu;
import model.PravnaForma;
import model.Rukovodilac;
import model.TipPodatkaOFakultetu;
import model.VrstaOrganizacije;
import org.hibernate.Session;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import service.IFakultetService;
import validator.Validator;

/**
 *
 * @author edis
 */
@Service
@RequestScope
public class FakultetServiceImpl implements IFakultetService {

    private Session session;

    public FakultetServiceImpl() {
        session = HibernateUtil.getInstance().getNewSession();
    }

    @Override
    public List<Fakultet> loadAll() throws Exception {
        try {
            List<Fakultet> fakulteti = session.createNamedQuery("Fakultet.LoadAll").getResultList();
            return fakulteti;
        } catch (Exception e) {
            throw new Exception("Грешка приликом учитавања факултета.");
        } finally {
            session.close();
        }
    }

    @Override
    public List<Rukovodilac> ucitajRukovodioceZaFakultet(Integer fakultetID, boolean samoAktivni) throws Exception {
        try {
            if (samoAktivni) {
                session.enableFilter("filterAktivniRukovodioci").setParameter("tekuciDatum", new Date());
            }

            Fakultet fakultet = null;
            try {
                fakultet = session.get(Fakultet.class, fakultetID);
            } catch (Exception e) {
                throw new Exception("Грешка при конекцији");
            }
            if (fakultet == null) {
                throw new Exception("Факултет са идентификационим бројем " + fakultetID + " не постоји");
            }

            fakultet.getRukovodioci().size();
            List<Rukovodilac> rukovodioci = fakultet.getRukovodioci();

            return rukovodioci;
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Fakultet loadById(Integer id) throws Exception {
        try {
            Fakultet f = session.get(Fakultet.class, id);
            if (f == null) {
                throw new Exception("Факултет не постоји");
            }
            return f;
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Fakultet create(FakultetDTO fakultetDTO) throws Exception {
        try {
            Validator.validate(fakultetDTO);

            if (fakultetDTO.getVrstaOrganizacije().getId() == null) {
                throw new Exception("Изаберите врсту организације");
            }

            if (fakultetDTO.getPravnaForma().getId() == null) {
                throw new Exception("Изаберите правну форму");
            }

            if (fakultetDTO.getNaucnaOblast().getId() == null) {
                throw new Exception("Изаберите научну област");
            }

            List<Fakultet> fakultetiSaMaticnimBrojem = session.createNamedQuery("Fakultet.FindByMaticniBroj", Fakultet.class)
                    .setParameter("maticniBroj", fakultetDTO.getMaticniBroj(), StringType.INSTANCE)
                    .getResultList();
            if (!fakultetiSaMaticnimBrojem.isEmpty()) {
                throw new Exception("факултет са матичним бројем " + fakultetDTO.getMaticniBroj() + " већ постоји");
            }

            List<Fakultet> fakultetiSaPoreskimBrojem = session.createNamedQuery("Fakultet.FindByPoreskiBroj", Fakultet.class)
                    .setParameter("poreskiBroj", fakultetDTO.getPoreskiBroj(), StringType.INSTANCE)
                    .getResultList();
            if (!fakultetiSaPoreskimBrojem.isEmpty()) {
                throw new Exception("Факултет са пореским бројем " + fakultetDTO.getMaticniBroj() + " већ постоји");
            }

            List<Fakultet> fakultetiSaNazivom = session.createNamedQuery("Fakultet.FindByNaziv", Fakultet.class)
                    .setParameter("naziv", fakultetDTO.getNaziv(), StringType.INSTANCE)
                    .getResultList();
            if (!fakultetiSaNazivom.isEmpty()) {
                throw new Exception("Факултет са називом " + fakultetDTO.getNaziv() + " већ постоји");
            }

            VrstaOrganizacije vrstaOrganizacije = session.get(VrstaOrganizacije.class, fakultetDTO.getVrstaOrganizacije().getId());
            if (vrstaOrganizacije == null) {
                throw new Exception("Врста организације коју сте изабрали не постоји");
            }

            PravnaForma pravnaForma = session.get(PravnaForma.class, fakultetDTO.getPravnaForma().getId());
            if (pravnaForma == null) {
                throw new Exception("Правна форма коју сте изабрали не постоји");
            }

            NaucnaOblast naucnaOblast = session.get(NaucnaOblast.class, fakultetDTO.getNaucnaOblast().getId());
            if (naucnaOblast == null) {
                throw new Exception("Научна област коју сте изабрали не постоји");
            }

            Fakultet fakultet = new Fakultet();
            fakultet.setNaziv(fakultetDTO.getNaziv());
            fakultet.setMaticniBroj(fakultetDTO.getMaticniBroj());
            fakultet.setPoreskiBroj(fakultetDTO.getPoreskiBroj());
            fakultet.setOpis(fakultetDTO.getOpis());
            fakultet.setVrstaOrganizacije(vrstaOrganizacije);
            fakultet.setPravnaForma(pravnaForma);
            fakultet.setNaucnaOblast(naucnaOblast);

            List<PodatakOFakultetu> podaciOFakultetu = fakultetDTO.getPodaci().stream().map(p -> new PodatakOFakultetu(p)).collect(Collectors.toList());

            for (PodatakOFakultetu podatakOFakultetu : podaciOFakultetu) {
                TipPodatkaOFakultetu tipPodatka = session.get(TipPodatkaOFakultetu.class, podatakOFakultetu.getTipPodatka().getId());
                if (tipPodatka == null) {
                    throw new Exception("Тип податка " + podatakOFakultetu.getTipPodatka().getNaziv() + " не постоји.");
                }

                podatakOFakultetu.setTipPodatka(tipPodatka);
                podatakOFakultetu.setFakultet(fakultet);
            }

            fakultet.setPodaci(podaciOFakultetu);

            session.getTransaction().begin();
            Integer id = (Integer) session.save(fakultet);
            session.getTransaction().commit();

            return loadById(id);
        } catch (RuntimeException rte) {
            session.getTransaction().rollback();
            throw new Exception("Грешка. " + rte.getMessage());
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

}
