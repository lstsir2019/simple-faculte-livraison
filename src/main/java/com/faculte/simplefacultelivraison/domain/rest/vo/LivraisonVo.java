/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultelivraison.domain.rest.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class LivraisonVo implements Serializable {

    private static final long serialVersionUID = 1L;
    private String reference;
    private String referenceEntite;
    private String date;
    private String referenceCommande;
    private List<LivraisonItemVo> livraisonItemVos = new ArrayList<>();

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReferenceCommande() {
        return referenceCommande;
    }

    public void setReferenceCommande(String referenceCommande) {
        this.referenceCommande = referenceCommande;
    }

    public String getReferenceEntite() {
        return referenceEntite;
    }

    public void setReferenceEntite(String referenceEntite) {
        this.referenceEntite = referenceEntite;
    }
    

    @JsonIgnore
    public List<LivraisonItemVo> getLivraisonItemVos() {
        return livraisonItemVos;
    }

    @JsonSetter
    public void setLivraisonItemVos(List<LivraisonItemVo> livraisonItemVos) {
        if (livraisonItemVos != null) {
            this.livraisonItemVos = livraisonItemVos;
        }
    }

    @Override
    public String toString() {
        return "LivraisonVo{" + "reference=" + reference + ", referenceEntite=" + referenceEntite + ", date=" + date + ", referenceCommande=" + referenceCommande + ", livraisonItemVos=" + livraisonItemVos + '}';
    }

    

}
