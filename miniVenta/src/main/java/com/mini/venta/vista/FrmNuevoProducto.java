package com.mini.venta.vista;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mini.venta.entities.Marca;
import com.mini.venta.entities.Modelo;
import com.mini.venta.entities.Producto;
import com.mini.venta.service.intefaces.MarcaService;
import com.mini.venta.service.intefaces.ModeloService;
import com.mini.venta.service.intefaces.ProductoService;
import com.mini.venta.vista.support.JTextFieldMaxCharLimit;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class FrmNuevoProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtFecha;
	private JTextField txtNombre;
	private JTextField txtPrecioxUnidad;
	private JTextField txtStock;
	private JTextField txtPrecioxMayor;
	private JTextField txtColor;
	private JTextArea txtDescripcion;
	private JComboBox cboModelo;
	private JComboBox cboMarca;
	private JButton btnCancelar;
	private JButton btnAgregar;
	
	private Date fecha;
	
	private MarcaService marcaService;
	
	private ModeloService modeloService;
	
	private Producto productoToModify;
	
	@Autowired
	private PanelMenuProducto panelMenuProducto;
	
	@Autowired
	private ProductoService productoService;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrmNuevoProducto frame = new FrmNuevoProducto();
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
	public FrmNuevoProducto(MarcaService marcaService, ModeloService modeloService) {
		
		this.marcaService = marcaService;
		this.modeloService = modeloService;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 514, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCodigo = new JLabel("Codigo: ");
		
		JLabel lblFecha = new JLabel("Fecha: ");
		
		JLabel lblNombre = new JLabel("Nombre: ");
		
		JLabel lblPrecioXUnidad = new JLabel("Precio x Unidad: ");
		
		JLabel lblPrecioXMayor = new JLabel("Precio x Mayor: ");
		
		JLabel lblStock = new JLabel("Stock: ");
		
		JLabel lblColor = new JLabel("Color: ");
		
		JLabel lblDescripcion = new JLabel("Descripcion: ");
		
		JLabel lblMarca = new JLabel("Marca: ");
		
		JLabel lblModelo = new JLabel("Modelo: ");
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setDocument(new JTextFieldMaxCharLimit(10));
		
		txtFecha = new JTextField();
		txtFecha.setEnabled(false);
		txtFecha.setColumns(15);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(20);
		
		txtPrecioxUnidad = new JTextField();
		txtPrecioxUnidad.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setColumns(4);
		
		txtPrecioxMayor = new JTextField();
		txtPrecioxMayor.setColumns(10);
		
		txtColor = new JTextField();
		txtColor.setColumns(10);
		
		cboModelo = new JComboBox();
		
		cboMarca = new JComboBox();
		cboMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				llenarCboModelo((Marca)cboMarca.getSelectedItem());
			}
		});
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					btnAgregarProducto();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(79)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblFecha)
								.addComponent(lblCodigo)
								.addComponent(lblNombre)
								.addComponent(lblPrecioXMayor)
								.addComponent(lblStock)
								.addComponent(lblColor)
								.addComponent(lblDescripcion)
								.addComponent(lblMarca)
								.addComponent(lblModelo)
								.addComponent(lblPrecioXUnidad)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnAgregar)
							.addGap(8)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(cboModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cboMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNombre)
								.addComponent(txtPrecioxUnidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPrecioxMayor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtStock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(85)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigo)
						.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFecha)
						.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecioXUnidad)
						.addComponent(txtPrecioxUnidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrecioXMayor)
						.addComponent(txtPrecioxMayor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStock)
						.addComponent(txtStock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblColor))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMarca)
								.addComponent(cboMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblModelo)
								.addComponent(cboModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblDescripcion))
					.addGap(103)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnAgregar))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setRows(2);
		txtDescripcion.setColumns(20);
		scrollPane.setViewportView(txtDescripcion);
		contentPane.setLayout(gl_contentPane);
		
		llenarCboMarca();
		llenarCboModelo((Marca)cboMarca.getItemAt(0));
	}
	
	public void inicializar() {
		setTitle("Nuevo Producto");
		btnAgregar.setText("Agregar");

		txtCodigo.setText("");

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy h:mm");
		fecha = new Date();
		txtFecha.setText(sdf.format(fecha));

		txtNombre.setText("");
		txtPrecioxUnidad.setText("");
		txtPrecioxMayor.setText("");
		txtStock.setText("");
		txtColor.setText("");
		txtDescripcion.setText("");
		
		cboMarca.setSelectedIndex(0);
		cboModelo.setSelectedIndex(0);
	}
	
	private void llenarCboMarca() {
		List<Marca> lst = marcaService.findAll();
		Marca[] marcas = new Marca[lst.size()];
		for (int i = 0; i < lst.size(); i++) {
			marcas[i] = lst.get(i);
		}

		cboMarca.setModel(new DefaultComboBoxModel(marcas));
	}
	
	private void llenarCboModelo(Marca marca) {
		List<Modelo> lst = modeloService.findByMarca(marca);
		Modelo[] modelos = new Modelo[lst.size()];
		for (int i = 0; i < lst.size(); i++) {
			modelos[i] = lst.get(i);
		}

		cboModelo.setModel(new DefaultComboBoxModel(modelos));
	}
	
	private void btnAgregarProducto() throws Exception {
		if (btnAgregar.getText().equalsIgnoreCase("Agregar")) {
			Producto producto = new Producto();
			producto.setCodigo(txtCodigo.getText());
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy h:mm");
			producto.setFecha(sdf.parse(txtFecha.getText()));
			
			producto.setNombre(txtNombre.getText());
			producto.setPrecioUnidad(BigDecimal.valueOf(Double.parseDouble(txtPrecioxUnidad.getText())));
			producto.setPrecioMayor(BigDecimal.valueOf(Double.parseDouble(txtPrecioxMayor.getText())));
			producto.setStock(Integer.parseInt((txtStock.getText())));
			producto.setColor(txtColor.getText());
			producto.setDescripcion(txtDescripcion.getText());
			producto.setMarca((Marca) cboMarca.getSelectedItem());
			producto.setModelo((Modelo) cboModelo.getSelectedItem());

			productoService.save(producto);
			
		} else {
			productoToModify.setCodigo(txtCodigo.getText());
			
			productoToModify.setNombre(txtNombre.getText());
			productoToModify.setPrecioUnidad(BigDecimal.valueOf(Double.parseDouble(txtPrecioxUnidad.getText())));
			productoToModify.setPrecioMayor(BigDecimal.valueOf(Double.parseDouble(txtPrecioxMayor.getText())));
			productoToModify.setStock(Integer.parseInt((txtStock.getText())));
			productoToModify.setColor(txtColor.getText());
			productoToModify.setDescripcion(txtDescripcion.getText());
			productoToModify.setMarca((Marca) cboMarca.getSelectedItem());
			productoToModify.setModelo((Modelo) cboModelo.getSelectedItem());

			productoService.save(productoToModify);
		}

		dispose();
		
		panelMenuProducto.llenarTablaProducto();
	}
	
	public void mostrarDatosProducto(Producto producto) {
		productoToModify = producto;
		setTitle("Modificar Producto");
		btnAgregar.setText("Efectuar Cambios");

		txtCodigo.setText(producto.getCodigo());

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy h:mm");
		txtFecha.setText(sdf.format(producto.getFecha()));

		txtNombre.setText(producto.getNombre());
		txtPrecioxUnidad.setText(producto.getPrecioUnidad().toString());
		txtPrecioxMayor.setText(producto.getPrecioMayor().toString());
		txtStock.setText(String.valueOf(producto.getStock()));
		txtColor.setText(producto.getColor());
		txtDescripcion.setText(producto.getDescripcion());

		cboMarca.getModel().setSelectedItem(producto.getMarca());
		cboModelo.getModel().setSelectedItem(producto.getModelo());
	}
}
