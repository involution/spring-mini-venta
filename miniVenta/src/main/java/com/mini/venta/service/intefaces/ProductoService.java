package com.mini.venta.service.intefaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mini.venta.entities.Producto;

public interface ProductoService {

	Producto save(Producto producto);
	
	Page<Producto> findByName(String name, Pageable pageable);
	
	Page<Producto> findByCodigo(String codigo, Pageable pageable);
	
	Page<Producto> findByMarca(String marca, Pageable pageable);
	
	Page<Producto> findByModelo(String modelo, Pageable pageable);
}
