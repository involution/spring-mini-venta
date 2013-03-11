package com.mini.venta.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mini.venta.entities.Cliente;
import com.mini.venta.entities.Departamento;
import com.mini.venta.entities.Distrito;
import com.mini.venta.entities.Provincia;
import com.mini.venta.entities.TipoCliente;
import com.mini.venta.service.intefaces.ClienteService;
import com.mini.venta.service.intefaces.DepartamentoService;
import com.mini.venta.service.intefaces.DistritoService;
import com.mini.venta.service.intefaces.ProvinciaService;
import com.mini.venta.service.intefaces.TipoClienteService;
import com.mini.venta.vista.support.JTextFieldMaxCharLimit;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class FrmNuevoCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JTextField txtCelular;
	private JTextField txtDireccion;
	private JTextField txtRuc;
	private JTextField txtRazonSocial;
	private JTextField txtFecha;

	private JComboBox cboEstado;
	private JComboBox cboTipoCliente;
	private JComboBox cboDepartamento;
	private JComboBox cboProvincia;
	private JComboBox cboDistrito;

	private JButton btnAgregar;

	private Date fecha;
	
	private TipoClienteService tipoClienteService;
	private DepartamentoService departamentoService;
	private ProvinciaService provinciaService;
	private DistritoService distritoService;

	@Autowired
	private ClienteService clienteService;

	private Cliente clienteToModify;

	@Autowired
	private PanelMenuCliente panelMenuClientes;
	
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { FrmNuevoCliente frame = new
	 * FrmNuevoCliente(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	@Autowired
	public FrmNuevoCliente(TipoClienteService tipoClienteService,
			DepartamentoService departamentoService,
			ProvinciaService provinciaService, DistritoService distritoService) {

		this.tipoClienteService = tipoClienteService;
		this.departamentoService = departamentoService;
		this.provinciaService = provinciaService;
		this.distritoService = distritoService;

		setTitle("Nuevo Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 665, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNombre = new JLabel("Nombre: ");

		txtNombre = new JTextField();
		txtNombre.setColumns(20);

		JLabel lblApellido = new JLabel("Apellido: ");

		txtApellido = new JTextField();
		txtApellido.setColumns(20);

		JLabel lblEmail = new JLabel("Email: ");

		txtEmail = new JTextField();
		txtEmail.setColumns(30);

		JLabel lblTelefono = new JLabel("Telefono: ");

		txtTelefono = new JTextField();
		txtTelefono.setColumns(7);
		txtTelefono.setDocument(new JTextFieldMaxCharLimit(7));

		JLabel lblCelular = new JLabel("Celular: ");

		txtCelular = new JTextField();
		txtCelular.setColumns(9);
		txtCelular.setDocument(new JTextFieldMaxCharLimit(9));

		JLabel lblDireccion = new JLabel("Direccion: ");

		txtDireccion = new JTextField();
		txtDireccion.setColumns(40);

		JLabel lblRuc = new JLabel("RUC: ");

		txtRuc = new JTextField();
		txtRuc.setColumns(11);
		txtRuc.setDocument(new JTextFieldMaxCharLimit(11));

		JLabel lblRazonSocial = new JLabel("Razon social: ");

		txtRazonSocial = new JTextField();
		txtRazonSocial.setColumns(20);

		JLabel lblEstado = new JLabel("Estado: ");

		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] { "Activo",
				"No activo" }));

		JLabel lblTipoCliente = new JLabel("Tipo Cliente: ");

		cboTipoCliente = new JComboBox();

		JLabel lblDepartamento = new JLabel("Departamento: ");

		cboDepartamento = new JComboBox();
		cboDepartamento.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				llenarCboProvincias(((Departamento) cboDepartamento.getSelectedItem()).getCoddpto());
				llenarCboDistritos(((Provincia) cboProvincia.getSelectedItem())
						.getCoddpto(), ((Provincia) cboProvincia
						.getSelectedItem()).getCodprov());
			}
		});

		JLabel lblProvincia = new JLabel("Provincia: ");

		cboProvincia = new JComboBox();
		cboProvincia.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				llenarCboDistritos(((Provincia) cboProvincia.getSelectedItem())
						.getCoddpto(), ((Provincia) cboProvincia
						.getSelectedItem()).getCodprov());
			}
		});
		cboProvincia.setModel(new DefaultComboBoxModel(
				new String[] { "Seleccione departamento" }));

		JLabel lblDistrito = new JLabel("Distrito: ");

		cboDistrito = new JComboBox();
		cboDistrito.setModel(new DefaultComboBoxModel(
				new String[] { "Seleccione provincia" }));

		btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					btnAgregarCliente();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				FrmNuevoCliente.this.dispose();
			}
		});

		JLabel lblFecha = new JLabel("Fecha: ");

		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setColumns(15);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(138)
																		.addComponent(
																				lblFecha)
																		.addGap(16)
																		.addComponent(
																				txtFecha,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(143)
																		.addComponent(
																				lblEmail)
																		.addGap(16)
																		.addComponent(
																				txtEmail,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(118)
																		.addComponent(
																				lblTelefono)
																		.addGap(16)
																		.addComponent(
																				txtTelefono,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(130)
																		.addComponent(
																				lblCelular)
																		.addGap(16)
																		.addComponent(
																				txtCelular,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(115)
																		.addComponent(
																				lblDireccion)
																		.addGap(16)
																		.addComponent(
																				txtDireccion,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(152)
																		.addComponent(
																				lblRuc)
																		.addGap(16)
																		.addComponent(
																				txtRuc,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(136)
																		.addComponent(
																				btnAgregar)
																		.addGap(9)
																		.addComponent(
																				btnCancelar))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(77)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addGap(14)
																										.addComponent(
																												lblRazonSocial)
																										.addGap(16)
																										.addComponent(
																												txtRazonSocial,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addGap(54)
																										.addComponent(
																												lblEstado)
																										.addGap(16)
																										.addComponent(
																												cboEstado,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addGap(19)
																										.addComponent(
																												lblTipoCliente)
																										.addGap(16)
																										.addComponent(
																												cboTipoCliente,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addComponent(
																												lblDepartamento)
																										.addGap(16)
																										.addComponent(
																												cboDepartamento,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addGap(39)
																										.addComponent(
																												lblProvincia)
																										.addGap(16)
																										.addComponent(
																												cboProvincia,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addGap(50)
																										.addComponent(
																												lblDistrito)
																										.addGap(16)
																										.addComponent(
																												cboDistrito,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(127)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addGap(2)
																										.addComponent(
																												lblNombre)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												txtNombre,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												lblApellido)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												txtApellido,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)))))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGap(10)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																txtNombre,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNombre))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																txtApellido,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblApellido))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				lblFecha))
														.addComponent(
																txtFecha,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(7)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				lblEmail))
														.addComponent(
																txtEmail,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(7)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				lblTelefono))
														.addComponent(
																txtTelefono,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(7)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				lblCelular))
														.addComponent(
																txtCelular,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(7)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				lblDireccion))
														.addComponent(
																txtDireccion,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(7)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				lblRuc))
														.addComponent(
																txtRuc,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				lblRazonSocial))
														.addComponent(
																txtRazonSocial,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(7)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(4)
																		.addComponent(
																				lblEstado))
														.addComponent(
																cboEstado,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(7)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(4)
																		.addComponent(
																				lblTipoCliente))
														.addComponent(
																cboTipoCliente,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(11)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(4)
																		.addComponent(
																				lblDepartamento))
														.addComponent(
																cboDepartamento,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(7)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(4)
																		.addComponent(
																				lblProvincia))
														.addComponent(
																cboProvincia,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(7)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(4)
																		.addComponent(
																				lblDistrito))
														.addComponent(
																cboDistrito,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(38)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																btnAgregar)
														.addComponent(
																btnCancelar))));
		contentPane.setLayout(gl_contentPane);

		llenarCboTipoCliente();
		llenarCboDepartamentos();
		llenarCboProvincias(((Departamento) cboDepartamento.getItemAt(0))
				.getCoddpto());
		llenarCboDistritos(
				((Provincia) cboProvincia.getItemAt(0)).getCoddpto(),
				((Provincia) cboProvincia.getSelectedItem()).getCodprov());
	}

	public void inicializar() {
		FrmNuevoCliente.this.setTitle("Nuevo Cliente");
		FrmNuevoCliente.this.btnAgregar.setText("Agregar");

		txtNombre.setText("");
		txtApellido.setText("");

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy h:mm");
		fecha = new Date();
		txtFecha.setText(sdf.format(fecha));

		txtEmail.setText("");
		txtTelefono.setText("");
		txtCelular.setText("");
		txtDireccion.setText("");
		txtRuc.setText("");
		txtRazonSocial.setText("");
		cboEstado.setSelectedIndex(0);
		cboTipoCliente.setSelectedIndex(0);
		cboDepartamento.setSelectedIndex(0);
	}

	private void llenarCboTipoCliente() {
		List<TipoCliente> lst = tipoClienteService.getListTipoClientes();
		TipoCliente[] tipoClientes = new TipoCliente[lst.size()];
		for (int i = 0; i < lst.size(); i++) {
			tipoClientes[i] = lst.get(i);
		}

		cboTipoCliente.setModel(new DefaultComboBoxModel(tipoClientes));
	}

	private void llenarCboDepartamentos() {
		List<Departamento> lst = departamentoService.getDepartamentos();
		Departamento[] departamentos = new Departamento[lst.size()];
		for (int i = 0; i < lst.size(); i++) {
			departamentos[i] = lst.get(i);
		}

		cboDepartamento.setModel(new DefaultComboBoxModel(departamentos));
	}

	private void llenarCboProvincias(String codDpto) {
		List<Provincia> lst = provinciaService.getProvinciaByCodDpto(codDpto);
		Provincia[] provincias = new Provincia[lst.size()];
		for (int i = 0; i < lst.size(); i++) {
			provincias[i] = lst.get(i);
		}

		cboProvincia.setModel(new DefaultComboBoxModel(provincias));
	}

	private void llenarCboDistritos(String codDpto, String codProv) {
		List<Distrito> lst = distritoService.getDistritoByCodDptoAndCodProv(
				codDpto, codProv);
		Distrito[] distritos = new Distrito[lst.size()];
		for (int i = 0; i < lst.size(); i++) {
			distritos[i] = lst.get(i);
		}

		cboDistrito.setModel(new DefaultComboBoxModel(distritos));
	}

	private void btnAgregarCliente() throws Exception {
		if (btnAgregar.getText().equalsIgnoreCase("Agregar")) {
			Cliente cliente = new Cliente();
			cliente.setNombre(txtNombre.getText());
			cliente.setApellido(txtApellido.getText());
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy h:mm");
			cliente.setFecha(sdf.parse(txtFecha.getText()));
			
			cliente.setEMail(txtEmail.getText());
			cliente.setTelefono(txtTelefono.getText());
			cliente.setCelular(txtCelular.getText());
			cliente.setDireccionNegocio(txtDireccion.getText());
			cliente.setRuc(txtRuc.getText());
			cliente.setRazonSocial(txtRazonSocial.getText());
			if (cboEstado.getSelectedItem().toString()
					.equalsIgnoreCase("activo")) {
				cliente.setEstado('1');
			} else {
				cliente.setEstado('0');
			}
			cliente.setTipoCliente((TipoCliente) cboTipoCliente
					.getSelectedItem());
			cliente.setDepartamento((Departamento) cboDepartamento
					.getSelectedItem());
			cliente.setProvincia((Provincia) cboProvincia.getSelectedItem());
			cliente.setDistrito((Distrito) cboDistrito.getSelectedItem());

			clienteService.save(cliente);
			
		} else {
			clienteToModify.setNombre(txtNombre.getText());
			clienteToModify.setApellido(txtApellido.getText());
			clienteToModify.setEMail(txtEmail.getText());
			clienteToModify.setTelefono(txtTelefono.getText());
			clienteToModify.setCelular(txtCelular.getText());
			clienteToModify.setDireccionNegocio(txtDireccion.getText());
			clienteToModify.setRuc(txtRuc.getText());
			clienteToModify.setRazonSocial(txtRazonSocial.getText());
			if (cboEstado.getSelectedItem().toString()
					.equalsIgnoreCase("activo")) {
				clienteToModify.setEstado('1');
			} else {
				clienteToModify.setEstado('0');
			}
			clienteToModify.setTipoCliente((TipoCliente) cboTipoCliente
					.getSelectedItem());
			clienteToModify.setDepartamento((Departamento) cboDepartamento
					.getSelectedItem());
			clienteToModify.setProvincia((Provincia) cboProvincia.getSelectedItem());
			clienteToModify.setDistrito((Distrito) cboDistrito.getSelectedItem());
			
			clienteService.save(clienteToModify);
		}

		FrmNuevoCliente.this.dispose();
		
		panelMenuClientes.llenarTablaClientes();
	}

	public void mostrarDatosCliente(Cliente cliente) {
		clienteToModify = cliente;
		FrmNuevoCliente.this.setTitle("Modificar Cliente");
		FrmNuevoCliente.this.btnAgregar.setText("Efectuar Cambios");

		txtNombre.setText(cliente.getNombre());
		txtApellido.setText(cliente.getApellido());

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy h:mm");
		txtFecha.setText(sdf.format(cliente.getFecha()));

		txtEmail.setText(cliente.getEMail());
		txtTelefono.setText(cliente.getTelefono());
		txtCelular.setText(cliente.getCelular());
		txtDireccion.setText(cliente.getDireccionNegocio());
		txtRuc.setText(cliente.getRuc());
		txtRazonSocial.setText(cliente.getRazonSocial());

		if (cliente.getEstado() == '1') {
			cboEstado.setSelectedItem("Activo");
		} else {
			cboEstado.setSelectedItem("No activo");
		}

		cboTipoCliente.getModel().setSelectedItem(cliente.getTipoCliente());
		cboDepartamento.getModel().setSelectedItem(cliente.getDepartamento());
		cboProvincia.getModel().setSelectedItem(cliente.getProvincia());
		cboDistrito.getModel().setSelectedItem(cliente.getDistrito());
	}
}
