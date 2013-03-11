package com.mini.venta.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mini.venta.dao.NotaPedidoProductoRepository;
import com.mini.venta.entities.NotaPedidoProducto;
import com.mini.venta.service.intefaces.NotaPedidoProductoService;

@Service
@Transactional(readOnly = true)
public class NotaPedidoProductoServiceImpl implements NotaPedidoProductoService {

	private static final Logger logger = LoggerFactory.getLogger(NotaPedidoProductoServiceImpl.class);

	@Autowired
	private NotaPedidoProductoRepository repository;
	
	@Override
	public NotaPedidoProducto save(NotaPedidoProducto notaPedidoProducto) {
		logger.debug("NotaPedidoProductoServiceImpl.save(NotaPedidoProducto)");
		return repository.save(notaPedidoProducto);
	}

	@Override
	public List<NotaPedidoProducto> save(Iterable<NotaPedidoProducto> iterable) {
		logger.debug("NotaPedidoProductoServiceImpl.save(Iterable<NotaPedidoProducto>)");
		return repository.save(iterable);
	}

}
