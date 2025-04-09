package com.kostiago.templatebase.entities;

public class Order {
    private Integer code;
    private Double price;
    private Double discount;

    private Order() {
    }

    public Order(Integer code, Double price, Double discount) {
        this.code = code;
        this.price = price;
        this.discount = discount;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

}
