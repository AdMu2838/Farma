package guis;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.InternalFrameEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDayChooser;

import gestores.GestorProducto;
import gestores.GestorProveedor;
import modelo.Cliente;
import modelo.Producto;
import modelo.Proveedor;

import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.event.InternalFrameListener;

public class GuiProducto extends JInternalFrame implements ActionListener, InternalFrameListener {

	public JTextField txtCodigo;
	public JTextField txtNombre;
	public JTextField txtPrecio;
	private JLabel lblStock;
	private JLabel lblFechaVencimientto;
	private JDateChooser datFecha;
	public JTextField txtStock;
	public JTable tblLista;
	private JButton btnRegistrar;
	private JButton btnCerrar;
	private JButton btnEditar;
	
	public static String pro;
	private JScrollPane scrollPane;
	public JButton btnEliminar;
	private JLabel lblNewLabel;
	private JComboBox cboProveedor;
	GestorProducto gestorProducto = new GestorProducto();
	GestorProveedor gestorProveedor = new GestorProveedor();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiProducto frame = new GuiProducto();
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
	public GuiProducto() {
		addInternalFrameListener(this);
		pro=pro;
		getContentPane().setBackground(new Color(175, 238, 238));
		setBounds(100, 100, 626, 510);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setLayout(null);
		panel.setToolTipText("");
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 245, 245), new Color(0, 0, 0)), "MANTENIMIENTO DE PRODUCTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel.setBounds(30, 11, 330, 197);
		getContentPane().add(panel);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Arial", Font.BOLD, 12));
		lblCodigo.setBounds(10, 22, 55, 14);
		panel.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
		lblNombre.setBounds(10, 47, 55, 20);
		panel.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Arial", Font.BOLD, 12));
		lblPrecio.setBounds(10, 106, 55, 14);
		panel.add(lblPrecio);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(118, 22, 190, 20);
		panel.add(txtCodigo);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(118, 50, 190, 20);
		panel.add(txtNombre);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(118, 106, 190, 20);
		panel.add(txtPrecio);
		
		lblFechaVencimientto = new JLabel("Fecha de Vencimiento");
		lblFechaVencimientto.setFont(new Font("Arial", Font.BOLD, 12));
		lblFechaVencimientto.setBounds(10, 134, 128, 14);
		panel.add(lblFechaVencimientto);
		
		datFecha = new JDateChooser();
		datFecha.setBounds(142, 131, 166, 20);
		panel.add(datFecha);
		
		lblStock = new JLabel("Stock:");
		lblStock.setFont(new Font("Arial", Font.BOLD, 12));
		lblStock.setBounds(10, 160, 46, 14);
		panel.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setBounds(118, 160, 190, 20);
		panel.add(txtStock);
		txtStock.setColumns(10);
		
		lblNewLabel = new JLabel("Proveedor");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 78, 74, 14);
		panel.add(lblNewLabel);
		
		cboProveedor = new JComboBox();
		cboProveedor.setBounds(118, 77, 190, 22);
		panel.add(cboProveedor);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 236, 588, 197);
		getContentPane().add(scrollPane);
		
		tblLista = new JTable();
		tblLista.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tblListaMousePressed(e);
			}
		});
		tblLista.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CODIGO", "NOMBRE", "PROVEEDOR (ID)", "PRECIO", "FECHA DE VENCIMIENTO", "STOCK"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Object.class, Double.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblLista.getColumnModel().getColumn(1).setPreferredWidth(187);
		tblLista.getColumnModel().getColumn(3).setPreferredWidth(103);
		tblLista.getColumnModel().getColumn(4).setPreferredWidth(141);
		tblLista.getColumnModel().getColumn(5).setPreferredWidth(96);
		scrollPane.setViewportView(tblLista);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setIcon(new ImageIcon(GuiProducto.class.getResource("/img/registro.png")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnRegistrar.setBounds(397, 42, 196, 29);
		getContentPane().add(btnRegistrar);
		
		btnEditar = new JButton("ACTUALIZAR");
		btnEditar.setIcon(new ImageIcon(GuiProducto.class.getResource("/img/actualizar-base-de-datos.png")));
		btnEditar.addActionListener(this);
		btnEditar.setFont(new Font("Arial", Font.BOLD, 12));
		btnEditar.setBounds(397, 82, 196, 29);
		getContentPane().add(btnEditar);
		
		btnCerrar = new JButton("CERRAR");
		btnCerrar.setIcon(new ImageIcon(GuiProducto.class.getResource("/img/closing.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnCerrar.setBounds(442, 444, 156, 25);
		getContentPane().add(btnCerrar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setIcon(new ImageIcon(GuiProducto.class.getResource("/img/eliminar.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 12));
		btnEliminar.setBounds(397, 122, 196, 29);
		getContentPane().add(btnEliminar);
		CargarLista();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnEditar) {
			handle_btnEditar_actionPerformed(e);
		}
		if (e.getSource() == btnCerrar) {
			handle_btnCerrar_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrar) {
			handle_btnNuevo_actionPerformed(e);
		}
	}
	void CargarLista() {
		ArrayList<Producto> lista = gestorProducto.listar();
		
		DefaultTableModel modelo = (DefaultTableModel) tblLista.getModel();
		modelo.getDataVector().clear();
		
		for(Producto obj : lista) {
			Object[] data = {obj.getCodigo(), obj.getNombre(), obj.getCodProv(), obj.getPrecio(),obj.getFecha(),obj.getStock()};
			modelo.addRow(data);
		}
	}
	
	void LimpiarFormulario() {
		txtCodigo.setText("");
		txtNombre.setText("");
		cboProveedor.setSelectedIndex(0);
		txtPrecio.setText("");
		datFecha.setDate(new Date());
		txtStock.setText("");
		
	}
	
	boolean codigo() {
		String cod = txtCodigo.getText();
		Pattern pat = Pattern.compile("^[P][0-9]{4}$");
		Matcher mat = pat.matcher(cod);
		if (mat.find()) {
			return true;
		}else
			return false;
	}
	
	protected void handle_btnNuevo_actionPerformed(ActionEvent e) {
		if(codigo()==true) {
			if(txtNombre.getText().length()>0) {
				if(txtPrecio.getText().length()>0) {
					if(txtStock.getText().length()>0) {
						Producto obj = new Producto();
						obj.setCodigo(txtCodigo.getText());
						obj.setNombre(txtNombre.getText());
						obj.setCodProv(cboProveedor.getSelectedIndex()+1);
						obj.setPrecio(Double.parseDouble(txtPrecio.getText()));
						obj.setFecha(new SimpleDateFormat("yyyy-MM-dd").format(datFecha.getDate()));
						obj.setStock(Integer.parseInt(txtStock.getText()));
						
						int resultado = gestorProducto.registrar(obj);
						
						if(resultado == 1) {
							JOptionPane.showMessageDialog(this, "Se registró el producto");
							CargarLista();
							LimpiarFormulario();
						}
						else {
							JOptionPane.showMessageDialog(this, "No se pudo registrar el producto");
						}
					}else
						JOptionPane.showMessageDialog(this, "Ingrese el stock del producto.");					
				}else
					JOptionPane.showMessageDialog(this, "Ingrese el precio del producto.");					
			}else
				JOptionPane.showMessageDialog(this, "Ingrese el nombre del producto.");		
		}else
			JOptionPane.showMessageDialog(this, "Ingrese el codigo del producto. Formato PXXXX");
		
	}
	
	void CargarProducto(String codigo) {
		Producto obj = gestorProducto.obtener(codigo);
		if(obj.getCodigo() != null) {	
			txtCodigo.setText(obj.getCodigo());
			txtNombre.setText(obj.getNombre());
			cboProveedor.getSelectedItem();
			txtPrecio.setText(String.valueOf(obj.getPrecio()));
			datFecha.setDate(new Date());
			txtStock.setText(String.valueOf(obj.getStock()));
		}
	}
	protected void tblListaMousePressed(MouseEvent e) {
		String codigo = (String) tblLista.getValueAt(tblLista.getSelectedRow(), 0);
		txtCodigo.setText("" + codigo);
		CargarProducto(codigo);
	}
	protected void handle_btnCerrar_actionPerformed(ActionEvent e) {
		dispose();
		pro=null;
	}
	protected void handle_btnEditar_actionPerformed(ActionEvent e) {
		if(!txtCodigo.getText().equals("")) {
			if(codigo()==true) {
				if(txtNombre.getText().length()>0) {
					if(txtPrecio.getText().length()>0) {
						if(txtStock.getText().length()>0) {
							Producto obj = new Producto();
							obj.setCodigo(txtCodigo.getText());
							obj.setNombre(txtNombre.getText());
							obj.setCodProv(cboProveedor.getSelectedIndex()+1);
							obj.setPrecio(Double.parseDouble(txtPrecio.getText()));
							obj.setFecha(new SimpleDateFormat("yyyy-MM-dd").format(datFecha.getDate()));
							obj.setStock(Integer.parseInt(txtStock.getText()));
							
							
							int resultado = gestorProducto.actualizar(obj);
							
							if(resultado == 1) {
								JOptionPane.showMessageDialog(this, "Se actualizó el producto");
								CargarLista();
								LimpiarFormulario();
							}
							else {
								JOptionPane.showMessageDialog(this, "No se pudo actualizar el producto");
							}
						}else
							JOptionPane.showMessageDialog(this, "Ingrese el stock del producto.");					
					}else
						JOptionPane.showMessageDialog(this, "Ingrese el precio del producto.");					
				}else
					JOptionPane.showMessageDialog(this, "Ingrese el nombre del producto.");		
			}else
				JOptionPane.showMessageDialog(this, "Ingrese el codigo del producto. Formato PXXXX");	
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		if(!txtCodigo.getText().equals("")) {
			if(JOptionPane.showConfirmDialog(null, "Se eliminar� el registro seleccionado. �Desea continuar?", 
						"PuercoFarma", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				String codigo = txtCodigo.getText();
				int resultado = gestorProducto.eliminar(codigo);
				
				if(resultado == 1) {
					JOptionPane.showMessageDialog(this, "Se eliminó el producto");					
					LimpiarFormulario();
					
				}
				else {
					JOptionPane.showMessageDialog(this, "No se pudo eliminar el producto");
				}
				CargarLista();
			}
			
		}
	}
	void CargarProveedor() {
		ArrayList<Proveedor> lista = gestorProveedor.listar();
		for (Proveedor proveedor:lista) {
			cboProveedor.addItem(proveedor);
		}
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
		CargarProveedor();
	}
}
