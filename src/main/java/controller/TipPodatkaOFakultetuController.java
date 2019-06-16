/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.TipPodatkaOFakultetuDTO;
import java.util.List;
import java.util.stream.Collectors;
import model.TipPodatkaOFakultetu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;
import response.IResponse;
import response.ResponseBuilder;
import service.ITipPodatkaOFakultetuService;

/**
 *
 * @author edis
 */
@RestController
@RequestMapping("tip-podatka")
@SessionScope
@CrossOrigin(origins = "*")
public class TipPodatkaOFakultetuController {

    @Autowired
    private ITipPodatkaOFakultetuService service;

    @GetMapping
    public IResponse loadAll() {
        try {
            List<TipPodatkaOFakultetu> tipoviPodataka = service.loadAll();
            List<TipPodatkaOFakultetuDTO> tipoviPodatakaDTO
                    = tipoviPodataka.stream().map(tp -> new TipPodatkaOFakultetuDTO(tp)).collect(Collectors.toList());
            return ResponseBuilder.getOkResponse(tipoviPodatakaDTO);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

}
