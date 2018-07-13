/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dto.TipPodatkaOFakultetuDTO;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author edis
 */
@Entity
@Table(name = "tip_podatka")
@NamedQueries({
    @NamedQuery(name = "TipPodatkaOFakultetu.LoadAll", query = "from TipPodatkaOFakultetu")
})
public class TipPodatkaOFakultetu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String naziv;

    public TipPodatkaOFakultetu() {
    }

    TipPodatkaOFakultetu(TipPodatkaOFakultetuDTO tipPodatkaDTO) {
        if (tipPodatkaDTO != null) {
            id = tipPodatkaDTO.getId();
            naziv = tipPodatkaDTO.getNaziv();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}
