package com.bootcamp.clinica.citas.controllers;

import com.bootcamp.clinica.citas.entities.Cita;
import com.bootcamp.clinica.citas.entities.Doctor;
import com.bootcamp.clinica.citas.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Cita save(@RequestBody Cita doctor){
        return this.citaService.save(doctor);
    }

}
