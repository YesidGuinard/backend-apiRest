package com.adalove.springbootbackendapirest.models.dao;


import com.adalove.springbootbackendapirest.models.entity.Factura;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaDao extends CrudRepository<Factura, Long> {

}
