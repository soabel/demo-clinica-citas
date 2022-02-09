package com.bootcamp.clinica.citas.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="receta")
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(unique = true , nullable = false)
    private Long id;
    @Column(name = "fechahora")
    private Date fechaHora;
    @ManyToOne()
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @ManyToOne()
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @ManyToOne()
    @JoinColumn(name = "cita_id")
    private Cita cita;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    @Override
    public String toString() {
        return "Receta{" +
                "id=" + id +
                ", fechaHora=" + fechaHora +
                ", doctor=" + doctor +
                ", paciente=" + paciente +
                '}';
    }
}
