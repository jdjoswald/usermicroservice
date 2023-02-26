/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UserMicroService.UserMicroService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author joswald
 */
@Entity
@Table(name="Tbl_Rol")
public class Rol {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol", nullable = false)
    private Integer id;
    
    @Column(name = "rol", nullable = false, length = 150)
    private String rol;
    
    @JsonIgnore
    @OneToMany(mappedBy="idRol",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Usuario> usuarios;

    public Rol(String rol) {
        this.rol = rol;
       
    }

    public Rol() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
    
    
    
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rol roll = (Rol) o;
        return (Objects.equals(id, roll.id) && Objects.equals(rol, roll.rol));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rol);
    }
    
}
