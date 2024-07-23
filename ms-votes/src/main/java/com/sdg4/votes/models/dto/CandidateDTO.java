package com.sdg4.votes.models.dto;

public class CandidateDTO {

    private Integer id;
    private String name;
    private String party;
    private String position;
    //private BallotDTO ballot;

    @Override
    public String toString() {
        return "CandidateDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", party='" + party + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getParty() {
        return party;
    }

    public String getPosition() {
        return position;
    }



    /*public BallotDTO getBallot() {
        return ballot;
    }

    public void setBallot(BallotDTO ballot) {
        this.ballot = ballot;
    }*/
}
