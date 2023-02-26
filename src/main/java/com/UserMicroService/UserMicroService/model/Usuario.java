/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UserMicroService.UserMicroService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author joswald
 */
@Entity
@Table(name="Tbl_Usuario")
//@JsonIgnoreProperties("password")
public class Usuario {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario", nullable = false)
    private Integer id;
    
    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;
    @Column(name = "apellido", nullable = false, length = 150)
    private String apellido;
    @Column(name = "correo", nullable = false, length = 150,unique = true)
    private String correo;
    @Column(name = "contrasenna", nullable = false, length = 150)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    
    
    @Column(name = "definitivo", nullable = false, length = 150)
    private boolean definitivo;
    
    
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "rolId", nullable = false)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties("Tbl_Usuario")
    private Rol idRol;
    
  
    @OneToMany(mappedBy="id",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
     @JsonBackReference
    private List<Comentario> comentarios;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String correo, String password, boolean definitivo, Rol idRol, List<Comentario> comentarios) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.definitivo = definitivo;
        this.idRol = idRol;
        this.comentarios = comentarios;
    }

    public boolean isDefinitivo() {
        return definitivo;
    }

    public void setDefinitivo(boolean definitivo) {
        this.definitivo = definitivo;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    
    
    
    
    
    
    
    
    
    
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return (Objects.equals(id, usuario.id) && Objects.equals(correo, usuario.correo)
                && Objects.equals(idRol, usuario.idRol)&& Objects.equals(definitivo, usuario.definitivo));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre,apellido,correo,idRol,definitivo);
    }
    
}
