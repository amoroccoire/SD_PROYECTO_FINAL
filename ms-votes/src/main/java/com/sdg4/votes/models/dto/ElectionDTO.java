package com.sdg4.votes.models.dto;

import java.util.List;

public class ElectionDTO {
    private Integer id;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private List<BallotDTO> ballots;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<BallotDTO> getBallots() {
        return ballots;
    }

    public void setBallots(List<BallotDTO> ballots) {
        this.ballots = ballots;
    }

    @Override
    public String toString() {
        return "ElectionDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", ballots=" + ballots +
                '}';
    }
}
