package com.apartamentos.apartamentos.models;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.EnumType;
import jakarta.persistence.CascadeType;
import com.apartamentos.apartamentos.models.enums.usuarioTipo;
import com.apartamentos.apartamentos.models.enums.usuarioEstado;


@Entity
@Table(name = "usuarios")
public class usuariosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo",nullable = false)
    private usuarioTipo tipo;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "apellido",nullable = false)
    private String apellido;

    @Column(name = "email",nullable = false, unique = true)
    private String email;

    @Column(name = "telefono",nullable = false)
    private String telefono;

    @Column(name = "fecha_nacimiento",nullable = false)
    private LocalDate fecha_nacimiento;

    @Column(name = "documento_identidad",nullable = false)
    private String documento_identidad;

    @Column(name = "direccion",nullable = false)
    private String direccion;   

    @Column(name = "fecha_registro",nullable = false)
    private LocalDateTime fecha_registro;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado",nullable = false)
    private usuarioEstado estado;

    @Column(name = "contraseña_hash",nullable = false)
    private String contrasena_hash;

    @Column(name = "ultima_conexion",nullable = false)
    private LocalDateTime ultima_conexion;

    //Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public usuarioTipo getTipo() {
        return tipo;
    }

    public void setTipo(usuarioTipo tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDocumento_identidad() {
        return documento_identidad;
    }

    public void setDocumento_identidad(String documento_identidad) {
        this.documento_identidad = documento_identidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public usuarioEstado getEstado() {
        return estado;
    }

    public void setEstado(usuarioEstado estado) {
        this.estado = estado;
    }

    public String getContrasena_hash() {
        return contrasena_hash;
    }

    public void setContrasena_hash(String contrasena_hash) {
        this.contrasena_hash = contrasena_hash;
    }

    public LocalDateTime getUltima_conexion() {
        return ultima_conexion;
    }

    public void setUltima_conexion(LocalDateTime ultima_conexion) {
        this.ultima_conexion = ultima_conexion;
    }

    //Relaciones

    @JsonIgnore
    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
    private List<propiedadesModel> propiedades;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<reservacionesModel> reservaciones;

    @JsonIgnore
    @OneToMany(mappedBy = "remitente")
    private List<mensajesModel> mensajesEnviados;

    @JsonIgnore
    @OneToMany(mappedBy = "destinatario")
    private List<mensajesModel> mensajesRecibidos;
}