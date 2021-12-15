package com.example.walletmicroservice.aplication.model;

import com.example.walletmicroservice.domain.Wallet;

public interface WalletKafka {
    public void create(Wallet wallet);
}
