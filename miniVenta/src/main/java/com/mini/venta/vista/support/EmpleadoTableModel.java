package com.mini.venta.vista.support;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.mini.venta.entities.Empleado;

public class EmpleadoTableModel implements TableModel {

	private List<Empleado> lstEmpleado;
	private List<TableModelListener> listeners = new ArrayList<TableModelListener>();

	public EmpleadoTableModel(List<Empleado> lstEmpleado) {
		this.lstEmpleado = lstEmpleado;
	}

	@Override
	public int getRowCount() {
		return lstEmpleado.size();
	}

	@Override
	public int getColumnCount() {
		return 11;
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
			return "Dni";
		case 3:
			return "Email";
		case 4:
			return "Telefono";
		case 5:
			return "Celular";
		case 6:
			return "Direccion";
		case 7:
			return "Usuario";
		case 8:
			return "Estado";
		case 9:
			return "Area";
		case 10:
			return "Cargo";
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
			return String.class;
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
		case 10:
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
		Empleado empleado;

		empleado = lstEmpleado.get(rowIndex);

		// Se obtiene el campo apropiado según el valor de columnIndex
		switch (columnIndex) {
		case 0:
			return empleado.getNombre();
		case 1:
			return empleado.getApellido();
		case 2:
			return empleado.getDni();
		case 3:
			return empleado.getEMail();
		case 4:
			return empleado.getTelefono();
		case 5:
			return empleado.getCelular();
		case 6:
			return empleado.getDireccion();
		case 7:
			return empleado.getUsuario();
		case 8:
			if (empleado.getEstado().equals("1")) {
				return "Activo";
			} else {
				return "No Activo";
			}
		case 9:
			return empleado.getArea().getNombre();
		case 10:
			return empleado.getCargo().getNombre();
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
