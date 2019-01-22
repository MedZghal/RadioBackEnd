/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.radiosfax.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "intervention")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Intervention.findAll", query = "SELECT i FROM Intervention i")
    , @NamedQuery(name = "Intervention.findByNumIntervention", query = "SELECT i FROM Intervention i WHERE i.numIntervention = :numIntervention")
    , @NamedQuery(name = "Intervention.findByNom", query = "SELECT i FROM Intervention i WHERE i.nom = :nom")
    , @NamedQuery(name = "Intervention.findByPrenom", query = "SELECT i FROM Intervention i WHERE i.prenom = :prenom")
    , @NamedQuery(name = "Intervention.findByDescription", query = "SELECT i FROM Intervention i WHERE i.description = :description")
    , @NamedQuery(name = "Intervention.findByTel", query = "SELECT i FROM Intervention i WHERE i.tel = :tel")
    , @NamedQuery(name = "Intervention.findByLocalisationActuel", query = "SELECT i FROM Intervention i WHERE i.localisationActuel = :localisationActuel")
    , @NamedQuery(name = "Intervention.findByLocalisationImage", query = "SELECT i FROM Intervention i WHERE i.localisationImage = :localisationImage")
    , @NamedQuery(name = "Intervention.findByType", query = "SELECT i FROM Intervention i WHERE i.type = :type")
    , @NamedQuery(name = "Intervention.findByEtat", query = "SELECT i FROM Intervention i WHERE i.etat = :etat")})
public class Intervention implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_intervention")
    private Integer numIntervention;
    @Size(max = 50)
    @Column(name = "nom")
    private String nom;
    @Size(max = 50)
    @Column(name = "prenom")
    private String prenom;
    @Size(max = 50)
    @Column(name = "description")
    private String description;
    @Size(max = 50)
    @Column(name = "tel")
    private String tel;
    @Size(max = 50)
    @Column(name = "localisation_actuel")
    private String localisationActuel;
    @Size(max = 50)
    @Column(name = "localisation_image")
    private String localisationImage;
    @Size(max = 50)
    @Column(name = "type")
    private String type;
    @Size(max = 50)
    @Column(name = "etat")
    private String etat;
    @OneToMany(mappedBy = "numIntervention")
    private Collection<Filesupload> filesuploadCollection;
    @JoinColumn(name = "nom_emission", referencedColumnName = "nom_emission")
    @ManyToOne
    private Emission nomEmission;

    public Intervention() {
    }

    public Intervention(Integer numIntervention) {
        this.numIntervention = numIntervention;
    }

    public Intervention(Integer numIntervention, String nom, String prenom, String description, String tel, String localisationActuel, String localisationImage, String type, String etat) {
        this.numIntervention = numIntervention;
        this.nom = nom;
        this.prenom = prenom;
        this.description = description;
        this.tel = tel;
        this.localisationActuel = localisationActuel;
        this.localisationImage = localisationImage;
        this.type = type;
        this.etat = etat;
    }

    public Integer getNumIntervention() {
        return numIntervention;
    }

    public void setNumIntervention(Integer numIntervention) {
        this.numIntervention = numIntervention;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLocalisationActuel() {
        return localisationActuel;
    }

    public void setLocalisationActuel(String localisationActuel) {
        this.localisationActuel = localisationActuel;
    }

    public String getLocalisationImage() {
        return localisationImage;
    }

    public void setLocalisationImage(String localisationImage) {
        this.localisationImage = localisationImage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Filesupload> getFilesuploadCollection() {
        return filesuploadCollection;
    }

    public void setFilesuploadCollection(Collection<Filesupload> filesuploadCollection) {
        this.filesuploadCollection = filesuploadCollection;
    }

    public Emission getNomEmission() {
        return nomEmission;
    }

    public void setNomEmission(Emission nomEmission) {
        this.nomEmission = nomEmission;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numIntervention != null ? numIntervention.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Intervention)) {
            return false;
        }
        Intervention other = (Intervention) object;
        if ((this.numIntervention == null && other.numIntervention != null) || (this.numIntervention != null && !this.numIntervention.equals(other.numIntervention))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.radiosfax.entities.Intervention[ numIntervention=" + numIntervention + " ]";
    }
    
}
