package com.sdg4.votes.services;

import com.sdg4.votes.models.dto.BallotDTO;
import com.sdg4.votes.models.dto.CandidateDTO;
import com.sdg4.votes.models.dto.ElectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ValidationService {
    private final WebClient webClient;

    @Autowired
    public ValidationService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("lb://cartilla-service").build();
    }

    public Mono<Boolean> isElectionIdValid(Integer electionId, Integer ballotId, Integer candidateId) {
        return webClient.get()
                .uri("/eleccion/{id}", electionId)
                .retrieve()
                .bodyToMono(ElectionDTO.class)
                .map(election -> {
                    //validar ballot
                    BallotDTO ballot = election.getBallotList().stream()
                            .filter(b -> b.getBallotId().equals(ballotId))
                            .findFirst()
                            .orElse(null);

                    System.out.println(ballot);

                    if (ballot == null)
                        return false;

                    CandidateDTO candidate = ballot.getCandidateList().stream()
                            .filter(c -> c.getCandidateId().equals(candidateId))
                            .findFirst()
                            .orElse(null);

                    System.out.println(candidate);

                    return candidate != null;
                })
                .onErrorReturn(false);
    }
}
