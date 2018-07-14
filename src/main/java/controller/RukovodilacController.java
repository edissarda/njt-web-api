/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.RukovodilacCreateDTO;
import model.Rukovodilac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;
import response.IResponse;
import response.ResponseBuilder;
import service.IRukovodilacService;

/**
 *
 * @author edis
 */
@RestController
@RequestMapping("rukovodilac")
@SessionScope
@CrossOrigin(origins = "http://localhost:3000")
public class RukovodilacController {
    
    @Autowired
    private IRukovodilacService service;

    @PostMapping
    public IResponse create(@RequestBody RukovodilacCreateDTO rukovodilacDTO) {
        try {
            Rukovodilac rukovodilac = service.save(rukovodilacDTO);
            RukovodilacCreateDTO rukovDTO = new RukovodilacCreateDTO(rukovodilac);
            return ResponseBuilder.getOkResponse(rukovDTO);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

}
