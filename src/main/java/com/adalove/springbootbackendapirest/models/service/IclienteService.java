package com.adalove.springbootbackendapirest.models.service;

import com.adalove.springbootbackendapirest.models.entity.Cliente;

import java.util.List;

public interface IclienteService {
    public List<Cliente> findAll();
    public Cliente findById(Long id);
    public Cliente save(Cliente cliente);
    public void delete(Long id);

}
