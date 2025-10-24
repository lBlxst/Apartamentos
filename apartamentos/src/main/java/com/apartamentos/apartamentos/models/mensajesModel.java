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
@Table(name = "mensajes")
public class mensajesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_remitente", nullable = false)
    private usuariosModel remitente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_destinatario", nullable = false)
    private usuariosModel destinatario;

    @ManyToOne
    @JoinColumn(name = "id_reservacion")
    private reservacionesModel reservacion;

    @Column(name = "asunto")
    private String asunto;

    @Column(name = "contenido", columnDefinition = "TEXT")
    private String contenido;

    @Column(name = "leido")
    private Boolean leido;

    @Column(name = "fecha_envio")
    private LocalDateTime fechaEnvio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public usuariosModel getRemitente() {
        return remitente;
    }

    public void setRemitente(usuariosModel remitente) {
        this.remitente = remitente;
    }

    public usuariosModel getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(usuariosModel destinatario) {
        this.destinatario = destinatario;
    }

    public reservacionesModel getReservacion() {
        return reservacion;
    }

    public void setReservacion(reservacionesModel reservacion) {
        this.reservacion = reservacion;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Boolean getLeido() {
        return leido;
    }

    public void setLeido(Boolean leido) {
        this.leido = leido;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
}
