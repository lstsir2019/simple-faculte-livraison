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
public class LivraisonItemVo implements Serializable {

    private static final long serialVersionUID = 1L;
    private String refenceProduit;
    private String referenceReception;
    private String strategy;
    private String qte;
    private String codeMagasin;
    private String referenceCommandeExpression;
    private LivraisonVo livraisonVo;
    

    public String getReferenceReception() {
        return referenceReception;
    }

    public void setReferenceReception(String referenceReception) {
        this.referenceReception = referenceReception;
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

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getReferenceCommandeExpression() {
        return referenceCommandeExpression;
    }

    public void setReferenceCommandeExpression(String referenceCommandeExpression) {
        this.referenceCommandeExpression = referenceCommandeExpression;
    }

    @Override
    public String toString() {
        return "LivraisonItemVo{" + "refenceProduit=" + refenceProduit + ", referenceReception=" + referenceReception + ", strategy=" + strategy + ", qte=" + qte + ", codeMagasin=" + codeMagasin + ", referenceCommandeExpression=" + referenceCommandeExpression + ", livraisonVo=" + livraisonVo + '}';
    }
    

   
}
