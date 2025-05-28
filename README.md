# 🧩 Desafio 02 – Modelo de Domínio e ORM

## 🎯 Objetivo

Neste desafio, o objetivo é construir o modelo de domínio e implementar o mapeamento objeto-relacional (ORM) utilizando Java e JPA para um sistema de gerenciamento de eventos acadêmicos.

O sistema permite o cadastro de participantes em atividades como palestras, cursos, oficinas práticas, entre outras. Cada atividade pode ser classificada por uma categoria, ter um preço, e ser dividida em diferentes blocos de horários.

---

## 🛠 O que foi utilizado

- [x] Java 17+
- [x] Spring Boot
- [x] JPA / Hibernate
- [x] Anotações: @Entity, @Id, @GeneratedValue, @OneToMany, @ManyToOne, @ManyToMany, @JoinColumn, @JoinTable
- [x] Tipos modernos de data/hora: Instant
- [x] Mapeamento bidirecional com coleções (Set)
- [x] Spring Web
- [x] Seeding para popular o banco de dados
- [x] Banco de dados H2

---

## ✅ Requisitos

O que foi implementado:

- [x] A Entidade **`Participante`**, representa um usuario e contém:
  - id de participante (Long)
  - nome de participante (String)
  - email de participante (String/unique)
  - Participa de várias atividades (relação muitos-para-muitos).
    
- [x] A classe **`Atividade`**, contém:
  - id da atividade (Long)
  - nome da atividade (String)
  - descrição da atividade (String)
  - preço da atividade (Double)
  - Relaciona-se com várias categorias, participantes e blocos de horário.
    
- [x] A classe **`Categoria`**, contém:
  - id da categoria (Long)
  - descricao da categoria (String)
  - Classifica uma ou mais atividades.

- [x] A classe **`Bloco`**, contém:
  - id do bloco (String)
  - inicio do bloco (Instant)
  - fim do bloco (Instant)
  - Representa um período específico em que uma atividade ocorre.

---

## 📦 Regras de negócio

Cada **atividade** pode ser realizada em um ou mais **blocos de horário**, cada um com início e fim.

Um **participante** pode se inscrever em várias atividades, e cada atividade pode ter vários participantes.

Toda **atividade** pertence a uma única **categoria**.

O modelo evita duplicidades utilizando `Set` nas coleções.
