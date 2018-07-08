/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import model.PravnaForma;

/**
 *
 * @author edis
 */
public class PravnaFormaDTO {

    private Integer id;
    private String naziv;

    public PravnaFormaDTO(PravnaForma pf) {
        if (pf != null) {
            this.id = pf.getId();
            this.naziv = pf.getNaziv();
        }
    }

    public PravnaFormaDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
