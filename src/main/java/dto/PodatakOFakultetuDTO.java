/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import model.PodatakOFakultetu;

/**
 *
 * @author edis
 */
public class PodatakOFakultetuDTO implements Serializable {

    private int id;
    private String vrednost;
    private TipPodatkaOFakultetuDTO tipPodatka;

    public PodatakOFakultetuDTO(PodatakOFakultetu podatak) {
        if (podatak != null) {
            this.id = podatak.getId();
            this.vrednost = podatak.getVrednost();
            this.tipPodatka = new TipPodatkaOFakultetuDTO(podatak.getTipPodatka());
        }
    }

    public PodatakOFakultetuDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVrednost() {
        return vrednost;
    }

    public void setVrednost(String vrednost) {
        this.vrednost = vrednost;
    }

    public TipPodatkaOFakultetuDTO getTipPodatka() {
        return tipPodatka;
    }

    public void setTipPodatka(TipPodatkaOFakultetuDTO vrstaPodatka) {
        this.tipPodatka = vrstaPodatka;
    }

}
