package com.apartamentos.apartamentos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartamentos.apartamentos.models.mensajesModel;
import com.apartamentos.apartamentos.repositories.IMensajesRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class mensajesServices {

    @Autowired
    IMensajesRepository mensajeRepository;

    public ArrayList<mensajesModel> getAllMensajes() {
        return (ArrayList<mensajesModel>) mensajeRepository.findAll();
    }

    public Optional<mensajesModel> getMensajeById(Long id) {
        return mensajeRepository.findById(id);
    }

    public mensajesModel saveMensaje(mensajesModel mensaje) {
        return mensajeRepository.save(mensaje);
    }

    public boolean deleteMensaje(Long id) {
        try {
            mensajeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public mensajesModel updateById(mensajesModel request, Long id) {
        mensajesModel mensaje = mensajeRepository.findById(id).get();
        mensaje.setAsunto(request.getAsunto());
        mensaje.setContenido(request.getContenido());
        mensaje.setLeido(request.getLeido());
        mensaje.setFechaEnvio(request.getFechaEnvio());
        
        return mensaje;
    }
}