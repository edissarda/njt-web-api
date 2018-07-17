/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.AdministratorDTO;
import model.Administrator;

/**
 *
 * @author edis
 */
public interface IAuthService {

    public Administrator login(AdministratorDTO adminDTO) throws Exception;
}
