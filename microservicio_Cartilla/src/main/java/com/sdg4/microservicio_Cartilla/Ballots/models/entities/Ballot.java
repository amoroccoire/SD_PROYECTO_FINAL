package com.sdg4.microservicio_Cartilla.Ballots.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sdg4.microservicio_Cartilla.Candidates.models.entities.Candidate;
import com.sdg4.microservicio_Cartilla.Elections.models.entities.Election;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ballot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "election_id", nullable = false)
    @JsonBackReference
    private Election election; //id de la eleccion, es foranea
    private String name;
    private String description;

    @OneToMany(mappedBy = "ballot", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Candidate> candidates;

}
