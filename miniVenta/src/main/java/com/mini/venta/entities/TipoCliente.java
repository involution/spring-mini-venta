package com.mini.venta.entities;

// Generated Jan 15, 2013 11:21:45 AM by Hibernate Tools 3.6.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TipoCliente generated by hbm2java
 */
@Entity
@Table(name = "TIPO_CLIENTE")
public class TipoCliente implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idTipoCliente;
	private String descripcion;
	private Set<Cliente> clientes = new HashSet<Cliente>(0);

	public TipoCliente() {
	}

	public TipoCliente(String descripcion, Set<Cliente> clientes) {
		this.descripcion = descripcion;
		this.clientes = clientes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_TIPO_CLIENTE", unique = true, nullable = false)
	public Long getIdTipoCliente() {
		return this.idTipoCliente;
	}

	public void setIdTipoCliente(Long idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
	}

	@Column(name = "DESCRIPCION", length = 100)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoCliente")
	public Set<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return getDescripcion();
	}
}
