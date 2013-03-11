package com.mini.venta.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mini.venta.entities.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {

}
