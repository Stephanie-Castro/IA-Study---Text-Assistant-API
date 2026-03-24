package com.example.demo_ia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ReactorClientHttpRequestFactory;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.client.RestClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Configuration
public class WebClientConfig {


    @Bean
    public RestClient restClient() {
        var httpClient = HttpClient.create()
                .responseTimeout(Duration.ofSeconds(60)); // aumenta aqui

        var connector = new ReactorClientHttpConnector(httpClient);
        return RestClient.builder()
                .requestFactory(new ReactorClientHttpRequestFactory(httpClient))
                .baseUrl("https://api.openai.com")
                    .defaultHeader("Authorization", "Bearer " + System.getenv("OPENAI_API_KEY"))
                .defaultHeader("Content-Type", "application/json")
                .build();
    }
}
