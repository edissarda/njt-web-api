/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import model.Nastavnik;

/**
 *
 * @author edis
 */
public class NastavnikDTO implements Serializable {

    private Integer id;
    private String ime;
    private String prezime;
    private ZvanjeDTO zvanje;
    private TitulaDTO titula;

    public NastavnikDTO() {
    }

    public NastavnikDTO(Nastavnik n) {
        if (n != null) {
            id = n.getId();
            ime = n.getIme();
            prezime = n.getPrezime();

            if (!n.getZvanja().isEmpty()) {
                zvanje = new ZvanjeDTO(n.getZvanja().get(0));
            }

            if (!n.getTitule().isEmpty()) {
                titula = new TitulaDTO(n.getTitule().get(0));
            }
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}
