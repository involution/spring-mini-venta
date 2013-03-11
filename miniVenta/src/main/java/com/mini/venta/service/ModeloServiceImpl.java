package com.mini.venta.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mini.venta.dao.ModeloRepository;
import com.mini.venta.entities.Marca;
import com.mini.venta.entities.Modelo;
import com.mini.venta.service.intefaces.ModeloService;

@Service
@Transactional(readOnly = true)
public class ModeloServiceImpl implements ModeloService {

	private static final Logger logger = LoggerFactory
			.getLogger(ModeloServiceImpl.class);

	@Autowired
	private ModeloRepository repository;
	
	@Override
	public List<Modelo> findByMarca(Marca marca) {
		logger.debug("ModeloServiceImpl.findByMarca");
		return repository.findByMarca(marca);
	}

}
