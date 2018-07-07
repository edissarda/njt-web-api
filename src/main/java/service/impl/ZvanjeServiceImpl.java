/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dto.ZvanjeDTO;
import hibernate.HibernateUtil;
import java.util.List;
import javax.validation.ConstraintViolationException;
import model.Zvanje;
import org.hibernate.Session;
import org.hibernate.type.StringType;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import service.IZvanjeService;
import validator.Validator;

/**
 *
 * @author edis
 */
@Component(value = "ZvanjeServiceImpl")
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ZvanjeServiceImpl implements IZvanjeService {

    private Session session;

    public ZvanjeServiceImpl() {
        session = HibernateUtil.getInstance().getNewSession();
    }

    @Override
    public List<Zvanje> loadAll() {
        try {
            List<Zvanje> zvanja = session.createNamedQuery("Zvanje.findAll", Zvanje.class).getResultList();
            return zvanja;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Zvanje save(ZvanjeDTO zvanjeDTO) throws Exception {
        try {
            Validator.validate(zvanjeDTO);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        List resultList = session.createNamedQuery("Zvanje.findByNaziv", Zvanje.class)
                .setParameter("naziv", zvanjeDTO.getNaziv(), StringType.INSTANCE)
                .getResultList();

        if (!resultList.isEmpty()) {
            throw new Exception("Звање са називом " + zvanjeDTO.getNaziv() + " већ постоји.");
        }

        try {
            Zvanje zvanjeZaInsert = new Zvanje(zvanjeDTO.getNaziv());
            session.getTransaction().begin();
            Integer id = (Integer) session.save(zvanjeZaInsert);
            session.getTransaction().commit();
            return session.get(Zvanje.class, id);
        } catch (ConstraintViolationException cvex) {
            session.getTransaction().rollback();
            throw new Exception(cvex.getLocalizedMessage());
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception("Грешка. Звање није сачувано.");
        }

    }

    @Override
    public Zvanje findById(int id) throws Exception {
        try {
            Zvanje zvanje = session.get(Zvanje.class, id);
            if (zvanje == null) {
                throw new Exception("Звање са идентификационим бројем " + id + " не постоји");
            }
            return zvanje;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Zvanje delete(Zvanje zvanje) throws Exception {
        try {
            session.getTransaction().begin();
            session.remove(zvanje);
            session.getTransaction().commit();
            return zvanje;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Zvanje update(Zvanje toUpdate) throws Exception {
        try {
            System.out.println(toUpdate);
            Zvanje fromDb = findById(toUpdate.getId());

            session.getTransaction().begin();
            Zvanje updated = (Zvanje) session.merge(toUpdate);
            session.getTransaction().commit();

            return updated;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public List<Zvanje> find(String naziv, int limit) throws Exception {
        if (limit <= 0) {
            limit = 1;
        }

        naziv = (naziv == null) ? "" : naziv.trim();

        try {
            List<Zvanje> zvanja = session.createNamedQuery("Zvanje.LoadNazivLike", Zvanje.class)
                    .setParameter("naziv", "%" + naziv + "%", StringType.INSTANCE)
                    .setMaxResults(limit)
                    .getResultList();
            return zvanja;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
