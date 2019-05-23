/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultelivraison.domain.rest;


import com.faculte.simplefacultelivraison.commun.pdf.GeneratePdf;
import com.faculte.simplefacultelivraison.commun.util.DateUtil;
import com.faculte.simplefacultelivraison.domain.bean.Livraison;
import com.faculte.simplefacultelivraison.domain.model.service.LivraisonService;
import com.faculte.simplefacultelivraison.domain.rest.converter.LivraisonVoConverter;
import com.faculte.simplefacultelivraison.domain.rest.proxy.CommandeProxy;
import com.faculte.simplefacultelivraison.domain.rest.proxy.ProduitProxy;
import com.faculte.simplefacultelivraison.domain.rest.vo.LivraisonVo;
import com.faculte.simplefacultelivraison.domain.rest.vo.exchange.CommandeSourceWithProduit;
import com.faculte.simplefacultelivraison.domain.rest.vo.exchange.ProduitVo;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author LENOVO
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value ={"/Livraison-api/livraisons"})
public class LivraisonRest {

    @Autowired
    private LivraisonService livraisonService;
    @Autowired
    private ProduitProxy produitProxy;
    @Autowired
    private CommandeProxy commandeProxy;

    
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
   @PostMapping("/detaille/")
    public int creeLivraisonDetaille(@RequestBody LivraisonVo livraisonVo) {
        LivraisonVoConverter lvc = new LivraisonVoConverter();
        Livraison myLivraison = lvc.toItem(livraisonVo);
        return livraisonService.creeLivraisonDetaille(myLivraison);
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

    @DeleteMapping("/delete/reference/{reference}")
    public void deleteLivraison(@PathVariable String reference) {
        livraisonService.deleteLivraison(reference);
    }
   
    @PostMapping("/query")
    public List<LivraisonVo> findLivraisonsByQuery(@RequestBody LivraisonVo livraisonVo) {
        LivraisonVoConverter lvc = new LivraisonVoConverter();
        return lvc.toVo(livraisonService.findLivraisonsByQuery(livraisonVo.getReference(),livraisonVo.getReferenceCommande(), DateUtil.parse(livraisonVo.getDateMin()),DateUtil.parse(livraisonVo.getDateMax())));
    }

    @RequestMapping(value = "/searchPage",method = RequestMethod.GET)
  public List<LivraisonVo> fidAllPage(@RequestParam(name = "page",defaultValue = "0") int page,@RequestParam(name = "size",defaultValue = "5") int size) {
        LivraisonVoConverter lvc = new LivraisonVoConverter();
      return lvc.toVo(livraisonService.fidAllPage(page, size));
    }
  
   @GetMapping("/commande/{refCommande}/entity/{refEntite}")
   public List<CommandeSourceWithProduit> findByRefCommandeAndRefEntite(@PathVariable String refCommande,@PathVariable String refEntite) {
        return commandeProxy.findByRefCommandeAndRefEntite(refCommande, refEntite);
    }

   @PutMapping("/incrementeQte/commandeExpression/{referenceCommandeExpression}/QteLivre/{qte}")
    public int incerementQteLivre(@PathVariable String referenceCommandeExpression,@PathVariable int qte) {
        return commandeProxy.incerementQteLivre(referenceCommandeExpression, qte);
    }
    
     @GetMapping("/pdf/reference/{reference}")
    public ResponseEntity<Object> report(@PathVariable String reference)throws JRException, IOException{
        Map<String,Object> params=new HashMap<>();
         
        Livraison myLivraison = livraisonService.findByReference(reference);
        
        params.put("reference", myLivraison.getReference());
        params.put("date",myLivraison.getDate());
      
        params.put("referenceCommande",myLivraison.getReferenceCommande());
        params.put("referenceEntite", myLivraison.getReferenceEntite());
        
        return GeneratePdf.generate("test", params,myLivraison.getLivraisonItems(), "/rapport/rapport.jasper");
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

    public CommandeProxy getCommandeProxy() {
        return commandeProxy;
    }

    public void setCommandeProxy(CommandeProxy commandeProxy) {
        this.commandeProxy = commandeProxy;
    }

    
}
