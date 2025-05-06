package dev.java10x.MagicFridgeAI.mapper;

import dev.java10x.MagicFridgeAI.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAI.model.FoodItem;
import org.springframework.stereotype.Component;

@Component
public class FoodItemMapper {

    public FoodItem map(FoodItemDTO foodItemDTO) {
        FoodItem foodItem = new FoodItem();
        foodItem.setId(foodItemDTO.getId());
        foodItem.setNome(foodItemDTO.getNome());
        foodItem.setCategoryEnum(foodItemDTO.getCategoryEnum());
        foodItem.setQuantidade(foodItemDTO.getQuantidade());
        foodItem.setValidade(foodItemDTO.getValidade());
        return foodItem;
    }

    public FoodItemDTO map(FoodItem foodItem) {
        FoodItemDTO foodItemDTO = new FoodItemDTO();
        foodItemDTO.setId(foodItem.getId());
        foodItemDTO.setNome(foodItem.getNome());
        foodItemDTO.setCategoryEnum(foodItem.getCategoryEnum());
        foodItemDTO.setQuantidade(foodItem.getQuantidade());
        foodItemDTO.setValidade(foodItem.getValidade());
        return foodItemDTO;
    }
}
