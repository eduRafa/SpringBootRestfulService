/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springbootrestfulservice.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rafae
 */
@Entity
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
    , @NamedQuery(name = "Empresa.findById", query = "SELECT e FROM Empresa e WHERE e.id = :id")
    , @NamedQuery(name = "Empresa.findByNombre", query = "SELECT e FROM Empresa e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Empresa.findByDirecci\u00f3n", query = "SELECT e FROM Empresa e WHERE e.direcci\u00f3n = :direcci\u00f3n")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nombre")
    private int nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "direcci\u00f3n")
    private int dirección;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private Set<EmpresaYoutuber> empresaYoutuberSet;

    public Empresa() {
    }

    public Empresa(Integer id) {
        this.id = id;
    }

    public Empresa(Integer id, int nombre, int dirección) {
        this.id = id;
        this.nombre = nombre;
        this.dirección = dirección;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getDirección() {
        return dirección;
    }

    public void setDirección(int dirección) {
        this.dirección = dirección;
    }

    @XmlTransient
    public Set<EmpresaYoutuber> getEmpresaYoutuberSet() {
        return empresaYoutuberSet;
    }

    public void setEmpresaYoutuberSet(Set<EmpresaYoutuber> empresaYoutuberSet) {
        this.empresaYoutuberSet = empresaYoutuberSet;
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
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springbootrestfulservice.model.Empresa[ id=" + id + " ]";
    }
    
}
