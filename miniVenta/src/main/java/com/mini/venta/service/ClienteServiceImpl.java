package com.mini.venta.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mini.venta.dao.ClienteRepository;
import com.mini.venta.entities.Cliente;
import com.mini.venta.service.intefaces.ClienteService;

@Service
@Transactional(readOnly = true)
public class ClienteServiceImpl implements ClienteService {

	private static final Logger logger = LoggerFactory.getLogger(ClienteServiceImpl.class);

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public Cliente save(Cliente cliente) {
		logger.debug("ClienteServiceImpl.save");
		return repository.save(cliente);
	}

	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		logger.debug("ClienteServiceImpl.findAll");
		return repository.findAll(pageable);
	}

	@Override
	public Page<Cliente> findByName(String name, Pageable pageable) {
		logger.debug("ClienteServiceImpl.findByName");
		name = "%" + name + "%";
		return repository.findByName(name, pageable);
	}

	@Override
	public Page<Cliente> findByRuc(String ruc, Pageable pageable) {
		logger.debug("ClienteServiceImpl.findByRuc");
		ruc = "%" + ruc + "%";
		return repository.findByRuc(ruc, pageable);
	}

	@Override
	public Page<Cliente> findByDireccionNegocio(String direccion, Pageable pageable) {
		logger.debug("ClienteServiceImpl.findByDireccionNegocio");
		direccion = "%" + direccion + "%";
		return repository.findByDireccionNegocio(direccion, pageable);
	}

}
