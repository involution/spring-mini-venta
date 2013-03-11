package com.mini.venta.service.intefaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mini.venta.entities.Cliente;

public interface ClienteService {

	Cliente save(Cliente cliente);
	
	Page<Cliente> findAll(Pageable pageable);
	
	Page<Cliente> findByName(String name, Pageable pageable);
	
	Page<Cliente> findByRuc(String ruc, Pageable pageable);
	
	Page<Cliente> findByDireccionNegocio(String direccion, Pageable pageable);
}
