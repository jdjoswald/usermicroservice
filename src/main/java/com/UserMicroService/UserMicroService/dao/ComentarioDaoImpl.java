/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UserMicroService.UserMicroService.dao;

import com.UserMicroService.UserMicroService.model.Comentario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author joswald
 */
@Repository
public class ComentarioDaoImpl implements IComentarioDao{

       @Autowired
     IComentarioJpa comentarioJpa;
    @Override
    public List<Comentario> buscarTodos() {
        return comentarioJpa.findAll();
    }

    @Override
    public Comentario buscarPorId(Integer idComentario) {
        
            Optional<Comentario> optional = comentarioJpa.findById(idComentario); 
        if (optional.isPresent()) {
        return optional.get();
        }
        return null;
       
    }

    @Override
    public List<Comentario> buscarPorPelicula(Integer idPelicula) {
        return comentarioJpa.findByidPelicula(idPelicula);
    }

    @Override
    public Comentario guardar(Comentario Comentario) {
        return comentarioJpa.save(Comentario);
    }

    @Override
    public Comentario actualizar(Comentario Comentario) {
        return comentarioJpa.save(Comentario);
    }

    @Override
    public void eliminar(Integer idComentario) {
        comentarioJpa.deleteById(idComentario);
        
    }
    
    
}
