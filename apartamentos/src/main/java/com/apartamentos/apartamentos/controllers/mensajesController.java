package com.apartamentos.apartamentos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.apartamentos.apartamentos.models.mensajesModel;
import com.apartamentos.apartamentos.services.mensajesServices;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/mensajes")
public class mensajesController {

    @Autowired
    private mensajesServices mensajeServices;

    @GetMapping()
    public ArrayList<mensajesModel> getMensajes() {
        return mensajeServices.getAllMensajes();
    }

    @GetMapping(path = "/{id}")
    public Optional<mensajesModel> getMensajeById(@PathVariable("id") Long id) {
        return mensajeServices.getMensajeById(id);
    }

    @PostMapping()
    public mensajesModel saveMensaje(@RequestBody mensajesModel mensaje) {
        return mensajeServices.saveMensaje(mensaje);
    }

    @PutMapping(path = "/{id}")
    public mensajesModel updateById(@RequestBody mensajesModel request, @PathVariable("id") Long id) {
        return mensajeServices.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteMensaje(@PathVariable("id") Long id) {
        boolean ok = mensajeServices.deleteMensaje(id);
        if (ok) {
            return "Se eliminó el mensaje con id " + id;
        } else {
            return "No se pudo eliminar el mensaje con id " + id;
        }
    }
}
