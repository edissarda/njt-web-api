/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author edis
 */
@Entity
@Table(name = "kontakt_poruka")
@NamedQueries({
    @NamedQuery(name = "KontaktPoruka.LoadAll", query = "from KontaktPoruka kp ORDER BY kp.datumIVreme DESC")
    ,@NamedQuery(name = "KontaktPoruka.LoadByEmail", query = "from KontaktPoruka kp WHERE kp.email = :email ORDER BY kp.datumIVreme DESC")
})
public class KontaktPoruka implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ime;

    private String email;

    private String naslov;

    @Lob
    private String poruka;

    @Column(name = "datum_i_vreme")
    private LocalDateTime datumIVreme;

    public KontaktPoruka() {
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

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public LocalDateTime getDatumIVreme() {
        return datumIVreme;
    }

    public void setDatumIVreme(LocalDateTime datumIVreme) {
        this.datumIVreme = datumIVreme;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
