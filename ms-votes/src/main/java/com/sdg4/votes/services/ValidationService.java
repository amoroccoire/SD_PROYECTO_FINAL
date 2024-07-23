package com.sdg4.votes.services;

import com.sdg4.votes.models.dto.BallotDTO;
import com.sdg4.votes.models.dto.CandidateDTO;
import com.sdg4.votes.models.dto.ElectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class ValidationService {
    private final WebClient webClient;

    @Autowired
    public ValidationService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("lb://cartilla-service").build();
    }

    public Mono<Boolean> isElectionIdValid(Integer electionId, Integer ballotId, Integer candidateId) {
        System.out.println("DATOS en isElectionIdValid" + electionId + "\n" + ballotId + "\n" + candidateId);
        return webClient.get()
                .uri("/eleccion/{id}", electionId)
                .retrieve()
                .bodyToMono(ElectionDTO.class)
                .doOnNext(election -> {
                    // Imprimir el objeto ElectionDTO completo
                    System.out.println("ElectionDTO: " + election);
                })
                .map(election -> {
                    //validar ballot
                    BallotDTO ballot = election.getBallots().stream()
                            .filter(b -> b.getId().equals(ballotId))
                            .findFirst()
                            .orElse(null);

                    System.out.println("Resultado final de BALLOT :" + (ballot == null));
                    if (ballot == null) {
                        System.out.println("esto es el ballot"  + ballot);
                        return false;

                    }

                    CandidateDTO candidate = ballot.getCandidates().stream()
                            .filter(c -> c.getId().equals(candidateId))
                            .findFirst()
                            .orElse(null);

                    System.out.println("esto es el candidato"  + candidate);
                    System.out.println("Resultado final de candidate :" + (candidate != null));
                    return candidate != null;
                })
                .doOnError(error -> System.out.println("Error en isElectionIdValid: " + error.getMessage()))
                .onErrorReturn(false)
                .log()
                .subscribeOn(Schedulers.boundedElastic());

    }
}
