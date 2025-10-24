package com.apartamentos.apartamentos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.apartamentos.apartamentos.models.resenaModel;
import com.apartamentos.apartamentos.services.resenaServices;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/resenas")
public class resenaController {

    @Autowired
    private resenaServices resenaServices;

    @GetMapping()
    public ArrayList<resenaModel> getResenas() {
        return resenaServices.getAllResenas();
    }

    @GetMapping(path = "/{id}")
    public Optional<resenaModel> getResenaById(@PathVariable("id") Long id) {
        return resenaServices.getResenaById(id);
    }

    @PostMapping()
    public resenaModel saveResena(@RequestBody resenaModel resena) {
        return resenaServices.saveResena(resena);
    }

    @PutMapping(path = "/{id}")
    public resenaModel updateById(@RequestBody resenaModel request, @PathVariable("id") Long id) {
        return resenaServices.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteResena(@PathVariable("id") Long id) {
        boolean ok = resenaServices.deleteResena(id);
        if (ok) {
            return "Se eliminó la reseña con id " + id;
        } else {
            return "No se pudo eliminar la reseña con id " + id;
        }
    }
}
