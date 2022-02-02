package com.bootcamp.clinica.citas.services;

import com.bootcamp.clinica.citas.entities.Cita;
import com.bootcamp.clinica.citas.entities.Doctor;
import com.bootcamp.clinica.citas.entities.Paciente;

import java.util.List;

public interface CitaService {
    List<Cita> findAll();
    Cita save(Cita cita);
}
