/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultelivraison.domain.rest.proxy;

import com.faculte.simplefacultelivraison.domain.rest.vo.exchange.CommandeSourceWithProduit;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author gouss
 */

@FeignClient(name="simple-faculte-commande",url = "localhost:8090")
public interface CommandeProxy {
    
    @GetMapping("/faculte-commande/commandes/commande/{refCommande}/entity/{refEntite}")
    public List<CommandeSourceWithProduit> findByRefCommandeAndRefEntite(@PathVariable("refCommande") String refCommande,@PathVariable("refEntite") String refEntite);
 
    @PutMapping("/faculte-commande/items/commandeExpression/{referenceCommandeExpression}/QteLivre/{qte}/increment")
    public int incerementQteLivre(@PathVariable String referenceCommandeExpression,@PathVariable int qte);

  
}
