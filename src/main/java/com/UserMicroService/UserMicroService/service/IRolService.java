/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.UserMicroService.UserMicroService.service;

import com.UserMicroService.UserMicroService.model.Rol;
import java.util.List;

/**
 *
 * @author joswald
 */
public interface IRolService {
    List<Rol> buscarTodos();
    Rol buscarPorId(Integer idRol);
    Rol guardarRol(Rol rol);
    Rol actualizarRol(Rol rol);
    boolean eliminarRol(Integer idRol);
    
}
