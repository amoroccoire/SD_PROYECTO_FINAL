package com.sdg4.votes.models.entities;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Document(collation = "votes")
public class Vote {
    @Id
    private Long id;

    @NotNull(message = "ID del votante no puede ser null")
    @Size(min = 8, max = 15, message = "Voter ID deberia estar entre 8 and 15 caracteres")
    private String voterId;

    @NotNull(message = "Election ID no puede ser null")
    private Integer electionId;

    @NotNull(message="Ballot ID no puede ser null")
    private Integer cartillaId;

    @NotNull(message = "Candidato ID no puede ser null")
    private Integer candidateId;

    private LocalDateTime timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public Integer getElectionId() {
        return electionId;
    }

    public void setElectionId(Integer electionId) {
        this.electionId = electionId;
    }

    public Integer getCartillaId() {
        return cartillaId;
    }

    public void setCartillaId(Integer cartillaId) {
        this.cartillaId = cartillaId;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
