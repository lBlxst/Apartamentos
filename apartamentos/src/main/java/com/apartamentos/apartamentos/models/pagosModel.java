package com.apartamentos.apartamentos.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.apartamentos.apartamentos.models.enums.metodoPago;
import com.apartamentos.apartamentos.models.enums.pagoEstado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagos")
public class pagosModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_reservacion", nullable = false)
    private reservacionesModel reservacion;

    @Column(precision = 12, scale = 2)
    private BigDecimal monto;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago")
    private metodoPago metodoPago;

    @Enumerated(EnumType.STRING)
    private pagoEstado estado;

    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;

    @Column(name = "referencia_pago")
    private String referenciaPago;

    @Lob
    @Column(name = "datos_pago")
    private String datosPago;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public reservacionesModel getReservacion() {
        return reservacion;
    }

    public void setReservacion(reservacionesModel reservacion) {
        this.reservacion = reservacion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public metodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(metodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public pagoEstado getEstado() {
        return estado;
    }

    public void setEstado(pagoEstado estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getReferenciaPago() {
        return referenciaPago;
    }

    public void setReferenciaPago(String referenciaPago) {
        this.referenciaPago = referenciaPago;
    }

    public String getDatosPago() {
        return datosPago;
    }

    public void setDatosPago(String datosPago) {
        this.datosPago = datosPago;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    
}
