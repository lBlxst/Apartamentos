package com.apartamentos.apartamentos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartamentos.apartamentos.repositories.IUsuariosRepository;
import com.apartamentos.apartamentos.models.usuariosModel;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class usuarioServices {
    @Autowired
    IUsuariosRepository usuarioRepository;

    public ArrayList<usuariosModel> getAllUsuarios() {
        return (ArrayList<usuariosModel>) usuarioRepository.findAll();
    }

    public Optional<usuariosModel> getUsuariosById(Long id) {
        return usuarioRepository.findById(id);
    }

    public usuariosModel saveUsuario(usuariosModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public boolean deleteUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public usuariosModel updateById(usuariosModel request, Long id){

        usuariosModel usuario = usuarioRepository.findById(id).get();
        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setEmail(request.getEmail());
        usuario.setTelefono(request.getTelefono());
        usuario.setFecha_nacimiento(request.getFecha_nacimiento());
        usuario.setDocumento_identidad(request.getDocumento_identidad());
        usuario.setDireccion(request.getDireccion());
        usuario.setFecha_registro(request.getFecha_registro());
        
        return usuario;
    }
}
