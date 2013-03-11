package com.mini.venta.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.mini.venta.entities.NotaPedidoProducto;
import com.mini.venta.entities.Producto;
import com.mini.venta.service.intefaces.ProductoService;
import com.mini.venta.vista.support.ProductoTableModel;

@Component
public class FrmBuscarProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtTextBuscar;
	private JTable tblProducto;
	private JComboBox cboBuscarPor;
	
	private final int ELEMENTOS_POR_PAGINA = 20;
	
	@Autowired
	private PanelNuevaNotaPedido panelNuevaNotaPedido;
	
	@Autowired
	private ProductoService productoService;

	List<Producto> lstProducto;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrmBuscarProducto frame = new FrmBuscarProducto();
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
	public FrmBuscarProducto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 737, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Buscar por: ");
		
		cboBuscarPor = new JComboBox();
		cboBuscarPor.setModel(new DefaultComboBoxModel(new String[] {"Nombre o Descripcion", "Codigo", "Marca", "Modelo"}));
		
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
		
		JButton btnElegirYContinuar = new JButton("Elegir y continuar");
		btnElegirYContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				elegirYContinuar();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(cboBuscarPor, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(txtTextBuscar, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
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
					.addGap(12)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnElegirYContinuar)
					.addContainerGap(122, Short.MAX_VALUE))
		);
		
		tblProducto = new JTable();
		scrollPane.setViewportView(tblProducto);
		contentPane.setLayout(gl_contentPane);
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

	private void buscarProducto() {
		llenarTablaProducto();
	}
	
	private void elegirYContinuar() {
		NotaPedidoProducto npp = new NotaPedidoProducto();
		Producto producto = lstProducto.get(tblProducto.getSelectedRow());
		
		npp.setProducto(producto);
		
		npp.setProducto(producto);
		npp.setDescripcion(producto.getDescripcion());
		npp.setPrecio(producto.getPrecioUnidad());
		npp.setCantidad(new Long("0"));
		npp.setDescuento(new BigDecimal(0));
		
		panelNuevaNotaPedido.agregarLstNotaPedidoProducto(npp);
		panelNuevaNotaPedido.validate();
		panelNuevaNotaPedido.repaint();
		
		dispose();
	}
}
