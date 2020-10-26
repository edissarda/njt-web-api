/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

import dto.TipRukovodiocaDTO;
import model.TipRukovodioca;

/**
 *
 * @author edis
 */
public interface ITipRukovodiocaService {

    public List<TipRukovodioca> loadAll() throws Exception;

    TipRukovodioca create(TipRukovodiocaDTO tipRukovodioca) throws Exception;

    TipRukovodioca delete(int id) throws Exception;
}
