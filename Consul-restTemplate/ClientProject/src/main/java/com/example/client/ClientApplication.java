package com.example.client;

import com.example.client.entities.Client;
import com.example.client.repositories.ClientRepository;
import org.apache.http.util.Args;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {

        SpringApplication.run(ClientApplication.class, args);

    }

    @Bean
    CommandLineRunner initialiserBaseH2(ClientRepository clientRepository){
        return  args -> {
            clientRepository.save(new Client(null,"Rabab Slimani",23f));
            clientRepository.save(new Client(null,"Adama Bloman",26f));
            clientRepository.save(new Client(null,"Aicha Laazar",73f));



        };

    }
}
