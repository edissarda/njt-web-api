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
@Table(name = "zvanje_nastavnika")
public class ZvanjeNastavnika implements Serializable {

    @Id
    @Column(name = "nastavnik_id")
    private Integer nastavnikID;

    @Id
    @Column(name = "zvanje_id")
    private Integer zvanjeID;

    @Column(name = "datum_od")
    private LocalDate datumOd;

    @ManyToOne
    @JoinColumn(name = "zvanje_id")
    private Zvanje zvanje;

    public ZvanjeNastavnika() {
    }

    public Integer getNastavnikID() {
        return nastavnikID;
    }

    public void setNastavnikID(Integer nastavnikID) {
        this.nastavnikID = nastavnikID;
    }

    public Integer getZvanjeID() {
        return zvanjeID;
    }

    public void setZvanjeID(Integer zvanjeID) {
        this.zvanjeID = zvanjeID;
    }

    public LocalDate getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(LocalDate datumOd) {
        this.datumOd = datumOd;
    }

    public Zvanje getZvanje() {
        return zvanje;
    }

    public void setZvanje(Zvanje zvanje) {
        this.zvanje = zvanje;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final ZvanjeNastavnika other = (ZvanjeNastavnika) obj;
        if (!Objects.equals(this.nastavnikID, other.nastavnikID)) {
            return false;
        }
        if (!Objects.equals(this.zvanjeID, other.zvanjeID)) {
            return false;
        }
        return true;
    }
    
    

}
