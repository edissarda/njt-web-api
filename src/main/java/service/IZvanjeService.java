/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.ZvanjeDTO;
import java.util.List;
import model.Zvanje;

/**
 *
 * @author edis
 */
public interface IZvanjeService {

    public List<Zvanje> loadAll();

    public Zvanje save(ZvanjeDTO zvanje) throws Exception;

    public Zvanje findById(int id) throws Exception;

    public Zvanje delete(Zvanje zvanje) throws Exception;

    public Zvanje update(Zvanje toUpdate) throws Exception;

    public List<Zvanje> find(String naziv, int limit) throws Exception;
}
