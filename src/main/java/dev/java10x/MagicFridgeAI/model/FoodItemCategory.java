package dev.java10x.MagicFridgeAI.model;

public enum FoodItemCategory {
    VEGETAIS("vegetais"),
    FRUTAS("frutas"),
    CEREAIS("cereais"),
    PROTEÍNAS("proteínas"),
    LEITE("leite");

    private final String foodItemCategory;

    FoodItemCategory(String foodItemCategory) {
        this.foodItemCategory = foodItemCategory;
    }

    public String getFoodItemCategory() {
        return foodItemCategory;
    }
}
