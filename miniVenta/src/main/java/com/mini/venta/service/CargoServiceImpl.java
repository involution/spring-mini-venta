package com.mini.venta.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mini.venta.dao.CargoRepository;
import com.mini.venta.entities.Area;
import com.mini.venta.entities.Cargo;
import com.mini.venta.service.intefaces.CargoService;

@Service
@Transactional(readOnly = true)
public class CargoServiceImpl implements CargoService {

	private static final Logger logger = LoggerFactory.getLogger(CargoServiceImpl.class);

	@Autowired
	private CargoRepository repository;
	
	@Override
	public List<Cargo> findByArea(Area area) {
		logger.debug("CargoServiceImpl.findByArea: ");
		return repository.findByArea(area);
	}

}
