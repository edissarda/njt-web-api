/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author edis
 */
@Entity
@Table(name = "titula_nastavnika")
public class TitulaNastavnika implements Serializable {

    @Id
    @Column(name = "nastavnik_id")
    private Integer nastavnikID;

    @Id
    @Column(name = "titula_id")
    private Integer titulaID;

    @Column(name = "datum_od")
    private LocalDate datumOd;

    @ManyToOne
    @JoinColumn(name = "titula_id", insertable = false)
    private Titula titula;

    public TitulaNastavnika() {
    }

    public Integer getNastavnikID() {
        return nastavnikID;
    }

    public void setNastavnikID(Integer nastavnikID) {
        this.nastavnikID = nastavnikID;
    }

    public Integer getTitulaID() {
        return titulaID;
    }

    public void setTitulaID(Integer titulaID) {
        this.titulaID = titulaID;
    }

    public Titula getTitula() {
        return titula;
    }

    public void setTitula(Titula titula) {
        this.titula = titula;
    }

    public LocalDate getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(LocalDate datumOd) {
        this.datumOd = datumOd;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final TitulaNastavnika other = (TitulaNastavnika) obj;
        if (!Objects.equals(this.nastavnikID, other.nastavnikID)) {
            return false;
        }
        if (!Objects.equals(this.titulaID, other.titulaID)) {
            return false;
        }
        return true;
    }

}
