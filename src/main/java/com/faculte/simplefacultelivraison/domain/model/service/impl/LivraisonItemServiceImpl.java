/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultelivraison.domain.model.service.impl;


import com.faculte.simplefacultelivraison.domain.bean.LivraisonItem;
import com.faculte.simplefacultelivraison.domain.model.dao.LivraisonItemDao;
import com.faculte.simplefacultelivraison.domain.model.service.LivraisonItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class LivraisonItemServiceImpl implements LivraisonItemService{
      @Autowired
       private LivraisonItemDao livraisonItemDao;

    public LivraisonItemDao getLivraisonItemDao() {
        return livraisonItemDao;
    }

    public void setLivraisonItemDao(LivraisonItemDao livraisonItemDao) {
        this.livraisonItemDao = livraisonItemDao;
    }
    
    @Override
    public void creeLivraisonItem(LivraisonItem livraisonItem) {
       
        livraisonItemDao.save(livraisonItem);
    }

    @Override
    public List<LivraisonItem> findByLivraisonReference(String reference) {
       return livraisonItemDao.findByLivraisonReference(reference);
    }
}
