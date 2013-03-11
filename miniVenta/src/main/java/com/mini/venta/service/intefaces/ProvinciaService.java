package com.mini.venta.service.intefaces;

import java.util.List;

import com.mini.venta.entities.Provincia;

public interface ProvinciaService {

	List<Provincia> getProvinciaByCodDpto(String codDpto);
}
