/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import model.Fakultet;

/**
 *
 * @author edis
 */
public class FakultetDTO implements Serializable {

    private Integer id;

    @NotBlank(message = "Назив факултета не сме бити непознат")
    private String naziv;

    @NotBlank(message = "Назив факултета не сме бити непознат")
    @Size(min = 8, max = 8, message = "Матични број мора имати тачно 8 цифара")

    private String maticniBroj;

    @NotBlank(message = "Порески број не сме бити непознат")
    private String poreskiBroj;

    @NotNull(message = "Опис не сме бити непознат")
    private String opis;

    @NotNull
    private VrstaOrganizacijeDTO vrstaOrganizacije;

    @NotNull
    private PravnaFormaDTO pravnaForma;

    @NotNull
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
