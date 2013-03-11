package com.mini.venta.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.mini.venta.entities.Empleado;
import com.mini.venta.service.intefaces.EmpleadoService;
import com.mini.venta.vista.support.ShareData;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@Component
public class FrmLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblMensaje;

	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private FrmMenuPrincipal frmMenuPrincipal;
	
	@Autowired
	private ShareData shareData;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public FrmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("126px"),
				ColumnSpec.decode("89px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("221px"),},
			new RowSpec[] {
				RowSpec.decode("64px"),
				RowSpec.decode("19px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("19px"),
//				frmMenuPrincipal.validate();
//				frmMenuPrincipal.repaint();
				RowSpec.decode("33px"),
				RowSpec.decode("25px"),
				RowSpec.decode("68px"),
				RowSpec.decode("1px"),}));
		
		JLabel lblUsuario = new JLabel("Usuario:");
		contentPane.add(lblUsuario, "2, 2, left, center");
		
		txtUsuario = new JTextField();
		contentPane.add(txtUsuario, "4, 2, left, top");
		txtUsuario.setColumns(10);
		
		JLabel lblClave = new JLabel("Clave:");
		contentPane.add(lblClave, "2, 4, left, center");
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		contentPane.add(txtPassword, "4, 4, left, top");
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = txtUsuario.getText();
				@SuppressWarnings("deprecation")
				String password = txtPassword.getText();
				
				System.out.println("usuario: " + usuario + " , password: " + password);
				
				Empleado empleado = empleadoService.login(usuario, password);
				
				if (empleado == null) {
					lblMensaje.setText("El usuario o password son incorrectos");
				} else {
					shareData.setMapData("empleado", empleado);
					lblMensaje.setText("");
					FrmLogin.this.setVisible(false);
					
					frmMenuPrincipal.colocarBienvenida();
					//Maximizar ventana
					frmMenuPrincipal.setExtendedState(Frame.MAXIMIZED_BOTH);
					frmMenuPrincipal.setLocationRelativeTo(null);
					frmMenuPrincipal.setVisible(true);
				}
			}
		});
		contentPane.add(btnAceptar, "2, 6, left, top");
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnCancelar, "4, 6, left, top");
		
		lblMensaje = new JLabel("");
		contentPane.add(lblMensaje, "2, 8, 3, 1, fill, top");
	}

}
