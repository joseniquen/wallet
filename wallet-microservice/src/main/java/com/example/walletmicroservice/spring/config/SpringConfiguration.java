package com.example.walletmicroservice.spring.config;

import com.example.walletmicroservice.aplication.model.WalletRepository;
import com.example.walletmicroservice.infraestructure.repository.WalletCrudRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
    @Bean
    public WalletRepository walletRepository() {
        return new WalletCrudRepository();
    }
}
