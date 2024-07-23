package com.sdg4.microservicio_Cartilla.Elections.models.DTO;

import java.time.LocalDateTime;

public record DtoElection(String nombre, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
}
