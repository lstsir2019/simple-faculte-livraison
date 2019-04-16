/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultelivraison.domain.model.dao.Searsh;

import com.faculte.simplefacultelivraison.domain.bean.Livraison;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.faculte.simplefacultelivraison.commun.util.SearchUtil;

/**
 *
 * @author gouss
 */
@Repository
public class LivraisonSearsh {

    @Autowired
    private EntityManager entityManager;
    
    public List<Livraison> findLivraisonByQuery(String referenceLivraison,String referenceCommande,Date dateMin,Date dateMax){
        String query="SELECT l FROM Livraison l WHERE 1=1";
        query+=SearchUtil.addConstraint("l","reference", "LIKE",referenceLivraison);
        query+=SearchUtil.addConstraint("l","referenceCommande", "LIKE",referenceCommande);
        query+=SearchUtil.addConstraintMinMaxDate("l", "date", dateMin, dateMax);
        System.out.println(query);
        return entityManager.createQuery(query).getResultList();
        
    }

    
}
