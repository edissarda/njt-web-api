/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import model.TitulaNastavnika;

/**
 *
 * @author edis
 */
public class TitulaNastavnikaDTO implements Serializable {

    private Integer id;
    private String naziv;
    private String datumOd;

    public TitulaNastavnikaDTO(TitulaNastavnika titulaNastavnika) {
        if (titulaNastavnika != null) {
            id = titulaNastavnika.getTitulaID();
            naziv = titulaNastavnika.getTitula().getNaziv();
            datumOd = titulaNastavnika.getDatumOd().format(DateTimeFormatter.ofPattern("dd.MM.yyyy."));
        }
    }

    public TitulaNastavnikaDTO() {
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

    public String getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(String datumOd) {
        this.datumOd = datumOd;
    }

}
