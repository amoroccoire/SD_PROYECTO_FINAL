package com.sdg4.votes.services;

//clase para enviar a kafka

import com.sdg4.votes.proto.VoteProto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@Service
public class MessageService {

    @Autowired
    private KafkaTemplate<String, VoteProto.Vote> kafkaTemplate;

    private final String TOPIC = "votes-topic";
    /*public void sendMessage(VoteProto.Vote vote) {
        kafkaTemplate.send(TOPIC, vote);
    }*/
    public Mono<Void> sendMessage(VoteProto.Vote vote) {
        CompletableFuture<SendResult<String, VoteProto.Vote>> future = kafkaTemplate.send(TOPIC, vote).toCompletableFuture();
        return Mono.fromFuture(future)
                .then();
    }

}
