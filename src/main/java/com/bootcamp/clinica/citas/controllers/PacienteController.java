package com.bootcamp.clinica.citas.controllers;

import com.bootcamp.clinica.citas.entities.Doctor;
import com.bootcamp.clinica.citas.entities.Paciente;
import com.bootcamp.clinica.citas.services.DoctorService;
import com.bootcamp.clinica.citas.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> findAll(){
        System.out.println("call findALl");
        return this.pacienteService.findAll();
    }

    @GetMapping("/{id}")
    public Paciente findById(@PathVariable("id") Long id){
        System.out.println("id = " + id);
        return this.pacienteService.findById(id);
    }

    @GetMapping("/buscar")
    public List<Paciente> findByName(@RequestParam("nombre") String nombre){
        return this.pacienteService.findByName(nombre);
    }

    @PostMapping
    public Paciente save(@RequestBody Paciente paciente){
        return this.pacienteService.save(paciente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        this.pacienteService.delete(id);
    }

}
