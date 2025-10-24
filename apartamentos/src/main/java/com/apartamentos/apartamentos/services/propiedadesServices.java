package com.apartamentos.apartamentos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartamentos.apartamentos.models.propiedadesModel;
import com.apartamentos.apartamentos.repositories.IPropiedadesRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class propiedadesServices {

    @Autowired
    IPropiedadesRepository propiedadRepository;

    public ArrayList<propiedadesModel> getAllPropiedades() {
        return (ArrayList<propiedadesModel>) propiedadRepository.findAll();
    }

    public Optional<propiedadesModel> getPropiedadById(Long id) {
        return propiedadRepository.findById(id);
    }

    public propiedadesModel savePropiedad(propiedadesModel propiedad) {
        return propiedadRepository.save(propiedad);
    }

    public boolean deletePropiedad(Long id) {
        try {
            propiedadRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public propiedadesModel updateById(propiedadesModel request, Long id) {
        propiedadesModel propiedad = propiedadRepository.findById(id).get();
        propiedad.setTipo(request.getTipo());
        propiedad.setTitulo(request.getTitulo());
        propiedad.setDescripcion(request.getDescripcion());
        propiedad.setDireccion(request.getDireccion());
        propiedad.setCiudad(request.getCiudad());
        propiedad.setCodigo_postal(request.getCodigo_postal());
        propiedad.setPais(request.getPais());
        propiedad.setLatitud(request.getLatitud());
        propiedad.setLongitud(request.getLongitud());
        propiedad.setPrecio_noche(request.getPrecio_noche());
        propiedad.setCapacidad_personas(request.getCapacidad_personas());
        propiedad.setNumero_habitaciones(request.getNumero_habitaciones());
        propiedad.setNumero_banos(request.getNumero_banos());
        propiedad.setArea_m2(request.getArea_m2());
        propiedad.setComodidades(request.getComodidades());
        propiedad.setNormas_casa(request.getNormas_casa());
        propiedad.setEstado(request.getEstado());
        propiedad.setFecha_creacion(request.getFecha_creacion());
        propiedad.setFecha_actualizacion(request.getFecha_actualizacion());
        
        return propiedad;
    }
}