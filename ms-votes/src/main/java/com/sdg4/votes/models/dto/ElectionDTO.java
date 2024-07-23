package com.sdg4.votes.models.dto;

import java.util.List;

public class ElectionDTO {
    private Integer electionId;
    private String name;
    private String description;
    private List<BallotDTO> ballotList;

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

    public List<BallotDTO> getBallotList() {
        return ballotList;
    }

    public void setBallotList(List<BallotDTO> ballotList) {
        this.ballotList = ballotList;
    }
}
