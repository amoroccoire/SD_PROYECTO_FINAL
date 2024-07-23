package com.sdg4.ms_statistics.controller;

import com.sdg4.ms_statistics.entities.dto.EleccionDto;
import com.sdg4.ms_statistics.services.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estadistica")
public class StatisticController {
    @Autowired
    private StatisticsService statisticsService;

    @GetMapping
    public ResponseEntity<List<EleccionDto>> getAll() {
        List<EleccionDto> results = statisticsService.getAll();
        return ResponseEntity.ok(results);
    }
}
