/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultelivraison.domain.model.service;

import com.faculte.simplefacultelivraison.domain.bean.LivraisonItem;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface LivraisonItemService {

    public void creeLivraisonItem(LivraisonItem livraisonItem);

    public List<LivraisonItem> findByLivraisonReference(String reference);
    
    public void deleteLivraisonItem(Long id);
    
    public BigDecimal qteBilan(String referenceLivraison,String refenceProduit);

    public List<LivraisonItem> livraisonItems();
}
