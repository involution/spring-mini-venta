package com.mini.venta.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mini.venta.entities.Credito;

public interface CreditoRepository extends JpaRepository<Credito, Long> {

}
