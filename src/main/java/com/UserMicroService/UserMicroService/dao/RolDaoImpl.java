/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UserMicroService.UserMicroService.dao;

import com.UserMicroService.UserMicroService.model.Rol;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author joswald
 */
@Repository
public class RolDaoImpl implements IRolDao{
    
     @Autowired
     IRolJPA rolJPA;
    
    @Override
    public List<Rol> buscarTodos() {
         return rolJPA.findAll();
    }

    @Override
    public Rol buscarPorId(Integer idRol) {
           Optional<Rol> optional = rolJPA.findById(idRol); 
        if (optional.isPresent()) {
        return optional.get();
        }
        return null;
    }

    @Override
    public Rol guardar(Rol rol) {
          return rolJPA.save(rol);
    }

    @Override
    public Rol actualizar(Rol rol) {
         return rolJPA.save(rol);
    }

    @Override
    public void eliminar(Integer idRol) {
     rolJPA.deleteById(idRol);
    }
  

    
}
