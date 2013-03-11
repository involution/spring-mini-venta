package com.mini.venta.service.intefaces;

import com.mini.venta.entities.NotaPedido;

public interface NotaPedidoService {

	NotaPedido save(NotaPedido notaPedido);
	
	NotaPedido findOne(Long id);
}
