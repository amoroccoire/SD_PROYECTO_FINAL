package com.sdg4.votes.models.dto;

public record CreateVote(String voterId, Integer electionId, Integer ballotId, Integer candidateId) {

}
