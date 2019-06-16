/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.NastavnikDTO;
import dto.TitulaDTO;
import dto.ZvanjeDTO;
import java.util.List;
import java.util.stream.Collectors;
import model.Nastavnik;
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
import service.INastavnikService;

/**
 *
 * @author edis
 */
@RestController
@RequestMapping("nastavnik")
@SessionScope
@CrossOrigin(origins = "*")
public class NastavnikController {

    @Autowired
    private INastavnikService service;

    @GetMapping(path = "/{id}")
    public IResponse getById(@PathVariable(name = "id") Integer id) {
        try {
            Nastavnik nastavnik = service.getById(id);
            NastavnikDTO nastavnikDTO = new NastavnikDTO(nastavnik);
            return ResponseBuilder.getOkResponse(nastavnikDTO);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

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

    @PostMapping
    public IResponse save(@RequestBody NastavnikDTO nastavnikDTO) {
        try {
            Nastavnik nastavnik = service.save(nastavnikDTO);
            NastavnikDTO nastavnikDTOResp = new NastavnikDTO(nastavnik);
            return ResponseBuilder.getOkResponse(nastavnikDTOResp);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

    @PostMapping(path = "/{id}/zvanje")
    public IResponse postaviZvanjeNastavniku(@PathVariable(name = "id") Integer nastavnikId, @RequestBody ZvanjeDTO zvanjeDTO) {
        try {
            Nastavnik nastavnik = service.dodajZvanjeNastavniku(nastavnikId, zvanjeDTO);
            NastavnikDTO nastavnikDTO = new NastavnikDTO(nastavnik);
            return ResponseBuilder.getOkResponse(nastavnikDTO);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }
    
    @PostMapping(path = "/{id}/titula")
    public IResponse postaviTituluNastavniku(@PathVariable(name = "id") Integer nastavnikId, @RequestBody TitulaDTO titulaDTO) {
        try {
            Nastavnik nastavnik = service.dodajTituluNastavniku(nastavnikId, titulaDTO);
            NastavnikDTO nastavnikDTO = new NastavnikDTO(nastavnik);
            return ResponseBuilder.getOkResponse(nastavnikDTO);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

}
