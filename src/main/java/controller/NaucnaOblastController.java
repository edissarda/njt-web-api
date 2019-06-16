/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.NaucnaOblastDTO;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.NaucnaOblast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;
import response.IResponse;
import response.ResponseBuilder;
import service.INaucnaOblastService;

/**
 *
 * @author edis
 */
@RestController
@RequestMapping(path = "naucna-oblast")
@CrossOrigin(origins = "*")
@SessionScope
public class NaucnaOblastController {

    @Autowired
    private INaucnaOblastService service;

    @GetMapping
    public IResponse loadAll() {
        try {
            List<NaucnaOblast> naucneOblasti = service.loadAll();
            List<NaucnaOblastDTO> naucneOblastiDTO = 
                    naucneOblasti.stream()
                    .map(no -> new NaucnaOblastDTO(no)).collect(Collectors.toList());
            return ResponseBuilder.getOkResponse(naucneOblastiDTO);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }
}
