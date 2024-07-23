package com.sdg4.votes.models.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

public class BallotDTO {

    private Integer ballotId;
    private Integer electionId;
    private String name;
    private String description;

    private List<CandidateDTO> candidateList;

    public Integer getBallotId() {
        return ballotId;
    }

    public void setBallotId(Integer ballotId) {
        this.ballotId = ballotId;
    }

    public Integer getElectionId() {
        return electionId;
    }

    public void setElectionId(Integer electionId) {
        this.electionId = electionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CandidateDTO> getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(List<CandidateDTO> candidateList) {
        this.candidateList = candidateList;
    }
}
