package com.mini.venta.service.intefaces;

import java.util.List;

import com.mini.venta.entities.Area;
import com.mini.venta.entities.Cargo;

public interface CargoService {
	
	List<Cargo> findByArea(Area area);
	
}
