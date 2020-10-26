
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;

import dto.TipRukovodiocaDTO;
import model.TipRukovodioca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import response.IResponse;
import response.ResponseBuilder;
import service.ITipRukovodiocaService;

/**
 *
 * @author edis
 */
@RestController
@RequestMapping(path = "tip-rukovodioca")
@CrossOrigin(origins = "*")
@SessionScope
public class TipRukovodiocaController {

    @Autowired(required = true)
    private ITipRukovodiocaService tipRukovodoicaService;

    @PostMapping
    public IResponse create(@RequestBody TipRukovodiocaDTO tipRukovodioca) {
        try {
            TipRukovodioca kreireniTipRukovodioca = this.tipRukovodoicaService.create(tipRukovodioca);
            return ResponseBuilder.getOkResponse(new TipRukovodiocaDTO(kreireniTipRukovodioca));
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

    @DeleteMapping(path = "/{id}")
    public IResponse delete(@PathVariable() int id) {
        try {
            TipRukovodioca kreireniTipRukovodioca = this.tipRukovodoicaService.delete(id);
            return ResponseBuilder.getOkResponse(new TipRukovodiocaDTO(kreireniTipRukovodioca));
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

    @GetMapping
    public IResponse loadAll() {
        try {
            List<TipRukovodioca> tipoviRukovodioca = tipRukovodoicaService.loadAll();
            return ResponseBuilder.getOkResponse(tipoviRukovodioca);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

}
