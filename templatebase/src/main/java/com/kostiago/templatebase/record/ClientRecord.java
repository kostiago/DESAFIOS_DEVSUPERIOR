package com.kostiago.templatebase.record;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.kostiago.templatebase.entity.Client;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record ClientRecord(Long id,
        @NotBlank(message = "Campo requerido") @Size(min = 3, max = 80, message = "Campo precisa ter acima de 3 caratecteres") String name,
        @NotBlank(message = "O CPF é obrigatório") @Size(min = 11, max = 14, message = "O CPF deve ter entre 11 e 14 caracteres (com ou sem pontuação)") String cpf,
        @NotNull(message = "A renda é obrigatória") @Positive(message = "Campo não pode ser negativo") Double income,
        @NotNull(message = "A data de nascimento é obrigatória") @PastOrPresent(message = "A data de nascimento deve estar no passado") LocalDate birthDate,
        @NotNull(message = "Número de dependentes é obrigatório") @PositiveOrZero(message = "Número de dependentes não pode ser negativo") @Max(value = 20, message = "Número máximo de dependentes é 20") Integer children) {

    public ClientRecord(Client entity) {
        this(entity.getId(), entity.getName(), entity.getCpf(), entity.getIncome(), entity.getBirthDate(),
                entity.getChildren());
    }
}
