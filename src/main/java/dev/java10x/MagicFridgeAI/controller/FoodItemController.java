package dev.java10x.MagicFridgeAI.controller;

import dev.java10x.MagicFridgeAI.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAI.model.FoodItem;
import dev.java10x.MagicFridgeAI.service.FoodItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
public class FoodItemController {
    private FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @PostMapping("/criar")
    public ResponseEntity<FoodItemDTO> criar(@RequestBody FoodItemDTO foodItemDTO) {
        FoodItemDTO salvo = foodItemService.salvar(foodItemDTO);
        System.out.println("Categoria recebida: " + foodItemDTO.getCategoryEnum());
        return ResponseEntity.ok(salvo);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        List<FoodItemDTO> foods = foodItemService.listar();
        return ResponseEntity.ok(foods);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Object> listarId(@PathVariable Long id){
        Optional<FoodItemDTO> foodItemDTOOptional = foodItemService.listarId(id);
        if (foodItemDTOOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(foodItemDTOOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Comida ID " + id + " não encontrada");
        }
    }

    @PatchMapping("/alterar/{id}")
    public ResponseEntity<?> alterarId(@PathVariable Long id, @RequestBody FoodItemDTO foodItemDTO) {
        Optional<FoodItemDTO> foodItemDTO1 = foodItemService.listarId(id);
        if (foodItemDTO1.isPresent()) {
            FoodItemDTO foodItemDTO2 = foodItemService.alterar(id, foodItemDTO);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(foodItemDTO2);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Comida ID " + id + " não encontrada");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarId(@PathVariable Long id) {
        foodItemService.deletarId(id);
    }
}
