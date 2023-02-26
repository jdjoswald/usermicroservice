/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.UserMicroService.UserMicroService.dao;

import com.UserMicroService.UserMicroService.model.Comentario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author joswald
 */
public interface IComentarioJpa extends JpaRepository<Comentario, Integer>{
     
       List<Comentario>findByidPelicula(Integer idPelicula);
               
}


