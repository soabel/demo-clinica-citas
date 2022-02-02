package com.bootcamp.clinica.citas.repositories;

import com.bootcamp.clinica.citas.entities.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
}
