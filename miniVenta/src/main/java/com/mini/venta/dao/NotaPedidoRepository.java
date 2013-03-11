package com.mini.venta.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mini.venta.entities.NotaPedido;

public interface NotaPedidoRepository extends JpaRepository<NotaPedido, Long> {

}
