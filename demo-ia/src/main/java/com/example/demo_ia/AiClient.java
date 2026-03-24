package com.example.demo_ia;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Component
public class AiClient {

    private final RestClient restClient;

    public AiClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public String callAI(String prompt) {

        Map<String, Object> body = Map.of(
                "model", "gpt-4o-mini",
                "messages", List.of(
                        Map.of("role", "user", "content", prompt)
                )
        );

        Map response = restClient.post()
                .uri("/v1/chat/completions")
                .body(body)
                .retrieve()
                .body(Map.class);

        List<Map<String, Object>> choices =
                (List<Map<String, Object>>) response.get("choices");

        Map<String, Object> message =
                (Map<String, Object>) choices.get(0).get("message");

        return (String) message.get("content");
    }
}