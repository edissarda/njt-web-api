/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.RukovodilacCreateDTO;
import model.Rukovodilac;

/**
 *
 * @author edis
 */
public interface IRukovodilacService {

    public Rukovodilac save(RukovodilacCreateDTO rukovodilacDTO) throws Exception;
}
