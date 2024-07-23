package com.sdg4.microservicio_Cartilla.Ballots.services;

import com.sdg4.microservicio_Cartilla.Ballots.models.entities.Ballot;
import com.sdg4.microservicio_Cartilla.Ballots.models.entities.dto.CreateBallot;
import com.sdg4.microservicio_Cartilla.Ballots.models.entities.dto.UpdateBallot;
import com.sdg4.microservicio_Cartilla.Candidates.models.entities.Candidate;
import com.sdg4.microservicio_Cartilla.Ballots.repositories.BallotRepository;
import com.sdg4.microservicio_Cartilla.Candidates.repositories.CandidateRepository;
import com.sdg4.microservicio_Cartilla.Elections.models.entities.Election;
import com.sdg4.microservicio_Cartilla.Elections.repositories.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BallotService {
    @Autowired
    private BallotRepository ballotRepository;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private ElectionRepository electionRepository;

    public List<Ballot> getAllBallot() {
        return ballotRepository.findAll();
    }

    public Optional<Ballot> getBallotById(Integer id) {
        return ballotRepository.findById(id);
    }

    public List<Ballot> getAllBallotsByElectionId(Integer id) {
        return ballotRepository.findByElectionId(id);
    }

    public List<Candidate> getCandidatesByBallotId(Integer ballotId) {
        return candidateRepository.findByBallotId(ballotId);
    }

    public Ballot createBallot(CreateBallot ballot) {
        Optional<Election> election = electionRepository.findById(ballot.idElection());
        if (election.isEmpty()) {
            throw new IllegalArgumentException("Election not found with id: " + ballot.idElection());
        }
        Ballot ballot1 = Ballot.builder()
                .id(null)
                .election(election.get())
                .name(ballot.name())
                .description(ballot.description())
                .build();
        return ballotRepository.save(ballot1);
    }

    public Ballot updateBallot(UpdateBallot ballot) {
        Optional<Ballot> ballotFound = ballotRepository.findById(ballot.id());
        Optional<Election> electionFound = electionRepository.findById(ballot.idElection());
        if (ballotFound.isEmpty()) {
            throw new IllegalArgumentException("Ballot not found with id: " + ballot.id());
        }
        if (electionFound.isEmpty()) {
            throw new IllegalArgumentException("Election not found with id: " + ballot.idElection());
        }

        Ballot ballotUpdate = Ballot.builder()
                .id(ballot.id())
                .election(electionFound.get())
                .name(ballot.name())
                .description(ballot.description())
                .build();
        return ballotRepository.save(ballotUpdate);
    }

    public void deleteBallot(Integer id) {
        ballotRepository.deleteById(id);
    }
}
