package com.mini.venta.entities;

// Generated Jan 15, 2013 11:21:45 AM by Hibernate Tools 3.6.0

import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Producto generated by hbm2java
 */
@Entity
@Table(name = "PRODUCTO")
public class Producto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idProducto;
	private Marca marca;
	private Modelo modelo;
	private String codigo;
	private Date fecha;
	private String nombre;
	private BigDecimal precioUnidad;
	private BigDecimal precioMayor;
	private Integer stock;
	private String color;
	private String descripcion;
	private Set<NotaPedidoProducto> notaPedidoProductos = new HashSet<NotaPedidoProducto>(0);

	public Producto() {
	}

	public Producto(Marca marca, Modelo modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}

	public Producto(Marca marca, Modelo modelo, String codigo, Date fecha,
			String nombre, BigDecimal precioUnidad, BigDecimal precioMayor,
			Integer stock, String color, String descripcion,
			Set<NotaPedidoProducto> notaPedidoProductos) {
		this.marca = marca;
		this.modelo = modelo;
		this.codigo = codigo;
		this.fecha = fecha;
		this.nombre = nombre;
		this.precioUnidad = precioUnidad;
		this.precioMayor = precioMayor;
		this.stock = stock;
		this.color = color;
		this.descripcion = descripcion;
		this.notaPedidoProductos = notaPedidoProductos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_PRODUCTO", unique = true, nullable = false)
	public Long getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_MARCA", nullable = false)
	public Marca getMarca() {
		return this.marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_MODELO", nullable = false)
	public Modelo getModelo() {
		return this.modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	@Column(name = "CODIGO", length = 10)
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA", length = 19)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "NOMBRE", length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "PRECIO_UNIDAD", precision = 8)
	public BigDecimal getPrecioUnidad() {
		return this.precioUnidad;
	}

	public void setPrecioUnidad(BigDecimal precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	@Column(name = "PRECIO_MAYOR", precision = 8)
	public BigDecimal getPrecioMayor() {
		return this.precioMayor;
	}

	public void setPrecioMayor(BigDecimal precioMayor) {
		this.precioMayor = precioMayor;
	}

	@Column(name = "STOCK")
	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Column(name = "COLOR", length = 30)
	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "DESCRIPCION", length = 100)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "notaPedidoProductoId.producto")
	public Set<NotaPedidoProducto> getNotaPedidoProductos() {
		return this.notaPedidoProductos;
	}

	public void setNotaPedidoProductos(
			Set<NotaPedidoProducto> notaPedidoProductos) {
		this.notaPedidoProductos = notaPedidoProductos;
	}

	@Override
	public String toString() {
		return getNombre();
	}
}
