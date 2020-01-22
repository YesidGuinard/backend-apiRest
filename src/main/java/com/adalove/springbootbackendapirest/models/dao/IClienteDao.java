package com.adalove.springbootbackendapirest.models.dao;

import com.adalove.springbootbackendapirest.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IClienteDao extends JpaRepository<Cliente, Long> {
}
