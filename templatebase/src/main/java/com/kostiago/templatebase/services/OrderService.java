package com.kostiago.templatebase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kostiago.templatebase.entities.Order;

@Service
public class OrderService {

    @Autowired
    private ShippingService service;

    public double total(Order order) {
        double discountPrice = order.getPrice() * (order.getDiscount() / 100.0);
        double priceWithDiscount = order.getPrice() - discountPrice;
        double freight = service.shipment(order.getPrice());
        return priceWithDiscount + freight;
    }
}
