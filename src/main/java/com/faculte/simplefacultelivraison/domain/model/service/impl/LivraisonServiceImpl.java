/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultelivraison.domain.model.service.impl;


import com.faculte.simplefacultelivraison.domain.bean.Livraison;
import com.faculte.simplefacultelivraison.domain.bean.LivraisonItem;
import com.faculte.simplefacultelivraison.domain.model.dao.LivraisonDao;
import com.faculte.simplefacultelivraison.domain.model.dao.LivraisonItemDao;
import com.faculte.simplefacultelivraison.domain.model.service.LivraisonItemService;
import com.faculte.simplefacultelivraison.domain.model.service.LivraisonService;
import com.faculte.simplefacultelivraison.domain.rest.proxy.ProduitProxy;
import com.faculte.simplefacultelivraison.domain.rest.vo.exchange.ProduitVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.transport.LiveRef;

/**
 *
 * @author LENOVO
 */
@Service
public class LivraisonServiceImpl implements LivraisonService {

    @Autowired
    private LivraisonDao livraisonDao;
    @Autowired
    private LivraisonItemDao livraisonItemDao;
    @Autowired
    private LivraisonItemService livraisonItemService;
    @Autowired
    private ProduitProxy produitProxy;

    public LivraisonItemService getLivraisonItemService() {
        return livraisonItemService;
    }

    public void setLivraisonItemService(LivraisonItemService livraisonItemService) {
        this.livraisonItemService = livraisonItemService;
    }

    public LivraisonItemDao getLivraisonItemDao() {
        return livraisonItemDao;
    }

    public void setLivraisonItemDao(LivraisonItemDao livraisonItemDao) {
        this.livraisonItemDao = livraisonItemDao;
    }

    public LivraisonDao getLivraisonDao() {
        return livraisonDao;
    }

    public void setLivraisonDao(LivraisonDao livraisonDao) {
        this.livraisonDao = livraisonDao;
    }

    @Override
    public Livraison findByReference(String reference) {
        return livraisonDao.findByReference(reference);
    }

    @Override
    public int CreeLivraison(Livraison livraison) {

        Livraison l = findByReference(livraison.getReference());
        System.out.println("----------------------");
        System.out.println(livraison);
        System.out.println("----------------------");
        if (l != null) {
            return -1;
        } else if (livraison.getLivraisonItems().isEmpty()) {
            return -2;
        } else {
            livraisonDao.save(livraison);
            for (LivraisonItem livraisonItem : livraison.getLivraisonItems()) {
                ProduitVo produitVo = produitProxy.findByReference(livraisonItem.getRefenceProduit());
                if (produitVo != null && produitVo.getReference() != null) {
                    livraisonItem.setLivraison(livraison);
                    livraisonItemService.creeLivraisonItem(livraisonItem);
                }
            }
            return 1;
        }

    }

    public ProduitProxy getProduitProxy() {
        return produitProxy;
    }

    public void setProduitProxy(ProduitProxy produitProxy) {
        this.produitProxy = produitProxy;
    }

    @Override
    public List<Livraison> fidAll() {
        return livraisonDao.findAll();
    }

    

}
