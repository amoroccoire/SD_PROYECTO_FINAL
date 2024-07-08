package com.sdg4.votes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories(basePackages = "com.sdg4.votes.repositories")
public class MsVotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsVotesApplication.class, args);
	}

}
