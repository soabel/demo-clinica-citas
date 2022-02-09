package com.bootcamp.clinica.citas.services;

import com.bootcamp.clinica.citas.entities.Cita;
import com.bootcamp.clinica.citas.entities.Paciente;
import com.bootcamp.clinica.citas.entities.Receta;
import com.bootcamp.clinica.citas.repositories.CitaRepository;
import com.bootcamp.clinica.citas.repositories.PacienteRepository;
import com.bootcamp.clinica.citas.repositories.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaSeviceImpl implements CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private RecetaRepository recetaRepository;

    @Override
    public List<Cita> findAll() {
        return this.citaRepository.findAll();
    }

    @Override
    public Cita save(Cita cita) {
        cita.setEstado("programado");
        return this.citaRepository.save(cita);
    }

    @Override
    public Cita findById(Long id) {
        return this.citaRepository.findById(id).get();
    }

    @Override
    public Cita updateToAttendant(Long id, String diagnostico) {
        var cita= this.citaRepository.findById(id).get();

        cita.setEstado("atendido");
        cita.setDiagnostico(diagnostico);

        this.citaRepository.save(cita);

        var receta = new Receta();
        receta.setDoctor(cita.getDoctor());
        receta.setFechaHora(cita.getFechaHora());
        receta.setPaciente(cita.getPaciente());
        receta.setCita(cita);

        this.recetaRepository.save(receta);

        return cita;
    }
}
