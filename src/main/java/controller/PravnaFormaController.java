/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.PravnaForma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;
import response.IResponse;
import response.ResponseBuilder;
import service.IPravnaFormaService;

/**
 *
 * @author edis
 */
@RestController
@RequestMapping(path = "pravna-forma")
@SessionScope
@CrossOrigin(origins = "*")
public class PravnaFormaController {

    @Autowired
    private IPravnaFormaService service;

    @GetMapping
    public IResponse loadAll() {
        try {
            List<PravnaForma> pravneForme = service.loadAll();
            return ResponseBuilder.getOkResponse(pravneForme);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

}
