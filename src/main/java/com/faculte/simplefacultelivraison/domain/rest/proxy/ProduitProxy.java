/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultelivraison.domain.rest.proxy;


import com.faculte.simplefacultelivraison.domain.rest.vo.exchange.ProduitVo;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author LENOVO
 */
@RibbonClient(name = "microservice-produits")
@FeignClient(name = "microservice-produits")
public interface ProduitProxy {
    
    @GetMapping("/produit_api/produit/reference/{reference}")
    public ProduitVo findByReference(@PathVariable("reference") String reference);
    
}
