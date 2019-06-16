/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.AdministratorDTO;
import model.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import response.IResponse;
import response.ResponseBuilder;
import service.IAuthService;

/**
 *
 * @author edis
 */
@RestController
@RequestMapping(path = "auth")
@RequestScope
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private IAuthService service;

    @PostMapping(path = "login")
    public IResponse login(@RequestBody AdministratorDTO adminDTO) {
        try {
            Administrator admin = service.login(adminDTO);
            AdministratorDTO administratorDTO = new AdministratorDTO(admin);
            return ResponseBuilder.getOkResponse(administratorDTO);
        } catch (Exception e) {
            return ResponseBuilder.getErrorResponse(e.getMessage());
        }
    }

}
