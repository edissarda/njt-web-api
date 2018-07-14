/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import model.Rukovodilac;

/**
 *
 * @author edis
 */
public class RukovodilacCreateDTO implements Serializable {

    private FakultetDTO fakultet;

    private NastavnikDTO nastavnik;

    private TipRukovodiocaDTO tipRukovodioca;

    @NotBlank(message = "Датум од не сме бити непознат")
    private String datumOd;

    @NotBlank(message = "Датум до не сме бити непознат")
    private String datumDo;

    public RukovodilacCreateDTO() {
    }

    public RukovodilacCreateDTO(Rukovodilac rukovodilac) {
        if (rukovodilac != null) {
            tipRukovodioca = new TipRukovodiocaDTO(rukovodilac.getTipRukovodioca());
        }
    }

    public FakultetDTO getFakultet() {
        return fakultet;
    }

    public void setFakultet(FakultetDTO fakultet) {
        this.fakultet = fakultet;
    }

    public NastavnikDTO getNastavnik() {
        return nastavnik;
    }

    public void setNastavnik(NastavnikDTO nastavnik) {
        this.nastavnik = nastavnik;
    }

    public String getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(String datumOd) {
        this.datumOd = datumOd;
    }

    public String getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(String datumDo) {
        this.datumDo = datumDo;
    }

    public TipRukovodiocaDTO getTipRukovodioca() {
        return tipRukovodioca;
    }

    public void setTipRukovodioca(TipRukovodiocaDTO tipRukovodioca) {
        this.tipRukovodioca = tipRukovodioca;
    }

}
