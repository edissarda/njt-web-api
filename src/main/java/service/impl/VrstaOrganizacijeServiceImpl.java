/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import hibernate.HibernateUtil;
import java.util.List;
import model.VrstaOrganizacije;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import service.IVrstaOrganizacijeService;

/**
 *
 * @author edis
 */
@Service
@RequestScope
public class VrstaOrganizacijeServiceImpl implements IVrstaOrganizacijeService {

    private Session session;

    public VrstaOrganizacijeServiceImpl() {
        session = HibernateUtil.getInstance().getNewSession();
    }

    @Override
    public List<VrstaOrganizacije> loadAll() throws Exception {
        try {
            List<VrstaOrganizacije> vrsteOrganizacija
                    = session.createNamedQuery("VrstaOrganizacije.LoadAll", VrstaOrganizacije.class)
                            .getResultList();
            return vrsteOrganizacija;
        } catch (Exception e) {
            throw new Exception("Грешка приликом учитавања врста организације.");
        } finally {
            session.close();
        }
    }

}
