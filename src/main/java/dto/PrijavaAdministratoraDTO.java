/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import model.PrijavaAdministratora;

/**
 *
 * @author edis
 */
public class PrijavaAdministratoraDTO implements Serializable {

    private Integer prijavaId;
    private String datumPrijave;
    private String vremePrijave;

    PrijavaAdministratoraDTO(PrijavaAdministratora prijava) {
        if (prijava != null) {
            prijavaId = prijava.getPrijavaID();
            datumPrijave = prijava.getDatumIVremePrijave().format(DateTimeFormatter.ofPattern("dd.MM.yyyy."));
            vremePrijave = prijava.getDatumIVremePrijave().format(DateTimeFormatter.ofPattern("H:m:s"));
        }
    }

    public PrijavaAdministratoraDTO() {
    }

    public Integer getPrijavaId() {
        return prijavaId;
    }

    public void setPrijavaId(Integer prijavaId) {
        this.prijavaId = prijavaId;
    }

    public String getDatumPrijave() {
        return datumPrijave;
    }

    public void setDatumPrijave(String datumPrijave) {
        this.datumPrijave = datumPrijave;
    }

    public String getVremePrijave() {
        return vremePrijave;
    }

    public void setVremePrijave(String vremePrijave) {
        this.vremePrijave = vremePrijave;
    }

}
