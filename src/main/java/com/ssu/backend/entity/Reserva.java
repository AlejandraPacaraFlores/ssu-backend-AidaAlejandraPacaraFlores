package com.ssu.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // "Código de Carnet de Asegurado" en la imagen
    @Column(name = "codigo_asegurado", nullable = false)
    private String codigoAsegurado;

    // "Nº de Carnet de Identidad" en la imagen (actúa como contraseña)
    @Column(nullable = false)
    private String contrasenia;

    @Column(nullable = true)
    private String especialidad;

    @Column(name = "fecha_reserva", nullable = true)
    private String fechaReserva;

    @Column(name = "hora_reserva", nullable = true)
    private String horaReserva;

    @Column(nullable = false)
    private Integer estado;

    public Reserva() {
    }

    public Reserva(Long id, String codigoAsegurado, String contrasenia, String especialidad, 
                   String fechaReserva, String horaReserva, Integer estado) {
        this.id = id;
        this.codigoAsegurado = codigoAsegurado;
        this.contrasenia = contrasenia;
        this.especialidad = especialidad;
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCodigoAsegurado() { return codigoAsegurado; }
    public void setCodigoAsegurado(String codigoAsegurado) { this.codigoAsegurado = codigoAsegurado; }

    public String getContrasenia() { return contrasenia; }
    public void setContrasenia(String contrasenia) { this.contrasenia = contrasenia; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(String fechaReserva) { this.fechaReserva = fechaReserva; }

    public String getHoraReserva() { return horaReserva; }
    public void setHoraReserva(String horaReserva) { this.horaReserva = horaReserva; }

    public Integer getEstado() { return estado; }
    public void setEstado(Integer estado) { this.estado = estado; }
}