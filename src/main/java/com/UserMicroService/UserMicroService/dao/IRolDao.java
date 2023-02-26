/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.UserMicroService.UserMicroService.dao;

import com.UserMicroService.UserMicroService.model.Rol;
import java.util.List;

/**
 *
 * @author joswald
 */
public interface IRolDao {
    List<Rol> buscarTodos();
    Rol buscarPorId(Integer idRol);
    Rol guardar(Rol rol);
    Rol actualizar(Rol rol);
    void eliminar(Integer idRol);
    
}
