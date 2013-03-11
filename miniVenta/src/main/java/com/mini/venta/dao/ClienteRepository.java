package com.mini.venta.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mini.venta.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("select c from Cliente c where c.nombre like ?1 or c.apellido like ?1 or c.razonSocial like ?1")
	Page<Cliente> findByName(String name, Pageable pageable);

	@Query("select c from Cliente c where c.ruc like ?1")
	Page<Cliente> findByRuc(String ruc, Pageable pageable);
	
	@Query("select c from Cliente c where c.direccionNegocio like ?1")
	Page<Cliente> findByDireccionNegocio(String direccion, Pageable pageable);
}