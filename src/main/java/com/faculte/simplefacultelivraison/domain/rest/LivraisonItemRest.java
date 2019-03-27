/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultelivraison.domain.rest;

/**
 *
 * @author gouss
 */


import com.faculte.simplefacultelivraison.domain.bean.LivraisonItem;
import com.faculte.simplefacultelivraison.domain.model.service.LivraisonItemService;
import com.faculte.simplefacultelivraison.domain.rest.converter.LivraisonItemConverter;
import com.faculte.simplefacultelivraison.domain.rest.vo.LivraisonItemVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value ={"/Livraison-api/livraisonItems"})
public class LivraisonItemRest {
    @Autowired
    private LivraisonItemService livraisonItemService;
   
    
    @GetMapping("/livraison/reference/{reference}")
    public List<LivraisonItemVo> findByLivraisonReference(@PathVariable String reference) {
        LivraisonItemConverter converter=new LivraisonItemConverter();
        return  converter.toVo(livraisonItemService.findByLivraisonReference(reference));
    }

    public LivraisonItemService getLivraisonItemService() {
        return livraisonItemService;
    }

    public void setLivraisonItemService(LivraisonItemService livraisonItemService) {
        this.livraisonItemService = livraisonItemService;
    }
    
    
    
    
}
