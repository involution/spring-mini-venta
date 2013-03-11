package com.mini.venta.service.intefaces;

import java.util.List;

import com.mini.venta.entities.Area;

public interface AreaService {

    Area save(Area area);
	
    List<Area> findAll();
}
