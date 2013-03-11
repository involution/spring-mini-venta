package com.mini.venta.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mini.venta.entities.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

	@Query("select e from Empleado e where e.usuario = ?1 and e.password = ?2")
	Empleado login(String usuario, String password);

	@Query("select e from Empleado e where e.nombre like ?1 or e.apellido like ?1")
	Page<Empleado> findByName(String name, Pageable pageable);

	@Query("select e from Empleado e where e.dni like ?1")
	Page<Empleado> findByDni(String dni, Pageable pageable);
	
	@Query("select e from Empleado e where e.direccion like ?1")
	Page<Empleado> findByDireccion(String direccion, Pageable pageable);
}
