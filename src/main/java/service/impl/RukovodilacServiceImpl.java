/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dto.RukovodilacCreateDTO;
import hibernate.HibernateUtil;
import java.time.LocalDate;
import java.util.List;
import model.Fakultet;
import model.Nastavnik;
import model.Rukovodilac;
import model.TipRukovodioca;
import org.hibernate.Session;
import org.hibernate.type.IntegerType;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import service.IRukovodilacService;
import validator.Validator;

/**
 *
 * @author edis
 */
@Service
@RequestScope
public class RukovodilacServiceImpl implements IRukovodilacService {

    private Session session;

    public RukovodilacServiceImpl() {
        session = HibernateUtil.getInstance().getNewSession();
    }

    @Override
    public Rukovodilac save(RukovodilacCreateDTO rukovodilacDTO) throws Exception {
        try {
            Validator.validate(rukovodilacDTO);

            if (rukovodilacDTO.getFakultet().getId() == null || rukovodilacDTO.getFakultet().getId() <= 0) {
                throw new Exception("Изаберите факултет");
            }

            if (rukovodilacDTO.getNastavnik().getId() == null || rukovodilacDTO.getNastavnik().getId() <= 0) {
                throw new Exception("Изаберите наставника");
            }

            if (rukovodilacDTO.getTipRukovodioca().getId() == null || rukovodilacDTO.getTipRukovodioca().getId() <= 0) {
                throw new Exception("Изаберите тип руководиоца");
            }

            Fakultet fakultet = session.get(Fakultet.class, rukovodilacDTO.getFakultet().getId());
            if (fakultet == null) {
                throw new Exception("Изабрани факултет не постоји");
            }

            Nastavnik nastavnik = session.get(Nastavnik.class, rukovodilacDTO.getNastavnik().getId());
            if (nastavnik == null) {
                throw new Exception("Изабрани наставник не постоји");
            }

            TipRukovodioca tipRukovodioca = session.get(TipRukovodioca.class, rukovodilacDTO.getTipRukovodioca().getId());
            if (tipRukovodioca == null) {
                throw new Exception("Изабрани тип руководиоца не постоји");
            }

            LocalDate now = LocalDate.now();

            LocalDate datumOd = LocalDate.parse(rukovodilacDTO.getDatumOd());
            LocalDate datumDo = LocalDate.parse(rukovodilacDTO.getDatumDo());

            if (datumOd.isBefore(now)) {
                throw new Exception("Датум од не сме бити у прошлости");
            }

            if (datumOd.isAfter(datumDo)) {
                throw new Exception("Датум до мора бити након датума од");
            }

            Rukovodilac rukovodilac = new Rukovodilac();
            rukovodilac.setDatumOd(datumOd);
            rukovodilac.setDatumDo(datumDo);
            rukovodilac.setFakultetID(fakultet.getId());
            rukovodilac.setNastavnikID(nastavnik.getId());
            rukovodilac.setTipRukovodioca(tipRukovodioca);

            if (nastavnik.getZvanjaNastavnika().isEmpty()) {
                throw new Exception("Изабрани наставник нема звање");
            } else {
                rukovodilac.setZvanje(nastavnik.getZvanjaNastavnika().iterator().next().getZvanje());
            }

            if (nastavnik.getTituleNastavnika().isEmpty()) {
                throw new Exception("Изабрани наставник нема титулу");
            } else {
                rukovodilac.setTitula(nastavnik.getTituleNastavnika().iterator().next().getTitula());
            }

            List<Rukovodilac> rukovodioci = session.createNamedQuery("Rukovodilac.DaLiNaFakultetuVecPostojiRukovodilacDatogTipaZaInterval")
                    .setParameter("fakultetId", fakultet.getId(), IntegerType.INSTANCE)
                    .setParameter("tipRukovodiocaId", tipRukovodioca.getId(), IntegerType.INSTANCE)
                    .setParameter("datumOd", datumOd)
                    .setParameter("datumDo", datumDo)
                    .getResultList();

            if (!rukovodioci.isEmpty()) {
                throw new Exception("Факултет тренутно има руководиоца изабраног типа у задатом временском периоду");
            }

            List<Rukovodilac> angazovanostIzbranogTipa = session.createNamedQuery("Rukovodilac.DaLiJeNastavnikVecRukovodilacDatogTipaZaInterval")
                    .setParameter("tipRukovodiocaId", tipRukovodioca.getId())
                    .setParameter("nastavnikId", nastavnik.getId())
                    .setParameter("datumOd", datumOd)
                    .setParameter("datumDo", datumDo)
                    .getResultList();
            if (!angazovanostIzbranogTipa.isEmpty()) {
                throw new Exception("Изабрани наставник је већ ангажован као " + tipRukovodioca.getNaziv() + " на неком од факултета у изабраном временском периоду");
            }

            session.getTransaction().begin();
            session.save(rukovodilac);
            session.getTransaction().commit();

            return rukovodilac;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

}
