/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import model.Fakultet;
import model.NaucnaOblast;
import model.PravnaForma;
import model.VrstaOrganizacije;

/**
 *
 * @author edis
 */
public class FakultetDTO {

    private Integer id;

    private String naziv;

    private String maticniBroj;

    private String poreskiBroj;

    private String opis;

    private VrstaOrganizacijeDTO vrstaOrganizacije;

    private PravnaFormaDTO pravnaForma;

    private NaucnaOblastDTO naucnaOblast;

    public FakultetDTO() {
    }

    public FakultetDTO(Fakultet f) {
        if (f != null) {
            this.id = f.getId();
            this.naziv = f.getNaziv();
            this.maticniBroj = f.getMaticniBroj();
            this.poreskiBroj = f.getPoreskiBroj();
            this.opis = f.getOpis();
            this.vrstaOrganizacije = new VrstaOrganizacijeDTO(f.getVrstaOrganizacije());
            this.naucnaOblast = new NaucnaOblastDTO(f.getNaucnaOblast());
            this.pravnaForma = new PravnaFormaDTO(f.getPravnaForma());
        }
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

    public VrstaOrganizacijeDTO getVrstaOrganizacije() {
        return vrstaOrganizacije;
    }

    public void setVrstaOrganizacije(VrstaOrganizacijeDTO vrstaOrganizacije) {
        this.vrstaOrganizacije = vrstaOrganizacije;
    }

    public PravnaFormaDTO getPravnaForma() {
        return pravnaForma;
    }

    public void setPravnaForma(PravnaFormaDTO pravnaForma) {
        this.pravnaForma = pravnaForma;
    }

    public NaucnaOblastDTO getNaucnaOblast() {
        return naucnaOblast;
    }

    public void setNaucnaOblast(NaucnaOblastDTO naucnaOblast) {
        this.naucnaOblast = naucnaOblast;
    }

}
