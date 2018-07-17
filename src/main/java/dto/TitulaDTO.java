/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import model.Titula;

/**
 *
 * @author edis
 */
public class TitulaDTO implements Serializable {

    private Integer id;

    @NotBlank(message = "Назив титуле не сме бити непознат")
    private String naziv;

    public TitulaDTO(Titula titula) {
        if (titula != null) {
            id = titula.getId();
            naziv = titula.getNaziv();
        } else {
            id = 0;
            naziv = "NEPOZNATO";
        }
    }

    public TitulaDTO() {
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
