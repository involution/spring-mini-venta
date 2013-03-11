package com.mini.venta.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class NotaPedidoProductoId implements Serializable {

	private static final long serialVersionUID = 1L;

	private NotaPedido notaPedido;
	private Producto producto;

	public NotaPedidoProductoId() {
	}

	@ManyToOne
	public NotaPedido getNotaPedido() {
		return notaPedido;
	}

	public void setNotaPedido(NotaPedido notaPedido) {
		this.notaPedido = notaPedido;
	}

	@ManyToOne
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		NotaPedidoProductoId that = (NotaPedidoProductoId) o;

		if (notaPedido != null ? !notaPedido.equals(that.notaPedido) : that.notaPedido != null)
			return false;
		if (producto != null ? !producto.equals(that.producto): that.producto != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (notaPedido != null ? notaPedido.hashCode() : 0);
		result = 31 * result + (producto != null ? producto.hashCode() : 0);
		return result;
	}
}