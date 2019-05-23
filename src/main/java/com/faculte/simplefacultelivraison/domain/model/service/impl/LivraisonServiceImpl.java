/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultelivraison.domain.model.service.impl;

import com.faculte.simplefacultelivraison.commun.util.NuberUtil;
import com.faculte.simplefacultelivraison.domain.bean.Livraison;
import com.faculte.simplefacultelivraison.domain.bean.LivraisonItem;
import com.faculte.simplefacultelivraison.domain.model.dao.LivraisonDao;
import com.faculte.simplefacultelivraison.domain.model.dao.LivraisonItemDao;
import com.faculte.simplefacultelivraison.domain.model.dao.Searsh.LivraisonSearsh;
import com.faculte.simplefacultelivraison.domain.model.service.LivraisonItemService;
import com.faculte.simplefacultelivraison.domain.model.service.LivraisonService;
import com.faculte.simplefacultelivraison.domain.rest.proxy.CommandeProxy;
import com.faculte.simplefacultelivraison.domain.rest.proxy.ProduitProxy;
import com.faculte.simplefacultelivraison.domain.rest.vo.exchange.ProduitVo;
import com.faculte.simplefacultelivraison.domain.rest.vo.exchange.StockGlobal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.transport.LiveRef;
import com.faculte.simplefacultelivraison.domain.rest.proxy.StockProxy;
import com.faculte.simplefacultelivraison.domain.rest.vo.exchange.MagasinVo;
import com.faculte.simplefacultelivraison.domain.rest.vo.exchange.StockVo;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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
    private StockProxy stockProxy;
    @Autowired
    private CommandeProxy commandeProxy;

    @Autowired
    private LivraisonSearsh livraisonSearsh;

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
                livraisonItem.setLivraison(livraison);
                livraisonItemService.creeLivraisonItem(livraisonItem);
                StockGlobal global = stockGlobal(livraisonItem);
                int i = stockProxy.livraisonStockGlobal(global, livraisonItem.getStrategy());
                commandeProxy.incerementQteLivre(livraisonItem.getReferenceCommandeExpression(), livraisonItem.getQte().intValue());
                System.out.println("ha di i " + i);
            }
            return 1;
        }

    }

    public int creeLivraisonDetaille(Livraison livraison) {
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
                livraisonItem.setLivraison(livraison);
                livraisonItemService.creeLivraisonItem(livraisonItem);
                StockVo stockVo = stockdetaiille(livraisonItem);
                stockProxy.stockLivraison(stockVo);
                commandeProxy.incerementQteLivre(livraisonItem.getReferenceCommandeExpression(),livraisonItem.getQte().intValue());

            }
            return 1;
        }

    }

    private StockGlobal stockGlobal(LivraisonItem livraisonItem) {
        NuberUtil util = new NuberUtil();
        StockGlobal stockGlobal = new StockGlobal();
        stockGlobal.setQte(util.toBigString(livraisonItem.getQte()));
        stockGlobal.setReferenceCommande(livraisonItem.getLivraison().getReferenceCommande());
        stockGlobal.setReferenceMagasin(livraisonItem.getCodeMagasin());
        stockGlobal.setReferenceProduit(livraisonItem.getRefenceProduit());
        return stockGlobal;
    }

    private StockVo stockdetaiille(LivraisonItem livraisonItem) {
        NuberUtil util = new NuberUtil();
        StockVo stockVo = new StockVo();
        stockVo.setReferenceReception(livraisonItem.getReferenceReception());
        stockVo.setQte(util.toBigString(livraisonItem.getQte()));
        stockVo.setMagasinVo(new MagasinVo(livraisonItem.getCodeMagasin()));
        stockVo.setReferenceProduit(livraisonItem.getRefenceProduit());
        return stockVo;
    }

    public LivraisonSearsh getLivraisonSearsh() {
        return livraisonSearsh;
    }

    public void setLivraisonSearsh(LivraisonSearsh livraisonSearsh) {
        this.livraisonSearsh = livraisonSearsh;
    }

    public StockProxy getStockProxy() {
        return stockProxy;
    }

    public void setStockProxy(StockProxy stockProxy) {
        this.stockProxy = stockProxy;
    }

    @Override
    public List<Livraison> fidAll() {
        return livraisonDao.findAll();
    }

    @Override
    public void deleteLivraison(String reference) {
        decrementQteLivre(reference);
        livraisonDao.deleteByReference(reference);
        
        
    }

    private void decrementQteLivre(String reference){
         Livraison livraison=  findByReference(reference);
       for (LivraisonItem livraisonItem : livraison.getLivraisonItems()){
           commandeProxy.decerementQteLivre(livraisonItem.getReferenceCommandeExpression(),livraisonItem.getQte().intValue());
       }
    }
    
    @Override
    public List<Livraison> findLivraisonsByQuery(String referenceLivraison, String referenceCommande, Date dateMin, Date dateMax) {
        return livraisonSearsh.findLivraisonByQuery(referenceLivraison, referenceCommande, dateMin, dateMax);
    }

    @Override
    public List<Livraison> fidAllPage(int page, int size) {
        return (List<Livraison>) livraisonDao.findAll(new PageRequest(page, size));
    }

    public CommandeProxy getCommandeProxy() {
        return commandeProxy;
    }

    public void setCommandeProxy(CommandeProxy commandeProxy) {
        this.commandeProxy = commandeProxy;
    }

}
