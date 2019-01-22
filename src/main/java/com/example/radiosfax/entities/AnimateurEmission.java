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
@Table(name = "animateur_emission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnimateurEmission.findAll", query = "SELECT a FROM AnimateurEmission a")
    , @NamedQuery(name = "AnimateurEmission.findByNomEmission", query = "SELECT a FROM AnimateurEmission a WHERE a.animateurEmissionPK.nomEmission = :nomEmission")
    , @NamedQuery(name = "AnimateurEmission.findByNomAnimateur", query = "SELECT a FROM AnimateurEmission a WHERE a.animateurEmissionPK.nomAnimateur = :nomAnimateur")
    , @NamedQuery(name = "AnimateurEmission.findByHeureDeb", query = "SELECT a FROM AnimateurEmission a WHERE a.heureDeb = :heureDeb")
    , @NamedQuery(name = "AnimateurEmission.findByHeureFin", query = "SELECT a FROM AnimateurEmission a WHERE a.heureFin = :heureFin")})
public class AnimateurEmission implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AnimateurEmissionPK animateurEmissionPK;
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
    @JoinColumn(name = "nom_animateur", referencedColumnName = "nom_animateur", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Animateur animateur;
    @JoinColumn(name = "nom_emission", referencedColumnName = "nom_emission", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Emission emission;

    public AnimateurEmission() {
    }

    public AnimateurEmission(AnimateurEmissionPK animateurEmissionPK) {
        this.animateurEmissionPK = animateurEmissionPK;
    }

    public AnimateurEmission(AnimateurEmissionPK animateurEmissionPK, String heureDeb, String heureFin) {
        this.animateurEmissionPK = animateurEmissionPK;
        this.heureDeb = heureDeb;
        this.heureFin = heureFin;
    }

    public AnimateurEmission(String nomEmission, String nomAnimateur) {
        this.animateurEmissionPK = new AnimateurEmissionPK(nomEmission, nomAnimateur);
    }

    public AnimateurEmissionPK getAnimateurEmissionPK() {
        return animateurEmissionPK;
    }

    public void setAnimateurEmissionPK(AnimateurEmissionPK animateurEmissionPK) {
        this.animateurEmissionPK = animateurEmissionPK;
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

    public Animateur getAnimateur() {
        return animateur;
    }

    public void setAnimateur(Animateur animateur) {
        this.animateur = animateur;
    }

    public Emission getEmission() {
        return emission;
    }

    public void setEmission(Emission emission) {
        this.emission = emission;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (animateurEmissionPK != null ? animateurEmissionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnimateurEmission)) {
            return false;
        }
        AnimateurEmission other = (AnimateurEmission) object;
        if ((this.animateurEmissionPK == null && other.animateurEmissionPK != null) || (this.animateurEmissionPK != null && !this.animateurEmissionPK.equals(other.animateurEmissionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.radiosfax.entities.AnimateurEmission[ animateurEmissionPK=" + animateurEmissionPK + " ]";
    }
    
}
