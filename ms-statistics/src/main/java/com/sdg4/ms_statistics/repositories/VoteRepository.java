package com.sdg4.ms_statistics.repositories;

import com.sdg4.ms_statistics.entities.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends MongoRepository<Vote, String>, VoteRepositoryCustom {
}
