package com.apartamentos.apartamentos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.apartamentos.apartamentos.models.disponibilidadModel;
import com.apartamentos.apartamentos.services.disponibilidadServices;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/disponibilidad")
public class disponibilidadController {

    @Autowired
    private disponibilidadServices disponibilidadServices;

    @GetMapping()
    public ArrayList<disponibilidadModel> getDisponibilidad() {
        return disponibilidadServices.getAllDisponibilidad();
    }

    @GetMapping(path = "/{id}")
    public Optional<disponibilidadModel> getDisponibilidadById(@PathVariable("id") Long id) {
        return disponibilidadServices.getDisponibilidadById(id);
    }

    @PostMapping()
    public disponibilidadModel saveDisponibilidad(@RequestBody disponibilidadModel disponibilidad) {
        return disponibilidadServices.saveDisponibilidad(disponibilidad);
    }

    @PutMapping(path = "/{id}")
    public disponibilidadModel updateById(@RequestBody disponibilidadModel request, @PathVariable("id") Long id) {
        return disponibilidadServices.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteDisponibilidad(@PathVariable("id") Long id) {
        boolean ok = disponibilidadServices.deleteDisponibilidad(id);
        if (ok) {
            return "Se eliminó el registro de disponibilidad con id " + id;
        } else {
            return "No se pudo eliminar el registro de disponibilidad con id " + id;
        }
    }
}
