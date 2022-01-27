package com.bootcamp.clinica.citas.services;

import com.bootcamp.clinica.citas.entities.Doctor;
import com.bootcamp.clinica.citas.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;
    public DoctorServiceImpl( DoctorRepository doctorRepository){
        this.doctorRepository=doctorRepository;
    }

    @Override
    public List<Doctor> findAll() {
        return this.doctorRepository.findAll();
    }
}
