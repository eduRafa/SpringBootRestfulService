/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springbootrestfulservice.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rafae
 */
@Entity
@Table(name = "youtuber")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Youtuber.findAll", query = "SELECT y FROM Youtuber y")
    , @NamedQuery(name = "Youtuber.findById", query = "SELECT y FROM Youtuber y WHERE y.id = :id")
    , @NamedQuery(name = "Youtuber.findByNombre", query = "SELECT y FROM Youtuber y WHERE y.nombre = :nombre")
    , @NamedQuery(name = "Youtuber.findByFechaAlta", query = "SELECT y FROM Youtuber y WHERE y.fechaAlta = :fechaAlta")})
public class Youtuber implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idYoutuber")
    private Set<EmpresaYoutuber> empresaYoutuberSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "youtuber")
    private Set<Video> videoSet;

    public Youtuber() {
    }

    public Youtuber(Integer id) {
        this.id = id;
    }

    public Youtuber(Integer id, String nombre, Date fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @XmlTransient
    public Set<EmpresaYoutuber> getEmpresaYoutuberSet() {
        return empresaYoutuberSet;
    }

    public void setEmpresaYoutuberSet(Set<EmpresaYoutuber> empresaYoutuberSet) {
        this.empresaYoutuberSet = empresaYoutuberSet;
    }

    @XmlTransient
    public Set<Video> getVideoSet() {
        return videoSet;
    }

    public void setVideoSet(Set<Video> videoSet) {
        this.videoSet = videoSet;
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
        if (!(object instanceof Youtuber)) {
            return false;
        }
        Youtuber other = (Youtuber) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springbootrestfulservice.model.Youtuber[ id=" + id + " ]";
    }
    
}
