/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import hibernate.HibernateUtil;
import java.util.List;
import model.TipPodatkaOFakultetu;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import service.ITipPodatkaOFakultetuService;

/**
 *
 * @author edis
 */
@Service
@RequestScope
public class TipPodatkaOFakultetuServiceImpl implements ITipPodatkaOFakultetuService {

    private Session session;

    public TipPodatkaOFakultetuServiceImpl() {
        session = HibernateUtil.getInstance().getNewSession();
    }

    @Override
    public List<TipPodatkaOFakultetu> loadAll() throws Exception {
        try {
            List<TipPodatkaOFakultetu> tipoviPodataka = session.createNamedQuery("TipPodatkaOFakultetu.LoadAll")
                    .getResultList();
            return tipoviPodataka;
        } catch (Exception e) {
            throw new Exception("Грешка приликом учитавања типова података.");
        } finally {
            session.close();
        }
    }

}
