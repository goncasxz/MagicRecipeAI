package dev.java10x.MagicFridgeAI.controller;

import dev.java10x.MagicFridgeAI.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAI.model.FoodItem;
import dev.java10x.MagicFridgeAI.service.FoodItemService;
import dev.java10x.MagicFridgeAI.service.GeminiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class RecipeController {

    private FoodItemService foodItemService;
    private GeminiService geminiService;

    public RecipeController(FoodItemService foodItemService, GeminiService geminiService) {
        this.foodItemService = foodItemService;
        this.geminiService = geminiService;
    }

    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> generateRecipe() {
        List<FoodItemDTO> foodItemList = foodItemService.listar();
        return geminiService.generateRecipe(foodItemList)
                .map(recipe -> ResponseEntity.ok(recipe))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }
}
