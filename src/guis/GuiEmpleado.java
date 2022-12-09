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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gestores.GestorEmpleado;
import modelo.Cliente;
import modelo.Empleado;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GuiEmpleado extends JInternalFrame implements ActionListener{

	private JPanel panel;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblDNI;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtDNI;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private JButton btnRegistrar;
	private JButton btnEditar;
	private JButton btnCerrar;
	GestorEmpleado gestorEmpleado = new GestorEmpleado();
	
	public static String emple;
	public JButton btnEliminar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtUsuario;
	private JTextField txtClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiEmpleado frame = new GuiEmpleado();
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
	public GuiEmpleado() {
		emple = emple;
		getContentPane().setBackground(new Color(175, 238, 238));
		setBounds(100, 100, 595, 430);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setToolTipText("");
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 245, 245), new Color(0, 0, 0)), "MANTENIMIENTO DE EMPLEADO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
		panel.setBounds(22, 11, 259, 161);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Arial", Font.BOLD, 12));
		lblCodigo.setBounds(10, 25, 55, 14);
		panel.add(lblCodigo);
		
		lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
		lblNombre.setBounds(10, 50, 55, 20);
		panel.add(lblNombre);
		
		lblDNI = new JLabel("DNI:");
		lblDNI.setBackground(new Color(240, 255, 255));
		lblDNI.setFont(new Font("Arial", Font.BOLD, 12));
		lblDNI.setBounds(10, 81, 55, 14);
		panel.add(lblDNI);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(75, 22, 171, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(75, 50, 171, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(75, 78, 171, 20);
		panel.add(txtDNI);
		txtDNI.setColumns(10);
		
		lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 106, 46, 14);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("CLAVE");
		lblNewLabel_1.setBounds(10, 131, 46, 14);
		panel.add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(74, 103, 103, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtClave = new JTextField();
		txtClave.setBounds(75, 128, 86, 20);
		panel.add(txtClave);
		txtClave.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 212, 547, 143);
		getContentPane().add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tblTablaMousePressed(e);
			}
		});
		tblTabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CODIGO", "NOMBRE", "DNI", "USUARIO", "Clave"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblTabla.getColumnModel().getColumn(0).setPreferredWidth(108);
		tblTabla.getColumnModel().getColumn(1).setPreferredWidth(293);
		tblTabla.getColumnModel().getColumn(2).setPreferredWidth(104);
		scrollPane.setViewportView(tblTabla);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setIcon(new ImageIcon(GuiEmpleado.class.getResource("/img/registro.png")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnRegistrar.setBounds(421, 23, 134, 32);
		getContentPane().add(btnRegistrar);
		
		btnEditar = new JButton("ACTUALIZAR");
		btnEditar.setIcon(new ImageIcon(GuiEmpleado.class.getResource("/img/actualizar-base-de-datos.png")));
		btnEditar.addActionListener(this);
		btnEditar.setFont(new Font("Arial", Font.BOLD, 12));
		btnEditar.setBounds(421, 78, 134, 32);
		getContentPane().add(btnEditar);
		
		btnCerrar = new JButton("CERRAR");
		btnCerrar.setIcon(new ImageIcon(GuiEmpleado.class.getResource("/img/closing.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnCerrar.setBounds(451, 366, 118, 23);
		getContentPane().add(btnCerrar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setIcon(new ImageIcon(GuiEmpleado.class.getResource("/img/eliminar.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 12));
		btnEliminar.setBounds(421, 129, 134, 32);
		getContentPane().add(btnEliminar);
		CargarLista();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnEditar) {
			actionPerformedBtnEditar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnNewButton(e);
		}
	}
	void CargarLista() {
		ArrayList<Empleado> lista = gestorEmpleado.listar();
		
		DefaultTableModel modelo = (DefaultTableModel) tblTabla.getModel();
		modelo.getDataVector().clear();
		
		for(Empleado obj : lista) {
			Object[] data = {obj.getCodigo(), obj.getNombre(), obj.getDni(),obj.getUsuario(),obj.getClave()};
			modelo.addRow(data);
		}
	}
	
	void LimpiarFormulario() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtDNI.setText("");
		txtUsuario.setText("");
		txtClave.setText("");
	}
	
	boolean nombre() {
		String nombre = txtNombre.getText();
		Pattern pat = Pattern.compile("[a-zA-Z�-��-��-�]+\\.?(( |\\-)[a-zA-Z�-��-��-�]+\\.?)*$");
		Matcher mat = pat.matcher(nombre);
		if (mat.find()) {
			return true;
		}else
			return false;
	}
	
	boolean dni() {
		String dni = txtDNI.getText();
		Pattern pat = Pattern.compile("^[1-9]{1}[0-9]{7}$");
		Matcher mat = pat.matcher(dni);
		if (mat.find()) {
			return true;
		}else
			return false;
	}
	
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		
		if(nombre()==true) {
			if(dni()==true) {
				if(gestorEmpleado.existeEmpleado(txtDNI.getText())==0) {
					if(txtUsuario.getText().length()<=5 &&txtUsuario.getText().length()>0 ) {
						if(txtClave.getText().length()<=6 && txtClave.getText().length()>0) {
							Empleado obj = new Empleado();
							obj.setNombre(txtNombre.getText());
							obj.setDni(txtDNI.getText());
							obj.setUsuario(txtUsuario.getText());
							obj.setClave(txtClave.getText());
							
							int resultado = gestorEmpleado.registrar(obj);
							
							if(resultado == 1) {
								JOptionPane.showMessageDialog(this, "Se registr� el empleado");
								CargarLista();
								LimpiarFormulario();
							}
							else {
								JOptionPane.showMessageDialog(this, "No se pudo registrar el empleado");
							}
						}else
							JOptionPane.showMessageDialog(this, "ERROR en la clave. MAX 6 CARACTERES");
					}else
						JOptionPane.showMessageDialog(this, "ERROR en el usuario. MAX 5 CARACTERES");
				}else
					JOptionPane.showMessageDialog(null, "Ya existe ese DNI");
			}else
				JOptionPane.showMessageDialog(null, "DNI no valido");
		}else
			JOptionPane.showMessageDialog(null, "Error en el nombre del empleado");			
	}
	
	void CargarEmpleado(int codigo) {
		Empleado obj = gestorEmpleado.obtener(codigo);
		if(obj.getCodigo() > 0) {
			
			txtCodigo.setText("" + obj.getCodigo());
			txtNombre.setText(obj.getNombre());
			txtDNI.setText(obj.getDni());
			txtUsuario.setText(obj.getUsuario());
			txtClave.setText(obj.getClave());
		}
	}
	
	protected void tblTablaMousePressed(MouseEvent e) {
		int codigo = (int) tblTabla.getValueAt(tblTabla.getSelectedRow(), 0);
		txtCodigo.setText("" + codigo);
		CargarEmpleado(codigo);
	}
	protected void actionPerformedBtnEditar(ActionEvent e) {
		if(!txtCodigo.getText().equals("")) {
			if(nombre()==true) {
				if(dni()==true) {
					if(txtUsuario.getText().length()<=5 &&txtUsuario.getText().length()>0 ) {
						if(txtClave.getText().length()<=6 && txtClave.getText().length()>0) {
							Empleado obj = new Empleado();
							obj.setCodigo(Integer.parseInt(txtCodigo.getText()));
							obj.setNombre(txtNombre.getText());
							obj.setDni(txtDNI.getText());
							obj.setUsuario(txtUsuario.getText());
							obj.setClave(txtClave.getText());
							
							
							int resultado = gestorEmpleado.actualizar(obj);
							
							if(resultado == 1) {
								JOptionPane.showMessageDialog(this, "Se actualiz� el empleado");
								CargarLista();
								LimpiarFormulario();
							}
							else {
								JOptionPane.showMessageDialog(this, "No se pudo actualizar el empleado");
							}
						}else
							JOptionPane.showMessageDialog(this, "ERROR en la clave. MAX 6 CARACTERES");
					}else
						JOptionPane.showMessageDialog(this, "ERROR en el usuario. MAX 5 CARACTERES");
				}else
					JOptionPane.showMessageDialog(null, "DNI no valido");
			}else
				JOptionPane.showMessageDialog(null, "Error en el nombre del empleado");		
		}
		LimpiarFormulario();
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
		emple=null;
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		if(!txtCodigo.getText().equals("")) {
			if(JOptionPane.showConfirmDialog(null, "Se eliminar� el registro seleccionado. �Desea continuar?", 
						"PuercoFarma", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				int codigo = Integer.parseInt(txtCodigo.getText());
				int resultado = gestorEmpleado.eliminar(codigo);
				
				if(resultado == 1) {
					JOptionPane.showMessageDialog(this, "Se elimin� el empleado");
					CargarLista();
					LimpiarFormulario();
				}
				else {
					JOptionPane.showMessageDialog(this, "No se pudo eliminar el empleado");
				}
			}
		}
	}
}
