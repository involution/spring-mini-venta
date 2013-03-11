package com.mini.venta.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mini.venta.dao.ProductoRepository;
import com.mini.venta.entities.Producto;
import com.mini.venta.service.intefaces.ProductoService;

@Service
@Transactional(readOnly = true)
public class ProductoServiceImpl implements ProductoService {

	private static final Logger logger = LoggerFactory.getLogger(ProductoServiceImpl.class);

	@Autowired
	private ProductoRepository repository;
	
	@Override
	public Producto save(Producto producto) {
		logger.debug("ProductoServiceImpl.save");
		return repository.save(producto);
	}
	
	@Override
	public Page<Producto> findByName(String name, Pageable pageable) {
		logger.debug("ProductoServiceImpl.findByName");
		name = "%" + name + "%";
		return repository.findByName(name, pageable);
	}

	@Override
	public Page<Producto> findByCodigo(String codigo, Pageable pageable) {
		logger.debug("ProductoServiceImpl.findByCodigo");
		codigo = "%" + codigo + "%";
		return repository.findByCodigo(codigo, pageable);
	}

	@Override
	public Page<Producto> findByMarca(String marca, Pageable pageable) {
		logger.debug("ProductoServiceImpl.findByMarca");
		marca = "%" + marca + "%";
		return repository.findByMarca(marca, pageable);
	}

	@Override
	public Page<Producto> findByModelo(String modelo, Pageable pageable) {
		logger.debug("ProductoServiceImpl.findByModelo");
		modelo = "%" + modelo + "%";
		return repository.findByModelo(modelo, pageable);
	}

}
