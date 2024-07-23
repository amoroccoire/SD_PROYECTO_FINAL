package com.sdg4.votes.repositories;

import com.sdg4.votes.models.entities.Vote;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository  extends ReactiveMongoRepository<Vote, Long> {

}
