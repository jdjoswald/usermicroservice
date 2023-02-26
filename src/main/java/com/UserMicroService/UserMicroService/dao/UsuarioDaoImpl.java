/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UserMicroService.UserMicroService.dao;

import com.UserMicroService.UserMicroService.model.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author joswald
 */
@Repository
public class UsuarioDaoImpl implements IUsuarioDao{
    
    @Autowired
    IUserJPA usuarioJPA;

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioJPA.findAll();    }

    @Override
    public Usuario buscarPorId(Integer idUsuario) {
        
        Optional<Usuario> optional = usuarioJPA.findById(idUsuario); 
        if (optional.isPresent()) {
        return optional.get();
        }
        return null;
       
    }

 
    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioJPA.save(usuario);
    }

    @Override
    public Usuario actualizar(Usuario usuario) {
        return usuarioJPA.save(usuario);
    }

    @Override
    public void eliminar(Integer idUsuario) {
        usuarioJPA.deleteById(idUsuario);
    }

    @Override
    public Usuario buscarPorCorreo(String correo) {
        return usuarioJPA.findBycorreo(correo);
    }
    @Override
    public List<Usuario> buscarPorCorreolista(String correo) {
        return usuarioJPA.findBycorreoContainingIgnoreCase(correo);
    }


   
    
}
