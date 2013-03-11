package com.mini.venta.vista;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.mini.venta.entities.Empleado;
import com.mini.venta.entities.NotaPedido;
import com.mini.venta.vista.support.ShareData;

import java.awt.Frame;
import javax.swing.JSeparator;

@Component
public class FrmMenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private PanelBienvenida panelBienvenida;
	
//	@Autowired
//	private FrmLogin frmLogin;
	
	@Autowired
	private ShareData shareData;
	
	@Autowired
	private PanelMenuCliente panelMenuClientes;
	
	@Autowired
	private PanelMenuProducto panelMenuProducto;
	
	@Autowired
	private PanelMenuEmpleado panelMenuEmpleado;
	
	@Autowired
	private PanelNuevaNotaPedido panelNuevaNotaPedido;
	
	@Autowired
	private PanelBusquedaNotaPedido panelBusquedaNotaPedido;
	
	@Autowired
	private PanelFinalizarVenta panelFinalizarVenta;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenuPrincipal frame = new FrmMenuPrincipal();
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
	@Autowired
	public FrmMenuPrincipal(PanelBienvenida pnlBienvenida) {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		this.panelBienvenida = pnlBienvenida;
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1133, 773);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("@@@mntmSalir");
				System.exit(0);
//				FrmMenuPrincipal.this.setVisible(false);
//				frmLogin.setVisible(true);
			}
		});
		
		JMenuItem mntmInicio = new JMenuItem("Inicio");
		mntmInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				setContentPane(panelBienvenida);
				validate();
		        repaint();
			}
		});
		mnSistema.add(mntmInicio);
		
		mnSistema.add(mntmSalir);
		
		JMenu mnVenta = new JMenu("Venta");
		menuBar.add(mnVenta);
		
		JMenuItem mntmNuevaNotaPedido = new JMenuItem("Nueva Nota Pedido");
		mntmNuevaNotaPedido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				setContentPane(panelNuevaNotaPedido);
				validate();
		        repaint();
			}
		});
		mnVenta.add(mntmNuevaNotaPedido);
		
		JMenuItem mntmBusquedaNotaPedido = new JMenuItem("Busqueda Nota Pedido");
		mntmBusquedaNotaPedido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				setContentPane(panelBusquedaNotaPedido);
				validate();
		        repaint();
			}
		});
		mnVenta.add(mntmBusquedaNotaPedido);
		
		JMenuItem mntmFinalizarVenta = new JMenuItem("Finalizar venta");
		mntmFinalizarVenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				setContentPane(panelFinalizarVenta);
				validate();
		        repaint();
			}
		});
		mnVenta.add(mntmFinalizarVenta);
		
		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				setContentPane(panelMenuClientes);
				validate();
		        repaint();
			}
		});
		mnMantenimiento.add(mntmClientes);
		
		JMenuItem mntmProductos = new JMenuItem("Productos");
		mntmProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				setContentPane(panelMenuProducto);
				validate();
		        repaint();
			}
		});
		mnMantenimiento.add(mntmProductos);
		
		JMenuItem mntmEmpleados = new JMenuItem("Empleados");
		mntmEmpleados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				setContentPane(panelMenuEmpleado);
				validate();
		        repaint();
			}
		});
		mnMantenimiento.add(mntmEmpleados);
		
		JSeparator separator = new JSeparator();
		mnMantenimiento.add(separator);
		
		JMenuItem mntmMarca = new JMenuItem("Marca");
		mnMantenimiento.add(mntmMarca);
		
		JMenuItem mntmModelo = new JMenuItem("Modelo");
		mnMantenimiento.add(mntmModelo);
		
		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		JMenuItem mntmReporteVentas = new JMenuItem("Reporte Ventas");
		mnReportes.add(mntmReporteVentas);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmVistaRapida = new JMenuItem("Vista Rapida");
		mnAyuda.add(mntmVistaRapida);
		
		//Set JPanel PanelBienvenida
		setContentPane(panelBienvenida);
	}

	public void colocarBienvenida(){
		setContentPane(panelBienvenida);
		Empleado empleado = (Empleado) shareData.getMapData().get("empleado");
		
		panelBienvenida.setLblNombreDeEmpleado(empleado.getApellido() + ", " + empleado.getNombre());
		panelBienvenida.setLblCargo(empleado.getCargo().getNombre());
		validate();
        repaint();
        setExtendedState(Frame.MAXIMIZED_BOTH);
	}
	
	public void colocarPanelFinalizarVenta(NotaPedido notaPedido){
		
		if (notaPedido == null) {
			//no hay datos para inicializar panel
		} else {
			panelFinalizarVenta.inicializar(notaPedido);
		}
		
		setContentPane(panelFinalizarVenta);
		validate();
        repaint();
	}
}
