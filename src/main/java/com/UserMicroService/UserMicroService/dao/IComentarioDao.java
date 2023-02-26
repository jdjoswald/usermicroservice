/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.UserMicroService.UserMicroService.dao;

import com.UserMicroService.UserMicroService.model.Comentario;
import java.util.List;

/**
 *
 * @author joswald
 */
public interface IComentarioDao {
    
    
     List<Comentario> buscarTodos();
    Comentario buscarPorId(Integer idComentario);
    List<Comentario> buscarPorPelicula(Integer idPelicula);
    Comentario guardar(Comentario Comentario);
    Comentario actualizar(Comentario Comentario);
    void eliminar(Integer idComentario);
    
}
