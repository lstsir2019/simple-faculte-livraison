/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultelivraison.domain.rest.converter;


import com.faculte.simplefacultelivraison.commun.util.NuberUtil;
import com.faculte.simplefacultelivraison.domain.bean.LivraisonItem;
import com.faculte.simplefacultelivraison.domain.rest.vo.LivraisonItemVo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class LivraisonItemConverter implements AbstractConverter<LivraisonItem, LivraisonItemVo> {

    public LivraisonItemConverter() {
    }

    public List<LivraisonItem> toItem(List<LivraisonItemVo> livraisonItemVos) {
        if (livraisonItemVos == null || livraisonItemVos.isEmpty()) {
            return null;

        } else {
            List<LivraisonItem> livraisonItems = new ArrayList<>();
            for (LivraisonItemVo livraisonItemVo : livraisonItemVos) {

                livraisonItems.add(toItem(livraisonItemVo));
            }
            return livraisonItems;
        }

    }
    public List<LivraisonItemVo> toVo(List<LivraisonItem> livraisonItems){
        if (livraisonItems == null || livraisonItems.isEmpty()){
            return null;
        }else{
            List<LivraisonItemVo> livraisonItemVos=new ArrayList<>();
            for (LivraisonItem livraisonItem : livraisonItems) {
                livraisonItemVos.add(toVo(livraisonItem));
            }
            return livraisonItemVos;
        }
    }

    @Override
    public LivraisonItem toItem(LivraisonItemVo vo) {
        if (vo != null) {
            LivraisonItem livraisonItem = new LivraisonItem();
            livraisonItem.setCodeMagasin(vo.getCodeMagasin());
            livraisonItem.setQte(NuberUtil.toBigDecimale(vo.getQte()));
            livraisonItem.setRefenceProduit(vo.getRefenceProduit());
            livraisonItem.setReferenceReception(vo.getReferenceReception());
            livraisonItem.setStrategy(vo.getStrategy());

            return livraisonItem;
 
        } else {
            return null;
        }
    }

    @Override
    public LivraisonItemVo toVo(LivraisonItem item) {
        if(item==null){
        return null;
        }else{
            LivraisonItemVo vo=new LivraisonItemVo();
            vo.setCodeMagasin(item.getCodeMagasin());
            vo.setQte(NuberUtil.toBigString(item.getQte()));
            vo.setRefenceProduit(item.getRefenceProduit());
            vo.setReferenceReception(item.getReferenceReception());
            vo.setStrategy(item.getStrategy());
            return vo;
        }
    }

}
