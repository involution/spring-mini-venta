package com.mini.venta.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mini.venta.entities.TipoCliente;

public interface TipoClienteRepository extends JpaRepository<TipoCliente, Long> {

}
