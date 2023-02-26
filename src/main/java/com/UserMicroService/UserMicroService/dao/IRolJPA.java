/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.UserMicroService.UserMicroService.dao;

import com.UserMicroService.UserMicroService.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author joswald
 */
public interface IRolJPA extends JpaRepository<Rol,Integer> {
    
}
