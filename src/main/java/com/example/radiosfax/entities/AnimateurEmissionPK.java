/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.radiosfax.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ProSYS
 */
@Embeddable
public class AnimateurEmissionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_emission")
    private String nomEmission;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_animateur")
    private String nomAnimateur;

    public AnimateurEmissionPK() {
    }

    public AnimateurEmissionPK(String nomEmission, String nomAnimateur) {
        this.nomEmission = nomEmission;
        this.nomAnimateur = nomAnimateur;
    }

    public String getNomEmission() {
        return nomEmission;
    }

    public void setNomEmission(String nomEmission) {
        this.nomEmission = nomEmission;
    }

    public String getNomAnimateur() {
        return nomAnimateur;
    }

    public void setNomAnimateur(String nomAnimateur) {
        this.nomAnimateur = nomAnimateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomEmission != null ? nomEmission.hashCode() : 0);
        hash += (nomAnimateur != null ? nomAnimateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnimateurEmissionPK)) {
            return false;
        }
        AnimateurEmissionPK other = (AnimateurEmissionPK) object;
        if ((this.nomEmission == null && other.nomEmission != null) || (this.nomEmission != null && !this.nomEmission.equals(other.nomEmission))) {
            return false;
        }
        if ((this.nomAnimateur == null && other.nomAnimateur != null) || (this.nomAnimateur != null && !this.nomAnimateur.equals(other.nomAnimateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.radiosfax.entities.AnimateurEmissionPK[ nomEmission=" + nomEmission + ", nomAnimateur=" + nomAnimateur + " ]";
    }
    
}
