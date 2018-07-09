/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.FakultetDTO;
import java.util.List;
import model.Fakultet;
import model.Rukovodilac;

/**
 *
 * @author edis
 */
public interface IFakultetService {

    public List<Fakultet> loadAll() throws Exception;

    public List<Rukovodilac> ucitajRukovodioceZaFakultet(Integer fakultetID) throws Exception;

    public Fakultet loadById(Integer id) throws Exception;

    public Fakultet create(FakultetDTO fakultetDTO) throws Exception;
}
