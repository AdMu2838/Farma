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
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gestores.GestorProveedor;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Proveedor;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class GuiProveedor extends JInternalFrame implements ActionListener{

	public JTextField txtCodigo;
	public JTextField txtNombre;
	public JTextField txtTelefono;
	public JTextField txtDireccion;
	public JTable tblLista;
	private JButton btnRegistrar;
	
	public static String prov;
	private JScrollPane scrollPane;
	private JLabel lblDirecion;
	private JLabel lblTelefono;
	private JLabel lblNombre;
	private JLabel lblCodigo;
	private JPanel panel;
	public JButton btnEliminar;
	public JButton btnEditar_1;
	public JButton btnSalir;
	GestorProveedor gestorProveedor = new GestorProveedor();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiProveedor frame = new GuiProveedor();
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
	public GuiProveedor() {
		prov=prov;
		getContentPane().setBackground(new Color(175, 238, 238));
		setBounds(100, 100, 644, 450);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setLayout(null);
		panel.setToolTipText("");
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 245, 245), new Color(0, 0, 0)), "MANTENIMIENTO DE PROVEEDOR", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel.setBounds(37, 11, 286, 142);
		getContentPane().add(panel);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBackground(new Color(240, 248, 255));
		lblCodigo.setFont(new Font("Arial", Font.BOLD, 12));
		lblCodigo.setBounds(20, 25, 66, 14);
		panel.add(lblCodigo);
		
		lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
		lblNombre.setBounds(20, 50, 66, 20);
		panel.add(lblNombre);
		
		lblTelefono = new JLabel("Celular:");
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 12));
		lblTelefono.setBounds(20, 81, 66, 14);
		panel.add(lblTelefono);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(96, 22, 159, 20);
		panel.add(txtCodigo);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(96, 50, 159, 20);
		panel.add(txtNombre);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(96, 78, 159, 20);
		panel.add(txtTelefono);
		
		lblDirecion = new JLabel("Direcion:");
		lblDirecion.setFont(new Font("Arial", Font.BOLD, 12));
		lblDirecion.setBounds(20, 106, 66, 14);
		panel.add(lblDirecion);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(96, 103, 159, 20);
		panel.add(txtDireccion);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 164, 590, 204);
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
				"CODIGO", "NOMBRE", "TELEFONO", "DIRECCION"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblLista.getColumnModel().getColumn(1).setPreferredWidth(193);
		tblLista.getColumnModel().getColumn(2).setPreferredWidth(119);
		tblLista.getColumnModel().getColumn(3).setPreferredWidth(225);
		scrollPane.setViewportView(tblLista);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setIcon(new ImageIcon(GuiProveedor.class.getResource("/img/registro.png")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnRegistrar.setBounds(405, 24, 153, 30);
		getContentPane().add(btnRegistrar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setIcon(new ImageIcon(GuiProveedor.class.getResource("/img/eliminar.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 12));
		btnEliminar.setBounds(405, 108, 153, 30);
		getContentPane().add(btnEliminar);
		
		btnEditar_1 = new JButton("ACTUALIZAR");
		btnEditar_1.setIcon(new ImageIcon(GuiProveedor.class.getResource("/img/actualizar-base-de-datos.png")));
		btnEditar_1.addActionListener(this);
		btnEditar_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnEditar_1.setBounds(405, 65, 153, 32);
		getContentPane().add(btnEditar_1);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(GuiProveedor.class.getResource("/img/cerrar.png")));
		btnSalir.setFont(new Font("Arial", Font.BOLD, 12));
		btnSalir.setBounds(515, 379, 103, 30);
		getContentPane().add(btnSalir);
		CargarLista();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnEditar_1) {
			actionPerformedBtnEditar_1(e);
		}
		if (e.getSource() == btnSalir) {
			handle_btnSalir_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrar) {
			handle_btnGuardar_actionPerformed(e);
		}
	}
	
	void CargarLista() {
		ArrayList<Proveedor> lista = gestorProveedor.listar();
		
		DefaultTableModel modelo = (DefaultTableModel) tblLista.getModel();
		modelo.getDataVector().clear();
		
		for(Proveedor obj : lista) {
			Object[] data = {obj.getCodigo(), obj.getNombre(), obj.getCelular(),obj.getDireccion()};
			modelo.addRow(data);
		}
	}
	
	void LimpiarFormulario() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		txtDireccion.setText("");
	}
	
	boolean celular() {
		String cel = txtTelefono.getText();
		Pattern pat = Pattern.compile("^[9][0-9]{8}$");
		Matcher mat = pat.matcher(cel);
		if (mat.find()) {
			return true;
		}else
			return false;
	}
	protected void handle_btnGuardar_actionPerformed(ActionEvent e) {
		if(txtNombre.getText().length()>0) {
			if(celular()==true) {
				if(txtDireccion.getText().length()>0) {
					Proveedor obj = new Proveedor();
					obj.setNombre(txtNombre.getText());
					obj.setCelular(Integer.parseInt(txtTelefono.getText()));
					obj.setDireccion(txtDireccion.getText());
					
					
					int resultado = gestorProveedor.registrar(obj);
					
					if(resultado == 1) {
						JOptionPane.showMessageDialog(this, "Se registr� el proveedor");
						CargarLista();
						LimpiarFormulario();
					}
					else {
						JOptionPane.showMessageDialog(this, "No se pudo registrar el proveedor");
					}
				}else
					JOptionPane.showMessageDialog(this, "Error en la direccion del proveedor");	
			}else
				JOptionPane.showMessageDialog(this, "Error en celular del proveedor");		
		}else
			JOptionPane.showMessageDialog(this, "Ingrese nombre del proveedor");
		
	}
	void CargarProveedor(int codigo) {
		Proveedor obj = gestorProveedor.obtener(codigo);
		if(obj.getCodigo() > 0) {
			
			txtCodigo.setText("" + obj.getCodigo());
			txtNombre.setText(obj.getNombre());
			txtTelefono.setText(String.valueOf(obj.getCelular()));
			txtDireccion.setText(obj.getDireccion());
		}
	}
	
	protected void tblListaMousePressed(MouseEvent e) {
		int codigo = (int) tblLista.getValueAt(tblLista.getSelectedRow(), 0);
		txtCodigo.setText("" + codigo);
		CargarProveedor(codigo);
	}
	protected void handle_btnSalir_actionPerformed(ActionEvent e) {
		dispose();
		prov=null;
	}
	protected void actionPerformedBtnEditar_1(ActionEvent e) {
		if(!txtCodigo.getText().equals("")) {
			if(txtNombre.getText().length()>0) {
				if(celular()==true) {
					if(txtDireccion.getText().length()>0) {
						Proveedor obj = new Proveedor();
						obj.setCodigo(Integer.parseInt(txtCodigo.getText()));
						obj.setNombre(txtNombre.getText());
						obj.setCelular(Integer.parseInt(txtTelefono.getText()));
						obj.setDireccion(txtDireccion.getText());
						
						int resultado = gestorProveedor.actualizar(obj);
						
						if(resultado == 1) {
							JOptionPane.showMessageDialog(this, "Se actualiz� el proveedor");
							CargarLista();
							LimpiarFormulario();
						}
						else {
							JOptionPane.showMessageDialog(this, "No se pudo actualizar el proveedor");
						}
					}else
						JOptionPane.showMessageDialog(this, "Error en la direccion del proveedor");	
				}else
					JOptionPane.showMessageDialog(this, "Error en celular del proveedor");		
			}else
				JOptionPane.showMessageDialog(this, "Ingrese nombre del proveedor");
			
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		if(!txtCodigo.getText().equals("")) {
			if(JOptionPane.showConfirmDialog(null, "Se eliminar� el registro seleccionado. �Desea continuar?", 
						"PuercoFarma", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				int codigo = Integer.parseInt(txtCodigo.getText());
				int resultado = gestorProveedor.eliminar(codigo);
				
				if(resultado == 1) {
					JOptionPane.showMessageDialog(this, "Se elimin� el proveedor");
					CargarLista();
					LimpiarFormulario();
				}
				else {
					JOptionPane.showMessageDialog(this, "No se pudo eliminar el proveedor");
				}
			}
		}
	}

}
