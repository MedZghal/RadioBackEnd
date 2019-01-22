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
public class DureeEmissionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_emission")
    private String nomEmission;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "jour")
    private String jour;

    public DureeEmissionPK() {
    }

    public DureeEmissionPK(String nomEmission, String jour) {
        this.nomEmission = nomEmission;
        this.jour = jour;
    }

    public String getNomEmission() {
        return nomEmission;
    }

    public void setNomEmission(String nomEmission) {
        this.nomEmission = nomEmission;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomEmission != null ? nomEmission.hashCode() : 0);
        hash += (jour != null ? jour.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DureeEmissionPK)) {
            return false;
        }
        DureeEmissionPK other = (DureeEmissionPK) object;
        if ((this.nomEmission == null && other.nomEmission != null) || (this.nomEmission != null && !this.nomEmission.equals(other.nomEmission))) {
            return false;
        }
        if ((this.jour == null && other.jour != null) || (this.jour != null && !this.jour.equals(other.jour))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.radiosfax.entities.DureeEmissionPK[ nomEmission=" + nomEmission + ", jour=" + jour + " ]";
    }
    
}
