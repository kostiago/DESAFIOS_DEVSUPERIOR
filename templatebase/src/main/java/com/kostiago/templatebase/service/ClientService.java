package com.kostiago.templatebase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kostiago.templatebase.entity.Client;
import com.kostiago.templatebase.record.ClientMapper;
import com.kostiago.templatebase.record.ClientRecord;
import com.kostiago.templatebase.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional
    public ClientRecord create(ClientRecord dto) {
        Client entity = ClientMapper.toEntity(dto);
        entity = repository.save(entity);

        return ClientMapper.toDto(entity);
    }

}
