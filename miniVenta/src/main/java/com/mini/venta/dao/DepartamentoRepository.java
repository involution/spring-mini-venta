package com.mini.venta.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mini.venta.entities.Departamento;

public interface DepartamentoRepository extends
		JpaRepository<Departamento, Long> {

}
