/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import model.Zvanje;

/**
 *
 * @author edis
 */
public class ZvanjeDTO implements Serializable {

    private Integer id;

    private String naziv;

    public ZvanjeDTO(String naziv) {
        this.naziv = naziv;
    }

    public ZvanjeDTO(Zvanje zvanje) {
        if (zvanje == null) {
            id = -1;
            naziv = "NEPOZNATO";
        } else {
            this.id = zvanje.getId();
            this.naziv = zvanje.getNaziv();
        }
    }

    public ZvanjeDTO() {
    }

    public String getNaziv() {
        return naziv.trim();
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
