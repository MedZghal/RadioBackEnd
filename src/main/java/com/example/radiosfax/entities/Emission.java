/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.radiosfax.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ProSYS
 */
@Entity
@Table(name = "emission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emission.findAll", query = "SELECT e FROM Emission e")
    , @NamedQuery(name = "Emission.findByNomEmission", query = "SELECT e FROM Emission e WHERE e.nomEmission = :nomEmission")
    , @NamedQuery(name = "Emission.findByDescriptionEmission", query = "SELECT e FROM Emission e WHERE e.descriptionEmission = :descriptionEmission")})
public class Emission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_emission")
    private String nomEmission;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "description_emission")
    private String descriptionEmission;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emission")
    private Collection<DureeEmission> dureeEmissionCollection;
    @OneToMany(mappedBy = "nomEmission")
    private Collection<Intervention> interventionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emission")
    private Collection<AnimateurEmission> animateurEmissionCollection;

    public Emission() {
    }

    public Emission(String nomEmission) {
        this.nomEmission = nomEmission;
    }

    public Emission(String nomEmission, String descriptionEmission) {
        this.nomEmission = nomEmission;
        this.descriptionEmission = descriptionEmission;
    }

    public String getNomEmission() {
        return nomEmission;
    }

    public void setNomEmission(String nomEmission) {
        this.nomEmission = nomEmission;
    }

    public String getDescriptionEmission() {
        return descriptionEmission;
    }

    public void setDescriptionEmission(String descriptionEmission) {
        this.descriptionEmission = descriptionEmission;
    }

    @XmlTransient
    public Collection<DureeEmission> getDureeEmissionCollection() {
        return dureeEmissionCollection;
    }

    public void setDureeEmissionCollection(Collection<DureeEmission> dureeEmissionCollection) {
        this.dureeEmissionCollection = dureeEmissionCollection;
    }

    @XmlTransient
    public Collection<Intervention> getInterventionCollection() {
        return interventionCollection;
    }

    public void setInterventionCollection(Collection<Intervention> interventionCollection) {
        this.interventionCollection = interventionCollection;
    }

    @XmlTransient
    public Collection<AnimateurEmission> getAnimateurEmissionCollection() {
        return animateurEmissionCollection;
    }

    public void setAnimateurEmissionCollection(Collection<AnimateurEmission> animateurEmissionCollection) {
        this.animateurEmissionCollection = animateurEmissionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomEmission != null ? nomEmission.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emission)) {
            return false;
        }
        Emission other = (Emission) object;
        if ((this.nomEmission == null && other.nomEmission != null) || (this.nomEmission != null && !this.nomEmission.equals(other.nomEmission))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.radiosfax.entities.Emission[ nomEmission=" + nomEmission + " ]";
    }
    
}
