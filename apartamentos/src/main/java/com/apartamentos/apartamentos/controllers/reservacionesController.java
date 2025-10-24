package com.apartamentos.apartamentos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.apartamentos.apartamentos.models.reservacionesModel;
import com.apartamentos.apartamentos.services.reservacionesServices;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/reservaciones")
public class reservacionesController {

    @Autowired
    private reservacionesServices reservacionesServices;

    @GetMapping()
    public ArrayList<reservacionesModel> getReservaciones() {
        return reservacionesServices.getAllReservaciones();
    }

    @GetMapping(path = "/{id}")
    public Optional<reservacionesModel> getReservacionById(@PathVariable("id") Long id) {
        return reservacionesServices.getReservacionById(id);
    }

    @PostMapping()
    public reservacionesModel saveReservacion(@RequestBody reservacionesModel reservacion) {
        return reservacionesServices.saveReservacion(reservacion);
    }

    @PutMapping(path = "/{id}")
    public reservacionesModel updateById(@RequestBody reservacionesModel request, @PathVariable("id") Long id) {
        return reservacionesServices.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteReservacion(@PathVariable("id") Long id) {
        boolean ok = reservacionesServices.deleteReservacion(id);
        if (ok) {
            return "Se eliminó la reservación con id " + id;
        } else {
            return "No se pudo eliminar la reservación con id " + id;
        }
    }
}
