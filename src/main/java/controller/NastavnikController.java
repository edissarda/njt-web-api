/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.NastavnikDTO;
import java.util.List;
import java.util.stream.Collectors;
import model.Nastavnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;
import response.IResponse;
import response.ResponseBuilder;
import service.INastavnikService;

/**
 *
 * @author edis
 */
@RestController
@RequestMapping("nastavnik")
@SessionScope
@CrossOrigin(origins = "http://localhost:3000")
public class NastavnikController {

    @Autowired
    private INastavnikService service;

    @GetMapping
    public IResponse loadAll() {
        try {
            List<Nastavnik> nastavnici = service.loadAll();
            List<NastavnikDTO> nastavniciDTO = nastavnici.stream().map(n -> new NastavnikDTO(n)).collect(Collectors.toList());
            return ResponseBuilder.getOkResponse(nastavniciDTO);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

}