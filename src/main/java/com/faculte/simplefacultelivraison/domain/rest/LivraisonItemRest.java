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


import com.faculte.simplefacultelivraison.commun.pdf.GeneratePdf;
import com.faculte.simplefacultelivraison.domain.bean.LivraisonItem;
import com.faculte.simplefacultelivraison.domain.model.service.LivraisonItemService;
import com.faculte.simplefacultelivraison.domain.rest.converter.LivraisonItemConverter;
import com.faculte.simplefacultelivraison.domain.rest.vo.LivraisonItemVo;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
   
    @DeleteMapping("/delete/id/{id}")
    public void deleteLivraisonItem(@PathVariable Long id) {
        livraisonItemService.deleteLivraisonItem(id);
    }
    @GetMapping("/qte/livraison/{referenceLivraison}/produit/{refenceProduit}")
    public BigDecimal qteBilan(@PathVariable String referenceLivraison,@PathVariable String refenceProduit) {
        return livraisonItemService.qteBilan(referenceLivraison, refenceProduit);
    }

     @GetMapping("/pdf")
    public ResponseEntity<Object> report()throws JRException, IOException{
        Map<String,Object> params=new HashMap<>();
        params.put("reference", "ref-1");
      
        params.put("referenceCommande", "ref-1");
        params.put("referenceEntite", "ref-1");
        
        return GeneratePdf.generate("test", params,livraisonItemService.livraisonItems(), "/rapport/rapport.jasper");
    }
    
    
    public LivraisonItemService getLivraisonItemService() {
        return livraisonItemService;
    }

    public void setLivraisonItemService(LivraisonItemService livraisonItemService) {
        this.livraisonItemService = livraisonItemService;
    }
    
    
    
    
}
