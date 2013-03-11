package com.mini.venta.service.intefaces;

import java.util.List;

import com.mini.venta.entities.NotaPedidoProducto;

public interface NotaPedidoProductoService {

	NotaPedidoProducto save(NotaPedidoProducto notaPedidoProducto);
	
	List<NotaPedidoProducto> save(Iterable<NotaPedidoProducto> iterable);
}
