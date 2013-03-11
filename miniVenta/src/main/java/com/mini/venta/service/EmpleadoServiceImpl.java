package com.mini.venta.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mini.venta.dao.EmpleadoRepository;
import com.mini.venta.entities.Empleado;
import com.mini.venta.service.intefaces.EmpleadoService;

@Service
@Transactional(readOnly = true)
public class EmpleadoServiceImpl implements EmpleadoService {

	private static final Logger logger = LoggerFactory
			.getLogger(EmpleadoServiceImpl.class);

	@Autowired
	private EmpleadoRepository repository;

	@Override
	public Empleado login(String usuario, String password) {
		logger.debug("EmpleadoServiceImpl.login(usuario,password): " + usuario
				+ " , " + password);
		return repository.login(usuario, password);
	}

	@Override
	public Empleado save(Empleado empleado) {
		logger.debug("EmpleadoServiceImpl.save");
		return repository.save(empleado);
	}

	@Override
	public Page<Empleado> findByName(String name, Pageable pageable) {
		logger.debug("EmpleadoServiceImpl.findByName");
		name = "%" + name + "%";
		return repository.findByName(name, pageable);
	}

	@Override
	public Page<Empleado> findByDni(String dni, Pageable pageable) {
		logger.debug("EmpleadoServiceImpl.findByDni");
		dni = "%" + dni + "%";
		return repository.findByDni(dni, pageable);
	}

	@Override
	public Page<Empleado> findByDireccion(String direccion, Pageable pageable) {
		logger.debug("EmpleadoServiceImpl.findByDireccion");
		direccion = "%" + direccion + "%";
		return repository.findByDireccion(direccion, pageable);
	}

}
