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
 * Distrito generated by hbm2java
 */
@Entity
@Table(name = "DISTRITO")
public class Distrito implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idDistrito;
	private String coddist;
	private String codprov;
	private String coddpto;
	private String nombre;
	private Set<Cliente> clientes = new HashSet<Cliente>(0);

	public Distrito() {
	}

	public Distrito(String coddist, String codprov, String coddpto) {
		this.coddist = coddist;
		this.codprov = codprov;
		this.coddpto = coddpto;
	}

	public Distrito(String coddist, String codprov, String coddpto,
			String nombre, Set<Cliente> clientes) {
		this.coddist = coddist;
		this.codprov = codprov;
		this.coddpto = coddpto;
		this.nombre = nombre;
		this.clientes = clientes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_DISTRITO", unique = true, nullable = false)
	public Long getIdDistrito() {
		return this.idDistrito;
	}

	public void setIdDistrito(Long idDistrito) {
		this.idDistrito = idDistrito;
	}

	@Column(name = "CODDIST", nullable = false, length = 2)
	public String getCoddist() {
		return this.coddist;
	}

	public void setCoddist(String coddist) {
		this.coddist = coddist;
	}

	@Column(name = "CODPROV", nullable = false, length = 2)
	public String getCodprov() {
		return this.codprov;
	}

	public void setCodprov(String codprov) {
		this.codprov = codprov;
	}

	@Column(name = "CODDPTO", nullable = false, length = 2)
	public String getCoddpto() {
		return this.coddpto;
	}

	public void setCoddpto(String coddpto) {
		this.coddpto = coddpto;
	}

	@Column(name = "NOMBRE", length = 30)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "distrito")
	public Set<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return getNombre();
	}
}
