/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author edis
 */
@Entity
@Table(name = "zvanje")
@NamedQueries({
    @NamedQuery(name = "Zvanje.findAll", query = "from Zvanje z")
    , @NamedQuery(name = "Zvanje.findByZvanjeId", query = "SELECT z FROM Zvanje z WHERE z.id = :zvanjeId")
    , @NamedQuery(name = "Zvanje.findByNaziv", query = "SELECT z FROM Zvanje z WHERE z.naziv = :naziv")
        , @NamedQuery(name = "Zvanje.LoadNazivLike", query = "from Zvanje z WHERE z.naziv LIKE :naziv")
})
public class Zvanje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zvanje_id")
    private Integer id;

    @Column(name = "naziv")
    private String naziv;

    public Zvanje(String naziv) {
        this.naziv = naziv;
    }

    public Zvanje() {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zvanje)) {
            return false;
        }
        Zvanje other = (Zvanje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Zvanje[ zvanjeId=" + id + " ]";
    }

}
