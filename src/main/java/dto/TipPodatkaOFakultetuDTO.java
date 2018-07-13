/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import model.TipPodatkaOFakultetu;

/**
 *
 * @author edis
 */
public class TipPodatkaOFakultetuDTO {

    private int id;
    private String naziv;

    public TipPodatkaOFakultetuDTO(TipPodatkaOFakultetu vrstaPodatka) {
        if (vrstaPodatka != null) {
            this.id = vrstaPodatka.getId();
            this.naziv = vrstaPodatka.getNaziv();
        } else {
            id = 0;
            naziv = "NEPOZNATO";
        }
    }

    public TipPodatkaOFakultetuDTO() {
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
