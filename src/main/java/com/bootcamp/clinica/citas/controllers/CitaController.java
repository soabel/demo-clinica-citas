package com.bootcamp.clinica.citas.controllers;

import com.bootcamp.clinica.citas.core.exceptions.InvalidDataException;
import com.bootcamp.clinica.citas.entities.Cita;
import com.bootcamp.clinica.citas.entities.Doctor;
import com.bootcamp.clinica.citas.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("citas")
public class CitaController {

    @Autowired
    private CitaService citaService;


    @GetMapping
    public List<Cita> findAll(){
        return this.citaService.findAll();
    }

    @GetMapping("/{id}")
    public Cita findById(@PathVariable Long id){
        return this.citaService.findById(id);
    }


    @PostMapping
    public Cita save(@Valid @RequestBody Cita doctor, BindingResult result){
        if(result.hasErrors()){
            throw new InvalidDataException("Error en los datos de ingreso", result);
        }
        return this.citaService.save(doctor);
    }

    @PatchMapping("/{id}/registrar-atencion")
    public Cita updateCita(@PathVariable Long id, @RequestBody String diagnostico){
        return this.citaService.updateToAttendant(id, diagnostico);
    }

}
