# 📦 Desafio 03 – CRUD de Clientes

## 🎯 Objetivo
Neste desafio, o objetivo é construir uma API REST completa em Java com Spring Boot para realizar operações CRUD (Create, Read, Update, Delete) sobre um recurso de clientes, incluindo tratamento de exceções, validações e busca paginada.

## 🛠 Tecnologias Utilizadas

- Java 17+

- Spring Boot

- Spring Web

- Spring Data JPA / Hibernate

- Bean Validation (JSR 380)

- Banco de dados H2 (ambiente de testes)

- Maven (gerenciador de dependência)

- Ferramentas de teste: Postman

## ✅ Requisitos e Funcionalidades

### 📄 Entidade Client
O que foi implementado:

- [x] A Entidade **`Client`**, representa um usuario e contém:
  - id do cliente (Long)
  - nome do cliente (String)
  - cpf de cliente (String/unique)
  - Renda do cliente (Double)
  - Data de aniversario cliente (Instant ou LocalDate)
  - Quantidade de filhos cliente (Integer)

## ✅ Funcionalidades Implementadas

O sistema implementa um CRUD completo com as seguintes operações REST:

- [x] Busca paginada de clientes: GET /clients?page=0&size=6&sort=name
   - **Retorna clientes de forma paginada e ordenada.**
- [x] Busca por ID: GET /clients/{id}:
   - **Retorna um cliente por ID.**
   - **Retorna **`404`** se o ID não for encontrado.**
- [x] Inserção de cliente: POST /clients :
   - **Insere um novo cliente.**
   - **Retorna **`422`** se houver campos inválidos.**
- [x] Atualização de cliente: PUT /clients/{id} :
   - **Atualiza os dados de um cliente existente.**
   - **Retorna 404 se o ID não for encontrado.**
   - **Retorna 422 se houver dados inválidos.**
- [x] Deleção de cliente: DELETE /clients/{id}:
   - **Remove um cliente do banco de dados.**
   - **Retorna 404 se o ID não for encontrado.**

## 📦 Regras de Negócio e Validações
- [x] **name:** Não pode ser vazio.
- [x] **birthDate:** Não pode ser uma data futura (@PastOrPresent).
- [x] **CPF:** Deve seguir o padrão informado.

## 🧪 Seed de Dados
O sistema realiza o seeding automático com pelo menos 10 clientes contendo dados significativos e realistas ao iniciar a aplicação.

## ⚠️ Tratamento de Exceções
ResourceNotFoundException → Retorna 404 Not Found com mensagem clara.

ValidationException → Retorna 422 Unprocessable Entity com mensagens personalizadas para cada campo inválido.

## 🧪 Testes
O projeto foi testado manualmente utilizando o Postman. O professor poderá realizar as seguintes verificações:
| Teste                    | Resultado Esperado           |
| ------------------------ | ---------------------------- |
| GET /clients/1           | Cliente existente retornado  |
| GET /clients/999         | 404 para cliente inexistente |
| GET paginado             | Lista clientes corretamente  |
| POST com dados válidos   | Insere cliente               |
| POST com dados inválidos | 422 com mensagens de erro    |
| PUT com dados válidos    | Atualiza cliente             |
| PUT com id inválido      | 404                          |
| PUT com dados inválidos  | 422                          |
| DELETE /clients/1        | Deleta cliente               |
| DELETE /clients/999      | 404                          |



