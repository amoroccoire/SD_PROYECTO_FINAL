package com.sdg4.microservicio_Cartilla.Candidates.repositories;

import com.sdg4.microservicio_Cartilla.Candidates.models.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
    List<Candidate> findByBallotId(Integer ballotId);
}
