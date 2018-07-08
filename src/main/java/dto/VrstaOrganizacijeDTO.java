/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import model.VrstaOrganizacije;

/**
 *
 * @author edis
 */
public class VrstaOrganizacijeDTO {

    private Integer id;
    private String naziv;

    public VrstaOrganizacijeDTO(VrstaOrganizacije vo) {
        if (vo != null) {
            this.id = vo.getId();
            this.naziv = vo.getNaziv();
        }
    }

    public VrstaOrganizacijeDTO() {
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
