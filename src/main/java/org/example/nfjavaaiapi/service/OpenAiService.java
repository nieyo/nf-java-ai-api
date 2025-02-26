package org.example.nfjavaonlde270125chatgptapi.service;

import org.example.nfjavaonlde270125chatgptapi.model.OpenAIRequest;
import org.example.nfjavaonlde270125chatgptapi.model.OpenAiMessage;
import org.example.nfjavaonlde270125chatgptapi.model.OpenAiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class OpenAiService {

    private final RestClient restClient;

    public OpenAiService(@Value("${OPENAI_API_KEY}") String key, RestClient.Builder restClient) {
        this.restClient = restClient
                .baseUrl("https://api.openai.com/v1/chat/completions")
                .defaultHeader("Authorization", "Bearer "+key)
                .build();
    }

    public String generateAiAnswer(String input) {
       OpenAiResponse response = restClient.post()
                .body(new OpenAIRequest(
                        "gpt-4o-mini",
                        List.of(new OpenAiMessage("user", input)),
                        0.7))
                .retrieve()
                .body(OpenAiResponse.class);

       return response.choices().get(0).message().content();
    }
}
