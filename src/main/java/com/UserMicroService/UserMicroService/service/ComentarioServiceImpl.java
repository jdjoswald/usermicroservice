/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UserMicroService.UserMicroService.service;

import com.UserMicroService.UserMicroService.dao.IComentarioDao;
import com.UserMicroService.UserMicroService.model.Comentario;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author joswald
 */
@Service
public class ComentarioServiceImpl implements IComentarioService{
    
    @Autowired
    IComentarioDao comentarioDao;

    @Override
    public List<Comentario> buscarTodos() {
    return comentarioDao.buscarTodos();
    }

    @Override
    public Comentario buscarPorId(Integer idComentario) {
     return comentarioDao.buscarPorId(idComentario);
    }

    @Override
    public List<Comentario> buscarPorPelicula(Integer idPelicula) {
     return comentarioDao.buscarPorPelicula(idPelicula);
    }

    @Override
    public Comentario guardarComentario(Comentario Comentario) {
     return comentarioDao.guardar(Comentario);
    }

    @Override
    public Comentario actualizarComentario(Comentario Comentario) {
     return comentarioDao.actualizar(Comentario);
    }

    @Override
    public boolean eliminarComentario(Integer idComentario) {
     comentarioDao.eliminar(idComentario);
     return true;
    }

    @Override
    public String movieAverage(Integer idPelicula) {
        float a=0;
        List<Comentario> comentarios = comentarioDao.buscarPorPelicula(idPelicula);
        String numerof;
        float total=0;
        float totalReview=0;
         
        
        for (Comentario comentario: comentarios){
             total= total+comentario.getPuntuacion();
             totalReview=totalReview+1;
                //System.out.println(total);
            }
        if(totalReview>0){
             a= total/totalReview;
         }
         
        NumberFormat formatter = new DecimalFormat("#0.00");
        numerof=formatter.format(a);
         
        return numerof;
    }
    
}
