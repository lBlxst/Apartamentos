package com.apartamentos.apartamentos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartamentos.apartamentos.models.resenaModel;
import com.apartamentos.apartamentos.repositories.IResenasRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class resenaServices {

    @Autowired
    IResenasRepository resenaRepository;

    public ArrayList<resenaModel> getAllResenas() {
        return (ArrayList<resenaModel>) resenaRepository.findAll();
    }

    public Optional<resenaModel> getResenaById(Long id) {
        return resenaRepository.findById(id);
    }

    public resenaModel saveResena(resenaModel resena) {
        return resenaRepository.save(resena);
    }

    public boolean deleteResena(Long id) {
        try {
            resenaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public resenaModel updateById(resenaModel request, Long id) {
        resenaModel resena = resenaRepository.findById(id).get();
        resena.setCalificacionLimpieza(request.getCalificacionLimpieza());
        resena.setCalificacionUbicacion(request.getCalificacionUbicacion());
        resena.setCalificacionComunicacion(request.getCalificacionComunicacion());
        resena.setCalificacionGeneral(request.getCalificacionGeneral());
        resena.setComentario(request.getComentario());
        resena.setFechaResena(request.getFechaResena());
        resena.setRespuestaPropietario(request.getRespuestaPropietario());
        resena.setFechaRespuesta(request.getFechaRespuesta());

        return resena;
    }
}