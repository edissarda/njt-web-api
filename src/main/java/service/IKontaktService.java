/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.KontaktPorukaDTO;
import java.util.List;
import model.KontaktPoruka;

/**
 *
 * @author edis
 */
public interface IKontaktService {

    public List<KontaktPoruka> loadAll() throws Exception;

    public KontaktPoruka kreirajPoruku(KontaktPorukaDTO kontaktPorukaDTO) throws Exception;
}
