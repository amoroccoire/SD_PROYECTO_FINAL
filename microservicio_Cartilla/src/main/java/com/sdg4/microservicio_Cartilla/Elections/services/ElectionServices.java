package com.sdg4.microservicio_Cartilla.Elections.services;

import com.sdg4.microservicio_Cartilla.Elections.models.entities.Election;
import com.sdg4.microservicio_Cartilla.Elections.repositories.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElectionServices {
    @Autowired
    private ElectionRepository electionRepository;

    public List<Election> getAll() {
        return electionRepository.findAll();
    }

    public Optional<Election> getElectionById(Integer id) {
        return  electionRepository.findById(id);
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
