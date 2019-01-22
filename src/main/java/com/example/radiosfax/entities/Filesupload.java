/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.radiosfax.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author ProSYS
 */
@Entity
@Table(name = "filesupload")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filesupload.findAll", query = "SELECT f FROM Filesupload f")
    , @NamedQuery(name = "Filesupload.findById", query = "SELECT f FROM Filesupload f WHERE f.id = :id")
    , @NamedQuery(name = "Filesupload.findByFileName", query = "SELECT f.id AS id,f.fileName AS fileName,f.fileType AS fileType FROM Filesupload f WHERE f.numIntervention.numIntervention = :numIntervention")
    , @NamedQuery(name = "Filesupload.findByFileType", query = "SELECT f FROM Filesupload f WHERE f.fileType = :fileType")})
public class Filesupload implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id")
    private String id;
    @Size(max = 300)
    @Column(name = "file_name")
    private String fileName;
    @Size(max = 300)
    @Column(name = "file_type")
    private String fileType;
    @Lob
    @Column(name = "data", columnDefinition="BLOB")
    private byte[] data;
    @JoinColumn(name = "num_intervention", referencedColumnName = "num_intervention")
    @ManyToOne
    private Intervention numIntervention;

    public Filesupload() {
    }
    
     public Filesupload(final String fileName, final String fileType, final byte[] data,Intervention numIntervention) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.numIntervention = numIntervention;
    }

    public Filesupload(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @JsonIgnore
    public Intervention getNumIntervention() {
        return numIntervention;
    }

    public void setNumIntervention(Intervention numIntervention) {
        this.numIntervention = numIntervention;
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
        if (!(object instanceof Filesupload)) {
            return false;
        }
        Filesupload other = (Filesupload) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.radiosfax.entities.Filesupload[ id=" + id + " ]";
    }
    
}
