package com.mini.venta.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

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
import java.util.List;

@Component
public class FrmBuscarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTextBuscar;
	private JTable tblCliente;
	private JComboBox cboBuscarPor;

	private final int ELEMENTOS_POR_PAGINA = 20;
	
	@Autowired
	private PanelNuevaNotaPedido panelNuevaNotaPedido;
	
	@Autowired
	private ClienteService clienteService;
	
	private List<Cliente> lstClientes;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrmBuscarCliente frame = new FrmBuscarCliente();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FrmBuscarCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 705, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("Buscar por: ");
		
		cboBuscarPor = new JComboBox();
		cboBuscarPor.setModel(new DefaultComboBoxModel(new String[] {"Nombre o Razon social", "Ruc", "Direccion"}));
		
		txtTextBuscar = new JTextField();
		txtTextBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				buscarCliente();
			}
		});
		
		JButton btnElegirYContinuar = new JButton("Elegir y continuar");
		btnElegirYContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				panelNuevaNotaPedido.llenarDatosCliente(lstClientes.get(tblCliente.getSelectedRow()));
				panelNuevaNotaPedido.validate();
				panelNuevaNotaPedido.repaint();
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(cboBuscarPor, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(txtTextBuscar, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnElegirYContinuar))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(label))
						.addComponent(cboBuscarPor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(txtTextBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnBuscar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnElegirYContinuar)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		
		tblCliente = new JTable();
		scrollPane.setViewportView(tblCliente);
		contentPane.setLayout(gl_contentPane);
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
	
	private void buscarCliente(){
		llenarTablaClientes();
	}
}
