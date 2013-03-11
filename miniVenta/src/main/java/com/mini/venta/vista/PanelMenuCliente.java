package com.mini.venta.vista;

import java.util.List;

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

import com.mini.venta.entities.Cliente;
import com.mini.venta.service.intefaces.ClienteService;
import com.mini.venta.vista.support.ClienteTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class PanelMenuCliente extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtTextBuscar;
	private JTable tblCliente;
	private JComboBox cboBuscarPor;

	private final int ELEMENTOS_POR_PAGINA = 20;

	@Autowired
	private FrmNuevoCliente frmNuevoCliente;
	
	@Autowired
	private ClienteService clienteService;
	
	private List<Cliente> lstClientes;
	
	/**
	 * Create the panel.
	 */
	public PanelMenuCliente() {
		
		JLabel lblMenuCliente = new JLabel("MENU CLIENTE");
		lblMenuCliente.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNuevoCliente = new JButton("NUEVO CLIENTE");
		btnNuevoCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				frmNuevoCliente.inicializar();
				frmNuevoCliente.setLocationRelativeTo(null);
				frmNuevoCliente.setVisible(true);
			}
		});
		
		JSeparator separator = new JSeparator();
		
		JLabel lblBuscarPor = new JLabel("Buscar por: ");
		
		cboBuscarPor = new JComboBox();
		cboBuscarPor.setModel(new DefaultComboBoxModel(new String[] {"Nombre o Razon Social", "Ruc", "Direccion"}));
		
		txtTextBuscar = new JTextField();
		txtTextBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				buscarCliente();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				mostrarDatosCliente(tblCliente.getSelectedRow());
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
						.addComponent(lblMenuCliente, GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
						.addComponent(btnNuevoCliente)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblBuscarPor)
							.addGap(4)
							.addComponent(cboBuscarPor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTextBuscar, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBuscar))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
						.addComponent(btnModificar))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMenuCliente)
					.addGap(18)
					.addComponent(btnNuevoCliente)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cboBuscarPor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBuscarPor)
						.addComponent(txtTextBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(47)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnModificar)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		
		tblCliente = new JTable();
		scrollPane.setViewportView(tblCliente);
		setLayout(groupLayout);
	}
	
	public void llenarTablaClientes(){
		//La paginacion comienza en cero(0)
		Pageable pageable = new PageRequest(0, ELEMENTOS_POR_PAGINA, Direction.ASC, "nombre");
		
		if (cboBuscarPor.getSelectedItem().toString().equalsIgnoreCase("ruc")) {
			lstClientes = clienteService.findByRuc(txtTextBuscar.getText(), pageable).getContent();
		} else if (cboBuscarPor.getSelectedItem().toString().equalsIgnoreCase("direccion")){
			lstClientes = clienteService.findByDireccionNegocio(txtTextBuscar.getText(), pageable).getContent();
		} else {
			lstClientes = clienteService.findByName(txtTextBuscar.getText(), pageable).getContent();
		}

		ClienteTableModel clienteTableModel = new ClienteTableModel(lstClientes);
		tblCliente.setModel(clienteTableModel);
		
		validate();
		repaint();
	}
	
	private void mostrarDatosCliente(int index){
		frmNuevoCliente.mostrarDatosCliente(lstClientes.get(index));
		frmNuevoCliente.setLocationRelativeTo(null);
		frmNuevoCliente.setVisible(true);
	}
	
	private void buscarCliente(){
		llenarTablaClientes();
	}
	
}
