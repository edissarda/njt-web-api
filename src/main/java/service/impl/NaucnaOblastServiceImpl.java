/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import service.INaucnaOblastService;
import hibernate.HibernateUtil;
import java.util.List;
import model.NaucnaOblast;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

/**
 *
 * @author edis
 */
@Service
@RequestScope
public class NaucnaOblastServiceImpl implements INaucnaOblastService {

    private Session session = HibernateUtil.getInstance().getNewSession();

    @Override
    public List<NaucnaOblast> loadAll() throws Exception {
        try {
            return session.createNamedQuery("NaucnaOblast.LoadAll", NaucnaOblast.class).getResultList();
        } catch (Exception e) {
            throw new Exception("Грешка при учитавању научних области.");
        }
    }

}
