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
@Table(name = "jour")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jour.findAll", query = "SELECT j FROM Jour j")
    , @NamedQuery(name = "Jour.findByJour", query = "SELECT j FROM Jour j WHERE j.jour = :jour")})
public class Jour implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "jour")
    private String jour;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jour1")
    private Collection<DureeEmission> dureeEmissionCollection;

    public Jour() {
    }

    public Jour(String jour) {
        this.jour = jour;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    @XmlTransient
    public Collection<DureeEmission> getDureeEmissionCollection() {
        return dureeEmissionCollection;
    }

    public void setDureeEmissionCollection(Collection<DureeEmission> dureeEmissionCollection) {
        this.dureeEmissionCollection = dureeEmissionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jour != null ? jour.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jour)) {
            return false;
        }
        Jour other = (Jour) object;
        if ((this.jour == null && other.jour != null) || (this.jour != null && !this.jour.equals(other.jour))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.radiosfax.entities.Jour[ jour=" + jour + " ]";
    }
    
}
