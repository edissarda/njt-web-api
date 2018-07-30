/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import hibernate.HibernateUtil;
import java.util.List;
import model.Titula;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import service.ITitulaService;

/**
 *
 * @author edis
 */
@Service
@RequestScope
public class TitulaServiceImpl implements ITitulaService {

    private Session session = HibernateUtil.getInstance().getNewSession();

    @Override
    public List<Titula> loadAll() throws Exception {
        try {
            List<Titula> titule = session.createNamedQuery("Titula.LoadAll").getResultList();
            return titule;
        } catch (Exception e) {
            throw new Exception("Грешка приликом учитавања титула");
        } finally {
            session.close();
        }
    }

}
