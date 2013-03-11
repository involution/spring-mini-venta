package com.mini.venta.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mini.venta.entities.Moneda;

public interface MonedaRepository extends JpaRepository<Moneda, Long> {

}
