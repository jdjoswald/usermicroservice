/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.UserMicroService.UserMicroService.service;

import com.UserMicroService.UserMicroService.model.Usuario;
import java.util.List;
import java.util.Map;

/**
 *
 * @author joswald
 */
public interface IUsuarioService {
    List<Usuario> buscarTodos();
    Usuario buscarPorId(Integer idUsuario);
    Usuario buscarPorCorreo(String correo);
    List<Usuario> buscarPorCorreolista(String correo);
    Usuario login(Map<String, String> user);
    Usuario guardarUsuario(Usuario usuario);
    Usuario actualizarUsuario(Usuario usuario);
    boolean eliminarUsuario(Integer idUsuario);
    boolean aceptar(Integer idUsuario);
    
}
