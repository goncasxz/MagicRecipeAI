package dev.java10x.MagicFridgeAI.controller;

import dev.java10x.MagicFridgeAI.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAI.model.FoodItemCategory;
import dev.java10x.MagicFridgeAI.repository.FoodItemRepository;
import dev.java10x.MagicFridgeAI.service.FoodItemService;
import dev.java10x.MagicFridgeAI.service.GeminiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/receitas/ui")
public class MagicFridgeUI {

    private final FoodItemService foodItemService;
    private final GeminiService geminiService;
    private final FoodItemRepository foodItemRepository;

    public MagicFridgeUI(FoodItemService foodItemService, GeminiService geminiService, FoodItemRepository foodItemRepository) {
        this.foodItemService = foodItemService;
        this.geminiService = geminiService;
        this.foodItemRepository = foodItemRepository;
    }

    @PostMapping("/adicionar")
    public String adicionarIngrediente(@ModelAttribute FoodItemDTO foodItemDTO, RedirectAttributes redirectAttributes) {
        foodItemService.salvar(foodItemDTO);
        redirectAttributes.addFlashAttribute("mensagem", "Ingrediente cadastrado com sucesso");
        return "redirect:/receitas/ui/listar";
    }

    @GetMapping("/listar")
    public String listarIngredientes(Model model) {
        List<FoodItemDTO> ingredientes =foodItemService.listar();
        model.addAttribute("ingredientes", ingredientes);
        model.addAttribute("categorias", Arrays.asList(FoodItemCategory.values()));
        return "index";
    }


    @GetMapping("/deletar/{id}")
    public String deletarIngrediente(@PathVariable Long id) {
        foodItemService.deletarId(id);
        return "redirect:/receitas/ui/listar";
    }
 }
