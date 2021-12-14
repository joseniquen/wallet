package com.bootcamp.wallet.spring.config;

import com.bootcamp.wallet.application.model.WalletRepository;
import com.bootcamp.wallet.infraestructure.repository.WalletCrudRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
    @Bean
    public WalletRepository walletRepository(){return  new WalletCrudRepository();}
}
