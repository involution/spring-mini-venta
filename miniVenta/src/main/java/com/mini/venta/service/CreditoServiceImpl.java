package com.mini.venta.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mini.venta.dao.CreditoRepository;
import com.mini.venta.entities.Credito;
import com.mini.venta.service.intefaces.CreditoService;

@Service
@Transactional(readOnly = true)
public class CreditoServiceImpl implements CreditoService {

	private static final Logger logger = LoggerFactory.getLogger(CreditoServiceImpl.class);

	@Autowired
	private CreditoRepository repository;
	
	@Override
	public Credito save(Credito credito) {
		logger.debug("CreditoServiceImpl.save");
		return repository.save(credito);
	}

}
