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
import javax.persistence.Table;

/**
 *
 * @author edis
 */
@Entity
@Table(name = "rukovodilac")
public class Rukovodilac implements Serializable {

    @Id
    @Column(name = "fakultet_id")
    private Integer fakultetID;

    @Id
    @Column(name = "nastavnik_id")
    private Integer nastavnikID;

    @Column(name = "datum_od")
    private LocalDate datumOd;

    @Column(name = "datum_do")
    private LocalDate datumDo;

    @ManyToOne
    @JoinColumn(name = "zvanje_fk")
    private Zvanje zvanje;

    @ManyToOne
    @JoinColumn(name = "nastavnik_id")
    private Nastavnik nastavnik;

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

}
