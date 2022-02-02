package com.bootcamp.clinica.citas.services;

import com.bootcamp.clinica.citas.entities.Cita;
import com.bootcamp.clinica.citas.entities.Paciente;
import com.bootcamp.clinica.citas.repositories.CitaRepository;
import com.bootcamp.clinica.citas.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaSeviceImpl implements CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Override
    public List<Cita> findAll() {
        return this.citaRepository.findAll();
    }

    @Override
    public Cita save(Cita cita) {
        return this.citaRepository.save(cita);
    }
}
