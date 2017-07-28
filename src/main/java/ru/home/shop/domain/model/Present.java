package ru.home.shop.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Present extends Entity {

    private String name;
    private BigDecimal price;
    private List<Candy> candies = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Candy> getItems() {
        return candies;
    }

    public void setItems(List<Candy> candies) {
        this.candies = candies;
    }
}