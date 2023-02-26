/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UserMicroService.UserMicroService.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author joswald
 */
@Entity
@Table(name="Tbl_Comentario")
public class Comentario {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario", nullable = false)
    private Integer id;
      @Column(name = "fecha", nullable = false, length = 150)
    private String fecha;
    @Column(name = "comentario", nullable = false, length = 150)
    private String comentario;
    @Column(name = "idPelicula", nullable = false, length = 150)
    private Integer idPelicula;
     @Column(name = "puntuacion", nullable = false)
    private Integer puntuacion;
    
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "usuarioId", nullable = false)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties("Tbl_Comentario")
    private Usuario user;

    public Comentario() {
    }

    public Comentario(String fecha, String comentario, Integer idPelicula, Integer puntuacion, Usuario user) {
        this.fecha = fecha;
        this.comentario = comentario;
        this.idPelicula = idPelicula;
        this.puntuacion = puntuacion;
        this.user = user;
    }
    
    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    
    
    
    
    
    
    
    
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comentario commentario = (Comentario) o;
        return (Objects.equals(id, commentario.id) && Objects.equals(comentario, commentario.comentario)
                && Objects.equals(idPelicula, commentario.idPelicula)&& Objects.equals(user, commentario.user)
                && Objects.equals(fecha, commentario.fecha));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comentario,idPelicula,user, fecha);
    }
    
}
