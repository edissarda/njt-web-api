
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.TipRukovodioca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import response.IResponse;
import response.ResponseBuilder;
import service.ITipRukovodiocaService;

/**
 *
 * @author edis
 */
@RestController
@RequestMapping(path = "tiprukovodioca")
public class TipRukovodiocaController {

    @Autowired(required = true)
    private ITipRukovodiocaService tipRukovodoicaService;

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
