package com.sdg4.votes.models.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

public class BallotDTO {

    private Integer id;
    private String name;
    private String description;

    private List<CandidateDTO> candidates;

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

    public List<CandidateDTO> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<CandidateDTO> candidates) {
        this.candidates = candidates;
    }

    @Override
    public String toString() {
        return "BallotDTO{" +
                "id=" + id +
                ", name=" + name +
                ", description='" + description + '\'' +
                ", candidates=" + candidates +
                '}';
    }
}
