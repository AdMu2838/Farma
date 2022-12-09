package guis;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gestores.GestorProducto;
import modelo.Producto;
import modelo.ProductoVendido;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class GuiProductoVendido extends JInternalFrame implements ActionListener {

	private JScrollPane scrollPane;
	private JTable tblProducto;
	public static String proVen;
	
	GestorProducto gestorProducto = new GestorProducto();
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiProductoVendido frame = new GuiProductoVendido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiProductoVendido() {
		getContentPane().setBackground(new Color(175, 238, 238));
		setBounds(100, 100, 528, 371);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 492, 282);
		getContentPane().add(scrollPane);
		
		tblProducto = new JTable();
		tblProducto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo Producto", "Cantidad"
			}
		));
		scrollPane.setViewportView(tblProducto);
		
		btnCerrar = new JButton("CERRAR");
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(GuiProductoVendido.class.getResource("/img/closing.png")));
		btnCerrar.setBounds(387, 304, 115, 23);
		getContentPane().add(btnCerrar);
		CargarLista();
	}
	
	void CargarLista() {
		ArrayList<ProductoVendido> lista = gestorProducto.listar1();
		
		DefaultTableModel modelo = (DefaultTableModel)tblProducto.getModel();
		modelo.getDataVector().clear();
		
		for(ProductoVendido obj : lista) {
			Object[] data = {obj.getCodigoProducto(), obj.getCantidad()};
			modelo.addRow(data);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
		proVen=null;
	}

}
