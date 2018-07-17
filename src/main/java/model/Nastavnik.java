/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.OrderBy;

/**
 *
 * @author edis
 */
@Entity
@Table(name = "nastavnik")
@NamedQueries({
    @NamedQuery(name = "Nastavnik.LoadAll", query = "from Nastavnik")
    ,@NamedQuery(name = "Nastavnik.LoadByBrojRadneKnjizice", query = "from Nastavnik n WHERE n.brojRadneKnjizice = :brojRadneKnjizice")
})
public class Nastavnik implements Serializable {

    @Id
    @Column(name = "nastavnik_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ime;

    private String prezime;

    @Column(name = "broj_radne_knjizice")
    private String brojRadneKnjizice;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "nastavnik_id")
    @OrderBy(clause = "datum_od DESC")
    private Set<ZvanjeNastavnika> zvanjaNastavnika;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "nastavnik_id")
    @OrderBy(clause = "datum_od DESC")
    private Set<TitulaNastavnika> tituleNastavnika;

    public Nastavnik() {
        zvanjaNastavnika = new HashSet<>();
        tituleNastavnika = new HashSet<>();
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

    public Set<ZvanjeNastavnika> getZvanjaNastavnika() {
        return zvanjaNastavnika;
    }

    public void setZvanjaNastavnika(Set<ZvanjeNastavnika> zvanjaNastavnika) {
        this.zvanjaNastavnika = zvanjaNastavnika;
    }

    public Set<TitulaNastavnika> getTituleNastavnika() {
        return tituleNastavnika;
    }

    public void setTituleNastavnika(Set<TitulaNastavnika> tituleNastavnika) {
        this.tituleNastavnika = tituleNastavnika;
    }

    public String getBrojRadneKnjizice() {
        return brojRadneKnjizice;
    }

    public void setBrojRadneKnjizice(String brojRadneKnjizice) {
        this.brojRadneKnjizice = brojRadneKnjizice;
    }

}
