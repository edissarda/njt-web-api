/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dto.TipRukovodiocaDTO;
import hibernate.HibernateUtil;
import java.util.List;
import model.TipRukovodioca;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import service.ITipRukovodiocaService;
import validator.Validator;

/**
 *
 * @author edis
 */
@Component
@RequestScope
public class TipRukovodiocaServiceImpl implements ITipRukovodiocaService {

    private Session session;

    public TipRukovodiocaServiceImpl() {
        session = HibernateUtil.getInstance().getNewSession();
    }

    @Override
    public List<TipRukovodioca> loadAll() throws Exception {
        try {
            List<TipRukovodioca> tipoviRukovodoica
                    = session.createNamedQuery("TipRukovodioca.LoadAll")
                            .getResultList();
            return tipoviRukovodoica;
        } catch (Exception e) {
            throw new Exception("Грешка приликом учитавања типова руководиоца.");
        } finally {
            session.close();
        }
    }

    @Override
    public TipRukovodioca create(TipRukovodiocaDTO tipRukovodiocaDTO) throws Exception {
        try {
            Validator.validate(tipRukovodiocaDTO);

            List<TipRukovodioca> tipoviRukovodilaca = session.createNamedQuery("TipRukovodioca.FindByName", TipRukovodioca.class).setParameter("naziv", tipRukovodiocaDTO.getNaziv()).getResultList();

            if (tipoviRukovodilaca.size() > 0) {
                throw new RuntimeException("Тип руководиоца са називом " + tipRukovodiocaDTO.getNaziv() + " већ постоји.");
            }

            TipRukovodioca tipRukovodioca = new TipRukovodioca();
            tipRukovodioca.setNaziv(tipRukovodiocaDTO.getNaziv());

            session.getTransaction().begin();
            session.save(tipRukovodioca);
            session.getTransaction().commit();
            return tipRukovodioca;
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public TipRukovodioca delete(int id) throws Exception {
        try {
            TipRukovodioca tipRukovodioca = session.get(TipRukovodioca.class, id);
            if (tipRukovodioca == null) {
                throw new RuntimeException("Тип руководиоца са идентификатором " + id + " не постоји.");
            }

            session.getTransaction().begin();
            session.delete(tipRukovodioca);
            session.getTransaction().commit();
            return tipRukovodioca;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception("Тип руководиоца не може бити обрисан");
        } finally {
            session.close();
        }
    }

}
