/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultelivraison.domain.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author LENOVO
 */
@Entity
public class LivraisonItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String refenceProduit;
    private BigDecimal qte;
    private String codeMagasin;
    private String referenceReception;
    private String strategy;
    @ManyToOne
    private Livraison livraison;
  
    
   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefenceProduit() {
        return refenceProduit;
    }

    public void setRefenceProduit(String refenceProduit) {
        this.refenceProduit = refenceProduit;
    }

    public BigDecimal getQte() {
        return qte;
    }

    public void setQte(BigDecimal qte) {
        this.qte = qte;
    }

    public String getCodeMagasin() {
        return codeMagasin;
    }

    public void setCodeMagasin(String codeMagasin) {
        this.codeMagasin = codeMagasin;
    }

    public Livraison getLivraison() {
        return livraison;
    }

    public void setLivraison(Livraison livraison) {
        this.livraison = livraison;
    }

    public String getReferenceReception() {
        return referenceReception;
    }

    public void setReferenceReception(String referenceReception) {
        this.referenceReception = referenceReception;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LivraisonItem)) {
            return false;
        }
        LivraisonItem other = (LivraisonItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LivraisonItem{" + "id=" + id + ", refenceProduit=" + refenceProduit + ", qte=" + qte + ", codeMagasin=" + codeMagasin + ", referenceReception=" + referenceReception + ", strategy=" + strategy + ", livraison=" + livraison + '}';
    }

   

    
   
}
