/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UserMicroService.UserMicroService.controller;

import com.UserMicroService.UserMicroService.model.Rol;
import com.UserMicroService.UserMicroService.service.IRolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author joswald
 */
@RestController
@RequestMapping("rol")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RolController {
    @Autowired
    IRolService rolService;
    
     @GetMapping("/all")
    public List<Rol> buscarTodos() {
        return rolService.buscarTodos();
        
    }
    
}
