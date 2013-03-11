package com.mini.venta.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mini.venta.entities.NotaPedidoProducto;
import com.mini.venta.entities.NotaPedidoProductoId;

public interface NotaPedidoProductoRepository extends JpaRepository<NotaPedidoProducto, NotaPedidoProductoId> {

}
