package com.kostiago.templatebase;

import com.kostiago.templatebase.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kostiago.templatebase.entities.Order;

@SpringBootApplication
public class TemplatebaseApplication implements CommandLineRunner {

	@Autowired
	private OrderService service;

	public static void main(String[] args) {
		SpringApplication.run(TemplatebaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Order order = new Order(1309, 95.90, 0.0);
		double total = service.total(order);
		System.out.printf("Pedido código %d%nValor total: R$ %.2f%n%n", order.getCode(), total);
	}

}
