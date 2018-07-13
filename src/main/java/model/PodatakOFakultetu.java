/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dto.PodatakOFakultetuDTO;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author edis
 */
@Entity
@Table(name = "podatak_o_fakultetu")
public class PodatakOFakultetu implements Serializable {

    @Id
    @Column(name = "podatak_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fakultet_id")
    private Fakultet fakultet;

    private String vrednost;

    @ManyToOne
    @JoinColumn(name = "tip_podatka_fk")
    private TipPodatkaOFakultetu tipPodatka;

    public PodatakOFakultetu(PodatakOFakultetuDTO podatakDTO) {
        if (podatakDTO != null) {
            vrednost = podatakDTO.getVrednost();
            tipPodatka = new TipPodatkaOFakultetu(podatakDTO.getTipPodatka());
        }
    }

    public PodatakOFakultetu() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Fakultet getFakultet() {
        return fakultet;
    }

    public void setFakultet(Fakultet fakultet) {
        this.fakultet = fakultet;
    }

    public String getVrednost() {
        return vrednost;
    }

    public void setVrednost(String vrednost) {
        this.vrednost = vrednost;
    }

    public TipPodatkaOFakultetu getTipPodatka() {
        return tipPodatka;
    }

    public void setTipPodatka(TipPodatkaOFakultetu tipPodatka) {
        this.tipPodatka = tipPodatka;
    }

}
