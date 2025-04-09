# 🧩 Desafio 01 – Componentes e Injeção de Dependência

## 🎯 Objetivo

Neste desafio, a ideia é criar um sistema simples de pedidos, praticando conceitos fundamentais do Spring Boot, como:

- **Componentes (`@Service`)**
- **Injeção de dependência**
- **Separação de responsabilidades**

A ideia é calcular o **valor total de um pedido**, considerando **desconto** e **frete**, e exibir o resultado no terminal da aplicação.

---

## 🛠 O que foi utilizado

- [x] Java 17+
- [x] Spring Boot
- [x] Componentes com `@Service`
- [x] Injeção de dependência com `@Autowired` ou via construtor
- [ ] Spring Web *(não necessário neste desafio)*
- [ ] Banco de dados *(não utilizado aqui)*

---

## ✅ Requisitos

O que foi implementado:

- [ ] A classe `Order`, que representa um pedido e contém:
  - Código do pedido (int)
  - Valor básico (double)
  - Porcentagem de desconto (double)
- [ ] A classe `OrderService`, responsável por:
  - Calcular o valor total com base no valor básico, desconto e frete
- [ ] A classe `ShippingService`, responsável por:
  - Calcular o valor do frete com base no valor básico do pedido

---

## 📦 Regras de negócio

### Cálculo do frete (feito em `ShippingService`):

| Valor Básico                | Frete      |
|----------------------------|------------|
| Abaixo de R$ 100.00        | R$ 20.00   |
| De R$ 100.00 até R$ 199.99 | R$ 12.00   |
| R$ 200.00 ou mais          | Grátis     |
