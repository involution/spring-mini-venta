package com.mini.venta.vista.support;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.mini.venta.entities.Cliente;

public class ClienteTableModel implements TableModel {
	
	private List<Cliente> lstCliente;
	private List<TableModelListener> listeners = new ArrayList<TableModelListener>();

	public ClienteTableModel(List<Cliente> lstCliente) {
		this.lstCliente = lstCliente;
	}
	
	@Override
	public int getRowCount() {
		return lstCliente.size();
	}

	@Override
	public int getColumnCount() {
		return 10;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// Devuelve el nombre de cada columna.
		switch (columnIndex) {
		case 0:
			return "Nombre";
		case 1:
			return "Apellido";
		case 2:
			return "Fecha";
		case 3:
			return "Email";
		case 4:
			return "Telefono";
		case 5:
			return "Celular";
		case 6:
			return "Direccion";
		case 7:
			return "Ruc";
		case 8:
			return "Razon social";
		case 9:
			return "Estado";
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
			return Date.class;
		case 3:
			return String.class;
		case 4:
			return String.class;
		case 5:
			return String.class;
		case 6:
			return String.class;
		case 7:
			return String.class;
		case 8:
			return String.class;
		case 9:
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
		Cliente cliente;

		cliente = lstCliente.get(rowIndex);

		// Se obtiene el campo apropiado según el valor de columnIndex
		switch (columnIndex) {
		case 0:
			return cliente.getNombre();
		case 1:
			return cliente.getApellido();
		case 2:
			return cliente.getFecha();
		case 3:
			return cliente.getEMail();
		case 4:
			return cliente.getTelefono();
		case 5:
			return cliente.getCelular();
		case 6:
			return cliente.getDireccionNegocio();
		case 7:
			return cliente.getRuc();
		case 8:
			return cliente.getRazonSocial();
		case 9:
			if (cliente.getEstado().equals("1")) {
				return "Activo";
			} else {
				return "No Activo";
			}
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
