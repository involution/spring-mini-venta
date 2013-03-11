package com.mini.venta.vista;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mini.venta.entities.Cliente;
import com.mini.venta.entities.NotaPedido;
import com.mini.venta.entities.NotaPedidoProducto;
import com.mini.venta.service.intefaces.NotaPedidoService;
import com.mini.venta.vista.support.NotaPedidoProductoTableModel;

import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.awt.Color;

@Component
public class PanelNuevaNotaPedido extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtClienteNombre;
	private JTextField txtClienteApellido;
	private JTextField txtClienteEmail;
	private JTextField txtClienteTelefono;
	private JTextField txtClienteCelular;
	private JTextField txtClienteDireccion;
	private JTextField txtClienteRuc;
	private JTextField txtClienteRazonSocial;
	private JTable tblNotaPedidoProducto;
	private JTextField txtSubTotal;
	private JTextField txtIgv;
	private JTextField txtTotal;

	private Cliente cliente;

	@Autowired
	private FrmMenuPrincipal frmMenuPrincipal;
	
	@Autowired
	private FrmBuscarCliente frmBuscarCliente;

	@Autowired
	private FrmBuscarProducto frmBuscarProducto;

	@Autowired
	private NotaPedidoService notaPedidoService;

	/**
	 * Create the panel.
	 */
	public PanelNuevaNotaPedido() {

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del Cliente",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JScrollPane scrollPane = new JScrollPane();

		JButton btnAgregarProducto = new JButton("Agregar Producto");
		btnAgregarProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				frmBuscarProducto.setLocationRelativeTo(null);
				frmBuscarProducto.setVisible(true);
			}
		});

		JButton btnQuitarProducto = new JButton("Quitar Producto");
		btnQuitarProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				quitarLstNotaPedidoProducto(tblNotaPedidoProducto
						.getSelectedRow());
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));

		JButton btnGuardarNotaDe = new JButton("Guardar Nota de Pedido");
		btnGuardarNotaDe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				guardarNotaPedido();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																panel_1,
																Alignment.TRAILING,
																GroupLayout.PREFERRED_SIZE,
																232,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																scrollPane,
																GroupLayout.DEFAULT_SIZE,
																695,
																Short.MAX_VALUE)
														.addComponent(
																panel,
																GroupLayout.DEFAULT_SIZE,
																695,
																Short.MAX_VALUE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				btnAgregarProducto)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnQuitarProducto))
														.addComponent(
																btnGuardarNotaDe))
										.addContainerGap()));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(panel,
												GroupLayout.PREFERRED_SIZE,
												187, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnAgregarProducto)
														.addComponent(
																btnQuitarProducto))
										.addGap(3)
										.addComponent(scrollPane,
												GroupLayout.PREFERRED_SIZE,
												239, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(panel_1,
												GroupLayout.PREFERRED_SIZE,
												114, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED, 34,
												Short.MAX_VALUE)
										.addComponent(btnGuardarNotaDe)
										.addGap(25)));

		JLabel lblSubtotal = new JLabel("SubTotal: ");

		JLabel lblIgv = new JLabel("IGV: ");

		JLabel lblTotal = new JLabel("Total: ");

		txtSubTotal = new JTextField();
		txtSubTotal.setEditable(false);
		txtSubTotal.setColumns(10);

		txtIgv = new JTextField();
		txtIgv.setEditable(false);
		txtIgv.setColumns(10);

		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_1
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_panel_1
										.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSubtotal)
										.addComponent(lblIgv)
										.addComponent(lblTotal))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								gl_panel_1
										.createParallelGroup(Alignment.LEADING)
										.addComponent(txtTotal,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtIgv,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtSubTotal,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addContainerGap(20, Short.MAX_VALUE)));
		gl_panel_1
				.setVerticalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblSubtotal)
														.addComponent(
																txtSubTotal,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblIgv)
														.addComponent(
																txtIgv,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblTotal)
														.addComponent(
																txtTotal,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(49, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		tblNotaPedidoProducto = new JTable(new NotaPedidoProductoTableModel());
		NotaPedidoProductoTableModel tableModel = (NotaPedidoProductoTableModel) tblNotaPedidoProducto.getModel();
		tableModel.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				System.out.println("tableChanged");
				calcularTotal();
			}
		});

		scrollPane.setViewportView(tblNotaPedidoProducto);

		JButton btnCliente = new JButton("Cliente ...");
		btnCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				frmBuscarCliente.setLocationRelativeTo(null);
				frmBuscarCliente.setVisible(true);
			}
		});

		JLabel lblNombre = new JLabel("Nombre: ");

		txtClienteNombre = new JTextField();
		txtClienteNombre.setEditable(false);
		txtClienteNombre.setColumns(30);

		JLabel lblApellido = new JLabel("Apellido: ");

		txtClienteApellido = new JTextField();
		txtClienteApellido.setEditable(false);
		txtClienteApellido.setColumns(30);

		JLabel lblEmail = new JLabel("Email: ");

		txtClienteEmail = new JTextField();
		txtClienteEmail.setEditable(false);
		txtClienteEmail.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono: ");

		txtClienteTelefono = new JTextField();
		txtClienteTelefono.setEditable(false);
		txtClienteTelefono.setColumns(10);

		JLabel lblCelular = new JLabel("Celular: ");

		txtClienteCelular = new JTextField();
		txtClienteCelular.setEditable(false);
		txtClienteCelular.setColumns(10);

		JLabel lblDireccion = new JLabel("Direccion: ");

		txtClienteDireccion = new JTextField();
		txtClienteDireccion.setEditable(false);
		txtClienteDireccion.setColumns(10);

		JLabel lblRuc = new JLabel("Ruc: ");

		txtClienteRuc = new JTextField();
		txtClienteRuc.setEditable(false);
		txtClienteRuc.setColumns(10);

		JLabel lblRazonSocial = new JLabel("Razon Social");

		txtClienteRazonSocial = new JTextField();
		txtClienteRazonSocial.setEditable(false);
		txtClienteRazonSocial.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING, false)
												.addComponent(btnCliente)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						lblNombre)
																				.addComponent(
																						lblEmail))
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING,
																				false)
																				.addComponent(
																						txtClienteEmail)
																				.addComponent(
																						txtClienteNombre,
																						GroupLayout.DEFAULT_SIZE,
																						238,
																						Short.MAX_VALUE))
																.addPreferredGap(
																		ComponentPlacement.UNRELATED)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						lblApellido)
																				.addComponent(
																						lblTelefono))
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						txtClienteTelefono,
																						GroupLayout.PREFERRED_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						txtClienteApellido,
																						GroupLayout.PREFERRED_SIZE,
																						208,
																						GroupLayout.PREFERRED_SIZE)))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						lblCelular)
																				.addComponent(
																						lblRuc))
																.addPreferredGap(
																		ComponentPlacement.RELATED)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addComponent(
																										txtClienteRuc,
																										GroupLayout.PREFERRED_SIZE,
																										GroupLayout.DEFAULT_SIZE,
																										GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										ComponentPlacement.UNRELATED)
																								.addComponent(
																										lblRazonSocial)
																								.addPreferredGap(
																										ComponentPlacement.RELATED)
																								.addComponent(
																										txtClienteRazonSocial,
																										GroupLayout.DEFAULT_SIZE,
																										318,
																										Short.MAX_VALUE))
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addComponent(
																										txtClienteCelular,
																										GroupLayout.PREFERRED_SIZE,
																										GroupLayout.DEFAULT_SIZE,
																										GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										ComponentPlacement.UNRELATED)
																								.addComponent(
																										lblDireccion)
																								.addPreferredGap(
																										ComponentPlacement.RELATED)
																								.addComponent(
																										txtClienteDireccion)))))
								.addContainerGap(16, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addComponent(btnCliente)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblNombre)
												.addComponent(
														txtClienteNombre,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblApellido)
												.addComponent(
														txtClienteApellido,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblEmail)
												.addComponent(
														txtClienteEmail,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblTelefono)
												.addComponent(
														txtClienteTelefono,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblCelular)
												.addComponent(
														txtClienteCelular,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblDireccion)
												.addComponent(
														txtClienteDireccion,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblRuc)
												.addComponent(
														txtClienteRuc,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblRazonSocial)
												.addComponent(
														txtClienteRazonSocial,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addContainerGap(34, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

	}

	public void llenarDatosCliente(Cliente c) {
		this.cliente = c;

		txtClienteNombre.setText(cliente.getNombre());
		txtClienteApellido.setText(cliente.getApellido());
		txtClienteEmail.setText(cliente.getEMail());
		txtClienteTelefono.setText(cliente.getTelefono());
		txtClienteCelular.setText(cliente.getCelular());
		txtClienteDireccion.setText(cliente.getDireccionNegocio());
		txtClienteRuc.setText(cliente.getRuc());
		txtClienteRazonSocial.setText(cliente.getRazonSocial());
	}

	public void agregarLstNotaPedidoProducto(NotaPedidoProducto npp) {
		NotaPedidoProductoTableModel tableModel = (NotaPedidoProductoTableModel) tblNotaPedidoProducto.getModel();
		tableModel.addToList(npp);
	}

	private void quitarLstNotaPedidoProducto(int selectedRow) {
		NotaPedidoProductoTableModel tableModel = (NotaPedidoProductoTableModel) tblNotaPedidoProducto.getModel();
		tableModel.removeOfList(selectedRow);
	}

	private void guardarNotaPedido() {
		try {
			NotaPedido notaPedido = new NotaPedido();
			notaPedido.setCliente(cliente);
			notaPedido.setFecha(new Date());
			notaPedido.setTotal(BigDecimal.valueOf(Double.parseDouble(txtTotal.getText())));

			NotaPedidoProductoTableModel tableModel = (NotaPedidoProductoTableModel) tblNotaPedidoProducto.getModel();
			List<NotaPedidoProducto> lstNotaPedidoProductos = tableModel.getLstNotaPedidoProducto();

			for (int i = 0; i < lstNotaPedidoProductos.size(); i++) {
				NotaPedidoProducto notaPedidoProducto = lstNotaPedidoProductos.get(i);
				notaPedidoProducto.setNotaPedido(notaPedido);
				lstNotaPedidoProductos.set(i, notaPedidoProducto);
			}

			notaPedido.getNotaPedidoProductos().addAll(lstNotaPedidoProductos);
			notaPedidoService.save(notaPedido);

			JOptionPane.showMessageDialog(null,"Se guardo nota de pedido satisfactotiamente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
			
			inicializar();

			frmMenuPrincipal.colocarPanelFinalizarVenta(notaPedido);
			
		} catch (TransactionException e) {
			JOptionPane.showMessageDialog(null,"Hubo un error al guardar la nota de pedido.", "Mensaje", JOptionPane.ERROR_MESSAGE);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void calcularTotal() {
		NotaPedidoProductoTableModel model = (NotaPedidoProductoTableModel) tblNotaPedidoProducto
				.getModel();

		BigDecimal subTotal = model.calcularSuma();
		BigDecimal igv = subTotal.multiply(new BigDecimal(0.19));
		BigDecimal total = subTotal.add(igv);

		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(0);
		df.setGroupingUsed(false);

		txtSubTotal.setText(df.format(subTotal));
		txtIgv.setText(df.format(igv));
		txtTotal.setText(df.format(total));
	}

	private void inicializar(){
		cliente = null;
		
		txtClienteNombre.setText("");
		txtClienteApellido.setText("");
		txtClienteCelular.setText("");
		txtClienteDireccion.setText("");
		txtClienteEmail.setText("");
		txtClienteRazonSocial.setText("");
		txtClienteTelefono.setText("");
		txtClienteRuc.setText("");
				
		((NotaPedidoProductoTableModel)tblNotaPedidoProducto.getModel()).removeAllList();
		
		txtSubTotal.setText("");
		txtIgv.setText("");
		txtTotal.setText("");
	}
}
