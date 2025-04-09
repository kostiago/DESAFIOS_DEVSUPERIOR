package com.kostiago.templatebase.services;

import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(double amount) {
        if (amount >= 200.0)
            return 0.0;
        if (amount >= 100.0)
            return 12.0;
        return 20.0;

    }
}
