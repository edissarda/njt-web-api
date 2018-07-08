/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import hibernate.HibernateUtil;
import java.util.List;
import model.Fakultet;
import model.Rukovodilac;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import service.IFakultetService;

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
            e.printStackTrace();
            throw new Exception("Грешка приликом учитавања факултета.");
        }
    }

    @Override
    public List<Rukovodilac> ucitajRukovodioceZaFakultet(Integer fakultetID) throws Exception {
        try {
            Fakultet fakultet = null;
            try {
                fakultet = session.get(Fakultet.class, fakultetID);
            } catch (Exception e) {
                throw new Exception("Грешка при конекцији");
            }
            if (fakultet == null) {
                throw new Exception("Факултет са идентификационим бројем " + fakultetID + " не постоји");
            }

            List<Rukovodilac> rukovodioci = fakultet.getRukovodioci();
            return rukovodioci;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
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
        }
    }

}
