/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultelivraison.domain.rest.vo;

import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class LivraisonItemVo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String refenceProduit;
    private String referenceExpressionCommande;
    private String qte;
    private String codeMagasin;
    private LivraisonVo livraisonVo;

    public String getReferenceExpressionCommande() {
        return referenceExpressionCommande;
    }

    public void setReferenceExpressionCommande(String referenceExpressionCommande) {
        this.referenceExpressionCommande = referenceExpressionCommande;
    }

    public String getQte() {
        return qte;
    }

    public void setQte(String qte) {
        this.qte = qte;
    }

    
    

    public String getRefenceProduit() {
        return refenceProduit;
    }

    public void setRefenceProduit(String refenceProduit) {
        this.refenceProduit = refenceProduit;
    }

  

    public String getCodeMagasin() {
        return codeMagasin;
    }

    public void setCodeMagasin(String codeMagasin) {
        this.codeMagasin = codeMagasin;
    }

    public LivraisonVo getLivraisonVo() {
        return livraisonVo;
    }

    public void setLivraisonVo(LivraisonVo livraisonVo) {
        this.livraisonVo = livraisonVo;
    }

    @Override
    public String toString() {
        return "LivraisonItemVo{" + "refenceProduit=" + refenceProduit + ", referenceExpressionCommande=" + referenceExpressionCommande + ", qte=" + qte + ", codeMagasin=" + codeMagasin + ", livraisonVo=" + livraisonVo + '}';
    }
    
    
}
