/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.Nastavnik;

/**
 *
 * @author edis
 */
public class NastavnikDTO implements Serializable {

    private Integer id;
    private String ime;
    private String prezime;
    private List<ZvanjeNastavnikaDTO> zvanja = new ArrayList<>();
    private List<TitulaNastavnikaDTO> titule = new ArrayList<>();

    public NastavnikDTO() {
    }

    public NastavnikDTO(Nastavnik n) {
        if (n != null) {
            id = n.getId();
            ime = n.getIme();
            prezime = n.getPrezime();

            if (!n.getZvanjaNastavnika().isEmpty()) {
                zvanja = n.getZvanjaNastavnika().stream().map(z -> new ZvanjeNastavnikaDTO(z)).collect(Collectors.toList());
            }

            if (!n.getTituleNastavnika().isEmpty()) {
                titule = n.getTituleNastavnika().stream().map(t -> new TitulaNastavnikaDTO(t)).collect(Collectors.toList());
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

    public List<ZvanjeNastavnikaDTO> getZvanja() {
        return zvanja;
    }

    public void setZvanja(List<ZvanjeNastavnikaDTO> zvanja) {
        this.zvanja = zvanja;
    }

    public List<TitulaNastavnikaDTO> getTitule() {
        return titule;
    }

    public void setTitule(List<TitulaNastavnikaDTO> titule) {
        this.titule = titule;
    }

}
