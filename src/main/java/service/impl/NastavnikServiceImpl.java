/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import hibernate.HibernateUtil;
import java.util.List;
import model.Nastavnik;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import service.INastavnikService;

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

}
