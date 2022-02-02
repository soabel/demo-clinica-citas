package com.bootcamp.clinica.citas.services;

import com.bootcamp.clinica.citas.entities.Doctor;
import com.bootcamp.clinica.citas.entities.Paciente;
import com.bootcamp.clinica.citas.repositories.DoctorRepository;
import com.bootcamp.clinica.citas.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> findByName(String nombre) {
        return this.pacienteRepository.find(nombre);
    }

    @Override
    public List<Paciente> findAll() {
        return this.pacienteRepository.findAll();
    }

    @Override
    public Paciente findById(Long id) {
        return this.pacienteRepository.findById(id).get();
    }

    @Override
    public Paciente save(Paciente doctor) {
        return this.pacienteRepository.save(doctor);
    }

    @Override
    public void delete(Long id) {
        this.pacienteRepository.deleteById(id);
    }
}
