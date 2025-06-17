package com.kostiago.templatebase.record;

import com.kostiago.templatebase.entity.Client;

public class ClientMapper {

    public static Client toEntity(ClientRecord dto) {
        Client entity = new Client();
        entity.setName(dto.name());
        entity.setCpf(dto.cpf());
        entity.setIncome(dto.income());
        entity.setBirthDate(dto.birthDate());
        entity.setChildren(dto.children());

        return entity;
    }

    public static ClientRecord toDto(Client entity) {
        return new ClientRecord(entity);
    }
}
