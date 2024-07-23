package com.sdg4.votes.services;

import com.sdg4.votes.models.dto.CreateVote;
import com.sdg4.votes.models.entities.Vote;
import com.sdg4.votes.proto.VoteProto;
import com.sdg4.votes.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private MessageService messageService;

    public Mono<Boolean> searchVote(CreateVote vote) {
        return voteRepository.findByVoterId(vote.voterId())
                .map(voteFound -> true)
                .defaultIfEmpty(false);
    }

    public Mono<Vote> createVote(CreateVote vote) {
        Vote voteCreated = new Vote();

        voteCreated.setTimestamp(LocalDateTime.now());
        voteCreated.setId(null);
        voteCreated.setElectionId(vote.electionId());
        voteCreated.setCartillaId(vote.ballotId());
        voteCreated.setCandidateId(vote.candidateId());
        voteCreated.setVoterId(vote.voterId());

        return voteRepository.save(voteCreated)
                .flatMap(savedVote -> {
                    LocalDateTime now = savedVote.getTimestamp();
                    VoteProto.LocalDateTime protoVoteTime = VoteProto.LocalDateTime.newBuilder()
                            .setYear(now.getYear())
                            .setMonth(now.getMonthValue())
                            .setDay(now.getDayOfMonth())
                            .setHour(now.getHour())
                            .setMinute(now.getMinute())
                            .setSecond(now.getSecond())
                            .build();

                    VoteProto.Vote protoVote = VoteProto.Vote.newBuilder()
                            .setId(savedVote.getId())
                            .setElectionId(savedVote.getElectionId())
                            .setBallotId(savedVote.getCartillaId())
                            .setCandidateId(savedVote.getCandidateId())
                            .setVoteTime(protoVoteTime)
                            .build();
                    return messageService.sendMessage(protoVote).thenReturn(savedVote);
                });
    }
}
