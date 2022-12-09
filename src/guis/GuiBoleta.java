package guis;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import gestores.GestorBoleta;
import gestores.GestorCliente;
import gestores.GestorEmpleado;
import gestores.GestorProducto;
import modelo.Boleta;
import modelo.BoletaDetalle;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Producto;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.InternalFrameEvent;
public class GuiBoleta extends JInternalFrame implements ActionListener, InternalFrameListener {

	public JTextField txtBoleta;
	public JTextField txtFecha;
	public JTextField txtDni;
	public JTable tblProductos;
	private JButton btnNuevo;
	
	public static String bol;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnBuscar;
	private JTextField txtCliente;
	private JLabel lblNewLabel_2;
	private JComboBox cboEmpleado;
	private JLabel lblNewLabel_3;
	private JTextField txtCodigoProducto;
	private JButton btnBuscar_1;
	private JTextField txtNomProducto;
	private JLabel lblNewLabel_4;
	private JTextField txtPrecio;
	private JLabel lblNewLabel_5;
	private JTextField txtCantidad;
	private JPanel panel_1;
	private JLabel lblNewLabel_6;
	private JTextField txtTotal;
	private JButton btnRegistrar;
	
	//GESTORES DE ACCESORIOS
	private GestorEmpleado gestorEmpleado = new GestorEmpleado();
	private GestorCliente gestorCliente = new GestorCliente ();
	private GestorProducto gestorProducto = new GestorProducto ();
	private JTextField txtCodCliente;
	
	private Boleta boleta;
	private JButton btnAgregar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiBoleta frame = new GuiBoleta();
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
	public GuiBoleta() {
		addInternalFrameListener(this);
		getContentPane().setFont(new Font("Arial", Font.BOLD, 12));
		bol=bol;
		getContentPane().setBackground(new Color(176, 224, 230));
		setBounds(100, 100, 657, 570);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setToolTipText("");
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 245, 245), new Color(0, 0, 0)), "INFORME DE ORDEN DE PEDIDO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(21, 11, 566, 223);
		getContentPane().add(panel);
		
		JLabel lblNumeroBoleta = new JLabel("Numero de Boleta:");
		lblNumeroBoleta.setFont(new Font("Arial", Font.BOLD, 12));
		lblNumeroBoleta.setBounds(10, 25, 118, 14);
		panel.add(lblNumeroBoleta);
		
		txtBoleta = new JTextField();
		txtBoleta.setColumns(10);
		txtBoleta.setBounds(138, 22, 102, 20);
		panel.add(txtBoleta);
		
		txtFecha = new JTextField();
		txtFecha.setEnabled(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(138, 50, 102, 20);
		panel.add(txtFecha);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(138, 78, 102, 20);
		panel.add(txtDni);
		
		lblNewLabel = new JLabel("Fecha");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 53, 46, 14);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Cliente");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 81, 46, 14);
		panel.add(lblNewLabel_1);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setIcon(new ImageIcon(GuiBoleta.class.getResource("/img/order.png")));
		btnNuevo.setBounds(405, 16, 123, 32);
		panel.add(btnNuevo);
		btnNuevo.addActionListener(this);
		btnNuevo.setFont(new Font("Arial", Font.BOLD, 12));
		btnNuevo.setBackground(new Color(176, 196, 222));
		
		btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(GuiBoleta.class.getResource("/img/buscar.png")));
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(244, 77, 34, 23);
		panel.add(btnBuscar);
		
		txtCliente = new JTextField();
		txtCliente.setEnabled(false);
		txtCliente.setBounds(328, 78, 228, 20);
		panel.add(txtCliente);
		txtCliente.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Empleado");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 106, 71, 14);
		panel.add(lblNewLabel_2);
		
		cboEmpleado = new JComboBox();
		cboEmpleado.setBounds(138, 102, 139, 22);
		panel.add(cboEmpleado);
		
		lblNewLabel_3 = new JLabel("Producto");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 136, 71, 14);
		panel.add(lblNewLabel_3);
		
		txtCodigoProducto = new JTextField();
		txtCodigoProducto.setColumns(10);
		txtCodigoProducto.setBounds(138, 133, 102, 20);
		panel.add(txtCodigoProducto);
		
		btnBuscar_1 = new JButton("");
		btnBuscar_1.setIcon(new ImageIcon(GuiBoleta.class.getResource("/img/buscar.png")));
		btnBuscar_1.addActionListener(this);
		btnBuscar_1.setBounds(244, 132, 34, 23);
		panel.add(btnBuscar_1);
		
		txtNomProducto = new JTextField();
		txtNomProducto.setEnabled(false);
		txtNomProducto.setColumns(10);
		txtNomProducto.setBounds(288, 133, 244, 20);
		panel.add(txtNomProducto);
		
		lblNewLabel_4 = new JLabel("Precio");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 161, 46, 14);
		panel.add(lblNewLabel_4);
		
		txtPrecio = new JTextField();
		txtPrecio.setEnabled(false);
		txtPrecio.setBounds(138, 158, 102, 20);
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Cantidad");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setBounds(244, 161, 58, 14);
		panel.add(lblNewLabel_5);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(312, 158, 94, 20);
		panel.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		txtCodCliente = new JTextField();
		txtCodCliente.setEnabled(false);
		txtCodCliente.setBounds(279, 78, 46, 20);
		panel.add(txtCodCliente);
		txtCodCliente.setColumns(10);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(416, 157, 89, 23);
		panel.add(btnAgregar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 259, 566, 164);
		getContentPane().add(scrollPane);
		
		tblProductos = new JTable();
		tblProductos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Item", "Codigo", "Producto", "Cantidad", "Precio", "Subtotal"
			}
		));
		scrollPane.setViewportView(tblProductos);
		
		panel_1 = new JPanel();
		panel_1.setBounds(420, 434, 167, 38);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_6 = new JLabel("Total");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 11, 46, 14);
		panel_1.add(lblNewLabel_6);
		
		txtTotal = new JTextField();
		txtTotal.setEnabled(false);
		txtTotal.setBounds(66, 8, 86, 20);
		panel_1.add(txtTotal);
		txtTotal.setColumns(10);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setIcon(new ImageIcon(GuiBoleta.class.getResource("/img/registro.png")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 13));
		btnRegistrar.setBounds(203, 434, 186, 38);
		getContentPane().add(btnRegistrar);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
		if (e.getSource() == btnBuscar_1) {
			actionPerformedBtnBuscar_1(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
	}
	void CargarEmpleado () {
		ArrayList <Empleado> lista = gestorEmpleado.listar();
		for (Empleado empleado : lista) {
			cboEmpleado.addItem(empleado);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		boleta = new Boleta();
		txtFecha.setText(new SimpleDateFormat("dd/MM/YYYY").format(new Date()));
	}
	public void internalFrameActivated(InternalFrameEvent e) {
	}
	public void internalFrameClosed(InternalFrameEvent e) {
	}
	public void internalFrameClosing(InternalFrameEvent e) {
	}
	public void internalFrameDeactivated(InternalFrameEvent e) {
	}
	public void internalFrameDeiconified(InternalFrameEvent e) {
	}
	public void internalFrameIconified(InternalFrameEvent e) {
	}
	public void internalFrameOpened(InternalFrameEvent e) {
		if (e.getSource() == this) {
			internalFrameOpenedThis(e);
		}
	}
	protected void internalFrameOpenedThis(InternalFrameEvent e) {
		CargarEmpleado();
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		Cliente obj = gestorCliente.buscarXDocumento(txtDni.getText());
		if(obj != null && obj.getCodigo() != 0 && dni()==true) {
			txtCodCliente.setText("" + obj.getCodigo());
			txtCliente.setText(obj.getNombre());
		}
		else {
			txtCodCliente.setText("");
			txtCliente.setText("");
			JOptionPane.showMessageDialog(this, "DNI INVALIDO");
		}
	}
	protected void actionPerformedBtnBuscar_1(ActionEvent e) {
		Producto obj = gestorProducto.buscarXCodigo(txtCodigoProducto.getText());
		if(obj != null && obj.getCodigo() != "" && codigoProducto()==true) {
			txtNomProducto.setText(obj.getNombre());
			txtPrecio.setText("" + obj.getPrecio());
		}
		else {
			txtNomProducto.setText("");
			txtPrecio.setText("");
			JOptionPane.showMessageDialog(this, "CODIGO PRODUCTO INVALIDO");
		}
	}
	
	boolean codigo() {
		String cod = txtBoleta.getText();
		Pattern pat = Pattern.compile("^[B][0-9]{4}$");
		Matcher mat = pat.matcher(cod);
		if (mat.find()) {
			return true;
		}else
			return false;
	}
	
	boolean codigoProducto() {
		String cod = txtCodigoProducto.getText();
		Pattern pat = Pattern.compile("^[P][0-9]{4}$");
		Matcher mat = pat.matcher(cod);
		if (mat.find()) {
			return true;
		}else
			return false;
	}
	
	boolean dni() {
		String dni = txtDni.getText();
		Pattern pat = Pattern.compile("^[1-9]{1}[0-9]{7}$");
		Matcher mat = pat.matcher(dni);
		if (mat.find()) {
			return true;
		}else
			return false;
	}
	
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		
		//if(codigo()==true) {
			if(dni()==true) {
				if(codigoProducto()==true) {
					if(txtNomProducto.getText() != "" && txtCantidad.getText() != "") {
						BoletaDetalle detalle = new BoletaDetalle();
						detalle.setProducto(txtCodigoProducto.getText());
						detalle.setProductoDescripcion(txtNomProducto.getText());
						detalle.setPrecio(Double.parseDouble(txtPrecio.getText()));
						detalle.setCantidad(Integer.parseInt(txtCantidad.getText()));
						detalle.setImporte(detalle.getPrecio() * detalle.getCantidad());
						
						// Agregamos a la lista de detalles
						boleta.getDetalles().add(detalle);
						txtTotal.setText(""+boleta.calcularTotal());
						listarDetalles();
						limpiarDetalle();
					}
				}else
					JOptionPane.showMessageDialog(this, "Error en el codigo del producto");		
			}else
				JOptionPane.showMessageDialog(this, "Error en el DNI del cliente");		
		//}else
			//JOptionPane.showMessageDialog(this, "Error en el codigo de la boleta. Formato BXXXX");
	}
	
	void listarDetalles() {
		DefaultTableModel modelo = (DefaultTableModel) tblProductos.getModel();
		modelo.getDataVector().clear();
		for (BoletaDetalle detalle : boleta.getDetalles()) {
			Object[] row = {0, detalle.getProducto(), detalle.getProductoDescripcion(), 
					detalle.getCantidad(), detalle.getPrecio(), detalle.getImporte()};
			modelo.addRow(row);
		}
	}
	void limpiarDetalle() {
		txtCodigoProducto.setText("");
		txtNomProducto.setText("");
		txtPrecio.setText("");
		txtCantidad.setText("");
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		
		//if(boleta != null && codigo()==true) {
			try {
				boleta.setFecha(new SimpleDateFormat("dd/MM/yyyy").parse(txtFecha.getText()));
				boleta.setCliente(Integer.parseInt(txtCodCliente.getText()));
				boleta.setVendedor(((Empleado)cboEmpleado.getSelectedItem()).getCodigo());
				boleta.setTotal(boleta.calcularTotal());
				
				int resultado = new GestorBoleta().registrar(boleta);
				if(resultado ==1) {
					JOptionPane.showMessageDialog(this, "SE REGISTRO LA BOLETA");
				}else {
					JOptionPane.showMessageDialog(this, "NO SE PUDO REGISTRAR LA BOLETA");
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage());
			}
			
		//}
	}
}
