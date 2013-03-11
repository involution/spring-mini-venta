package com.mini.venta.service.intefaces;

import java.util.List;

import com.mini.venta.entities.Marca;

public interface MarcaService {
	
	List<Marca> findAll();
	
	Marca findOne(Long id);
}
