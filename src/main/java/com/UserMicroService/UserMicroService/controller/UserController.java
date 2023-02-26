/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UserMicroService.UserMicroService.controller;

import com.UserMicroService.UserMicroService.model.Usuario;
import com.UserMicroService.UserMicroService.service.IRolService;
import com.UserMicroService.UserMicroService.service.IUsuarioService;
import java.util.List;
import java.util.Map;
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
@RequestMapping("usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
     @Autowired
     IUsuarioService usuarioService;
     @Autowired
     IRolService rolService;
    
    @GetMapping("/all")
    public List<Usuario> buscarTodos() {
        return usuarioService.buscarTodos();
        
    }
    @GetMapping("/id/{id}")
    public Usuario buscarPorId(@PathVariable("id") Integer id) {
        return usuarioService.buscarPorId(id);
        
    }
    @PostMapping("/save")
    public Usuario guardar(@RequestBody Usuario usuario){
        
        var rol=usuario.getIdRol();
        usuario.setIdRol(rolService.buscarPorId(rol.getId()));
        System.out.println(usuario.getIdRol().getId());
        return usuarioService.guardarUsuario(usuario);
        
    }
    @PutMapping("/update")
    public Usuario editar(@RequestBody Usuario usuario){
        return usuarioService.actualizarUsuario(usuario);
       
    }
    
    @DeleteMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        
       
        return  String.valueOf(usuarioService.eliminarUsuario(id));
    
    }
    
    @PostMapping("/login")
    public Usuario login(@RequestBody  Map < String, String > values){
        if(values.containsKey("correo") && values.containsKey("password")){
            
             //System.out.println(values);
             return usuarioService.login(values);
        }
        
         //System.out.println("no entro");
        return null;
       
       
        
        
    }
    @GetMapping("aceptar/{id}")
    public boolean aceptar(@PathVariable("id") Integer id) {
        return usuarioService.aceptar(id);
        
    }
    
    @GetMapping("/mail/{correo}")
    public Usuario buscarPorMail(@PathVariable("correo") String correo) {
        return usuarioService.buscarPorCorreo(correo);
        
    }
       @GetMapping("/listamail/{correo}")
    public List<Usuario> buscarListaMail(@PathVariable("correo") String correo) {
        return usuarioService.buscarPorCorreolista(correo);
        
    }
    
}
