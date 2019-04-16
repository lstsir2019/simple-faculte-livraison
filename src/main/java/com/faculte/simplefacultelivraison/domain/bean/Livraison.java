/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultelivraison.domain.bean;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author LENOVO
 */
@Entity
public class Livraison implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    private String referenceCommande;
    private String referenceEntite;
    @OneToMany(mappedBy = "livraison",cascade = CascadeType.REMOVE)
    private List<LivraisonItem> livraisonItems = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceEntite() {
        return referenceEntite;
    }

    public void setReferenceEntite(String referenceEntite) {
        this.referenceEntite = referenceEntite;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReferenceCommande() {
        return referenceCommande;
    }

    public void setReferenceCommande(String referenceCommande) {
        this.referenceCommande = referenceCommande;
    }

    public List<LivraisonItem> getLivraisonItems() {
        return livraisonItems;
    }

    public void setLivraisonItems(List<LivraisonItem> livraisonItems) {
        if (livraisonItems != null) {
            this.livraisonItems = livraisonItems;
        }
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
        if (!(object instanceof Livraison)) {
            return false;
        }
        Livraison other = (Livraison) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Livraison{" + "id=" + id + ", reference=" + reference + ", date=" + date + ", referenceCommande=" + referenceCommande + ", referenceEntite=" + referenceEntite + ", livraisonItems=" + livraisonItems + '}';
    }

    

}
