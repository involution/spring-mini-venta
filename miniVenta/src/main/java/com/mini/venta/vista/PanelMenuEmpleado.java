package com.mini.venta.vista;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.mini.venta.entities.Empleado;
import com.mini.venta.service.intefaces.EmpleadoService;
import com.mini.venta.vista.support.EmpleadoTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@Component
public class PanelMenuEmpleado extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtTextBuscar;
	private JTable tblEmpleado;
	private JComboBox cboBuscarPor;

	private final int ELEMENTOS_POR_PAGINA = 20;

	@Autowired
	private FrmNuevoEmpleado frmNuevoEmpleado;

	@Autowired
	private EmpleadoService empleadoService;

	private List<Empleado> lstEmpleados;

	/**
	 * Create the panel.
	 */
	public PanelMenuEmpleado() {

		JLabel lblMenuEmpleado = new JLabel("MENU EMPLEADO");
		lblMenuEmpleado.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnNuevoEmpleado = new JButton("NUEVO EMPLEADO");
		btnNuevoEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNuevoEmpleado.inicializar();
				frmNuevoEmpleado.setLocationRelativeTo(null);
				frmNuevoEmpleado.setVisible(true);
			}
		});

		JSeparator separator = new JSeparator();

		JLabel lblBuscarPor = new JLabel("Buscar por: ");

		cboBuscarPor = new JComboBox();
		cboBuscarPor.setModel(new DefaultComboBoxModel(new String[] { "Nombre",
				"Dni", "Direccion" }));

		txtTextBuscar = new JTextField();
		txtTextBuscar.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarEmpleado();
			}
		});

		JScrollPane scrollPane = new JScrollPane();

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarDatosEmpleado(tblEmpleado.getSelectedRow());
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																separator,
																GroupLayout.DEFAULT_SIZE,
																657,
																Short.MAX_VALUE)
														.addComponent(
																lblMenuEmpleado,
																GroupLayout.DEFAULT_SIZE,
																657,
																Short.MAX_VALUE)
														.addComponent(
																btnNuevoEmpleado)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				lblBuscarPor)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				cboBuscarPor,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				txtTextBuscar,
																				GroupLayout.PREFERRED_SIZE,
																				331,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnBuscar))
														.addComponent(
																scrollPane,
																GroupLayout.DEFAULT_SIZE,
																657,
																Short.MAX_VALUE)
														.addComponent(
																btnModificar))
										.addContainerGap()));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblMenuEmpleado)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(btnNuevoEmpleado)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(separator,
												GroupLayout.PREFERRED_SIZE, 2,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblBuscarPor)
														.addComponent(
																cboBuscarPor,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																txtTextBuscar,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(btnBuscar))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(scrollPane,
												GroupLayout.PREFERRED_SIZE,
												271, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(btnModificar)
										.addContainerGap(50, Short.MAX_VALUE)));

		tblEmpleado = new JTable();
		scrollPane.setViewportView(tblEmpleado);
		setLayout(groupLayout);

	}

	public void llenarTablaEmpleado() {
		// La paginacion comienza en cero(0)
		Pageable pageable = new PageRequest(0, ELEMENTOS_POR_PAGINA, Direction.ASC, "nombre");

		if (cboBuscarPor.getSelectedItem().toString().equalsIgnoreCase("dni")) {
			lstEmpleados = empleadoService.findByDni(txtTextBuscar.getText(), pageable).getContent();
		} else if (cboBuscarPor.getSelectedItem().toString().equalsIgnoreCase("direccion")) {
			lstEmpleados = empleadoService.findByDireccion(txtTextBuscar.getText(), pageable).getContent();
		} else {
			lstEmpleados = empleadoService.findByName(txtTextBuscar.getText(), pageable).getContent();
		}

		EmpleadoTableModel empleadoTableModel = new EmpleadoTableModel(lstEmpleados);
		tblEmpleado.setModel(empleadoTableModel);

		validate();
		repaint();
	}

	private void mostrarDatosEmpleado(int index) {
		frmNuevoEmpleado.mostrarDatosEmpleado(lstEmpleados.get(index));
		frmNuevoEmpleado.setLocationRelativeTo(null);
		frmNuevoEmpleado.setVisible(true);
	}

	private void buscarEmpleado() {
		llenarTablaEmpleado();
	}
}
