package com.bootcamp.clinica.citas.repositories;

import com.bootcamp.clinica.citas.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository  extends JpaRepository<Doctor, Long> {
}
