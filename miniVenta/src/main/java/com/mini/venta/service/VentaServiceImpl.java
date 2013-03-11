package com.mini.venta.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mini.venta.dao.VentaRepository;
import com.mini.venta.entities.Venta;
import com.mini.venta.service.intefaces.VentaService;

@Service
@Transactional(readOnly = true)
public class VentaServiceImpl implements VentaService {

	private static final Logger logger = LoggerFactory.getLogger(VentaServiceImpl.class);

	@Autowired
	private VentaRepository repository;
	
	@Override
	public Venta save(Venta venta) {
		logger.debug("VentaServiceImpl.save");
		return repository.save(venta);
	}

}
