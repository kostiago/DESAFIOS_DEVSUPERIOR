package com.kostiago.templatebase.record;

import java.time.LocalDate;

import com.kostiago.templatebase.entity.Client;

public record ClientRecord(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {

    public ClientRecord(Client entity) {
        this(entity.getId(), entity.getName(), entity.getCpf(), entity.getIncome(), entity.getBirthDate(),
                entity.getChildren());
    }
}
