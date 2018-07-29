/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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
@Table(name = "administrator")
@NamedQueries({
    @NamedQuery(name = "Administrator.FindByUsernameAndPassword", query = "from Administrator a WHERE a.korisnickoIme = :username AND a.sifra = :password")
    ,@NamedQuery(name = "Administrator.FindByUsername", query = "from Administrator a WHERE a.korisnickoIme = :username")
})
public class Administrator implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ime;
    private String prezime;

    @Column(name = "username")
    private String korisnickoIme;

    @Column(name = "password")
    private String sifra;

    @Column(name = "datum_registracije")
    private LocalDate datumRegistracije;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "administrator_id")
    @OrderBy(clause = "datum DESC")
    private List<PrijavaAdministratora> prijave;

    public Administrator() {
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

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public LocalDate getDatumRegistracije() {
        return datumRegistracije;
    }

    public void setDatumRegistracije(LocalDate datumRegistracije) {
        this.datumRegistracije = datumRegistracije;
    }

    public List<PrijavaAdministratora> getPrijave() {
        return prijave;
    }

    public void setPrijave(List<PrijavaAdministratora> prijave) {
        this.prijave = prijave;
    }

    public void dodajPrijavu(PrijavaAdministratora prijava) {
        prijave.add(0, prijava);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Administrator other = (Administrator) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
