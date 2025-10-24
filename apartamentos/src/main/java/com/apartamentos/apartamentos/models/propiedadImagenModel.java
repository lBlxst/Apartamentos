package com.apartamentos.apartamentos.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "propiedadImagen")

public class propiedadImagenModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_propiedad", nullable = false)
    private propiedadesModel propiedad;

    @Column(name = "url_imagen")
    private String urlImagen;

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "es_principal")
    private Boolean es_principal;

    @Column(name = "fecha_subida")
    private LocalDateTime fecha_subida;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public propiedadesModel getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(propiedadesModel propiedad) {
        this.propiedad = propiedad;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Boolean getEs_principal() {
        return es_principal;
    }

    public void setEs_principal(Boolean es_principal) {
        this.es_principal = es_principal;
    }

    public LocalDateTime getFecha_subida() {
        return fecha_subida;
    }

    public void setFecha_subida(LocalDateTime fecha_subida) {
        this.fecha_subida = fecha_subida;
    }

    
}
