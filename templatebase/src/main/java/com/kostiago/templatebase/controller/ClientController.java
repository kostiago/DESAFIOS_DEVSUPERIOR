package com.kostiago.templatebase.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kostiago.templatebase.record.ClientRecord;
import com.kostiago.templatebase.service.ClientService;

@RestController
@RequestMapping(value = "api/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping
    public ResponseEntity<ClientRecord> create(@RequestBody ClientRecord dto) {
        dto = service.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
