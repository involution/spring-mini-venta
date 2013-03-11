package com.mini.venta.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mini.venta.entities.Area;
import com.mini.venta.entities.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

	List<Cargo> findByArea(Area area);
	
}
