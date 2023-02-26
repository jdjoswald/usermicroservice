/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UserMicroService.UserMicroService.service;

import com.UserMicroService.UserMicroService.dao.IUsuarioDao;
import com.UserMicroService.UserMicroService.model.Usuario;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author joswald
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService{
     @Autowired
     IUsuarioDao usuarioDao;

    @Override
    public List<Usuario> buscarTodos() {
        
    return usuarioDao.buscarTodos();
    }

    @Override
    public Usuario buscarPorId(Integer idUsuario) {
    return usuarioDao.buscarPorId(idUsuario);
    }

    @Override
    public Usuario buscarPorCorreo(String correo) {
    return usuarioDao.buscarPorCorreo(correo);
    }

    @Override
    public Usuario login(Map<String, String> user) {
        
    Usuario usuario= usuarioDao.buscarPorCorreo(user.get("correo"));
        
        if(usuario.getPassword().equals(user.get("password"))){
        
            return usuario;
        }else{
           
            return null;
        }
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        
    return usuarioDao.guardar(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        Usuario old = usuarioDao.buscarPorId(usuario.getId());
        usuario.setComentarios(old.getComentarios());
        usuario.setDefinitivo(old.isDefinitivo());
        usuario.setPassword(old.getPassword());
        if(usuario.getIdRol()==null){
             usuario.setIdRol(old.getIdRol());
        }
       
       
    return usuarioDao.actualizar(usuario);
    }

    @Override
    public boolean eliminarUsuario(Integer idUsuario) {
        usuarioDao.eliminar(idUsuario);
    return true;
    }

    @Override
    public boolean aceptar(Integer idUsuario) {
        Usuario user=usuarioDao.buscarPorId(idUsuario);
        user.setDefinitivo(true);
        usuarioDao.actualizar(user);
       return true;
    }

    @Override
    public List<Usuario> buscarPorCorreolista(String correo) {
      return usuarioDao.buscarPorCorreolista(correo);
    }
    
}
