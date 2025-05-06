package dev.java10x.MagicFridgeAI.service;

import dev.java10x.MagicFridgeAI.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAI.mapper.FoodItemMapper;
import dev.java10x.MagicFridgeAI.model.FoodItem;
import dev.java10x.MagicFridgeAI.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodItemService {
    private final FoodItemRepository foodItemRepository;
    private final FoodItemMapper foodItemMapper;

    @Autowired
    public FoodItemService(FoodItemRepository foodItemRepository, FoodItemMapper foodItemMapper) {
        this.foodItemRepository = foodItemRepository;
        this.foodItemMapper = foodItemMapper;
    }

    public FoodItemDTO salvar(FoodItemDTO foodItemDTO){
        FoodItem food = foodItemMapper.map(foodItemDTO);
        food = foodItemRepository.save(food);
        return foodItemMapper.map(food);
    }

    public List<FoodItemDTO> listar() {
        List<FoodItem> foods = foodItemRepository.findAll();
        return foods.stream()
                .map(foodItemMapper::map)
                .collect(Collectors.toList());
    }

    public Optional<FoodItemDTO> listarId(Long id) {
        Optional<FoodItem> foodOptional = foodItemRepository.findById(id);
        return foodOptional.map(foodItemMapper::map);
    }

    public FoodItemDTO alterar(Long id, FoodItemDTO foodItemDTO) {
        Optional<FoodItem> food = foodItemRepository.findById(id);
        if (food.isPresent()) {
            FoodItem foodUpdated = food.get();
            if (foodItemDTO.getNome() != null) {
                foodUpdated.setNome(foodItemDTO.getNome());
            }

            if (foodItemDTO.getCategoryEnum() != null) {
                foodUpdated.setCategoryEnum(foodItemDTO.getCategoryEnum());
            }

            if (foodItemDTO.getQuantidade() != null) {
                foodUpdated.setQuantidade(foodItemDTO.getQuantidade());
            }

            if (foodItemDTO.getValidade() != null) {
                foodUpdated.setValidade(foodItemDTO.getValidade());
            }

            foodUpdated = foodItemRepository.save(foodUpdated);
            return foodItemMapper.map(foodUpdated);
        }
        return null;
    }

    public void deletarId(Long id) {
        foodItemRepository.deleteById(id);
    }
}
