package com.mini.venta.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mini.venta.entities.Provincia;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {

	@Query("select p from Provincia p where p.coddpto= ?1")
	List<Provincia> getProvinciaByCodDpto(String codDpto);
}
