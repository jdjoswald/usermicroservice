/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UserMicroService.UserMicroService.service;

import com.UserMicroService.UserMicroService.dao.IRolDao;
import com.UserMicroService.UserMicroService.model.Rol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author joswald
 */
@Service
public class RolServiceImpl implements IRolService{
    
     @Autowired
     IRolDao rolDao;

    @Override
    public List<Rol> buscarTodos() {
       return rolDao.buscarTodos();
    }

    @Override
    public Rol buscarPorId(Integer idRol) {
       return rolDao.buscarPorId(idRol);
    }

    @Override
    public Rol guardarRol(Rol rol) {
       return rolDao.guardar(rol);
    }

    @Override
    public Rol actualizarRol(Rol rol) {
       return rolDao.actualizar(rol);
    }

    @Override
    public boolean eliminarRol(Integer idRol) {
        rolDao.eliminar(idRol);
       return true;
    }
    
    
    
}
