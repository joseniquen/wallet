package com.example.walletmicroservice.aplication;

import com.example.walletmicroservice.domain.Wallet;

public interface WalletKafkaOperations {
    public void create(Wallet wallet);
}
