package com.example.walletmicroservice.aplication.impl;

import com.example.walletmicroservice.aplication.WalletKafkaOperations;
import com.example.walletmicroservice.aplication.model.WalletKafka;
import com.example.walletmicroservice.domain.Wallet;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class WalletProducerOperationsImpl implements WalletKafkaOperations {

    Logger logger = LoggerFactory.getLogger(WalletProducerOperationsImpl.class);
    private final WalletKafka walletKafka;

    @Override
    public void create(Wallet wallet) {
        walletKafka.create(wallet);
    }
}
