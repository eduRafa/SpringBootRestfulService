/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springbootrestfulservice.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafae
 */
@Entity
@Table(name = "video")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Video.findAll", query = "SELECT v FROM Video v")
    , @NamedQuery(name = "Video.findById", query = "SELECT v FROM Video v WHERE v.id = :id")
    , @NamedQuery(name = "Video.findByVisualizaciones", query = "SELECT v FROM Video v WHERE v.visualizaciones = :visualizaciones")
    , @NamedQuery(name = "Video.findByLikes", query = "SELECT v FROM Video v WHERE v.likes = :likes")
    , @NamedQuery(name = "Video.findByDislikes", query = "SELECT v FROM Video v WHERE v.dislikes = :dislikes")})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Video implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", length = 11)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "visualizaciones", length = 11)
    private int visualizaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "likes", length = 11)
    private int likes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dislikes", length = 11)
    private int dislikes;
    @JoinColumn(name = "categoria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categoria categoria;
    @JoinColumn(name = "youtuber", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Youtuber youtuber;

    public Video() {
    }

    public Video(Long id) {
        this.id = id;
    }

    public Video(Long id, int visualizaciones, int likes, int dislikes) {
        this.id = id;
        this.visualizaciones = visualizaciones;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVisualizaciones() {
        return visualizaciones;
    }

    public void setVisualizaciones(int visualizaciones) {
        this.visualizaciones = visualizaciones;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Youtuber getYoutuber() {
        return youtuber;
    }

    public void setYoutuber(Youtuber youtuber) {
        this.youtuber = youtuber;
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
        if (!(object instanceof Video)) {
            return false;
        }
        Video other = (Video) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springbootrestfulservice.model.Video[ id=" + id + " ]";
    }

}
