/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.NaucnaOblast;

/**
 *
 * @author edis
 */
public interface INaucnaOblastService {

    public List<NaucnaOblast> loadAll() throws Exception;
}
