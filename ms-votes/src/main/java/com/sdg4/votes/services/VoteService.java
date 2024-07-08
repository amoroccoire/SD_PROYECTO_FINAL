package com.sdg4.votes.services;

import com.sdg4.votes.models.dto.CreateVote;
import com.sdg4.votes.models.entities.Vote;
import com.sdg4.votes.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;

    public Mono<Vote> createVote(CreateVote vote) {
        Vote voteCreated = new Vote();

        voteCreated.setTimestamp(LocalDateTime.now());
        voteCreated.setId(null);
        voteCreated.setElectionId(vote.electionId());
        voteCreated.setCartillaId(vote.ballotId());
        voteCreated.setCandidateId(vote.candidateId());
        voteCreated.setVoterId(vote.voterId());

        return voteRepository.save(voteCreated);
    }
}
