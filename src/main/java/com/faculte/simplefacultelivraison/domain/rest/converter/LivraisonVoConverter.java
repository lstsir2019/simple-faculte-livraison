/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultelivraison.domain.rest.converter;


import com.faculte.simplefacultelivraison.commun.util.NuberUtil;
import com.faculte.simplefacultelivraison.domain.bean.Livraison;
import com.faculte.simplefacultelivraison.domain.rest.vo.LivraisonVo;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class LivraisonVoConverter implements AbstractConverter<Livraison, LivraisonVo>{

    @Override
    public Livraison toItem(LivraisonVo vo) {
       if(vo==null){
           return null;
           }else{
           Livraison livraison=new Livraison();
           try {
               livraison.setDate(NuberUtil.toDate(vo.getDate()));
           } catch (ParseException ex) {
               livraison.setDate(null);
           }
           livraison.setReference(vo.getReference());
           livraison.setReferenceCommande(vo.getReferenceCommande());
           livraison.setLivraisonItems(new LivraisonItemConverter().toItem(vo.getLivraisonItemVos()));
           livraison.setReferenceEntite(vo.getReferenceEntite());
           return livraison;
       }
    }

    @Override
    public LivraisonVo toVo(Livraison item) {
        if(item==null){
            return null;
        }
        else{
            LivraisonVo vo=new LivraisonVo();
            vo.setReference(item.getReference());
            vo.setReferenceCommande(item.getReferenceCommande());
            vo.setDate(NuberUtil.toDateString(item.getDate()));
            vo.setLivraisonItemVos(new LivraisonItemConverter().toVo(item.getLivraisonItems()));
            vo.setReferenceEntite(item.getReferenceEntite());
            return vo;
        }
    }
    public List<LivraisonVo> toVo(List<Livraison> livraisons){
        if(livraisons==null || livraisons.isEmpty()){
            return null;
        }else{
            List<LivraisonVo> livraisonVos=new ArrayList<>();
            for (Livraison livraison : livraisons) {
                livraisonVos.add(toVo(livraison));
            }
            return livraisonVos;
        }
    }
   
}
