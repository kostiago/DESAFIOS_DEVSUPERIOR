package com.kostiago.templatebase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kostiago.templatebase.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
