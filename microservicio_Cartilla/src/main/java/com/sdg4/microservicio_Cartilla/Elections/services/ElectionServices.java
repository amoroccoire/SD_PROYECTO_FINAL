package com.sdg4.microservicio_Cartilla.Elections.services;

import com.sdg4.microservicio_Cartilla.Elections.models.entities.Election;
import com.sdg4.microservicio_Cartilla.Elections.repositories.jpa.ElectionRepository;
import com.sdg4.microservicio_Cartilla.Elections.repositories.reactive.RElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ElectionServices {
    @Autowired
    private ElectionRepository electionRepository;
    @Autowired
    private RElectionRepository rElectionRepository;

    public List<Election> getAll() {
        return electionRepository.findAll();
    }

    public Mono<Election> getElectionById(Integer id) {
        return rElectionRepository.findById(id);
        //return  electionRepository.findById(id);
    }

    public Election createElection(Election election) {
        return electionRepository.save(election);
    }

    public Election updateElection(Election election) {
        return electionRepository.save(election);
    }

    public void deleteElection(Integer id) {
        electionRepository.deleteById(id);
    }

}
