package dev.java10x.MagicFridgeAI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.java10x.MagicFridgeAI.model.FoodItemCategory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
public class FoodItemDTO {

    private Long id;
    private String nome;
    @JsonProperty("categoria")
    private FoodItemCategory categoryEnum;
    private Integer quantidade;
    private LocalDate validade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public FoodItemCategory getCategoryEnum() {
        return categoryEnum;
    }

    public void setCategoryEnum(FoodItemCategory categoryEnum) {
        this.categoryEnum = categoryEnum;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
}
