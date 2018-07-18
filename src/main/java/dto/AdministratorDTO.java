/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import model.Administrator;

/**
 *
 * @author edis
 */
public class AdministratorDTO implements Serializable {

    private String ime;
    private String prezime;
    private String datumRegistracije;

    @NotBlank(message = "Корисничко име не сме бити празно")
    @Size(max = 20, message = "Корисничко име не сме имати више од 20 карактера")
    private String username;

    @NotBlank(message = "Шифра не сме бити празна")
    @Size(max = 50, message = "Шифра не сме имати више од 20 карактера")
    private String password;

    private List<PrijavaAdministratoraDTO> prijave = new ArrayList<>();

    public AdministratorDTO() {
    }

    public AdministratorDTO(Administrator admin) {
        if (admin != null) {
            ime = admin.getIme();
            prezime = admin.getPrezime();
            datumRegistracije = admin.getDatumRegistracije().format(DateTimeFormatter.ofPattern("dd.MM.yyyy."));
            username = admin.getKorisnickoIme();
            password = "/";
            if (admin.getPrijave() != null && !admin.getPrijave().isEmpty()) {
                prijave = admin.getPrijave().stream().map(p -> new PrijavaAdministratoraDTO(p)).collect(Collectors.toList());
            }
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getDatumRegistracije() {
        return datumRegistracije;
    }

    public void setDatumRegistracije(String datumRegistracije) {
        this.datumRegistracije = datumRegistracije;
    }

    public List<PrijavaAdministratoraDTO> getPrijave() {
        return prijave;
    }

    public void setPrijave(List<PrijavaAdministratoraDTO> prijave) {
        this.prijave = prijave;
    }

}
