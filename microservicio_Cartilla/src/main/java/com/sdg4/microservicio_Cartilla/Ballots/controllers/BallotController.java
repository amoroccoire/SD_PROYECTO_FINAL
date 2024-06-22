package com.sdg4.microservicio_Cartilla.Ballots.controllers;

import com.sdg4.microservicio_Cartilla.Ballots.models.entities.Ballot;
import com.sdg4.microservicio_Cartilla.Ballots.models.entities.dto.CreateBallot;
import com.sdg4.microservicio_Cartilla.Ballots.models.entities.dto.UpdateBallot;
import com.sdg4.microservicio_Cartilla.Candidates.models.entities.Candidate;
import com.sdg4.microservicio_Cartilla.Ballots.services.BallotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ballot")
public class BallotController {
    @Autowired
    private BallotService ballotService;
    //PARA ADMIN
    //PARA USUARIO - retorna todos las cartillas por id de la eleccion
    @GetMapping
    public ResponseEntity<List<Ballot>> getAll() {
        List<Ballot> list = ballotService.getAllBallot();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{electionId}/election")
    public ResponseEntity<List<Ballot>> getBallotsByElectionId(@PathVariable Integer electionId) {
        List<Ballot> ballots = ballotService.getAllBallotsByElectionId(electionId);
        return ResponseEntity.ok(ballots);
    }
    //PARA ADMIN
    //PARA USUARIO - retorna todos los candidatos de la cartilla por id de la cartilla
    @GetMapping("/{ballotId}/candidates")
    public ResponseEntity<List<Candidate>> getCandidatesByBallotId(@PathVariable Integer ballotId) {
        List<Candidate> candidates = ballotService.getCandidatesByBallotId(ballotId);
        return ResponseEntity.ok(candidates);
    }

    //SOLO ADMIN
    @PostMapping
    public ResponseEntity<Ballot> createBallot(@RequestBody CreateBallot ballot) {
        Ballot createdBallot = ballotService.createBallot(ballot);
        return ResponseEntity.ok(createdBallot);
    }

    //SOLO ADMIN
    @PutMapping
    public ResponseEntity<Ballot> updateBallot(@RequestBody UpdateBallot ballot) {
        Ballot updateBallot = ballotService.updateBallot(ballot);
        return ResponseEntity.ok(updateBallot);
    }

    //SOLO ADMIN
    @DeleteMapping("/{id}")
    public void deleteBallot(@PathVariable Integer id) {
        ballotService.deleteBallot(id);
    }
}
