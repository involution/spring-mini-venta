package com.mini.venta.vista.support;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.mini.venta.entities.NotaPedidoProducto;

public class BoletaTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<NotaPedidoProducto> lstNotaPedidoProducto;
	private boolean isEditable;

	public BoletaTableModel() {
		super();
		lstNotaPedidoProducto = new ArrayList<NotaPedidoProducto>();
		isEditable = false;
	}

	public List<NotaPedidoProducto> getLstNotaPedidoProducto() {
		return lstNotaPedidoProducto;
	}

	public void setLstNotaPedidoProducto(
			List<NotaPedidoProducto> lstNotaPedidoProducto) {
		this.lstNotaPedidoProducto = lstNotaPedidoProducto;
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return lstNotaPedidoProducto.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// Devuelve el nombre de cada columna.
		switch (columnIndex) {
		case 0:
			return "Cantidad";
		case 1:
			return "Descripcion";
		case 2:
			return "Precio Unitario";
		case 3:
			return "Importe";
		default:
			return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// Devuelve la clase que hay en cada columna.
		switch (columnIndex) {
		case 0:
			return Integer.class;
		case 1:
			return String.class;
		case 2:
			return BigDecimal.class;
		case 3:
			return BigDecimal.class;
		default:
			// Devuelve una clase Object por defecto.
			return Object.class;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (isEditable) {
			switch (columnIndex) {
			case 0:
				return false;
			case 1:
				return true;
			case 2:
				return false;
			case 3:
				return true;
			default:
				return false;
			}

		} else {
			return false;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		if (lstNotaPedidoProducto.size() > 0) {
			NotaPedidoProducto notaPedidoProducto;
			notaPedidoProducto = lstNotaPedidoProducto.get(rowIndex);

			// Se obtiene el campo apropiado según el valor de columnIndex
			switch (columnIndex) {
			case 0:
				return notaPedidoProducto.getCantidad();
			case 1:
				return notaPedidoProducto.getDescripcion();
			case 2:
				return notaPedidoProducto.getPrecio();
			case 3:
				return calcularTotal(rowIndex);
			default:
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		NotaPedidoProducto npp = lstNotaPedidoProducto.get(rowIndex);

		switch (columnIndex) {

		case 0:
			npp.setCantidad((Long) aValue);
			lstNotaPedidoProducto.set(rowIndex, npp);
			fireTableRowsUpdated(rowIndex, columnIndex);
			break;

		case 1:
			npp.setDescripcion((String) aValue);
			lstNotaPedidoProducto.set(rowIndex, npp);
			fireTableRowsUpdated(rowIndex, columnIndex);
			break;

		default:
			break;
		}

	}

	public BigDecimal calcularSuma() {
		BigDecimal suma = calcularTotal(0);
		// System.out.println("suma i -> 0: " + suma);

		for (int i = 1; i < lstNotaPedidoProducto.size(); i++) {
			suma = suma.add(calcularTotal(i));
			// System.out.println("suma i -> " + i + ": " + suma);
		}

		return suma;
	}

	private BigDecimal calcularTotal(int row) {
		NotaPedidoProducto notaPedidoProducto = lstNotaPedidoProducto.get(row);

		BigDecimal precio = notaPedidoProducto.getPrecio();
		BigDecimal cantidad = BigDecimal.valueOf(notaPedidoProducto
				.getCantidad());

		return precio.multiply(cantidad);
	}

}
