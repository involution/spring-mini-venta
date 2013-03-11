package com.mini.venta.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mini.venta.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

	@Query("select p from Producto p where p.nombre like ?1 or p.descripcion like ?1")
	Page<Producto> findByName(String name, Pageable pageable);
	
	@Query("select p from Producto p where p.codigo like ?1")
	Page<Producto> findByCodigo(String codigo, Pageable pageable);
	
	@Query("select p from Producto p where p.marca like ?1")
	Page<Producto> findByMarca(String marca, Pageable pageable);
	
	@Query("select p from Producto p where p.modelo like ?1")
	Page<Producto> findByModelo(String modelo, Pageable pageable);
}
