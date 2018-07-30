/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import hibernate.HibernateUtil;
import java.util.List;
import model.PravnaForma;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import service.IPravnaFormaService;

/**
 *
 * @author edis
 */
@Service
@RequestScope
public class PravnaFormaServiceImpl implements IPravnaFormaService {

    private Session session;

    public PravnaFormaServiceImpl() {
        session = HibernateUtil.getInstance().getNewSession();
    }

    @Override
    public List<PravnaForma> loadAll() throws Exception {
        try {
            List<PravnaForma> pravneForme
                    = session.createNamedQuery("PravnaForma.LoadAll", PravnaForma.class)
                            .getResultList();
            return pravneForme;
        } catch (Exception e) {
            throw new Exception("Грешка приликом учитавања правних форми.");
        } finally {
            session.close();
        }
    }

}
