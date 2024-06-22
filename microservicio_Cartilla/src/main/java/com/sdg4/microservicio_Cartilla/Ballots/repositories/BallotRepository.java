package com.sdg4.microservicio_Cartilla.Ballots.repositories;

import com.sdg4.microservicio_Cartilla.Ballots.models.entities.Ballot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BallotRepository extends JpaRepository<Ballot, Integer> {
    List<Ballot> findByElectionId(Integer electionId);
}
