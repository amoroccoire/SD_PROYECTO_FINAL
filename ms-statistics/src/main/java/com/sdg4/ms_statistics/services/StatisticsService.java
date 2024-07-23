package com.sdg4.ms_statistics.services;

import com.sdg4.ms_statistics.entities.dto.EleccionDto;
import com.sdg4.ms_statistics.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdg4.ms_statistics.entities.dto.ConteoVoto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StatisticsService {
    @Autowired
    private VoteRepository voteRepository;

    public List<EleccionDto> getAll() {
        List<Map<String, Object>> flatResults = voteRepository.countVotesByElectionAndCandidate();

        Map<Integer, List<Map<String, Object>>> groupedByElection = flatResults.stream()
                .collect(Collectors.groupingBy(result -> (Integer) result.get("eleccionId")));

        return groupedByElection.entrySet().stream()
                .map(entry -> new EleccionDto(
                        entry.getKey(),
                        entry.getValue().stream()
                                .map(candidateResult -> new ConteoVoto(
                                        (Integer) candidateResult.get("candidatoId"),
                                        (Integer) candidateResult.get("voteCount")
                                ))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }
}
