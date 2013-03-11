package com.mini.venta.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mini.venta.dao.DistritoRepository;
import com.mini.venta.entities.Distrito;
import com.mini.venta.service.intefaces.DistritoService;

@Service
@Transactional(readOnly = true)
public class DistritoServiceImpl implements DistritoService {

	private static final Logger logger = LoggerFactory
			.getLogger(DistritoServiceImpl.class);
	
	@Autowired
	private DistritoRepository repository;
	
	@Override
	public List<Distrito> getDistritoByCodDptoAndCodProv(String codDpto,
			String codProv) {
		logger.debug("DistritoServiceImpl.getDistritoByCodDptoAndCodProv(codDpto, codProv): " + codDpto + ", " + codProv);
		return repository.getDistritoByCodDptoAndCodProv(codDpto, codProv);
	}

}
