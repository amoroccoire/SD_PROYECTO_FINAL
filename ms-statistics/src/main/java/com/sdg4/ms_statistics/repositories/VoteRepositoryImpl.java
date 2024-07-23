package com.sdg4.ms_statistics.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

@Repository
public class VoteRepositoryImpl implements VoteRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Map<String, Object>> countVotesByElectionAndCandidate() {
        GroupOperation groupByElectionAndCandidate = Aggregation.group("eleccionId", "candidatoId")
                .count().as("voteCount");

        Aggregation aggregation = Aggregation.newAggregation(groupByElectionAndCandidate);
        AggregationResults<Map> results = mongoTemplate.aggregate(aggregation, "votes", Map.class);
        List<Map> mappedResults = results.getMappedResults();
        mappedResults.forEach(result -> System.out.println("Mapped Result: " + result));

        return convert(results.getMappedResults());
    }

    private List<Map<String, Object>> convert(List<Map> results) {
        return results.stream()
                .map(result -> {
                    System.out.println("Converting Result: " + result);
                    Map<String, Object> newResult = new HashMap<>();
                    Map<String, Object> idMap = (Map<String, Object>) result.get("_id");
                    newResult.put("eleccionId", idMap.get("eleccionId"));
                    newResult.put("candidatoId", idMap.get("candidatoId"));
                    newResult.put("voteCount", result.get("voteCount"));
                    return newResult;
                })
                .collect(Collectors.toList());
    }
}
