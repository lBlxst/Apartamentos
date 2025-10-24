package com.apartamentos.apartamentos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartamentos.apartamentos.models.reservacionesModel;
import com.apartamentos.apartamentos.repositories.IReservacionesRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class reservacionesServices {

    @Autowired
    IReservacionesRepository reservacionRepository;

    public ArrayList<reservacionesModel> getAllReservaciones() {
        return (ArrayList<reservacionesModel>) reservacionRepository.findAll();
    }

    public Optional<reservacionesModel> getReservacionById(Long id) {
        return reservacionRepository.findById(id);
    }

    public reservacionesModel saveReservacion(reservacionesModel reservacion) {
        return reservacionRepository.save(reservacion);
    }

    public boolean deleteReservacion(Long id) {
        try {
            reservacionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public reservacionesModel updateById(reservacionesModel request, Long id) {
        reservacionesModel reservacion = reservacionRepository.findById(id).get();
        reservacion.setFechaEntrada(request.getFechaEntrada());
        reservacion.setFechaSalida(request.getFechaSalida());
        reservacion.setNumeroHuespedes(request.getNumeroHuespedes());
        reservacion.setPrecioTotal(request.getPrecioTotal());
        reservacion.setEstado(request.getEstado());
        reservacion.setNotas(request.getNotas());
        reservacion.setCodigoReserva(request.getCodigoReserva());
        reservacion.setFechaCheckin(request.getFechaCheckin());
        reservacion.setFechaCheckout(request.getFechaCheckout());
        
        return reservacion;
    }
}