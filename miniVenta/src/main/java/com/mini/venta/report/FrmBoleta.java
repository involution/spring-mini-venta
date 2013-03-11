package com.mini.venta.report;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.springframework.stereotype.Component;

import com.mini.venta.entities.Cliente;
import com.mini.venta.entities.NotaPedidoProducto;
import com.mini.venta.entities.Venta;
import com.mini.venta.vista.support.BoletaTableModel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@Component
public class FrmBoleta extends JFrame implements Printable {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblBoleta;
	private JPanel pnlBoleta;
	private JLabel lblFecha;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel lblDireccion;
	private JLabel lblTotal;
	
	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// FrmBoleta frame = new FrmBoleta();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public FrmBoleta() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 635, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		pnlBoleta = new JPanel();

		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				imprimir();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.LEADING)
										.addComponent(pnlBoleta,
												GroupLayout.DEFAULT_SIZE, 764,
												Short.MAX_VALUE)
										.addComponent(btnImprimir))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addComponent(pnlBoleta, GroupLayout.PREFERRED_SIZE,
								503, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 21,
								Short.MAX_VALUE).addComponent(btnImprimir)
						.addContainerGap()));

		lblFecha = new JLabel("Fecha: ");

		JLabel lNombre = new JLabel("Nombre: ");

		lblNombre = new JLabel("lblNombre");

		JLabel lApellido = new JLabel("Apellido: ");

		lblApellido = new JLabel("lblApellido");

		JLabel lDni = new JLabel("DNI: ");

		lblDni = new JLabel("lblDNI");

		JLabel lDireccion = new JLabel("Direccion: ");

		lblDireccion = new JLabel("lblDireccion");

		JScrollPane scrollPane = new JScrollPane();

		lblTotal = new JLabel("lblTotal");

		JLabel lTotal = new JLabel("Total: ");
		GroupLayout gl_pnlBoleta = new GroupLayout(pnlBoleta);
		gl_pnlBoleta.setHorizontalGroup(
			gl_pnlBoleta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBoleta.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlBoleta.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_pnlBoleta.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.LEADING, gl_pnlBoleta.createSequentialGroup()
							.addGroup(gl_pnlBoleta.createParallelGroup(Alignment.LEADING)
								.addComponent(lDireccion)
								.addComponent(lNombre)
								.addComponent(lDni))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnlBoleta.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlBoleta.createSequentialGroup()
									.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
									.addGap(32)
									.addComponent(lApellido)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblDni, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDireccion, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
							.addContainerGap(12, Short.MAX_VALUE))
						.addGroup(gl_pnlBoleta.createSequentialGroup()
							.addComponent(lTotal)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addGap(35))
						.addGroup(Alignment.LEADING, gl_pnlBoleta.createSequentialGroup()
							.addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_pnlBoleta.setVerticalGroup(
			gl_pnlBoleta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBoleta.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFecha)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlBoleta.createParallelGroup(Alignment.BASELINE)
						.addComponent(lNombre)
						.addComponent(lApellido)
						.addComponent(lblApellido)
						.addComponent(lblNombre))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlBoleta.createParallelGroup(Alignment.BASELINE)
						.addComponent(lDni)
						.addComponent(lblDni))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlBoleta.createParallelGroup(Alignment.BASELINE)
						.addComponent(lDireccion)
						.addComponent(lblDireccion))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlBoleta.createParallelGroup(Alignment.BASELINE)
						.addComponent(lTotal)
						.addComponent(lblTotal))
					.addContainerGap(98, Short.MAX_VALUE))
		);

		tblBoleta = new JTable(new BoletaTableModel());
		scrollPane.setViewportView(tblBoleta);
		pnlBoleta.setLayout(gl_pnlBoleta);
		contentPane.setLayout(gl_contentPane);
	}

	public void inicializar(Venta venta) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lblFecha.setText(sdf.format(venta.getFecha()));
		
		Cliente cliente = venta.getNotaPedido().getCliente();
		
		lblNombre.setText(cliente.getNombre());
		lblApellido.setText(cliente.getApellido());
		lblDni.setText(cliente.getDni());
		lblDireccion.setText(cliente.getDireccionNegocio());
		
		BoletaTableModel tableModel = (BoletaTableModel) tblBoleta.getModel();
		tableModel.setLstNotaPedidoProducto(new ArrayList<NotaPedidoProducto>(venta.getNotaPedido().getNotaPedidoProductos()));
		
		lblTotal.setText(tableModel.calcularSuma().toString());
	}

	private void imprimir() {
		try {
			PrinterJob job = PrinterJob.getPrinterJob();
			job.setPrintable(this);
			job.printDialog();
			job.print();
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
			throws PrinterException {
		if (pageIndex > 0) { /* We have only one page, and 'page' is zero-based */
			return NO_SUCH_PAGE;
		}

		Graphics2D g2d = (Graphics2D) graphics;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

		pnlBoleta.printAll(graphics);

		return PAGE_EXISTS;
	}
}
