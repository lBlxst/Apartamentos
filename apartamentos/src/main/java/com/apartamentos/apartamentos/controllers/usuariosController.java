package com.apartamentos.apartamentos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apartamentos.apartamentos.services.usuarioServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.apartamentos.apartamentos.models.usuariosModel;
import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/usuarios")
public class usuariosController {
    
    @Autowired
    private usuarioServices usuarioServices;

    @GetMapping()
    public ArrayList<usuariosModel> getUsuarios(){
        return usuarioServices.getAllUsuarios();
    }

    @GetMapping(path = "/{id}")
    public Optional<usuariosModel> getUsuarioById (@PathVariable("id") Long id){
        return this.usuarioServices.getUsuariosById(id);
    }

    @PostMapping()
    public usuariosModel saveHotel(@RequestBody usuariosModel hotel) {
        return this.usuarioServices.saveUsuario(hotel);
    }

    @PutMapping(path = "/{id}")
    public usuariosModel updateById(@RequestBody usuariosModel request, @PathVariable("id") Long id) {
        return usuarioServices.updateById(request, id);
    }

    @DeleteMapping (path = "/{id}")
    public String deleteHotel(@PathVariable("id") Long id) {
        boolean ok = this.usuarioServices.deleteUsuario(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No se pudo eliminar el usuario con id" + id;
        }
    }
    
}
