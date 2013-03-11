package com.mini.venta.service.intefaces;

import java.util.List;

import com.mini.venta.entities.Distrito;

public interface DistritoService {

	List<Distrito> getDistritoByCodDptoAndCodProv(String codDpto, String codProv); 
}
