package com.sdg4.votes.controllers;

import com.sdg4.votes.models.dto.CreateVote;
import com.sdg4.votes.services.ValidationService;
import com.sdg4.votes.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/votes")
public class VoteController {
    @Autowired
    private VoteService voteService;
    @Autowired
    private ValidationService validationService;

    @PostMapping
    public Mono<ResponseEntity<String>> registerVote(@RequestBody @Valid CreateVote vote) {

        return voteService.searchVote(vote)
                .flatMap(exists -> {
                    if (!exists) {
                        return validationService.isElectionIdValid(vote.electionId(), vote.ballotId(), vote.candidateId())
                                .flatMap(isValid -> {
                                    if (!isValid) {
                                        return Mono.just(new ResponseEntity<>("ID de la eleccion invalida", HttpStatus.BAD_REQUEST));
                                    }
                                    return voteService.createVote(vote)
                                            .map(savedVote -> new ResponseEntity<>("Registro guardado con exito", HttpStatus.CREATED));
                                });
                    } else {
                        return Mono.just(new ResponseEntity<>("Usted ya ha votado", HttpStatus.ACCEPTED));
                    }
                })
                .doOnError(error -> {
                    System.out.println("ERROR: " + error.getMessage());
                });
    }
}
