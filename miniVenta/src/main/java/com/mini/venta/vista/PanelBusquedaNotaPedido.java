package com.mini.venta.vista;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mini.venta.entities.NotaPedido;
import com.mini.venta.service.intefaces.NotaPedidoService;
import com.mini.venta.vista.support.NotaPedidoTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

@Component
public class PanelBusquedaNotaPedido extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtBuscarPor;
	private JTable tblNotaPedido;
	private JComboBox cboBuscarPor;

	@Autowired
	private FrmMenuPrincipal frmMenuPrincipal;
	
	@Autowired
	private NotaPedidoService notaPedidoService;
	
	private List<NotaPedido> lstNotaPedido;
	/**
	 * Create the panel.
	 */
	public PanelBusquedaNotaPedido() {
		
		JLabel label = new JLabel("Buscar por: ");
		
		cboBuscarPor = new JComboBox();
		cboBuscarPor.setModel(new DefaultComboBoxModel(new String[] {"Id Nota Pedido"}));
		
		txtBuscarPor = new JTextField();
		txtBuscarPor.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				buscarNotaPedido();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnFinalizarVenta = new JButton("Finalizar venta");
		btnFinalizarVenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				finalizarVenta(tblNotaPedido.getSelectedRow());
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(cboBuscarPor, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(txtBuscarPor, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())
						.addComponent(btnFinalizarVenta, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(label))
						.addComponent(cboBuscarPor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(txtBuscarPor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnBuscar))
					.addGap(12)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnFinalizarVenta)
					.addGap(34))
		);
		
		tblNotaPedido = new JTable();
		scrollPane.setViewportView(tblNotaPedido);
		setLayout(groupLayout);

	}

	protected void finalizarVenta(int index) {
		frmMenuPrincipal.colocarPanelFinalizarVenta(lstNotaPedido.get(index));
	}

	protected void buscarNotaPedido() {
		NotaPedido notaPedido = notaPedidoService.findOne(Long.parseLong(txtBuscarPor.getText()));
		
		if (notaPedido != null) {
			lstNotaPedido = new ArrayList<NotaPedido>();
			lstNotaPedido.add(notaPedido);
			
			NotaPedidoTableModel notaPedidoTableModel = new NotaPedidoTableModel(lstNotaPedido);
			tblNotaPedido.setModel(notaPedidoTableModel);
			
			validate();
			repaint();
		} else {
			JOptionPane.showMessageDialog(null,"La nota de pedido no existe.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
