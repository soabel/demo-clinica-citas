package com.bootcamp.clinica.citas.repositories;

import com.bootcamp.clinica.citas.entities.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Long> {
}
