package com.apartamentos.apartamentos.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "disponibilidad")
public class disponibilidadModel {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disponibilidad")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_propiedad", nullable = false)
    private propiedadesModel propiedad;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "disponible")
    private Boolean disponible;

    @Column(name = "precio_especial", precision = 12, scale = 2)
    private BigDecimal precioEspecial;

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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public BigDecimal getPrecioEspecial() {
        return precioEspecial;
    }

    public void setPrecioEspecial(BigDecimal precioEspecial) {
        this.precioEspecial = precioEspecial;
    }

    
}
