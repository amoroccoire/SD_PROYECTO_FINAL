package com.sdg4.ms_statistics.entities.dto;

import java.util.List;

public record EleccionDto(Integer id, List<ConteoVoto> candidatos) {
}
