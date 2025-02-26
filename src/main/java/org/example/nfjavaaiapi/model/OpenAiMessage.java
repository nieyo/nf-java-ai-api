package org.example.nfjavaaiapi.model;

/**
 * {
 *      "role": "user",
 *      "content": "Was ist eine Primzahl?"
 * }
 */

public record OpenAiMessage(String role, String content) {
}
