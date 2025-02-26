package org.example.nfjavaaiapi.model;


import java.util.List;

/**
 * {
 *      "model": "gpt-4o-mini",
 *      "messages": [{"role": "user", "content": "Was ist eine Primzahl?"}],
 *      "temperature": 0.7
 *    }
 */
public record OpenAIRequest(
        String model,
        List<OpenAiMessage> messages,
        double temperature) {

    public OpenAIRequest(String model, String input, double temperature) {
        this(model, List.of(new OpenAiMessage("user", input)), temperature);
    }
}
