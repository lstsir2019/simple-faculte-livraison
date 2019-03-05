/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultelivraison.domain.rest;


import com.faculte.simplefacultelivraison.domain.bean.Livraison;
import com.faculte.simplefacultelivraison.domain.model.service.LivraisonService;
import com.faculte.simplefacultelivraison.domain.rest.converter.LivraisonVoConverter;
import com.faculte.simplefacultelivraison.domain.rest.proxy.ProduitProxy;
import com.faculte.simplefacultelivraison.domain.rest.vo.LivraisonVo;
import com.faculte.simplefacultelivraison.domain.rest.vo.exchange.ProduitVo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LENOVO
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping({"/Livraison-api/livraisons"})
public class LivraisonRest {

    @Autowired
    private LivraisonService livraisonService;
    @Autowired
    private ProduitProxy produitProxy;

    public Livraison findByReference(String reference) {
        return livraisonService.findByReference(reference);
    }

    @PostMapping("/")
    public int CreeLivraison(@RequestBody LivraisonVo livraisonVo) {
        System.out.println("=======================");
        System.out.println(livraisonVo);
        System.err.println("=======================");
        LivraisonVoConverter lvc = new LivraisonVoConverter();
        Livraison myLivraison = lvc.toItem(livraisonVo);
        return livraisonService.CreeLivraison(myLivraison);

    }
    @GetMapping("/")
    public List<LivraisonVo> fidAll() {
        LivraisonVoConverter lvc = new LivraisonVoConverter();
        return lvc.toVo(livraisonService.fidAll());
    }
    

    @GetMapping("/reference/{reference}")
    public ProduitVo findProduitByReference(@PathVariable String reference) {
        
        
       return produitProxy.findByReference(reference);
      
       

        

    }

    public LivraisonService getLivraisonService() {
        return livraisonService;
    }

    public void setLivraisonService(LivraisonService livraisonService) {
        this.livraisonService = livraisonService;
    }

    public ProduitProxy getProduitProxy() {
        return produitProxy;
    }

    public void setProduitProxy(ProduitProxy produitProxy) {
        this.produitProxy = produitProxy;
    }

}
