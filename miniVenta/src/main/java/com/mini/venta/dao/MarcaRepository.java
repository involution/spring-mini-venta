package com.mini.venta.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mini.venta.entities.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
