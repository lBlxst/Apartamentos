package com.apartamentos.apartamentos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartamentos.apartamentos.models.disponibilidadModel;
import com.apartamentos.apartamentos.repositories.IDisponibilidadRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class disponibilidadServices {

    @Autowired
    IDisponibilidadRepository disponibilidadRepository;

    public ArrayList<disponibilidadModel> getAllDisponibilidad() {
        return (ArrayList<disponibilidadModel>) disponibilidadRepository.findAll();
    }

    public Optional<disponibilidadModel> getDisponibilidadById(Long id) {
        return disponibilidadRepository.findById(id);
    }

    public disponibilidadModel saveDisponibilidad(disponibilidadModel disponibilidad) {
        return disponibilidadRepository.save(disponibilidad);
    }

    public boolean deleteDisponibilidad(Long id) {
        try {
            disponibilidadRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public disponibilidadModel updateById(disponibilidadModel request, Long id) {
        disponibilidadModel disponibilidad = disponibilidadRepository.findById(id).get();
        disponibilidad.setFecha(request.getFecha());
        disponibilidad.setDisponible(request.getDisponible());
        disponibilidad.setPrecioEspecial(request.getPrecioEspecial());
        return disponibilidad;
    }
}
