package com.mini.venta.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the NOTA_PEDIDO_PRODUCTOS database table.
 * 
 */
@Entity
@Table(name = "NOTA_PEDIDO_PRODUCTO")
@AssociationOverrides({
		@AssociationOverride(name = "notaPedidoProductoId.notaPedido", joinColumns = @JoinColumn(name = "ID_NPEDIDO")),
		@AssociationOverride(name = "notaPedidoProductoId.producto", joinColumns = @JoinColumn(name = "ID_PRODUCTO")) })
public class NotaPedidoProducto implements Serializable {

	private static final long serialVersionUID = 1L;

	private NotaPedidoProductoId notaPedidoProductoId = new NotaPedidoProductoId();

	private Long cantidad;
	private String descripcion;
	private BigDecimal descuento;
	private BigDecimal precio;

	public NotaPedidoProducto() {
	}

	@EmbeddedId
	public NotaPedidoProductoId getNotaPedidoProductoId() {
		return notaPedidoProductoId;
	}

	public void setNotaPedidoProductoId(
			NotaPedidoProductoId notaPedidoProductoId) {
		this.notaPedidoProductoId = notaPedidoProductoId;
	}

	@Transient
	public NotaPedido getNotaPedido() {
		return getNotaPedidoProductoId().getNotaPedido();
	}

	public void setNotaPedido(NotaPedido notaPedido) {
		getNotaPedidoProductoId().setNotaPedido(notaPedido);
	}

	@Transient
	public Producto getProducto() {
		return getNotaPedidoProductoId().getProducto();
	}

	public void setProducto(Producto producto) {
		getNotaPedidoProductoId().setProducto(producto);
	}

	@Column(name = "CANTIDAD")
	public Long getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name = "DESCRIPCION")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descrpcion) {
		this.descripcion = descrpcion;
	}

	@Column(name = "DESCUENTO")
	public BigDecimal getDescuento() {
		return this.descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	@Column(name = "PRECIO")
	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		NotaPedidoProducto that = (NotaPedidoProducto) o;

		if (getNotaPedidoProductoId() != null ? !getNotaPedidoProductoId()
				.equals(that.getNotaPedidoProductoId()) : that
				.getNotaPedidoProductoId() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getNotaPedidoProductoId() != null ? getNotaPedidoProductoId()
				.hashCode() : 0);
	}
}