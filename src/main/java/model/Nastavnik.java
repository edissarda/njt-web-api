/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
})
public class Nastavnik implements Serializable {

    @Id
    @Column(name = "nastavnik_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ime;
    private String prezime;

    @ManyToMany
    @JoinTable(name = "zvanje_nastavnika",
            joinColumns = @JoinColumn(name = "nastavnik_id"),
            inverseJoinColumns = @JoinColumn(name = "zvanje_id"))
    @OrderBy(clause = "datum_od DESC")
    private List<Zvanje> zvanja;

    @ManyToMany
    @JoinTable(name = "titula_nastavnika",
            joinColumns = @JoinColumn(name = "nastavnik_id"),
            inverseJoinColumns = @JoinColumn(name = "titula_id"))
    @OrderBy(clause = "datum_od DESC")
    private List<Titula> titule;

    public Nastavnik() {
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

    public List<Zvanje> getZvanja() {
        return zvanja;
    }

    public void setZvanja(List<Zvanje> zvanja) {
        this.zvanja = zvanja;
    }

    public List<Titula> getTitule() {
        return titule;
    }

    public void setTitule(List<Titula> titule) {
        this.titule = titule;
    }

}
