/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.VrstaOrganizacije;

/**
 *
 * @author edis
 */
public interface IVrstaOrganizacijeService {

    public List<VrstaOrganizacije> loadAll() throws Exception;
}
