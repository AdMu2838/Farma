package guis;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gestores.GestorProducto;
import modelo.Producto;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class GuiConsultaProducto extends JInternalFrame implements ActionListener {

	public static String conPro;
	private JLabel lblNewLabel;
	private JTextField txtNombreProducto;
	private JButton btnBuscar;
	private JScrollPane scrollPane;
	private JTable tblProducto;
	GestorProducto gestorProducto=new GestorProducto();
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiConsultaProducto frame = new GuiConsultaProducto();
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
	public GuiConsultaProducto() {
		getContentPane().setBackground(new Color(175, 238, 238));
		setBounds(100, 100, 568, 326);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Nombre del producto");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 17, 136, 14);
		getContentPane().add(lblNewLabel);
		
		txtNombreProducto = new JTextField();
		txtNombreProducto.setBounds(172, 15, 244, 20);
		getContentPane().add(txtNombreProducto);
		txtNombreProducto.setColumns(10);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setIcon(new ImageIcon(GuiConsultaProducto.class.getResource("/img/buscar.png")));
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(426, 7, 116, 35);
		getContentPane().add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 532, 206);
		getContentPane().add(scrollPane);
		
		tblProducto = new JTable();
		tblProducto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CODIGO", "NOMBRE", "CODIGO PROVEEDOR", "PRECIO PRODUCTO", "FECHA DE VENCIMIENTO", "STOCK"
			}
		));
		scrollPane.setViewportView(tblProducto);
		
		btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(this);
		btnNewButton.setIcon(new ImageIcon(GuiConsultaProducto.class.getResource("/img/closing.png")));
		btnNewButton.setBounds(453, 270, 89, 23);
		getContentPane().add(btnNewButton);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}
	private void listarUsuarios(ArrayList<Producto> lista) {
		
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		lista = gestorProducto.buscarXNombre(txtNombreProducto.getText());
		if(lista != null) {
			
			DefaultTableModel modelo = (DefaultTableModel) tblProducto.getModel();
			modelo.getDataVector().clear();
			
			for(Producto obj : lista) {
				Object[] data = {obj.getCodigo(), obj.getNombre(), obj.getCodProv(), obj.getPrecio(), obj.getFecha(),obj.getStock()};
				modelo.addRow(data);
			}
		}
			
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		dispose();
		conPro=null;
	}

}
