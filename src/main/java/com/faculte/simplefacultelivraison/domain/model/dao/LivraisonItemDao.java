/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultelivraison.domain.model.dao;

import com.faculte.simplefacultelivraison.domain.bean.Livraison;
import com.faculte.simplefacultelivraison.domain.bean.LivraisonItem;
import java.math.BigDecimal;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LENOVO
 */
@Repository
public interface LivraisonItemDao extends JpaRepository<LivraisonItem, Long> {

    public List<LivraisonItem> findByLivraisonReference(String reference);
    
    @Transactional
    public void deleteById(Long id);
    
    @Query("SELECT  SUM(qte) FROM LivraisonItem l WHERE l.livraison.referenceCommande = ?1  AND l.refenceProduit= ?2")
    public BigDecimal qteBilan(String referenceCommande,String refenceProduit );
    

}
