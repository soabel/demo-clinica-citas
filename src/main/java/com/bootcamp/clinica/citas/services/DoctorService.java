package com.bootcamp.clinica.citas.services;

import com.bootcamp.clinica.citas.entities.Doctor;

import java.util.List;

public interface DoctorService {
     List<Doctor> findByName(String nombre);
     List<Doctor> findAll();
     Doctor findById(Long id);
     Doctor save(Doctor doctor);
     void delete(Long id);
}
