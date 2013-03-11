package com.mini.venta.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mini.venta.dao.TipoPagoRepository;
import com.mini.venta.entities.TipoPago;
import com.mini.venta.service.intefaces.TipoPagoService;

@Service
@Transactional(readOnly = true)
public class TipoPagoServiceImpl implements TipoPagoService {

	private static final Logger logger = LoggerFactory.getLogger(TipoPagoServiceImpl.class);

	@Autowired
	private TipoPagoRepository repository;
	
	@Override
	public TipoPago save(TipoPago tipoPago) {
		logger.debug("TipoPagoServiceImpl.save");
		return repository.save(tipoPago);
	}

	@Override
	public List<TipoPago> findAll() {
		logger.debug("TipoPagoServiceImpl.findAll");
		return repository.findAll();
	}

}
