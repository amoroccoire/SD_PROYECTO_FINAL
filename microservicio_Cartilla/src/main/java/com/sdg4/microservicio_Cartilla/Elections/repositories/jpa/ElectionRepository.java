package com.sdg4.microservicio_Cartilla.Elections.repositories;

import com.sdg4.microservicio_Cartilla.Elections.models.entities.Election;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectionRepository extends JpaRepository<Election, Integer> {
}
