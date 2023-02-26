/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.UserMicroService.UserMicroService.dao;

import com.UserMicroService.UserMicroService.model.Usuario;
import java.util.List;

/**
 *
 * @author joswald
 */
public interface IUsuarioDao {
    
    List<Usuario> buscarTodos();
    Usuario buscarPorId(Integer idUsuario);
    Usuario buscarPorCorreo(String correo);
    List<Usuario> buscarPorCorreolista(String correo);
    Usuario guardar(Usuario usuario);
    Usuario actualizar(Usuario usuario);
    void eliminar(Integer idUsuario);
    
}
