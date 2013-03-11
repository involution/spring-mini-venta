package com.mini.venta.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mini.venta.dao.ProvinciaRepository;
import com.mini.venta.entities.Provincia;
import com.mini.venta.service.intefaces.ProvinciaService;

@Service
@Transactional(readOnly = true)
public class ProvinciaServiceImpl implements ProvinciaService {

	private static final Logger logger = LoggerFactory
			.getLogger(ProvinciaServiceImpl.class);
	
	@Autowired
	private ProvinciaRepository repository;
	
	@Override
	public List<Provincia> getProvinciaByCodDpto(String codDpto) {
		logger.debug("ProvinciaServiceImpl.getProvinciaByCodDpto(codDpto): " + codDpto);
		return repository.getProvinciaByCodDpto(codDpto);
	}

}
