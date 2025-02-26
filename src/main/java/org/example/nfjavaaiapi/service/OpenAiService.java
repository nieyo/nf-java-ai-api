package org.example.nfjavaaiapi.service;

import org.example.nfjavaaiapi.model.OpenAIRequest;
import org.example.nfjavaaiapi.model.OpenAiMessage;
import org.example.nfjavaaiapi.model.OpenAiResponse;
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
                .body(new OpenAIRequest("chatgpt-4o-latest", input, 0.7))
                .retrieve()
                .body(OpenAiResponse.class);

       return response.get();
    }

    public String aiPredictDietType(String input) {

        String AiPrompt = String.format("""
            Classify '%s' as 'vegan,' 'vegetarian,' or 'regular.'
            If it is invalid, unrecognizable, or not a known ingredient, return 'invalid: Only ingredients.'
            Return only the classification.
            """, input);

        input = AiPrompt;
        OpenAiResponse response = restClient.post()
                .body(new OpenAIRequest("gpt-4o", input, 0.7))
                .retrieve()
                .body(OpenAiResponse.class);

        return response.get();
    }
}
