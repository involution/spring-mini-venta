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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Cargo generated by hbm2java
 */
@Entity
@Table(name = "CARGO")
public class Cargo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idCargo;
	private Area area;
	private String nombre;
	private Set<Empleado> empleados = new HashSet<Empleado>(0);

	public Cargo() {
	}

	public Cargo(Area area) {
		this.area = area;
	}

	public Cargo(Area area, String nombre, Set<Empleado> empleados) {
		this.area = area;
		this.nombre = nombre;
		this.empleados = empleados;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_CARGO", unique = true, nullable = false)
	public Long getIdCargo() {
		return this.idCargo;
	}

	public void setIdCargo(Long idCargo) {
		this.idCargo = idCargo;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_AREA", nullable = false)
	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@Column(name = "NOMBRE", length = 30)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cargo")
	public Set<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}

	@Override
	public String toString() {
		return getNombre();
	}
}
