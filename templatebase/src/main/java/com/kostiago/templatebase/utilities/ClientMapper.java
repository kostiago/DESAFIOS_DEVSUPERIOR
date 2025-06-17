package com.kostiago.templatebase.utilities;

import com.kostiago.templatebase.entity.Client;
import com.kostiago.templatebase.record.ClientRecord;

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

    public static void updateToEntityFromDto(Client entity, ClientRecord dto) {

        entity.setName(dto.name());
        entity.setCpf(dto.cpf());
        entity.setIncome(dto.income());
        entity.setBirthDate(dto.birthDate());
        entity.setChildren(dto.children());

    }

    public static ClientRecord toDto(Client entity) {
        return new ClientRecord(entity);
    }
}
