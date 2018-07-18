/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dto.AdministratorDTO;
import hibernate.HibernateUtil;
import java.time.LocalDateTime;
import java.util.List;
import model.Administrator;
import model.PrijavaAdministratora;
import org.hibernate.Session;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import service.IAuthService;
import validator.Validator;

/**
 *
 * @author edis
 */
@Service
@RequestScope
public class AuthServiceImpl implements IAuthService {

    private Session session;

    public AuthServiceImpl() {
        session = HibernateUtil.getInstance().getNewSession();
    }

    @Override
    public Administrator login(AdministratorDTO administratorDTO) throws Exception {
        try {
            Validator.validate(administratorDTO);

            List<Administrator> admins = session.createNamedQuery("Administrator.FindByUsername", Administrator.class)
                    .setParameter("username", administratorDTO.getUsername(), StringType.INSTANCE)
                    .getResultList();

            if (admins.isEmpty()) {
                throw new Exception("Није пронађен корисник са корисничким именом " + administratorDTO.getUsername());
            }

            if (admins.size() > 1) {
                throw new Exception("Пронађено је више корисника са истим корисничким именом");
            }

            Administrator admin = admins.get(0);

            String unetaSifra = administratorDTO.getPassword();
            String stvarnaSifra = admin.getSifra();

            if (unetaSifra.equals(stvarnaSifra)) {
                PrijavaAdministratora prijava = new PrijavaAdministratora();
                prijava.setAdminID(admin.getId());
                prijava.setDatumIVremePrijave(LocalDateTime.now());
                
                session.getTransaction().begin();
                session.save(prijava);
                session.getTransaction().commit();

                admin.dodajPrijavu(prijava);
                
                return admin;
            } else {
                throw new Exception("Погрешно корисничко име или шифра");
            }

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

}
