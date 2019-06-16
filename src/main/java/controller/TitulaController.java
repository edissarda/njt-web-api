/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.TitulaDTO;
import java.util.List;
import java.util.stream.Collectors;
import model.Titula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;
import response.IResponse;
import response.ResponseBuilder;
import service.ITitulaService;

/**
 *
 * @author edis
 */
@RestController
@RequestMapping("titula")
@SessionScope
@CrossOrigin(origins = "*")
public class TitulaController {

    @Autowired
    private ITitulaService service;

    @GetMapping
    public IResponse loadAll() {
        try {
            List<Titula> titule = service.loadAll();
            List<TitulaDTO> tituleDTO = titule.stream().map(t -> new TitulaDTO(t)).collect(Collectors.toList());
            return ResponseBuilder.getOkResponse(tituleDTO);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

}
