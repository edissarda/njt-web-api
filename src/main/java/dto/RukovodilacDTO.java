/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import model.Rukovodilac;

/**
 *
 * @author edis
 */
public class RukovodilacDTO implements Serializable {

    private String ime;
    private String prezime;
    private String datumOd;
    private String datumDo;
    private ZvanjeDTO zvanje;
    private TitulaDTO titula;
    private TipRukovodiocaDTO tipRukovodioca;

    public RukovodilacDTO(Rukovodilac r) {
        if (r != null) {
            this.ime = r.getNastavnik().getIme();
            this.prezime = r.getNastavnik().getPrezime();
            this.datumOd = r.getDatumOd().format(DateTimeFormatter.ofPattern("dd.MM.yyyy."));
            this.datumDo = r.getDatumDo().format(DateTimeFormatter.ofPattern("dd.MM.yyyy."));
            this.zvanje = new ZvanjeDTO(r.getZvanje());
            this.titula = new TitulaDTO(r.getTitula());
            this.tipRukovodioca = new TipRukovodiocaDTO(r.getTipRukovodioca());
        }
    }

    public RukovodilacDTO() {
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(String datumOd) {
        this.datumOd = datumOd;
    }

    public String getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(String datumDo) {
        this.datumDo = datumDo;
    }

    public ZvanjeDTO getZvanje() {
        return zvanje;
    }

    public void setZvanje(ZvanjeDTO zvanje) {
        this.zvanje = zvanje;
    }

    public TitulaDTO getTitula() {
        return titula;
    }

    public void setTitula(TitulaDTO titula) {
        this.titula = titula;
    }

    public TipRukovodiocaDTO getTipRukovodioca() {
        return tipRukovodioca;
    }

    public void setTipRukovodioca(TipRukovodiocaDTO tipRukovodioca) {
        this.tipRukovodioca = tipRukovodioca;
    }

}
