/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Nastavnik;

/**
 *
 * @author edis
 */
public interface INastavnikService {

    public Nastavnik getById(Integer id) throws Exception;
    public List<Nastavnik> loadAll() throws Exception;

}
