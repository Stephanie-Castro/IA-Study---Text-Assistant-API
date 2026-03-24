package com.example.demo_ia;

import org.springframework.stereotype.Service;

@Service
public class AiService {

    private final AiClient aiClient;

    public AiService(AiClient aiClient) {
        this.aiClient = aiClient;
    }

    public String summarize(String text) {
        String prompt = "Summarize the following text:\n" + text;
        return aiClient.callAI(prompt);
    }
}
