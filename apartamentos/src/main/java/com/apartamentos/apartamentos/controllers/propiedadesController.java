package com.apartamentos.apartamentos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.apartamentos.apartamentos.models.propiedadesModel;
import com.apartamentos.apartamentos.services.propiedadesServices;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/propiedades")
public class propiedadesController {

    @Autowired
    private propiedadesServices propiedadesServices;

    @GetMapping()
    public ArrayList<propiedadesModel> getPropiedades() {
        return propiedadesServices.getAllPropiedades();
    }

    @GetMapping(path = "/{id}")
    public Optional<propiedadesModel> getPropiedadById(@PathVariable("id") Long id) {
        return propiedadesServices.getPropiedadById(id);
    }

    @PostMapping()
    public propiedadesModel savePropiedad(@RequestBody propiedadesModel propiedad) {
        return propiedadesServices.savePropiedad(propiedad);
    }

    @PutMapping(path = "/{id}")
    public propiedadesModel updateById(@RequestBody propiedadesModel request, @PathVariable("id") Long id) {
        return propiedadesServices.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deletePropiedad(@PathVariable("id") Long id) {
        boolean ok = propiedadesServices.deletePropiedad(id);
        if (ok) {
            return "Se eliminó la propiedad con id " + id;
        } else {
            return "No se pudo eliminar la propiedad con id " + id;
        }
    }
}