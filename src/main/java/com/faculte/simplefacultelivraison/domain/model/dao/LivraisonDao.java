/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultelivraison.domain.model.dao;


import com.faculte.simplefacultelivraison.domain.bean.Livraison;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author LENOVO
 */
@Repository
public interface LivraisonDao extends JpaRepository<Livraison, Long>,PagingAndSortingRepository<Livraison, Long>{
    public Livraison findByReference(String reference);
    
 
   
    
    @Transactional
    public void deleteByReference(String reference);
    
}
