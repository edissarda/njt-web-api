/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author edis
 */
public class ZvanjeDTO implements Serializable {

    @NotBlank(message = "Назив звања не сме бити непознат.")
    private String naziv;

    public ZvanjeDTO(String naziv) {
        this.naziv = naziv;
    }

    public ZvanjeDTO() {
    }

    public String getNaziv() {
        return naziv.trim();
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}
