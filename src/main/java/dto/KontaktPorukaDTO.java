/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import model.KontaktPoruka;

/**
 *
 * @author edis
 */
public class KontaktPorukaDTO implements Serializable {

    private Integer id;

    @NotBlank(message = "Име не сме бити празно")
    private String ime;

    @NotBlank(message = "Морате унети имејл адресу")
    private String email;

    @NotBlank(message = "Морате унети наслов поруке")
    private String naslov;

    @NotBlank(message = "Морате унети поруку")
    @Size(min = 3, message = "Порука мора имати бар 3 карактера")
    private String poruka;

    private String datum;
    private String vreme;

    public KontaktPorukaDTO(KontaktPoruka poruka) {
        if (poruka != null) {
            id = poruka.getId();
            ime = poruka.getIme();
            email = poruka.getEmail();
            naslov = poruka.getNaslov();
            this.poruka = poruka.getPoruka();
            datum = poruka.getDatumIVreme().format(DateTimeFormatter.ofPattern("dd.MM.yyyy."));
            vreme = poruka.getDatumIVreme().format(DateTimeFormatter.ofPattern("HH:mm"));
        }
    }

    public KontaktPorukaDTO() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

}
