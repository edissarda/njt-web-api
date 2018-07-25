/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.KontaktPorukaDTO;
import java.util.List;
import java.util.stream.Collectors;
import model.KontaktPoruka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;
import response.IResponse;
import response.ResponseBuilder;
import service.IKontaktService;

/**
 *
 * @author edis
 */
@RestController
@RequestMapping("kontakt")
@SessionScope
@CrossOrigin(origins = "http://localhost:3000")
public class KontaktController {

    @Autowired
    private IKontaktService service;

    @GetMapping
    public IResponse loadAll() {
        try {
            List<KontaktPoruka> poruke = service.loadAll();
            List<KontaktPorukaDTO> kontaktPorukeDTO = poruke.stream().map(p -> new KontaktPorukaDTO(p)).collect(Collectors.toList());
            return ResponseBuilder.getOkResponse(kontaktPorukeDTO);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

    @PostMapping
    public IResponse kreirajPoruku(@RequestBody KontaktPorukaDTO porukaDTO) {
        try {
            KontaktPoruka poruka = service.kreirajPoruku(porukaDTO);
            KontaktPorukaDTO kontaktPorukaDTO = new KontaktPorukaDTO(poruka);
            return ResponseBuilder.getOkResponse(kontaktPorukaDTO);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

}
