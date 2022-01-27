package com.bootcamp.clinica.citas.services;

import com.bootcamp.clinica.citas.entities.Doctor;

import java.util.List;

public interface DoctorService {
     List<Doctor> findAll();
}
