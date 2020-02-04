/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springbootrestfulservice.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Youtuber implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
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
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "empresa_youtuber",
            joinColumns = {
                @JoinColumn(name = "youtuber_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "empresa_id")}
    )
    private Set<Video> empresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "youtuber", fetch = FetchType.LAZY)
    private Set<Video> videos;

    public Youtuber() {
    }

    public Youtuber(Long id) {
        this.id = id;
    }

    public Youtuber(Long id, String nombre, Date fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    public Set<Video> getVideos() {
        return videos;
    }

    public void setVideos(Set<Video> videos) {
        this.videos = videos;
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
