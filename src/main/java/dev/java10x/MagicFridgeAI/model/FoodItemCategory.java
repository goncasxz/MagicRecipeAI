package dev.java10x.MagicFridgeAI.model;

public enum FoodItemCategory {
    VEGETAIS("vegetais"),
    FRUTAS("frutas"),
    CEREAIS("cereais"),
    PROTEINAS("proteínas"),
    LEITE("leite");

    private final String foodItemCategory;

    FoodItemCategory(String foodItemCategory) {
        this.foodItemCategory = foodItemCategory;
    }

    public String getFoodItemCategory() {
        return foodItemCategory;
    }
}
