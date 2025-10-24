package com.apartamentos.apartamentos.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


import com.apartamentos.apartamentos.models.enums.reservacionEstado;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "reservaciones")

public class reservacionesModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_propiedad", nullable = false)
    private propiedadesModel propiedad;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private usuariosModel cliente;

    @Column(name = "fecha_entrada")
    private LocalDate fechaEntrada;

    @Column(name = "fecha_salida")
    private LocalDate fechaSalida;

    @Column(name = "numero_huespedes")
    private Integer numeroHuespedes;

    @Column(name = "precio_total", precision = 12, scale = 2)
    private BigDecimal precioTotal;

    @Enumerated(EnumType.STRING)
    private reservacionEstado estado;

    @Column(name = "fecha_reservacion")
    private LocalDateTime fechaReservacion;

    @Column(name = "notas", length = 1000)
    private String notas;

    @Column(name = "codigo_reserva")
    private String codigoReserva;

    @Column(name = "fecha_checkin")
    private LocalDateTime fechaCheckin;

    @Column(name = "fecha_checkout")
    private LocalDateTime fechaCheckout;

    //getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public propiedadesModel getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(propiedadesModel propiedad) {
        this.propiedad = propiedad;
    }

    public usuariosModel getCliente() {
        return cliente;
    }

    public void setCliente(usuariosModel cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Integer getNumeroHuespedes() {
        return numeroHuespedes;
    }

    public void setNumeroHuespedes(Integer numeroHuespedes) {
        this.numeroHuespedes = numeroHuespedes;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

    public reservacionEstado getEstado() {
        return estado;
    }

    public void setEstado(reservacionEstado estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(LocalDateTime fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public LocalDateTime getFechaCheckin() {
        return fechaCheckin;
    }

    public void setFechaCheckin(LocalDateTime fechaCheckin) {
        this.fechaCheckin = fechaCheckin;
    }

    public LocalDateTime getFechaCheckout() {
        return fechaCheckout;
    }

    public void setFechaCheckout(LocalDateTime fechaCheckout) {
        this.fechaCheckout = fechaCheckout;
    }

    /* Relaciones */
    @OneToMany(mappedBy = "reservacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<pagosModel> pagos;

    @OneToOne(mappedBy = "reservacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private resenaModel resenas;

    @JsonIgnore
    @OneToMany(mappedBy = "reservacion")
    private List<mensajesModel> mensajes;

}
