package com.bootcamp.clinica.citas.controllers;

import com.bootcamp.clinica.citas.entities.Doctor;
import com.bootcamp.clinica.citas.services.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("doctores")
public class DoctorController {

    private DoctorService doctorService;

    DoctorController(DoctorService doctorService){
        this.doctorService= doctorService;
    }

    @GetMapping
    public List<Doctor> findAll(){
        return this.doctorService.findAll();
    }

    @GetMapping("/{id}")
    public Doctor findById(@PathVariable("id") Long id){
        return this.doctorService.findById(id);
    }

    @PostMapping
    public Doctor save(@RequestBody Doctor doctor){
        return this.doctorService.save(doctor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        this.doctorService.delete(id);
    }

}
