/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UserMicroService.UserMicroService.controller;

import com.UserMicroService.UserMicroService.dao.IUserJPA;
import com.UserMicroService.UserMicroService.model.Comentario;
import com.UserMicroService.UserMicroService.model.Usuario;
import com.UserMicroService.UserMicroService.service.IComentarioService;
import com.UserMicroService.UserMicroService.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author joswald
 */
@RestController
@RequestMapping("comment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ComentarioController {
    
     @Autowired
     IComentarioService comentarioService;
     @Autowired
     IUsuarioService usuarioService;
     
      @GetMapping("/all")
    public List<Comentario> buscarTodos() {
        return comentarioService.buscarTodos();
        
    }
    @PostMapping("/save")
    public Comentario guardar(@RequestBody Comentario comentario){
        
        var rol=comentario.getUser().getId();
        comentario.setUser(usuarioService.buscarPorId(rol));
       // System.out.println(comentario.getId());
        return comentarioService.guardarComentario(comentario);
    }
     @PutMapping("/update")
    public Comentario editar(@RequestBody Comentario comentario){
        return comentarioService.actualizarComentario(comentario);
       
    }
    
    @DeleteMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        
       
        return  String.valueOf(comentarioService.eliminarComentario(id));
    
    }
    @GetMapping("/id/{id}")
    public Comentario buscarPorId(@PathVariable("id") Integer id) {
        return comentarioService.buscarPorId(id);
        
    }
    @GetMapping("/movie/{id}")
    public List<Comentario> buscarPorPelicula(@PathVariable("id") Integer id) {
        return comentarioService.buscarPorPelicula(id);
        
    }
    @GetMapping("/average/{id}")
    public String average(@PathVariable("id") Integer id) {
        return comentarioService.movieAverage(id);
        
    }
}
