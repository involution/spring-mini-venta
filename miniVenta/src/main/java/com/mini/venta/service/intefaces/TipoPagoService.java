package com.mini.venta.service.intefaces;

import java.util.List;

import com.mini.venta.entities.TipoPago;

public interface TipoPagoService {

	TipoPago save(TipoPago tipoPago);
	
	List<TipoPago> findAll();
}
