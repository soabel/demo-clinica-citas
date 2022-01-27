package com.bootcamp.clinica.citas.controllers;

import com.bootcamp.clinica.citas.entities.Doctor;
import com.bootcamp.clinica.citas.services.DoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
