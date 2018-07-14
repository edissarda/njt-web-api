/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import model.ZvanjeNastavnika;

/**
 *
 * @author edis
 */
public class ZvanjeNastavnikaDTO implements Serializable {

    private Integer id;
    private String naziv;
    private String datumOd;

    public ZvanjeNastavnikaDTO(ZvanjeNastavnika zvanjeNastavnika) {
        if (zvanjeNastavnika != null) {
            id = zvanjeNastavnika.getZvanjeID();
            naziv = zvanjeNastavnika.getZvanje().getNaziv();
            datumOd = zvanjeNastavnika.getDatumOd().format(DateTimeFormatter.ofPattern("dd.MM.yyyy."));
        }
    }
    
    

    public ZvanjeNastavnikaDTO() {
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
