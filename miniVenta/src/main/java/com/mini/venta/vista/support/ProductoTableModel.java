package com.mini.venta.vista.support;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.mini.venta.entities.Producto;

public class ProductoTableModel implements TableModel {

	private List<Producto> lstProducto;
	private List<TableModelListener> listeners = new ArrayList<TableModelListener>();

	public ProductoTableModel(List<Producto> lstProducto) {
		this.lstProducto = lstProducto;
	}

	@Override
	public int getRowCount() {
		return lstProducto.size();
	}

	@Override
	public int getColumnCount() {
		return 9;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// Devuelve el nombre de cada columna.
		switch (columnIndex) {
		case 0:
			return "Codigo";
		case 1:
			return "Nombre";
		case 2:
			return "Precio x Unidad";
		case 3:
			return "Precio x Mayor";
		case 4:
			return "Stock";
		case 5:
			return "Color";
		case 6:
			return "Descripcion";
		case 7:
			return "Marca";
		case 8:
			return "Modelo";
		default:
			return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// Devuelve la clase que hay en cada columna.
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return BigDecimal.class;
		case 3:
			return BigDecimal.class;
		case 4:
			return Integer.class;
		case 5:
			return String.class;
		case 6:
			return String.class;
		case 7:
			return String.class;
		case 8:
			return String.class;
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
		Producto producto;

		producto = lstProducto.get(rowIndex);

		// Se obtiene el campo apropiado según el valor de columnIndex
		switch (columnIndex) {
		case 0:
			return producto.getCodigo();
		case 1:
			return producto.getNombre();
		case 2:
			return producto.getPrecioUnidad();
		case 3:
			return producto.getPrecioMayor();
		case 4:
			return producto.getStock();
		case 5:
			return producto.getColor();
		case 6:
			return producto.getDescripcion();
		case 7:
			return producto.getMarca().getNombre();
		case 8:
			return producto.getModelo().getNombre();
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
