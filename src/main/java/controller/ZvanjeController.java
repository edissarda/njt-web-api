/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.ZvanjeDTO;
import java.util.List;
import model.Zvanje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;
import response.IResponse;
import response.ResponseBuilder;
import service.IZvanjeService;

/**
 *
 * @author edis
 */
@RestController
@RequestMapping(path = "zvanje")
@CrossOrigin(origins = "http://localhost:3000")
@SessionScope
public class ZvanjeController {

    @Autowired(required = true)
    private IZvanjeService service;

    @GetMapping
    public Object getAll() {
        try {
            List<Zvanje> zvanja = service.loadAll();
            return ResponseBuilder.getOkResponse(zvanja);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

    @GetMapping(path = "/find")
    public IResponse find(
            @RequestParam(required = true) String naziv,
            @RequestParam(required = false, defaultValue = "5") int limit
    ) {
        try {
            List<Zvanje> zvanja = service.find(naziv, limit);
            return ResponseBuilder.getOkResponse(zvanja);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

    @PostMapping
    public IResponse create(@RequestBody ZvanjeDTO zvanje
    ) {
        try {
            Zvanje kreiranoZvanje = service.save(zvanje);
            return ResponseBuilder.getOkResponse(kreiranoZvanje);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public IResponse getById(@PathVariable int id
    ) {
        try {
            Zvanje zvanje = service.findById(id);
            return ResponseBuilder.getOkResponse(zvanje);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public IResponse delete(@PathVariable int id) {
        try {
            ZvanjeDTO zvanjeDTO = new ZvanjeDTO(service.delete(id));
            return ResponseBuilder.getOkResponse(zvanjeDTO);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public IResponse update(@PathVariable("id") int id,
            @RequestBody ZvanjeDTO toUpdate) {
        try {
            if (id != toUpdate.getId()) {
                throw new Exception("Грешка. Идентификатори су различити.");
            }

            ZvanjeDTO updatedDTO = new ZvanjeDTO(service.update(toUpdate));
            return ResponseBuilder.getOkResponse(updatedDTO);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }
}
