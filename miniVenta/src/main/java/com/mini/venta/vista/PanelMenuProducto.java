package com.mini.venta.vista;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
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

import com.mini.venta.entities.Producto;
import com.mini.venta.service.intefaces.ProductoService;
import com.mini.venta.vista.support.ProductoTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

@Component
public class PanelMenuProducto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtTextBuscar;
	private JTable tblProducto;
	private JComboBox cboBuscarPor;

	private final int ELEMENTOS_POR_PAGINA = 20;

	@Autowired
	private FrmNuevoProducto frmNuevoProducto;

	@Autowired
	private ProductoService productoService;

	List<Producto> lstProducto;

	/**
	 * Create the panel.
	 */
	public PanelMenuProducto() {

		JLabel lblMenuProducto = new JLabel("MENU PRODUCTO");
		lblMenuProducto.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnNuevoProducto = new JButton("NUEVO PRODUCTO");
		btnNuevoProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				frmNuevoProducto.inicializar();
				frmNuevoProducto.setLocationRelativeTo(null);
				frmNuevoProducto.setVisible(true);
			}
		});

		JSeparator separator = new JSeparator();

		JLabel lblBuscarPor = new JLabel("Buscar por: ");

		cboBuscarPor = new JComboBox();
		cboBuscarPor.setModel(new DefaultComboBoxModel(new String[] {
				"Nombre o Descripcion", "Codigo", "Marca", "Modelo" }));

		txtTextBuscar = new JTextField();
		txtTextBuscar.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				buscarProducto();
			}
		});

		JScrollPane scrollPane = new JScrollPane();

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				mostrarDatosProducto(tblProducto.getSelectedRow());
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
																Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE,
																703,
																Short.MAX_VALUE)
														.addComponent(
																lblMenuProducto,
																GroupLayout.DEFAULT_SIZE,
																703,
																Short.MAX_VALUE)
														.addComponent(
																btnNuevoProducto)
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
																				ComponentPlacement.RELATED)
																		.addComponent(
																				txtTextBuscar,
																				GroupLayout.PREFERRED_SIZE,
																				300,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnBuscar))
														.addComponent(
																scrollPane,
																GroupLayout.DEFAULT_SIZE,
																703,
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
										.addComponent(lblMenuProducto)
										.addGap(18)
										.addComponent(btnNuevoProducto)
										.addGap(14)
										.addComponent(separator,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
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
												259, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(btnModificar)
										.addContainerGap(60, Short.MAX_VALUE)));

		tblProducto = new JTable();
		scrollPane.setViewportView(tblProducto);
		setLayout(groupLayout);

	}

	public void llenarTablaProducto() {
		// La paginacion comienza en cero(0)
		Pageable pageable = new PageRequest(0, ELEMENTOS_POR_PAGINA, Direction.ASC, "nombre");

		if (cboBuscarPor.getSelectedItem().toString().equalsIgnoreCase("codigo")) {
			lstProducto = productoService.findByCodigo(txtTextBuscar.getText(), pageable).getContent();
		} else if (cboBuscarPor.getSelectedItem().toString().equalsIgnoreCase("marca")) {
			lstProducto = productoService.findByMarca(txtTextBuscar.getText(), pageable).getContent();
		} else if (cboBuscarPor.getSelectedItem().toString().equalsIgnoreCase("modelo")) {
			lstProducto = productoService.findByModelo(txtTextBuscar.getText(), pageable).getContent();
		} else {
			lstProducto = productoService.findByName(txtTextBuscar.getText(), pageable).getContent();
		}

		ProductoTableModel productoTableModel = new ProductoTableModel(lstProducto);
		tblProducto.setModel(productoTableModel);

		validate();
		repaint();
	}

	private void mostrarDatosProducto(int index) {
		frmNuevoProducto.mostrarDatosProducto(lstProducto.get(index));
		frmNuevoProducto.setLocationRelativeTo(null);
		frmNuevoProducto.setVisible(true);
	}

	private void buscarProducto() {
		llenarTablaProducto();
	}
}
