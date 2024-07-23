package com.sdg4.votes.models.dto;

public class CandidateDTO {

    private Integer candidateId;
    private String name;
    private String party;
    private String position;
    private BallotDTO ballot;

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BallotDTO getBallot() {
        return ballot;
    }

    public void setBallot(BallotDTO ballot) {
        this.ballot = ballot;
    }
}
