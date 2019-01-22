/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.radiosfax.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ProSYS
 */
@Entity
@Table(name = "duree_emission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DureeEmission.findAll", query = "SELECT d FROM DureeEmission d")
    , @NamedQuery(name = "DureeEmission.findByNomEmission", query = "SELECT d FROM DureeEmission d WHERE d.dureeEmissionPK.nomEmission = :nomEmission")
    , @NamedQuery(name = "DureeEmission.findByJour", query = "SELECT d FROM DureeEmission d WHERE d.dureeEmissionPK.jour = :jour")
    , @NamedQuery(name = "DureeEmission.findByHeureDeb", query = "SELECT d FROM DureeEmission d WHERE d.heureDeb = :heureDeb")
    , @NamedQuery(name = "DureeEmission.findByHeureFin", query = "SELECT d FROM DureeEmission d WHERE d.heureFin = :heureFin")})
public class DureeEmission implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DureeEmissionPK dureeEmissionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "heure_deb")
    private String heureDeb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "heure_fin")
    private String heureFin;
    @JoinColumn(name = "nom_emission", referencedColumnName = "nom_emission", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Emission emission;
    @JoinColumn(name = "jour", referencedColumnName = "jour", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Jour jour1;

    public DureeEmission() {
    }

    public DureeEmission(DureeEmissionPK dureeEmissionPK) {
        this.dureeEmissionPK = dureeEmissionPK;
    }

    public DureeEmission(DureeEmissionPK dureeEmissionPK, String heureDeb, String heureFin) {
        this.dureeEmissionPK = dureeEmissionPK;
        this.heureDeb = heureDeb;
        this.heureFin = heureFin;
    }

    public DureeEmission(String nomEmission, String jour) {
        this.dureeEmissionPK = new DureeEmissionPK(nomEmission, jour);
    }

    public DureeEmissionPK getDureeEmissionPK() {
        return dureeEmissionPK;
    }

    public void setDureeEmissionPK(DureeEmissionPK dureeEmissionPK) {
        this.dureeEmissionPK = dureeEmissionPK;
    }

    public String getHeureDeb() {
        return heureDeb;
    }

    public void setHeureDeb(String heureDeb) {
        this.heureDeb = heureDeb;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public Emission getEmission() {
        return emission;
    }

    public void setEmission(Emission emission) {
        this.emission = emission;
    }

    public Jour getJour1() {
        return jour1;
    }

    public void setJour1(Jour jour1) {
        this.jour1 = jour1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dureeEmissionPK != null ? dureeEmissionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DureeEmission)) {
            return false;
        }
        DureeEmission other = (DureeEmission) object;
        if ((this.dureeEmissionPK == null && other.dureeEmissionPK != null) || (this.dureeEmissionPK != null && !this.dureeEmissionPK.equals(other.dureeEmissionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.radiosfax.entities.DureeEmission[ dureeEmissionPK=" + dureeEmissionPK + " ]";
    }
    
}
