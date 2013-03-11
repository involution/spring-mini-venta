package com.mini.venta.vista;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;

import org.springframework.stereotype.Component;

@Component
public class PanelBienvenida extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel lblBienvenido;
	private JLabel lblNombreDeEmpleado;
	private JLabel lblCargo;

	/**
	 * Create the panel.
	 */
	public PanelBienvenida() {
		setLayout(new FormLayout(
				new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		lblBienvenido = new JLabel("BIENVENIDO");
		add(lblBienvenido, "4, 4");

		lblNombreDeEmpleado = new JLabel("Nombre de empleado");
		add(lblNombreDeEmpleado, "4, 8");

		lblCargo = new JLabel("Cargo");
		add(lblCargo, "4, 10");

	}

	public String getLblNombreDeEmpleado() {
		return lblNombreDeEmpleado.getText();
	}

	public void setLblNombreDeEmpleado(String nombreDeEmpleado) {
		this.lblNombreDeEmpleado.setText(nombreDeEmpleado);
	}

	public String getLblCargo() {
		return lblCargo.getText();
	}

	public void setLblCargo(String cargo) {
		this.lblCargo.setText(cargo);
	}

}
