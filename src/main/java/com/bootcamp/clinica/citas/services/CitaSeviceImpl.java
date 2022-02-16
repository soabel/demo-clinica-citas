package com.bootcamp.clinica.citas.services;

import com.bootcamp.clinica.citas.entities.Cita;
import com.bootcamp.clinica.citas.entities.Paciente;
import com.bootcamp.clinica.citas.entities.Receta;
import com.bootcamp.clinica.citas.entities.RecetaDetalle;
import com.bootcamp.clinica.citas.repositories.CitaRepository;
import com.bootcamp.clinica.citas.repositories.PacienteRepository;
import com.bootcamp.clinica.citas.repositories.RecetaRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CitaSeviceImpl implements CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private RecetaRepository recetaRepository;

    @Override
    public List<Cita> findAll() {

        var data = this.citaRepository.findAll()
                .stream()
                .filter(x-> x.getEstado()=="programado");

        var lista = data.collect(Collectors.toList());

        return lista;
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


        var citaOptional= this.citaRepository.findById(id);

        if(!citaOptional.isPresent())
            throw new NoSuchElementException("");

        var cita= citaOptional.get();

        cita.setEstado("atendido");
        cita.setDiagnostico(diagnostico);

        this.citaRepository.save(cita);

        System.out.println("cita = " + cita);

        var receta = new Receta();
        receta.setDoctor(cita.getDoctor());
        receta.setFechaHora(cita.getFechaHora());
        receta.setPaciente(cita.getPaciente());
        receta.setCita(cita);

        List<RecetaDetalle> detalles = new ArrayList<>();
        var recetaDetalle= new RecetaDetalle();
        recetaDetalle.setProducto("Amoxicilina");
        recetaDetalle.setCantidad(10);
        recetaDetalle.setIndicaciones("1 cada 8 horas");
        recetaDetalle.setId(0L);
        detalles.add(recetaDetalle);

        var recetaDetalle1= new RecetaDetalle();
        recetaDetalle1.setProducto("Paracetamol 1g");
        recetaDetalle1.setCantidad(10);
        recetaDetalle1.setIndicaciones("1 cada 12 horas");
        recetaDetalle1.setId(0L);
        detalles.add(recetaDetalle1);

        receta.setDetalle(detalles);

        this.recetaRepository.save(receta);


        return cita;
    }
}
