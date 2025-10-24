package com.apartamentos.apartamentos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartamentos.apartamentos.models.pagosModel;
import com.apartamentos.apartamentos.repositories.IPagosRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class pagosServices {

    @Autowired
    IPagosRepository pagoRepository;

    public ArrayList<pagosModel> getAllPagos() {
        return (ArrayList<pagosModel>) pagoRepository.findAll();
    }

    public Optional<pagosModel> getPagoById(Long id) {
        return pagoRepository.findById(id);
    }

    public pagosModel savePago(pagosModel pago) {
        return pagoRepository.save(pago);
    }

    public boolean deletePago(Long id) {
        try {
            pagoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public pagosModel updateById(pagosModel request, Long id) {
        pagosModel pago = pagoRepository.findById(id).get();
        pago.setMonto(request.getMonto());
        pago.setMetodoPago(request.getMetodoPago());
        pago.setEstado(request.getEstado());
        pago.setFechaPago(request.getFechaPago());
        pago.setReferenciaPago(request.getReferenciaPago());
        pago.setDatosPago(request.getDatosPago());
        pago.setFechaCreacion(request.getFechaCreacion());
        
        return pago;
    }
}