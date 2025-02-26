package org.example.nfjavaaiapi.controller;

import lombok.RequiredArgsConstructor;
import org.example.nfjavaaiapi.service.OpenAiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    private final OpenAiService service;

    @PostMapping
    String categorizeIngredient(@RequestBody String ingredient) {
        return service.aiPredictDietType(ingredient);
    }

}