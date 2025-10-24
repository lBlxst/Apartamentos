package com.apartamentos.apartamentos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.apartamentos.apartamentos.models.propiedadImagenModel;
import com.apartamentos.apartamentos.services.propiedadImagenServices;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/propiedad-imagenes")
public class propiedadImagenController {

    @Autowired
    private propiedadImagenServices propiedadImagenServices;

    @GetMapping()
    public ArrayList<propiedadImagenModel> getPropiedadImagenes() {
        return propiedadImagenServices.getAllPropiedadImagenes();
    }

    @GetMapping(path = "/{id}")
    public Optional<propiedadImagenModel> getPropiedadImagenById(@PathVariable("id") Long id) {
        return propiedadImagenServices.getPropiedadImagenById(id);
    }

    @PostMapping()
    public propiedadImagenModel savePropiedadImagen(@RequestBody propiedadImagenModel imagen) {
        return propiedadImagenServices.savePropiedadImagen(imagen);
    }

    @PutMapping(path = "/{id}")
    public propiedadImagenModel updateById(@RequestBody propiedadImagenModel request, @PathVariable("id") Long id) {
        return propiedadImagenServices.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deletePropiedadImagen(@PathVariable("id") Long id) {
        boolean ok = propiedadImagenServices.deletePropiedadImagen(id);
        if (ok) {
            return "Se eliminó la imagen con id " + id;
        } else {
            return "No se pudo eliminar la imagen con id " + id;
        }
    }
}
