/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultelivraison.domain.model.service;

import com.faculte.simplefacultelivraison.domain.bean.Livraison;
import com.faculte.simplefacultelivraison.domain.bean.LivraisonItem;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author LENOVO
 */
public interface LivraisonService {

    public Livraison findByReference(String reference);

    public int CreeLivraison(Livraison livraison);

    public int creeLivraisonDetaille(Livraison livraison);

    public List<Livraison> fidAll();
    public List<Livraison> fidAllPage(int page,int size);
    
    public void deleteLivraison(String reference);
    
    public List<Livraison> findLivraisonsByQuery(String referenceLivraison,String referenceCommande,Date dateMin,Date dateMax);

}
