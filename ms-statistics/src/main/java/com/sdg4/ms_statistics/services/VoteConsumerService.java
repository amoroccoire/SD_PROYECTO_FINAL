package com.sdg4.ms_statistics.services;

import com.sdg4.ms_statistics.entities.Vote;
import com.sdg4.ms_statistics.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.sdg4.ms_statistics.proto.VoteProto;

import java.time.LocalDateTime;

@Service
public class VoteConsumerService {

    @Autowired
    private VoteRepository voteRepository;

    @KafkaListener(topics = {"votes-topic"}, groupId="${spring.kafka.consumer.group-id}")
    public void listen(VoteProto.Vote vote) {
        // Procesa el mensaje
        System.out.println("Received message: " + vote);

        VoteProto.LocalDateTime time = vote.getVoteTime();
        LocalDateTime copia = LocalDateTime.of(time.getYear(), time.getMonth(), time.getDay(), time.getHour(), time.getMinute(), time.getSecond());

        Vote voteSaved = Vote.builder()
                .id(vote.getId())
                .eleccionId(vote.getElectionId())
                .ballotId(vote.getBallotId())
                .candidatoId(vote.getCandidateId())
                .localDateTime(copia)
                .build();

        voteRepository.save(voteSaved);

    }
}

