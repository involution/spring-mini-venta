package com.mini.venta.entities;

// Generated Jan 15, 2013 11:21:45 AM by Hibernate Tools 3.6.0

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DetallePago generated by hbm2java
 */
@Entity
@Table(name = "DETALLE_PAGO")
public class DetallePago implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idDetallePago;
	private Credito credito;
	private Date fechaPago;
	private BigDecimal montoPago;
	private Character estado;

	public DetallePago() {
	}

	public DetallePago(Credito credito) {
		this.credito = credito;
	}

	public DetallePago(Credito credito,
			Date fechaPago, BigDecimal montoPago, Character estado) {
		this.credito = credito;
		this.fechaPago = fechaPago;
		this.montoPago = montoPago;
		this.estado = estado;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_DETALLE_PAGO", unique = true, nullable = false)
	public Long getIdDetallePago() {
		return this.idDetallePago;
	}

	public void setIdDetallePago(Long idDetallePago) {
		this.idDetallePago = idDetallePago;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CREDITO", nullable = false)
	public Credito getCredito() {
		return this.credito;
	}

	public void setCredito(Credito credito) {
		this.credito = credito;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_PAGO", length = 19)
	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	@Column(name = "MONTO_PAGO", precision = 10)
	public BigDecimal getMontoPago() {
		return this.montoPago;
	}

	public void setMontoPago(BigDecimal montoPago) {
		this.montoPago = montoPago;
	}

	@Column(name = "ESTADO", length = 1)
	public Character getEstado() {
		return this.estado;
	}

	public void setEstado(Character estado) {
		this.estado = estado;
	}

}
