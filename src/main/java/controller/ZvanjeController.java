/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.ZvanjeDTO;
import java.util.List;
import javax.validation.Valid;
import model.Zvanje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import response.IResponse;
import response.ResponseBuilder;
import service.IZvanjeService;

/**
 *
 * @author edis
 */
@RestController
@RequestMapping(path = "/zvanje")
public class ZvanjeController {

    @Autowired(required = true)
    private IZvanjeService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public Object getAll() {
        try {
            List<Zvanje> zvanja = service.loadAll();
            return ResponseBuilder.getOkResponse(zvanja);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

    @PostMapping
    public IResponse create(@RequestBody ZvanjeDTO zvanje) {
        try {
            Zvanje kreiranoZvanje = service.save(zvanje);
            return ResponseBuilder.getOkResponse(kreiranoZvanje);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public IResponse getById(@PathVariable int id) {
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
            Zvanje zvanje = service.findById(id);
            service.delete(zvanje);
            return ResponseBuilder.getOkResponse(zvanje);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public IResponse update(@PathVariable("id") int id, @RequestBody Zvanje toUpdate) {
        try {
            if (id != toUpdate.getId()) {
                throw new Exception("Грешка. Идентификатори су различити.");
            }

            Zvanje updated = service.update(toUpdate);
            return ResponseBuilder.getOkResponse(updated);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }
}
