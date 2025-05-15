package dev.java10x.MagicFridgeAI.controller;

import dev.java10x.MagicFridgeAI.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAI.repository.FoodItemRepository;
import dev.java10x.MagicFridgeAI.service.FoodItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/receitas/ui")
public class MagicFridgeUI {

    private final FoodItemService foodItemService;
    private final FoodItemRepository foodItemRepository;

    public MagicFridgeUI(FoodItemService foodItemService, FoodItemRepository foodItemRepository) {
        this.foodItemService = foodItemService;
        this.foodItemRepository = foodItemRepository;
    }


    @PostMapping("/adicionar")
    public String adicionarIngrediente(@ModelAttribute FoodItemDTO foodItemDTO, RedirectAttributes redirectAttributes) {
        foodItemService.salvar(foodItemDTO);
        redirectAttributes.addFlashAttribute("mensagem", "Ingrediente cadastrado com sucesso");
        return "redirect:/receitar/ui/listar";
    }

    @GetMapping("/listar")
    public String listarIngredientes(Model model) {
        List<FoodItemDTO> foods =foodItemService.listar();
        model.addAttribute("foods", foods);
        return "index.html";
    }
}
