package com.apartamentos.apartamentos.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table  (name = "resenas")
public class resenaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "id_reservacion", unique = true, nullable = false)
    private reservacionesModel reservacion;

    @Column(name = "calificacion_limpieza")
    private Integer calificacionLimpieza;

    @Column(name = "calificacion_ubicacion")
    private Integer calificacionUbicacion;

    @Column(name = "calificacion_comunicacion")
    private Integer calificacionComunicacion;

    @Column(name = "calificacion_general")
    private Integer calificacionGeneral;

    @Lob
    @Column(name = "comentario")
    private String comentario;

    @Column(name = "fecha_resena")
    private LocalDateTime fechaResena;

    @Lob
    @Column(name = "respuesta_propietario")
    private String respuestaPropietario;

    @Column(name = "fecha_respuesta")
    private LocalDateTime fechaRespuesta;

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

    public Integer getCalificacionLimpieza() {
        return calificacionLimpieza;
    }

    public void setCalificacionLimpieza(Integer calificacionLimpieza) {
        this.calificacionLimpieza = calificacionLimpieza;
    }

    public Integer getCalificacionUbicacion() {
        return calificacionUbicacion;
    }

    public void setCalificacionUbicacion(Integer calificacionUbicacion) {
        this.calificacionUbicacion = calificacionUbicacion;
    }

    public Integer getCalificacionComunicacion() {
        return calificacionComunicacion;
    }

    public void setCalificacionComunicacion(Integer calificacionComunicacion) {
        this.calificacionComunicacion = calificacionComunicacion;
    }

    public Integer getCalificacionGeneral() {
        return calificacionGeneral;
    }

    public void setCalificacionGeneral(Integer calificacionGeneral) {
        this.calificacionGeneral = calificacionGeneral;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFechaResena() {
        return fechaResena;
    }

    public void setFechaResena(LocalDateTime fechaResena) {
        this.fechaResena = fechaResena;
    }

    public String getRespuestaPropietario() {
        return respuestaPropietario;
    }

    public void setRespuestaPropietario(String respuestaPropietario) {
        this.respuestaPropietario = respuestaPropietario;
    }

    public LocalDateTime getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(LocalDateTime fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    
}
