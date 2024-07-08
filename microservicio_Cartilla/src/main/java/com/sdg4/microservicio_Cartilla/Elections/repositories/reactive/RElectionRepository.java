package com.sdg4.microservicio_Cartilla.Elections.repositories;

import com.sdg4.microservicio_Cartilla.Elections.models.entities.Election;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface RElectionRepository extends ReactiveCrudRepository<Election, Integer> {
    Mono<Election> findById(Integer id);
}
