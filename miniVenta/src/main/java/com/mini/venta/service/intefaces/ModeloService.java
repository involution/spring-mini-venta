package com.mini.venta.service.intefaces;

import java.util.List;

import com.mini.venta.entities.Marca;
import com.mini.venta.entities.Modelo;

public interface ModeloService {

	List<Modelo> findByMarca(Marca marca);
	
}
