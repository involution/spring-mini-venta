package com.mini.venta.service.intefaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mini.venta.entities.Empleado;

public interface EmpleadoService {

    Empleado login(String usuario, String password);
	
    Empleado save(Empleado empleado);
    
    Page<Empleado> findByName(String name, Pageable pageable);

	Page<Empleado> findByDni(String dni, Pageable pageable);
	
	Page<Empleado> findByDireccion(String direccion, Pageable pageable);
}
