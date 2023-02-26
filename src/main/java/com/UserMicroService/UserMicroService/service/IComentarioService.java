/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.UserMicroService.UserMicroService.service;

import com.UserMicroService.UserMicroService.model.Comentario;
import java.util.List;

/**
 *
 * @author joswald
 */
public interface IComentarioService {
    List<Comentario> buscarTodos();
    Comentario buscarPorId(Integer idComentario);
    List<Comentario> buscarPorPelicula(Integer idPelicula);
    Comentario guardarComentario(Comentario Comentario);
    Comentario actualizarComentario(Comentario Comentario);
    boolean eliminarComentario(Integer idComentario);
    String movieAverage(Integer idPelicula);
    
}
