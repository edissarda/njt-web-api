/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import model.TipRukovodioca;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author edis
 */
public class TipRukovodiocaDTO implements Serializable {

    
    private Integer id;

    @NotBlank(message = "Назив типа руководиоца не сме бити непознат.")
    private String naziv;

    public TipRukovodiocaDTO(TipRukovodioca tipRukovodioca) {
        if (tipRukovodioca != null) {
            this.id = tipRukovodioca.getId();
            this.naziv = tipRukovodioca.getNaziv();
        } else {
            id = 0;
            naziv = "NEPOZNATO";
        }
    }

    public TipRukovodiocaDTO() {
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
