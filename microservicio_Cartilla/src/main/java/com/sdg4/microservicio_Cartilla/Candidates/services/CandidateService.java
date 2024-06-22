package com.sdg4.microservicio_Cartilla.Candidates.services;

import com.sdg4.microservicio_Cartilla.Ballots.models.entities.Ballot;
import com.sdg4.microservicio_Cartilla.Ballots.repositories.BallotRepository;
import com.sdg4.microservicio_Cartilla.Candidates.models.entities.Candidate;
import com.sdg4.microservicio_Cartilla.Candidates.models.entities.dto.CreateCandidate;
import com.sdg4.microservicio_Cartilla.Candidates.models.entities.dto.UpdateCandidate;
import com.sdg4.microservicio_Cartilla.Candidates.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private BallotRepository ballotRepository;

    public List<Candidate> getAll() {

        return candidateRepository.findAll();
    }

    public Optional<Candidate> getCandidateById(Integer id) {
        return candidateRepository.findById(id);
    }

    public Candidate createCandidate(CreateCandidate candidate) {
        Optional<Ballot> ballotFound = ballotRepository.findById(candidate.ballotId());
        if (ballotFound.isEmpty()) {
            throw new IllegalArgumentException("Ballot not found with id: " + candidate.ballotId());
        }

        Candidate buildCandidate = Candidate.builder()
                .id(null)
                .ballot(ballotFound.get())
                .name(candidate.name())
                .party(candidate.party())
                .position(candidate.position())
                .build();

        return candidateRepository.save(buildCandidate);
    }

    public Candidate updateCandidate(UpdateCandidate candidate) {
        Optional<Candidate> candidateFound = candidateRepository.findById(candidate.id());
        Optional<Ballot> ballotFound = ballotRepository.findById(candidate.ballotId());

        if (candidateFound.isEmpty()) {
            throw new IllegalArgumentException("Candidate not found with id: " + candidate.id());
        }
        if (ballotFound.isEmpty()) {
            throw new IllegalArgumentException("Ballot not found with id: " + candidate.ballotId());
        }

        Candidate buildCandidate = Candidate.builder()
                .id(candidateFound.get().getId())
                .ballot(ballotFound.get())
                .name(candidate.name())
                .party(candidate.party())
                .position(candidate.position())
                .build();

        return candidateRepository.save(buildCandidate);
    }

    public void deleteCandidate(Integer id) {
        candidateRepository.deleteById(id);
    }
}
