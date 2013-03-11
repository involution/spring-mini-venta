package com.mini.venta.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JButton;

import org.springframework.stereotype.Component;

import com.mini.venta.entities.Cliente;
import com.mini.venta.entities.NotaPedido;
import com.mini.venta.entities.NotaPedidoProducto;
import com.mini.venta.vista.support.NotaPedidoProductoTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class FrmFinalizarVentaDetalles extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtIdNotaPedido;
	private JTextField txtTotal;
	private JTextField txtClienteEmail;
	private JTextField txtClienteNombre;
	private JTextField txtClienteRuc;
	private JTextField txtClienteApellido;
	private JTextField txtClienteCelular;
	private JTextField txtClienteTelefono;
	private JTextField txtClienteDireccion;
	private JTable tblNotaPedidoProducto;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrmFinalizarVentaDetalles frame = new FrmFinalizarVentaDetalles();
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
	public FrmFinalizarVentaDetalles() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel pnlNotaPedido = new JPanel();
		pnlNotaPedido.setBorder(new TitledBorder(null, "Nota Pedido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("Id Nota Pedido: ");
		
		txtIdNotaPedido = new JTextField();
		txtIdNotaPedido.setEditable(false);
		txtIdNotaPedido.setColumns(10);
		
		JLabel label_1 = new JLabel("TOTAL: ");
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		GroupLayout gl_pnlNotaPedido = new GroupLayout(pnlNotaPedido);
		gl_pnlNotaPedido.setHorizontalGroup(
			gl_pnlNotaPedido.createParallelGroup(Alignment.LEADING)
				.addGap(0, 776, Short.MAX_VALUE)
				.addGroup(gl_pnlNotaPedido.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlNotaPedido.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
						.addGroup(gl_pnlNotaPedido.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtIdNotaPedido, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlNotaPedido.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_pnlNotaPedido.setVerticalGroup(
			gl_pnlNotaPedido.createParallelGroup(Alignment.LEADING)
				.addGap(0, 341, Short.MAX_VALUE)
				.addGroup(gl_pnlNotaPedido.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlNotaPedido.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(txtIdNotaPedido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlNotaPedido.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		
		tblNotaPedidoProducto = new JTable(new NotaPedidoProductoTableModel(false));
		scrollPane.setViewportView(tblNotaPedidoProducto);
		pnlNotaPedido.setLayout(gl_pnlNotaPedido);
		
		JPanel pnlCliente = new JPanel();
		pnlCliente.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel label_2 = new JLabel("Nombre: ");
		
		JLabel label_3 = new JLabel("Email: ");
		
		JLabel label_4 = new JLabel("Ruc: ");
		
		JLabel label_5 = new JLabel("Direccion: ");
		
		txtClienteEmail = new JTextField();
		txtClienteEmail.setEditable(false);
		txtClienteEmail.setColumns(10);
		
		txtClienteNombre = new JTextField();
		txtClienteNombre.setEditable(false);
		txtClienteNombre.setColumns(10);
		
		txtClienteRuc = new JTextField();
		txtClienteRuc.setEditable(false);
		txtClienteRuc.setColumns(10);
		
		JLabel label_6 = new JLabel("Apellido: ");
		
		JLabel label_7 = new JLabel("Telefono: ");
		
		JLabel label_8 = new JLabel("Celular: ");
		
		txtClienteApellido = new JTextField();
		txtClienteApellido.setEditable(false);
		txtClienteApellido.setColumns(10);
		
		txtClienteCelular = new JTextField();
		txtClienteCelular.setEditable(false);
		txtClienteCelular.setColumns(10);
		
		txtClienteTelefono = new JTextField();
		txtClienteTelefono.setEditable(false);
		txtClienteTelefono.setColumns(10);
		
		txtClienteDireccion = new JTextField();
		txtClienteDireccion.setEditable(false);
		txtClienteDireccion.setColumns(10);
		GroupLayout gl_pnlCliente = new GroupLayout(pnlCliente);
		gl_pnlCliente.setHorizontalGroup(
			gl_pnlCliente.createParallelGroup(Alignment.LEADING)
				.addGap(0, 776, Short.MAX_VALUE)
				.addGroup(gl_pnlCliente.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlCliente.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(label_4)
						.addComponent(label_5))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlCliente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCliente.createSequentialGroup()
							.addGroup(gl_pnlCliente.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlCliente.createParallelGroup(Alignment.LEADING, false)
									.addComponent(txtClienteEmail)
									.addComponent(txtClienteNombre, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
								.addComponent(txtClienteRuc, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnlCliente.createParallelGroup(Alignment.LEADING)
								.addComponent(label_6)
								.addComponent(label_7)
								.addComponent(label_8))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnlCliente.createParallelGroup(Alignment.LEADING)
								.addComponent(txtClienteApellido, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_pnlCliente.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(txtClienteCelular, Alignment.LEADING)
									.addComponent(txtClienteTelefono, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
						.addComponent(txtClienteDireccion, GroupLayout.PREFERRED_SIZE, 573, GroupLayout.PREFERRED_SIZE))
					.addGap(16))
		);
		gl_pnlCliente.setVerticalGroup(
			gl_pnlCliente.createParallelGroup(Alignment.LEADING)
				.addGap(0, 161, Short.MAX_VALUE)
				.addGroup(gl_pnlCliente.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(txtClienteNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6)
						.addComponent(txtClienteApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(txtClienteEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7)
						.addComponent(txtClienteTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(txtClienteRuc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_8)
						.addComponent(txtClienteCelular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(txtClienteDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pnlCliente.setLayout(gl_pnlCliente);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlNotaPedido, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
						.addComponent(btnCerrar)
						.addComponent(pnlCliente, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnlCliente, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(pnlNotaPedido, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCerrar)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void mostrarDatos(NotaPedido notaPedido){
		Cliente cliente = notaPedido.getCliente();
		
		txtClienteNombre.setText(cliente.getNombre());
		txtClienteApellido.setText(cliente.getApellido());
		txtClienteEmail.setText(cliente.getEMail());
		txtClienteTelefono.setText(cliente.getTelefono());
		txtClienteRuc.setText(cliente.getRuc());
		txtClienteCelular.setText(cliente.getCelular());
		txtClienteDireccion.setText(cliente.getDireccionNegocio());
		
		txtIdNotaPedido.setText(notaPedido.getIdNpedido().toString());
		
		List<NotaPedidoProducto> lstNotaPedidoProducto = new ArrayList<NotaPedidoProducto>(notaPedido.getNotaPedidoProductos());
		((NotaPedidoProductoTableModel) tblNotaPedidoProducto.getModel()).setLstNotaPedidoProducto(lstNotaPedidoProducto);
		
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(0);
		df.setGroupingUsed(false);
		
		txtTotal.setText(df.format(notaPedido.getTotal()));
	}

}
