package com.sdg4.microservicio_Cartilla.Candidates.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sdg4.microservicio_Cartilla.Ballots.models.entities.Ballot;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String party;
    private String position;

    @ManyToOne
    @JoinColumn(name = "ballot_id", nullable = false)
    @JsonBackReference
    private Ballot ballot;
}
