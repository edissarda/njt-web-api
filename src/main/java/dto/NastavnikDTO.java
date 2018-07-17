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
import javax.validation.constraints.NotBlank;
import model.Nastavnik;

/**
 *
 * @author edis
 */
public class NastavnikDTO implements Serializable {

    private Integer id;
    
    @NotBlank(message = "Име наставника не сме бити непознато")
    private String ime;
    
    @NotBlank(message = "Презиме наставника не сме бити непознато")
    private String prezime;
    
    @NotBlank(message = "Број раднке књижице не сме бити непознат")
    private String brojRadneKnjizice;
    
    private List<ZvanjeNastavnikaDTO> zvanja = new ArrayList<>();
    private List<TitulaNastavnikaDTO> titule = new ArrayList<>();

    public NastavnikDTO() {
    }

    public NastavnikDTO(Nastavnik nastavnik) {
        if (nastavnik != null) {
            id = nastavnik.getId();
            ime = nastavnik.getIme();
            prezime = nastavnik.getPrezime();
            brojRadneKnjizice = nastavnik.getBrojRadneKnjizice();

            if (!nastavnik.getZvanjaNastavnika().isEmpty()) {
                zvanja = nastavnik.getZvanjaNastavnika().stream().map(z -> new ZvanjeNastavnikaDTO(z)).collect(Collectors.toList());
            }

            if (!nastavnik.getTituleNastavnika().isEmpty()) {
                titule = nastavnik.getTituleNastavnika().stream().map(t -> new TitulaNastavnikaDTO(t)).collect(Collectors.toList());
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

    public String getBrojRadneKnjizice() {
        return brojRadneKnjizice;
    }

    public void setBrojRadneKnjizice(String brojRadneKnjizice) {
        this.brojRadneKnjizice = brojRadneKnjizice;
    }

}
