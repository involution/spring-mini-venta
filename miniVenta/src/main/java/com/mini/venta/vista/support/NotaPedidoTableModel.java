package com.mini.venta.vista.support;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.mini.venta.entities.NotaPedido;

public class NotaPedidoTableModel implements TableModel {

	private List<NotaPedido> lstNotaPedido;
	private List<TableModelListener> listeners = new ArrayList<TableModelListener>();

	public NotaPedidoTableModel(List<NotaPedido> lstNotaPedido) {
		this.lstNotaPedido = lstNotaPedido;
	}

	@Override
	public int getRowCount() {
		return lstNotaPedido.size();
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
			return "Id";
		case 1:
			return "Id cliente";
		case 2:
			return "Total";
		case 3:
			return "Fecha";
		default:
			return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// Devuelve la clase que hay en cada columna.
		switch (columnIndex) {
		case 0:
			return Long.class;
		case 1:
			return Long.class;
		case 2:
			return BigDecimal.class;
		case 3:
			return Date.class;
		default:
			// Devuelve una clase Object por defecto.
			return Object.class;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		NotaPedido notaPedido;

		notaPedido = lstNotaPedido.get(rowIndex);

		// Se obtiene el campo apropiado según el valor de columnIndex
		switch (columnIndex) {
		case 0:
			return notaPedido.getIdNpedido();
		case 1:
			return notaPedido.getCliente().getIdCliente();
		case 2:
			return notaPedido.getTotal();
		case 3:
			return notaPedido.getFecha();
		default:
			return null;
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		//Por defecto no se va editar los campos
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		listeners.add(l);
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		listeners.remove(l);
	}

}
