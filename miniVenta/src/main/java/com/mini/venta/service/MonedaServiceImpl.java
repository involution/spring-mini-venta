package com.mini.venta.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mini.venta.dao.MonedaRepository;
import com.mini.venta.entities.Moneda;
import com.mini.venta.service.intefaces.MonedaService;

@Service
@Transactional(readOnly = true)
public class MonedaServiceImpl implements MonedaService {

	private static final Logger logger = LoggerFactory
			.getLogger(MonedaServiceImpl.class);

	@Autowired
	private MonedaRepository repository;
	
	@Override
	public Moneda save(Moneda moneda) {
		logger.debug("MonedaServiceImpl.save");
		return repository.save(moneda);
	}

	@Override
	public List<Moneda> findAll() {
		logger.debug("ClienteServiceImpl.findAll");
		return repository.findAll();
	}

}
