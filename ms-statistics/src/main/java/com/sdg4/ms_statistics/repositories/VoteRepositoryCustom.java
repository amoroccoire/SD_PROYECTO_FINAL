package com.sdg4.ms_statistics.repositories;

import java.util.List;
import java.util.Map;

public interface VoteRepositoryCustom {
    List<Map<String, Object>> countVotesByElectionAndCandidate();
}
