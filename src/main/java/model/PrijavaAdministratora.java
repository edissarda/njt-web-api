/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author edis
 */
@Entity
@Table(name = "prijava_administratora")
public class PrijavaAdministratora implements Serializable {

    @Column(name = "administrator_id")
    private Integer adminID;

    @Id
    @Column(name = "prijava_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prijavaID;

    @Column(name = "datum")
    private LocalDateTime datumIVremePrijave;
    
    public PrijavaAdministratora() {
    }

    public Integer getAdminID() {
        return adminID;
    }

    public void setAdminID(Integer adminID) {
        this.adminID = adminID;
    }

    public Integer getPrijavaID() {
        return prijavaID;
    }

    public void setPrijavaID(Integer prijavaID) {
        this.prijavaID = prijavaID;
    }

    public LocalDateTime getDatumIVremePrijave() {
        return datumIVremePrijave;
    }

    public void setDatumIVremePrijave(LocalDateTime datumIVremePrijave) {
        this.datumIVremePrijave = datumIVremePrijave;
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
        final PrijavaAdministratora other = (PrijavaAdministratora) obj;
        if (!Objects.equals(this.adminID, other.adminID)) {
            return false;
        }
        if (!Objects.equals(this.prijavaID, other.prijavaID)) {
            return false;
        }
        return true;
    }

}
