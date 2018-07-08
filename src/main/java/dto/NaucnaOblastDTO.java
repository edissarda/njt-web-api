/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import model.NaucnaOblast;

/**
 *
 * @author edis
 */
public class NaucnaOblastDTO {

    private Integer id;
    private String naziv;

    public NaucnaOblastDTO(NaucnaOblast no) {
        if (no != null) {
            this.id = no.getId();
            this.naziv = no.getNaziv();
        }
    }

    public NaucnaOblastDTO() {
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
