/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.FakultetDTO;
import dto.RukovodilacDTO;
import java.util.List;
import java.util.stream.Collectors;
import model.Fakultet;
import model.Rukovodilac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;
import response.IResponse;
import response.ResponseBuilder;
import service.IFakultetService;

/**
 *
 * @author edis
 */
@RestController
@RequestMapping(path = "fakultet")
@SessionScope
@CrossOrigin(origins = "http://localhost:3000")
public class FakultetController {

    @Autowired
    private IFakultetService service;

    @GetMapping
    public IResponse loadAll() {
        try {
            List<Fakultet> fakulteti = service.loadAll();
            List<FakultetDTO> fakultetiDTO = fakulteti.stream().map(f -> new FakultetDTO(f)).collect(Collectors.toList());
            return ResponseBuilder.getOkResponse(fakultetiDTO);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

    @GetMapping(path = "/{id}")
    public IResponse loadById(@PathVariable(name = "id") Integer id) {
        try {
            Fakultet f = service.loadById(id);
            return ResponseBuilder.getOkResponse(new FakultetDTO(f));
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

    @PostMapping
    public IResponse save(@RequestBody FakultetDTO fakultetDTO) {
        try {
            Fakultet fakultet = service.create(fakultetDTO);
            return ResponseBuilder.getOkResponse(new FakultetDTO(fakultet));
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

    @GetMapping(path = "/{id}/rukovodioci")
    public IResponse rukovodiociZaFakultet(@PathVariable(name = "id") Integer fakultetID) {
        try {
            List<Rukovodilac> rukovodioci = service.ucitajRukovodioceZaFakultet(fakultetID);

            List<RukovodilacDTO> rukovodiociDTO = rukovodioci.stream().map(r -> new RukovodilacDTO(r)).collect(Collectors.toList());
            return ResponseBuilder.getOkResponse(rukovodiociDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

}
