/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import hibernate.HibernateUtil;
import java.util.List;
import model.TipRukovodioca;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import service.ITipRukovodiocaService;

/**
 *
 * @author edis
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
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
        }
    }

}
