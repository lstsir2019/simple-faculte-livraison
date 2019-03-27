/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultelivraison.domain.model.service;

import com.faculte.simplefacultelivraison.domain.bean.Livraison;
import com.faculte.simplefacultelivraison.domain.bean.LivraisonItem;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface LivraisonService {

    public Livraison findByReference(String reference);

    public int CreeLivraison(Livraison livraison);

    public List<Livraison> fidAll();

   
}
