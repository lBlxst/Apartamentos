package com.apartamentos.apartamentos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.apartamentos.apartamentos.models.enums.propiedadTipo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.apartamentos.apartamentos.models.enums.propiedadEstado;
import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.CascadeType;


@Entity
@Table(name = "propiedades")

public class propiedadesModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_propietario", nullable = false)
    private usuariosModel propietario;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private propiedadTipo tipo;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descripcion",nullable = false, length = 1000)
    private String descripcion;

    @Column(name = "direccion",nullable = false)
    private String direccion;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @Column(name = "codigo_postal",nullable = false)
    private String codigo_postal;

    @Column(name = "pais",nullable = false)
    private String pais;

    @Column(name = "latitud",nullable = false)
    private Double latitud;

    @Column(name = "longitud",nullable = false)
    private Double longitud;

    @Column(name = "precio_noche",nullable = false)
    private Double precio_noche;

    @Column(name = "capacidad_personas",nullable = false)
    private Integer capacidad_personas;

    @Column(name = "numero_habitaciones",nullable = false)
    private Integer numero_habitaciones;

    @Column(name = "numero_baños",nullable = false)
    private Integer numero_banos;

    @Column(name = "area_m2",nullable = false)
    private int area_m2;

    @Column(name = "comodidades",nullable = false)
    private String comodidades;

    @Column(name = "normas_casa",nullable = false)
    private String normas_casa;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado",nullable = false)
    private propiedadEstado estado;

    @Column(name = "fecha_creacion",nullable = false)
    private LocalDateTime fecha_creacion;

    @Column(name = "fecha_actualización",nullable = false)
    private LocalDateTime fecha_actualizacion;

    // Getters y Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public usuariosModel getPropietario() {
        return propietario;
    }

    public void setPropietario(usuariosModel propietario) {
        this.propietario = propietario;
    }

    public propiedadTipo getTipo() {
        return tipo;
    }

    public void setTipo(propiedadTipo tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getPrecio_noche() {
        return precio_noche;
    }

    public void setPrecio_noche(Double precio_noche) {
        this.precio_noche = precio_noche;
    }

    public Integer getCapacidad_personas() {
        return capacidad_personas;
    }

    public void setCapacidad_personas(Integer capacidad_personas) {
        this.capacidad_personas = capacidad_personas;
    }

    public Integer getNumero_habitaciones() {
        return numero_habitaciones;
    }

    public void setNumero_habitaciones(Integer numero_habitaciones) {
        this.numero_habitaciones = numero_habitaciones;
    }

    public Integer getNumero_banos() {
        return numero_banos;
    }

    public void setNumero_banos(Integer numero_banos) {
        this.numero_banos = numero_banos;
    }

    public int getArea_m2() {
        return area_m2;
    }

    public void setArea_m2(int area_m2) {
        this.area_m2 = area_m2;
    }

    public String getComodidades() {
        return comodidades;
    }

    public void setComodidades(String comodidades) {
        this.comodidades = comodidades;
    }

    public String getNormas_casa() {
        return normas_casa;
    }

    public void setNormas_casa(String normas_casa) {
        this.normas_casa = normas_casa;
    }

    public propiedadEstado getEstado() {
        return estado;
    }

    public void setEstado(propiedadEstado estado) {
        this.estado = estado;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public LocalDateTime getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(LocalDateTime fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    /* Relaciones */
    @OneToMany(mappedBy = "propiedad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<propiedadImagenModel> propiedad_imagenes;

    @JsonIgnore
    @OneToMany(mappedBy = "propiedad", cascade = CascadeType.ALL)
    private List<reservacionesModel> reservaciones;

    @OneToMany(mappedBy = "propiedad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<disponibilidadModel> disponibilidad;
}
