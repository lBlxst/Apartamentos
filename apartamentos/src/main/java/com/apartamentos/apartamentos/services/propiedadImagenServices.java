package com.apartamentos.apartamentos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartamentos.apartamentos.models.propiedadImagenModel;
import com.apartamentos.apartamentos.repositories.IPropiedadImagenRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class propiedadImagenServices {

    @Autowired
    IPropiedadImagenRepository propiedadImagenRepository;

    // Obtener todas las imágenes
    public ArrayList<propiedadImagenModel> getAllPropiedadImagenes() {
        return (ArrayList<propiedadImagenModel>) propiedadImagenRepository.findAll();
    }

    // Buscar por ID
    public Optional<propiedadImagenModel> getPropiedadImagenById(Long id) {
        return propiedadImagenRepository.findById(id);
    }

    // Guardar nueva imagen
    public propiedadImagenModel savePropiedadImagen(propiedadImagenModel imagen) {
        return propiedadImagenRepository.save(imagen);
    }

    // Eliminar imagen por ID
    public boolean deletePropiedadImagen(Long id) {
        try {
            propiedadImagenRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Actualizar imagen
    public propiedadImagenModel updateById(propiedadImagenModel request, Long id) {
        propiedadImagenModel imagen = propiedadImagenRepository.findById(id).get();
        imagen.setUrlImagen(request.getUrlImagen());
        imagen.setOrden(request.getOrden());
        imagen.setEs_principal(request.getEs_principal());
        imagen.setFecha_subida(request.getFecha_subida());
        return imagen;
    }
}