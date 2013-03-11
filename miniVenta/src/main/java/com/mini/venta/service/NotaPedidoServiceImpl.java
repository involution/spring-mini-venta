package com.mini.venta.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mini.venta.dao.NotaPedidoRepository;
import com.mini.venta.entities.NotaPedido;
import com.mini.venta.service.intefaces.NotaPedidoService;

@Service
@Transactional(readOnly = true)
public class NotaPedidoServiceImpl implements NotaPedidoService {

	private static final Logger logger = LoggerFactory
			.getLogger(NotaPedidoServiceImpl.class);

	@Autowired
	private NotaPedidoRepository repository;

	@Override
	public NotaPedido save(NotaPedido notaPedido) {
		logger.debug("NotaPedidoServiceImpl.save");
		return repository.save(notaPedido);
	}

	@Override
	public NotaPedido findOne(Long id) {
		logger.debug("NotaPedidoServiceImpl.findOne");
		return repository.findOne(id);
	}

}
