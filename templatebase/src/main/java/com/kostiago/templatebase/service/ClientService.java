package com.kostiago.templatebase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kostiago.templatebase.entity.Client;
import com.kostiago.templatebase.record.ClientRecord;
import com.kostiago.templatebase.repository.ClientRepository;
import com.kostiago.templatebase.service.exceptions.ResourceNotFoundException;
import com.kostiago.templatebase.utilities.ClientMapper;

import jakarta.persistence.EntityNotFoundException;

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

    @Transactional(readOnly = true)
    public ClientRecord findById(Long id) {
        Client entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Cliente com o ID %d não foi encontrado.", id)));
        return new ClientRecord(entity);
    }

    @Transactional(readOnly = true)
    public Page<ClientRecord> findAll(Pageable pageable) {
        Page<Client> entity = repository.findAll(pageable);
        return entity.map(dto -> new ClientRecord(dto));
    }

    @Transactional
    public ClientRecord update(Long id, ClientRecord dto) {
        try {
            Client entity = repository.getReferenceById(id);
            ClientMapper.updateToEntityFromDto(entity, dto);
            return ClientMapper.toDto(entity);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(String.format("O cliente com ID %d não foi encontrado.", id));
        }
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(String.format("O cliente com ID %d não foi encontrado.", id));
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new ResourceNotFoundException("Falha de integridade referencia!");
        }
    }

}
