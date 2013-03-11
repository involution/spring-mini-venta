package com.mini.venta.service.intefaces;

import java.util.List;

import com.mini.venta.entities.Moneda;

public interface MonedaService {

	Moneda save(Moneda moneda);
	
	List<Moneda> findAll();
	
}
