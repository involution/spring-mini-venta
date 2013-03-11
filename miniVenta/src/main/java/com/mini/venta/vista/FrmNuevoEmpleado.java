package com.mini.venta.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mini.venta.entities.Area;
import com.mini.venta.entities.Cargo;
import com.mini.venta.entities.Empleado;
import com.mini.venta.service.intefaces.AreaService;
import com.mini.venta.service.intefaces.CargoService;
import com.mini.venta.service.intefaces.EmpleadoService;
import com.mini.venta.vista.support.JTextFieldMaxCharLimit;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@Component
public class FrmNuevoEmpleado extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtDni;
	private JTextField txtTelefono;
	private JTextField txtCelular;
	private JTextField txtEmail;
	private JTextField txtDireccion;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JPasswordField txtRePassword;
	private JComboBox cboEstado;
	private JComboBox cboArea;
	private JComboBox cboCargo;

	private JButton btnAgregar;
	
	private AreaService areaService;
	private CargoService cargoService;
	
	@Autowired
	private EmpleadoService empleadoService;
	
	private Empleado empleadoToModify;
	
	@Autowired
	private PanelMenuEmpleado panelMenuEmpleado;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrmNuevoEmpleado frame = new FrmNuevoEmpleado();
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
	@Autowired
	public FrmNuevoEmpleado(AreaService areaService, CargoService cargoService) {
		
		this.areaService = areaService;
		this.cargoService = cargoService;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					btnAgregarEmpleado();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		
		JLabel lblNombre = new JLabel("Nombre: ");
		
		JLabel lblApellido = new JLabel("Apellido: ");
		
		JLabel lblDni = new JLabel("Dni: ");
		
		JLabel lblTelefono = new JLabel("Telefono: ");
		
		JLabel lblCelular = new JLabel("Celular: ");
		
		JLabel lblEmail = new JLabel("Email: ");
		
		JLabel lblDireccion = new JLabel("Direccion: ");
		
		JLabel lblEstado = new JLabel("Estado: ");
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		
		JLabel lblPassword = new JLabel("Password: ");
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setColumns(8);
		txtDni.setDocument(new JTextFieldMaxCharLimit(8));
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(7);
		txtTelefono.setDocument(new JTextFieldMaxCharLimit(7));
		
		txtCelular = new JTextField();
		txtCelular.setColumns(9);
		txtCelular.setDocument(new JTextFieldMaxCharLimit(9));
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		
		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Activo", "No Activo"}));
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		
		JLabel lblEscribeDeNuevo = new JLabel("Escribe de nuevo  ");
		
		JLabel lblTuPassword = new JLabel("tu password: ");
		
		txtRePassword = new JPasswordField();
		
		JLabel lblArea = new JLabel("Area: ");
		
		JLabel lblCargo = new JLabel("Cargo: ");
		
		cboArea = new JComboBox();
		cboArea.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				llenarCboCargo((Area)cboArea.getSelectedItem());
			}
		});
		
		cboCargo = new JComboBox();
		
		JLabel lblMensaje = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(109)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCargo)
						.addComponent(lblArea)
						.addComponent(lblEscribeDeNuevo)
						.addComponent(lblNombre)
						.addComponent(lblApellido)
						.addComponent(lblDni)
						.addComponent(lblTelefono)
						.addComponent(lblCelular)
						.addComponent(lblEmail)
						.addComponent(lblDireccion)
						.addComponent(lblEstado)
						.addComponent(lblUsuario)
						.addComponent(lblPassword)
						.addComponent(lblTuPassword))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(cboEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtCelular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
							.addComponent(txtApellido)
							.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
							.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txtUsuario, Alignment.LEADING)
							.addComponent(txtPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
						.addComponent(txtRePassword, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
						.addComponent(cboArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cboCargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(79, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(130)
					.addComponent(lblMensaje, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
					.addGap(107))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(131, Short.MAX_VALUE)
					.addComponent(btnAgregar)
					.addGap(82)
					.addComponent(btnCancelar)
					.addGap(120))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellido)
						.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefono)
						.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCelular)
						.addComponent(txtCelular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion)
						.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstado)
						.addComponent(cboEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsuario)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblEscribeDeNuevo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTuPassword))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(txtRePassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblArea)
						.addComponent(cboArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCargo)
						.addComponent(cboCargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
					.addComponent(lblMensaje, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAgregar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		llenarCboArea();
		llenarCboCargo((Area)cboArea.getItemAt(0));
	}
	
	public void inicializar() {
		setTitle("Nuevo Cliente");
		btnAgregar.setText("Agregar");

		txtNombre.setText("");
		txtApellido.setText("");
		txtDni.setText("");
		txtEmail.setText("");
		txtTelefono.setText("");
		txtCelular.setText("");
		txtDireccion.setText("");
		cboEstado.setSelectedIndex(0);
		txtUsuario.setText("");
		txtPassword.setText("");
		txtRePassword.setText("");
		cboArea.setSelectedIndex(0);
		cboCargo.setSelectedIndex(0);
	}

	private void llenarCboArea() {
		List<Area> lst = areaService.findAll();
		Area[] areas = new Area[lst.size()];
		for (int i = 0; i < lst.size(); i++) {
			areas[i] = lst.get(i);
		}

		cboArea.setModel(new DefaultComboBoxModel(areas));
	}

	private void llenarCboCargo(Area area) {
		List<Cargo> lst = cargoService.findByArea(area);
		Cargo[]cargos = new Cargo[lst.size()];
		for (int i = 0; i < lst.size(); i++) {
			cargos[i] = lst.get(i);
		}

		cboCargo.setModel(new DefaultComboBoxModel(cargos));
	}

	@SuppressWarnings("deprecation")
	private void btnAgregarEmpleado() throws Exception {
		if (btnAgregar.getText().equalsIgnoreCase("Agregar")) {
			Empleado empleado = new Empleado();
			empleado.setNombre(txtNombre.getText());
			empleado.setApellido(txtApellido.getText());
			empleado.setDni(txtDni.getText());
			empleado.setEMail(txtEmail.getText());
			empleado.setTelefono(txtTelefono.getText());
			empleado.setCelular(txtCelular.getText());
			empleado.setDireccion(txtDireccion.getText());
			if (cboEstado.getSelectedItem().toString()
					.equalsIgnoreCase("activo")) {
				empleado.setEstado('1');
			} else {
				empleado.setEstado('0');
			}
			empleado.setUsuario(txtUsuario.getText());
			empleado.setPassword(txtPassword.getText());
			empleado.setArea((Area) cboArea.getSelectedItem());
			empleado.setCargo((Cargo) cboCargo.getSelectedItem());
			
			empleadoService.save(empleado);
			
		} else {
			empleadoToModify.setNombre(txtNombre.getText());
			empleadoToModify.setApellido(txtApellido.getText());
			empleadoToModify.setDni(txtDni.getText());
			empleadoToModify.setEMail(txtEmail.getText());
			empleadoToModify.setTelefono(txtTelefono.getText());
			empleadoToModify.setCelular(txtCelular.getText());
			empleadoToModify.setDireccion(txtDireccion.getText());
			if (cboEstado.getSelectedItem().toString()
					.equalsIgnoreCase("activo")) {
				empleadoToModify.setEstado('1');
			} else {
				empleadoToModify.setEstado('0');
			}
			empleadoToModify.setUsuario(txtUsuario.getText());
			empleadoToModify.setPassword(txtPassword.getText());
			empleadoToModify.setArea((Area) cboArea.getSelectedItem());
			empleadoToModify.setCargo((Cargo) cboCargo.getSelectedItem());
			
			empleadoService.save(empleadoToModify);
		}

		dispose();
		
		panelMenuEmpleado.llenarTablaEmpleado();
	}

	public void mostrarDatosEmpleado(Empleado empleado) {
		empleadoToModify = empleado;
		setTitle("Modificar Empleado");
		btnAgregar.setText("Efectuar Cambios");

		txtNombre.setText(empleado.getNombre());
		txtApellido.setText(empleado.getApellido());
		txtDni.setText(empleado.getDni());
		txtEmail.setText(empleado.getEMail());
		txtTelefono.setText(empleado.getTelefono());
		txtCelular.setText(empleado.getCelular());
		txtDireccion.setText(empleado.getDireccion());

		if (empleado.getEstado() == '1') {
			cboEstado.setSelectedItem("Activo");
		} else {
			cboEstado.setSelectedItem("No activo");
		}
		txtUsuario.setText(empleado.getUsuario());
		txtPassword.setText(empleado.getPassword());
		txtRePassword.setText(empleado.getPassword());
		cboArea.getModel().setSelectedItem(empleado.getArea());
		cboCargo.getModel().setSelectedItem(empleado.getCargo());
	}
}
