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
import javax.persistence.Lob;
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
@Table(name = "animateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Animateur.findAll", query = "SELECT a FROM Animateur a")
    , @NamedQuery(name = "Animateur.findByNomAnimateur", query = "SELECT a FROM Animateur a WHERE a.nomAnimateur = :nomAnimateur")
    , @NamedQuery(name = "Animateur.findByDescriptionAnimateur", query = "SELECT a FROM Animateur a WHERE a.descriptionAnimateur = :descriptionAnimateur")})
public class Animateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_animateur")
    private String nomAnimateur;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "description_animateur")
    private String descriptionAnimateur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animateur")
    private Collection<AnimateurEmission> animateurEmissionCollection;

    public Animateur() {
    }

    public Animateur(String nomAnimateur) {
        this.nomAnimateur = nomAnimateur;
    }

    public Animateur(String nomAnimateur, String descriptionAnimateur) {
        this.nomAnimateur = nomAnimateur;
        this.descriptionAnimateur = descriptionAnimateur;
    }

    public String getNomAnimateur() {
        return nomAnimateur;
    }

    public void setNomAnimateur(String nomAnimateur) {
        this.nomAnimateur = nomAnimateur;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescriptionAnimateur() {
        return descriptionAnimateur;
    }

    public void setDescriptionAnimateur(String descriptionAnimateur) {
        this.descriptionAnimateur = descriptionAnimateur;
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
        hash += (nomAnimateur != null ? nomAnimateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animateur)) {
            return false;
        }
        Animateur other = (Animateur) object;
        if ((this.nomAnimateur == null && other.nomAnimateur != null) || (this.nomAnimateur != null && !this.nomAnimateur.equals(other.nomAnimateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.radiosfax.entities.Animateur[ nomAnimateur=" + nomAnimateur + " ]";
    }
    
}
