package com.mini.venta.vista;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mini.venta.entities.Credito;
import com.mini.venta.entities.Empleado;
import com.mini.venta.entities.Moneda;
import com.mini.venta.entities.NotaPedido;
import com.mini.venta.entities.TipoPago;
import com.mini.venta.entities.Venta;
import com.mini.venta.report.FrmBoleta;
import com.mini.venta.service.intefaces.CreditoService;
import com.mini.venta.service.intefaces.MonedaService;
import com.mini.venta.service.intefaces.TipoPagoService;
import com.mini.venta.service.intefaces.VentaService;
import com.mini.venta.vista.support.ShareData;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;

@Component
public class PanelFinalizarVenta extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField txtIdCliente;
	private JTextField txtIdNotaPedido;	
	private NotaPedido notaPedido;
	private JTextField txtDireccionEntrega;
	private JTextField txtFecha;
	private JTextField txtFechaEntrega;
	private JTextField txtTotal;
	private JTextField txtTipoCambio;
	private JComboBox cboTipoPago;
	private JComboBox cboMoneda;
	private JTextField txtSaldo;
	private JTextField txtNroCuotas;
	private JTextField txtFechaLimite;
	private JButton btnRealizarVenta;
	private JButton btnVerBoleta;
	
	private JPanel pnlTipoCambio;
	private JPanel pnlCredito;
	
	private Date fecha;	
	
	private Venta ventaEfectuada;
	
	@Autowired
	private FrmFinalizarVentaDetalles frmFinalizarVentaDetalles;
	
	@Autowired
	private VentaService ventaService;
	
	@Autowired
	private CreditoService creditoService;
	
	private MonedaService monedaService;
	private TipoPagoService tipoPagoService;
	
	@Autowired
	private ShareData data;
	
	@Autowired
	private FrmBoleta frmBoleta;
	/**
	 * Create the panel.
	 */
	@Autowired
	public PanelFinalizarVenta(MonedaService monedaService, TipoPagoService tipoPagoService) {
		
		this.monedaService = monedaService;
		this.tipoPagoService = tipoPagoService;
		
		JPanel pnlCliente = new JPanel();
		pnlCliente.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Cliente y Nota Pedido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		
		btnRealizarVenta = new JButton("Realizar venta");
		btnRealizarVenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					realizarVenta();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblFinalizarVenta = new JLabel("FINALIZAR VENTA");
		lblFinalizarVenta.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnVerBoleta = new JButton("Ver boleta");
		btnVerBoleta.setEnabled(false);
		btnVerBoleta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				verBoleta();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnRealizarVenta)
							.addGap(107)
							.addComponent(btnVerBoleta))
						.addComponent(lblFinalizarVenta, GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
						.addComponent(pnlCliente, GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFinalizarVenta)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(pnlCliente, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRealizarVenta)
						.addComponent(btnVerBoleta))
					.addGap(26))
		);
		
		JLabel lblDireccionDeEntrega = new JLabel("Direccion de entrega: ");
		
		txtDireccionEntrega = new JTextField();
		txtDireccionEntrega.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha: ");
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		
		JLabel lblFechaDeEntrega = new JLabel("Fecha de entrega: ");
		
		txtFechaEntrega = new JTextField();
		txtFechaEntrega.setColumns(10);
		
		JLabel lblTipoDePago = new JLabel("Tipo de pago: ");
		
		cboTipoPago = new JComboBox();
		cboTipoPago.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String tipoPago = ((TipoPago) cboTipoPago.getSelectedItem()).getDescripcion();
				if (tipoPago.equalsIgnoreCase("CONTADO")) {
					pnlCredito.setVisible(false);
				} else {
					pnlCredito.setVisible(true);
				}
			}
		});
		
		pnlCredito = new JPanel();
		pnlCredito.setVisible(false);
		pnlCredito.setBorder(new TitledBorder(null, "Credito", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblTotal = new JLabel("Total: ");
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		
		JLabel lblMoneda = new JLabel("Moneda: ");
		
		cboMoneda = new JComboBox();
		cboMoneda.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String moneda = ((Moneda) cboMoneda.getSelectedItem()).getDescripcion();
				if (moneda.equalsIgnoreCase("NUEVO SOL")) {
					pnlTipoCambio.setVisible(false);
				} else {
					pnlTipoCambio.setVisible(true);
				}
			}
		});
		
		pnlTipoCambio = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDireccionDeEntrega)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtDireccionEntrega, GroupLayout.PREFERRED_SIZE, 540, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblTotal)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(pnlCredito, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblTipoDePago)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cboTipoPago, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblFecha)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblMoneda)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cboMoneda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblFechaDeEntrega)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtFechaEntrega, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(26)
									.addComponent(pnlTipoCambio, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDireccionDeEntrega)
								.addComponent(txtDireccionEntrega, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(55)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTotal)
								.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(49)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFecha)
								.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFechaDeEntrega)
								.addComponent(txtFechaEntrega, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(51)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMoneda)
								.addComponent(cboMoneda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(14)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTipoDePago)
								.addComponent(cboTipoPago, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(40)
							.addComponent(pnlTipoCambio, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(pnlCredito, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		
		JLabel lblSaldo = new JLabel("Saldo: ");
		
		txtSaldo = new JTextField();
		txtSaldo.setColumns(10);
		
		JLabel lblNroCuotas = new JLabel("Nro cuotas: ");
		
		txtNroCuotas = new JTextField();
		txtNroCuotas.setColumns(10);
		
		JLabel lblFechaLimite = new JLabel("Fecha limite: ");
		
		txtFechaLimite = new JTextField();
		txtFechaLimite.setColumns(10);
		GroupLayout gl_pnlCredito = new GroupLayout(pnlCredito);
		gl_pnlCredito.setHorizontalGroup(
			gl_pnlCredito.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCredito.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlCredito.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFechaLimite)
						.addComponent(lblSaldo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlCredito.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtFechaLimite)
						.addComponent(txtSaldo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(70)
					.addComponent(lblNroCuotas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNroCuotas, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(286, Short.MAX_VALUE))
		);
		gl_pnlCredito.setVerticalGroup(
			gl_pnlCredito.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlCredito.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_pnlCredito.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSaldo)
						.addComponent(lblNroCuotas)
						.addComponent(txtNroCuotas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSaldo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlCredito.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaLimite)
						.addComponent(txtFechaLimite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		pnlCredito.setLayout(gl_pnlCredito);
		
		JLabel lblTipoDeCambio = new JLabel("Tipo de cambio: ");
		
		txtTipoCambio = new JTextField();
		txtTipoCambio.setColumns(10);
		GroupLayout gl_pnlTipoCambio = new GroupLayout(pnlTipoCambio);
		gl_pnlTipoCambio.setHorizontalGroup(
			gl_pnlTipoCambio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTipoCambio.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTipoDeCambio)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtTipoCambio, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		gl_pnlTipoCambio.setVerticalGroup(
			gl_pnlTipoCambio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTipoCambio.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlTipoCambio.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoDeCambio)
						.addComponent(txtTipoCambio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		pnlTipoCambio.setLayout(gl_pnlTipoCambio);
		panel.setLayout(gl_panel);
		
		JLabel lblIdCliente = new JLabel("Id Cliente: ");
		
		txtIdCliente = new JTextField();
		txtIdCliente.setEditable(false);
		txtIdCliente.setColumns(10);
		
		JLabel lblIdNotaPedido = new JLabel("Id Nota Pedido: ");
		
		txtIdNotaPedido = new JTextField();
		txtIdNotaPedido.setEditable(false);
		txtIdNotaPedido.setColumns(10);
		
		JButton btnMostrarDetalles = new JButton("Mostrar Detalles");
		btnMostrarDetalles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				mostrarDetalles();
			}
		});
		GroupLayout gl_pnlCliente = new GroupLayout(pnlCliente);
		gl_pnlCliente.setHorizontalGroup(
			gl_pnlCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCliente.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIdCliente)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtIdCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblIdNotaPedido)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtIdNotaPedido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnMostrarDetalles)
					.addContainerGap(160, Short.MAX_VALUE))
		);
		gl_pnlCliente.setVerticalGroup(
			gl_pnlCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCliente.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdCliente)
						.addComponent(txtIdCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIdNotaPedido)
						.addComponent(txtIdNotaPedido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMostrarDetalles))
					.addContainerGap(109, Short.MAX_VALUE))
		);
		pnlCliente.setLayout(gl_pnlCliente);
		setLayout(groupLayout);

		llenarCboMoneda();
		llenarCboTipoPago();
	}

	private void llenarCboMoneda(){
		List<Moneda> lstMoneda = monedaService.findAll();
		Moneda[] monedas = new Moneda[lstMoneda.size()];
		
		for (int i = 0; i < lstMoneda.size(); i++) {
			monedas[i] = lstMoneda.get(i);
		}
		
		cboMoneda.setModel(new DefaultComboBoxModel(monedas));
	}
	
	private void llenarCboTipoPago(){
		List<TipoPago> lstTipoPago = tipoPagoService.findAll();
		TipoPago[] tipoPagos = new TipoPago[lstTipoPago.size()];
		
		for (int i = 0; i < lstTipoPago.size(); i++) {
			tipoPagos[i] = lstTipoPago.get(i);
		}
		
		cboTipoPago.setModel(new DefaultComboBoxModel(tipoPagos));
	}
	
	private void mostrarDetalles() {
		if (notaPedido == null) {
			JOptionPane.showMessageDialog(null,"No hay nota de pedido que mostrar.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
			
		} else {
			frmFinalizarVentaDetalles.mostrarDatos(notaPedido);
			frmFinalizarVentaDetalles.setLocationRelativeTo(null);
			frmFinalizarVentaDetalles.setVisible(true);
		}
	}
 
	public void inicializar(NotaPedido notaPedido){
		this.notaPedido = notaPedido;
		
		txtIdCliente.setText(notaPedido.getCliente().getIdCliente().toString());
		txtIdNotaPedido.setText(notaPedido.getIdNpedido().toString());
		
		txtDireccionEntrega.setText(notaPedido.getCliente().getDireccionNegocio());
		txtTotal.setText(notaPedido.getTotal().toString());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy h:mm");
		fecha = new Date();
		txtFecha.setText(sdf.format(fecha));
		txtFechaEntrega.setText(sdf.format(fecha));
		
		pnlTipoCambio.setVisible(false);
	}
	
	private void realizarVenta() {
		try {
			Venta venta = new Venta();
			
			venta.setDireccionEntrega(txtDireccionEntrega.getText());
			venta.setFecha(fecha);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			venta.setFechaEntrega(sdf.parse(txtFechaEntrega.getText()));
			
			Moneda moneda = (Moneda) cboMoneda.getSelectedItem();
			if (moneda.getDescripcion().equalsIgnoreCase("NUEVO SOL")) {
				venta.setTipoCambio(new BigDecimal(0));
			} else {
				venta.setTipoCambio(new BigDecimal(txtTipoCambio.getText()));
			}
			
			venta.setMoneda(moneda);
			venta.setNotaPedido(notaPedido);
			venta.setEmpleado((Empleado) data.getMapData().get("empleado"));
			
			TipoPago tipoPago = (TipoPago)cboTipoPago.getSelectedItem();
			venta.setTipoPago(tipoPago);
			
			ventaEfectuada = ventaService.save(venta);
			
			if (tipoPago.getDescripcion().equalsIgnoreCase("credito")) {
				Credito credito = new Credito();
				
				credito.setSaldo(new BigDecimal(txtSaldo.getText()));
				credito.setNroCoutas(Integer.parseInt(txtNroCuotas.getText()));
				credito.setFechaLimite(sdf.parse(txtFechaLimite.getText()));
				credito.setVenta(venta);
				
				creditoService.save(credito);
			}
			
			JOptionPane.showMessageDialog(null,"La venta se realizo correctamente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
			
			btnRealizarVenta.setEnabled(false);
			btnVerBoleta.setEnabled(true);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Hubo un error al realizar la venta.", "Mensaje", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	public void limpiarCampos() {
		notaPedido = null;
		
		txtIdCliente.setText("");
		txtIdNotaPedido.setText("");
		
		txtDireccionEntrega.setText("");
		txtTotal.setText("");
		
		txtFecha.setText("");
		txtFechaEntrega.setText("");
		
		pnlTipoCambio.setVisible(false);
		txtTipoCambio.setText("");
		
		txtSaldo.setText("");
		txtNroCuotas.setText("");
		txtFechaLimite.setText("");
	}
	
	
	private void verBoleta() {
		frmBoleta.inicializar(ventaEfectuada);
		frmBoleta.setLocationRelativeTo(null);
		frmBoleta.setVisible(true);
	}
}