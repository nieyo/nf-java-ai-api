package org.example.nfjavaonlde270125chatgptapi.controller;

import org.example.nfjavaonlde270125chatgptapi.service.OpenAiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/open")
public class OpenAiController {

    private final OpenAiService service;

    public OpenAiController(OpenAiService service) {
        this.service = service;
    }

    @PostMapping
    public String generateAiAnswer(@RequestBody String input) {
        return service.generateAiAnswer(input);
    }

}
