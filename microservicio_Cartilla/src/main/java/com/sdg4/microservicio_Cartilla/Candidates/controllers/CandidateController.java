package com.sdg4.microservicio_Cartilla.Candidates.controllers;

import com.sdg4.microservicio_Cartilla.Candidates.models.entities.Candidate;
import com.sdg4.microservicio_Cartilla.Candidates.models.entities.dto.CreateCandidate;
import com.sdg4.microservicio_Cartilla.Candidates.models.entities.dto.UpdateCandidate;
import com.sdg4.microservicio_Cartilla.Candidates.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidato")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    //USUARIO O ADMIN - retorna todas los candidatos disponibles
    @GetMapping
    public ResponseEntity<List<Candidate>> getAll() {
        List<Candidate> list = candidateService.getAll();
        return ResponseEntity.ok(list);
    }

    //USUARIO O ADMIN - retorna todos los candidatos por id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Candidate>> getCandidateById(@PathVariable Integer id) {
        Optional<Candidate> candidato = candidateService.getCandidateById(id);
        return ResponseEntity.ok(candidato);
    }

    //ADMIN - crear candidato
    @PostMapping
    public ResponseEntity<Candidate> createCandidate(@RequestBody CreateCandidate candidate) {
        Candidate createdCandidate = candidateService.createCandidate(candidate);
        return ResponseEntity.ok(createdCandidate);
    }

    //ADMIN - Actualizar candidato
    @PutMapping
    public ResponseEntity<Candidate> updateCandidate(@RequestBody UpdateCandidate candidate) {
        Candidate updatedCandidated = candidateService.updateCandidate(candidate);
        return ResponseEntity.ok(updatedCandidated);
    }

    //ADMIN - Eliminar candidato
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        candidateService.deleteCandidate(id);
    }
}
