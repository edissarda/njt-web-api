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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author edis
 */
@Entity
@Table(name = "fakultet")
@NamedQueries({
    @NamedQuery(name = "Fakultet.LoadAll", query = "from Fakultet")
})
public class Fakultet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fakultet_id")
    private Integer id;

    private String naziv;

    @Column(name = "maticni_broj")
    private String maticniBroj;

    @Column(name = "poreski_broj")
    private String poreskiBroj;

    @Lob
    private String opis;

    @ManyToOne
    @JoinColumn(name = "vrsta_organizacije_fk")
    @Cascade(value = {CascadeType.REFRESH})
    private VrstaOrganizacije vrstaOrganizacije;

    @ManyToOne
    @JoinColumn(name = "pravna_forma_fk")
    @Cascade(value = {CascadeType.REFRESH})
    private PravnaForma pravnaForma;

    @ManyToOne
    @JoinColumn(name = "naucna_oblast_fk")
    @Cascade(value = {CascadeType.REFRESH})
    private NaucnaOblast naucnaOblast;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "fakultet_id")
    private List<Rukovodilac> rukovodioci;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "rukovodilac",
            joinColumns = @JoinColumn(name = "fakultet_id"),
            inverseJoinColumns = @JoinColumn(name = "rukovodilac_id")
    )
    private List<Nastavnik> nastavnici;

    public Fakultet() {
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

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public String getPoreskiBroj() {
        return poreskiBroj;
    }

    public void setPoreskiBroj(String poreskiBroj) {
        this.poreskiBroj = poreskiBroj;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public VrstaOrganizacije getVrstaOrganizacije() {
        return vrstaOrganizacije;
    }

    public void setVrstaOrganizacije(VrstaOrganizacije vrstaOrganizacije) {
        this.vrstaOrganizacije = vrstaOrganizacije;
    }

    public PravnaForma getPravnaForma() {
        return pravnaForma;
    }

    public void setPravnaForma(PravnaForma pravnaForma) {
        this.pravnaForma = pravnaForma;
    }

    public NaucnaOblast getNaucnaOblast() {
        return naucnaOblast;
    }

    public void setNaucnaOblast(NaucnaOblast naucnaOblast) {
        this.naucnaOblast = naucnaOblast;
    }

    public List<Rukovodilac> getRukovodioci() {
        return rukovodioci;
    }

    public List<Nastavnik> getNastavnici() {
        return nastavnici;
    }

}
