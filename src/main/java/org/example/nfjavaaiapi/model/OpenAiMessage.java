package org.example.nfjavaonlde270125chatgptapi.model;

/**
 * {
 *      "role": "user",
 *      "content": "Was ist eine Primzahl?"
 * }
 */

public record OpenAiMessage(String role, String content) {
}
