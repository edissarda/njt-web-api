/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.ParamDef;

/**
 *
 * @author edis
 */
@Entity
@Table(name = "rukovodilac")
@NamedQueries({
    @NamedQuery(name = "Rukovodilac.DaLiJeNastavnikVecRukovodilacDatogTipaZaInterval", query = "from Rukovodilac r WHERE (r.tipRukovodioca.id = :tipRukovodiocaId AND r.nastavnikID = :nastavnikId AND ((:datumOd BETWEEN r.datumOd AND r.datumDo) OR (:datumDo BETWEEN r.datumOd AND r.datumDo) OR (:datumOd <= r.datumOd AND :datumDo >= r.datumOd) OR (:datumOd >= r.datumDo AND :datumDo <= r.datumOd)))")
    , @NamedQuery(name = "Rukovodilac.DaLiNaFakultetuVecPostojiRukovodilacDatogTipaZaInterval", query = "from Rukovodilac r WHERE (r.fakultetID = :fakultetId AND r.tipRukovodioca.id = :tipRukovodiocaId AND ((:datumOd BETWEEN r.datumOd AND r.datumDo) OR (:datumDo BETWEEN r.datumOd AND r.datumDo) OR (:datumOd <= r.datumOd AND :datumDo >= r.datumOd) OR (:datumOd >= r.datumDo AND :datumDo <= r.datumOd)))")
})
@FilterDefs({
    @FilterDef(name = "filterAktivniRukovodioci", parameters = {
        @ParamDef(name = "tekuciDatum", type = "date")})
})
public class Rukovodilac implements Serializable {

    @Id
    @Column(name = "fakultet_id")
    private Integer fakultetID;

    @Id
    @Column(name = "nastavnik_id")
    private Integer nastavnikID;

    @Id
    @Column(name = "datum_od")
    private LocalDate datumOd;

    @Column(name = "datum_do")
    @Id
    private LocalDate datumDo;

    @ManyToOne
    @JoinColumn(name = "zvanje_fk")
    private Zvanje zvanje;

    @ManyToOne
    @JoinColumn(name = "nastavnik_id", insertable = false)
    private Nastavnik nastavnik;

    @ManyToOne
    @JoinColumn(name = "titula_fk")
    private Titula titula;

    @ManyToOne
    @JoinColumn(name = "tip_rukovodioca_fk")
    private TipRukovodioca tipRukovodioca;

    public Rukovodilac() {
    }

    public Integer getFakultetID() {
        return fakultetID;
    }

    public void setFakultetID(Integer fakultetID) {
        this.fakultetID = fakultetID;
    }

    public Integer getNastavnikID() {
        return nastavnikID;
    }

    public void setNastavnikID(Integer nastavnikID) {
        this.nastavnikID = nastavnikID;
    }

    public LocalDate getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(LocalDate datumOd) {
        this.datumOd = datumOd;
    }

    public LocalDate getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(LocalDate datumDo) {
        this.datumDo = datumDo;
    }

    public Zvanje getZvanje() {
        return zvanje;
    }

    public void setZvanje(Zvanje zvanje) {
        this.zvanje = zvanje;
    }

    public Nastavnik getNastavnik() {
        return nastavnik;
    }

    public void setNastavnik(Nastavnik nastavnik) {
        this.nastavnik = nastavnik;
    }

    public Titula getTitula() {
        return titula;
    }

    public void setTitula(Titula titula) {
        this.titula = titula;
    }

    public TipRukovodioca getTipRukovodioca() {
        return tipRukovodioca;
    }

    public void setTipRukovodioca(TipRukovodioca tipRukovodioca) {
        this.tipRukovodioca = tipRukovodioca;
    }

}
