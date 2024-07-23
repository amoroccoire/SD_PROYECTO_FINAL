package com.sdg4.ms_statistics.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "votes")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Vote {
    @Id
    private String id;
    private Integer eleccionId;
    private Integer ballotId;
    private Integer candidatoId;
    private LocalDateTime localDateTime;
}
