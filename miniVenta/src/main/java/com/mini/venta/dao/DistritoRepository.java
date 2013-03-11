package com.mini.venta.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mini.venta.entities.Distrito;

public interface DistritoRepository extends JpaRepository<Distrito, Long> {

	@Query("select d from Distrito d where d.coddpto= ?1 and d.codprov= ?2")
	List<Distrito> getDistritoByCodDptoAndCodProv(String codDpto, String codProv);
}
