/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dto.KontaktPorukaDTO;
import hibernate.HibernateUtil;
import java.time.LocalDateTime;
import java.util.List;
import model.KontaktPoruka;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import service.IKontaktService;
import validator.Validator;

/**
 *
 * @author edis
 */
@Service
@RequestScope
public class KontaktServiceImpl implements IKontaktService {

    private Session session;

    public KontaktServiceImpl() {
        session = HibernateUtil.getInstance().getNewSession();
    }

    @Override
    public KontaktPoruka kreirajPoruku(KontaktPorukaDTO kontaktPorukaDTO) throws Exception {
        try {
            Validator.validate(kontaktPorukaDTO);

            KontaktPoruka poruka = new KontaktPoruka();
            poruka.setIme(kontaktPorukaDTO.getIme());
            poruka.setEmail(kontaktPorukaDTO.getEmail());
            poruka.setNaslov(kontaktPorukaDTO.getNaslov());
            poruka.setPoruka(kontaktPorukaDTO.getPoruka());
            poruka.setDatumIVreme(LocalDateTime.now());

            session.getTransaction().begin();
            session.save(poruka);
            session.getTransaction().commit();

            return poruka;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List<KontaktPoruka> loadAll() throws Exception {
        try {
            List<KontaktPoruka> poruke = session.createNamedQuery("KontaktPoruka.LoadAll").getResultList();
            return poruke;
        } catch (Exception e) {
            throw new Exception("Дошло је до грешке приликом учитавања контакт порука");
        } finally {
            session.close();
        }
    }

}
