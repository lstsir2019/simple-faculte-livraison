/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultelivraison.domain.model.dao;


import com.faculte.simplefacultelivraison.domain.bean.LivraisonItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LENOVO
 */
@Repository
public interface LivraisonItemDao extends JpaRepository<LivraisonItem, Long>{
   
}
