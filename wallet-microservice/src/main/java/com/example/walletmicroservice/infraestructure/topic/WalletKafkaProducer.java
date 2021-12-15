package com.example.walletmicroservice.infraestructure.topic;

import com.example.walletmicroservice.aplication.model.WalletKafka;
import com.example.walletmicroservice.domain.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class WalletKafkaProducer implements WalletKafka {

    @Autowired
    private KafkaTemplate<String, Wallet> kafkaTemplate;
    private final String TOPIC_WALLET = "topic-wallet";

    @Override
    public void create(Wallet wallet) {
        this.kafkaTemplate.send(TOPIC_WALLET, wallet);

        ListenableFuture<SendResult<String, Wallet>> future = this.kafkaTemplate.send(TOPIC_WALLET, wallet);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Wallet>>() {

            @Override
            public void onSuccess(SendResult<String, Wallet> result) {
                System.out.println("Wallet=[" + wallet
                        + "] con offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Imposible enviar Wallet message=["
                        + wallet + "] due to : " + ex.getMessage());
            }
        });
    }
}
