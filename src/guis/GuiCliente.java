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

import gestores.GestorCliente;
import modelo.Cliente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class GuiCliente extends JInternalFrame implements ActionListener{

	public JPanel panel;
	public JLabel lblCodigo;
	public JLabel lblNombre;
	public JLabel lblDNI;
	public JTextField txtCodigo;
	public JTextField txtNombre;
	public JTextField txtDNI;
	public JScrollPane scrollPane;
	public JTable tblLista;
	public JButton btnRegistrar;
	public JButton btnEditar;
	public JButton btnCerrar;
	GestorCliente gestorCliente = new GestorCliente();
	
	public static String cli;
	public JButton btnEliminar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtCelular;
	private JTextField txtCorreo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiCliente frame = new GuiCliente();
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
	public GuiCliente() {
		cli=cli;
		getContentPane().setBackground(new Color(175, 238, 238));
		setBounds(100, 100, 642, 473);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setLayout(null);
		panel.setToolTipText("");
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 245, 245), new Color(0, 0, 0)), "MANTENIMIENTO DE CLIENTE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel.setBounds(37, 12, 363, 163);
		getContentPane().add(panel);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Arial", Font.BOLD, 12));
		lblCodigo.setBounds(10, 25, 55, 14);
		panel.add(lblCodigo);
		
		lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
		lblNombre.setBounds(10, 50, 55, 20);
		panel.add(lblNombre);
		
		lblDNI = new JLabel("DNI:");
		lblDNI.setFont(new Font("Arial", Font.BOLD, 12));
		lblDNI.setBounds(10, 81, 55, 14);
		panel.add(lblDNI);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(75, 22, 124, 20);
		panel.add(txtCodigo);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(75, 50, 278, 20);
		panel.add(txtNombre);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(75, 78, 124, 20);
		panel.add(txtDNI);
		
		lblNewLabel = new JLabel("Celular");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 106, 46, 14);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Correo");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 131, 46, 14);
		panel.add(lblNewLabel_1);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(75, 103, 97, 20);
		panel.add(txtCelular);
		txtCelular.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(75, 128, 278, 20);
		panel.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 211, 592, 163);
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
				"CODIGO", "NOMBRE", "DNI", "Celular", "Correo"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblLista.getColumnModel().getColumn(0).setPreferredWidth(88);
		tblLista.getColumnModel().getColumn(1).setPreferredWidth(240);
		tblLista.getColumnModel().getColumn(2).setPreferredWidth(119);
		scrollPane.setViewportView(tblLista);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setIcon(new ImageIcon(GuiCliente.class.getResource("/img/registro.png")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnRegistrar.setBounds(421, 12, 179, 37);
		getContentPane().add(btnRegistrar);
		
		btnEditar = new JButton("ACTUALIZAR");
		btnEditar.setIcon(new ImageIcon(GuiCliente.class.getResource("/img/actualizar-base-de-datos.png")));
		btnEditar.addActionListener(this);
		btnEditar.setFont(new Font("Arial", Font.BOLD, 12));
		btnEditar.setBounds(421, 60, 179, 38);
		getContentPane().add(btnEditar);
		
		btnCerrar = new JButton("CERRAR");
		btnCerrar.setIcon(new ImageIcon("C:\\Users\\colqu\\Downloads\\PROYECTO-III\\NEW-PROYECT\\src\\img\\closing.png"));
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnCerrar.setBounds(440, 385, 132, 34);
		getContentPane().add(btnCerrar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setIcon(new ImageIcon(GuiCliente.class.getResource("/img/eliminar.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 12));
		btnEliminar.setBounds(421, 109, 179, 35);
		getContentPane().add(btnEliminar);
		CargarLista();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnEditar) {
			actionPerformedBtnEditar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	void CargarLista() {
		ArrayList<Cliente> lista = gestorCliente.listar();
		
		DefaultTableModel modelo = (DefaultTableModel) tblLista.getModel();
		modelo.getDataVector().clear();
		
		for(Cliente obj : lista) {
			Object[] data = {obj.getCodigo(), obj.getNombre(), obj.getDni(),obj.getCelular(),obj.getCorreo()};
			modelo.addRow(data);
		}
	}
	
	void LimpiarFormulario() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtDNI.setText("");
		txtCelular.setText("");
		txtCorreo.setText("");
	}
	
	boolean nombre2() {
		String nombre = txtNombre.getText();
		Pattern pat = Pattern.compile("/^[a-z ,.'-]+$");
		Matcher mat = pat.matcher(nombre);
		if (mat.find()) {
			return true;
		}else
			return false;
	}
	
	boolean email() {
		String email = txtCorreo.getText();
		Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mat = pat.matcher(email);
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
	
	boolean celular() {
		String cel = txtCelular.getText();
		Pattern pat = Pattern.compile("^[9][0-9]{8}$");
		Matcher mat = pat.matcher(cel);
		if (mat.find()) {
			return true;
		}else
			return false;
	}
	
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		if(txtNombre.getText().length()>0) {
			if(gestorCliente.existeCliente(txtDNI.getText())== 0) {
				if(dni()==true) {
					if (celular()==true) {
						if (email()==true) {
							Cliente obj = new Cliente();
							obj.setNombre(txtNombre.getText());
							obj.setDni(txtDNI.getText());
							obj.setCelular(txtCelular.getText());
							obj.setCorreo(txtCorreo.getText());
							
							int resultado = gestorCliente.registrar(obj);
							
							if(resultado == 1) {
								JOptionPane.showMessageDialog(this, "Se registr� el cliente");
								CargarLista();
								LimpiarFormulario();
							}
							else {
								JOptionPane.showMessageDialog(this, "No se pudo registrar el cliente");
							}
						}else 
							JOptionPane.showMessageDialog(null, "Correo no valido");
					}else
						JOptionPane.showMessageDialog(null, "Celular no valido");
				}else
					JOptionPane.showMessageDialog(null, "DNI no valido");
			}else
				JOptionPane.showMessageDialog(null, "DNI YA EXISTE");
		}else
			JOptionPane.showMessageDialog(null, "Error en el nombre del cliente");		
	}
	
	void CargarCliente(int codigo) {
		Cliente obj = gestorCliente.obtener(codigo);
		if(obj.getCodigo() > 0) {
			
			txtCodigo.setText("" + obj.getCodigo());
			txtNombre.setText(obj.getNombre());
			txtDNI.setText(obj.getDni());
			txtCelular.setText(obj.getCelular());
			txtCorreo.setText(obj.getCorreo());
		}
	}
	
	protected void tblListaMousePressed(MouseEvent e) {
		int codigo = (int) tblLista.getValueAt(tblLista.getSelectedRow(), 0);
		txtCodigo.setText("" + codigo);
		CargarCliente(codigo);
	}
	protected void actionPerformedBtnEditar(ActionEvent e) {
		if(!txtCodigo.getText().equals("")) {
			if(dni()==true) {
				if (celular()==true) {
					if (email()==true) {
						Cliente obj = new Cliente();
						obj.setCodigo(Integer.parseInt(txtCodigo.getText()));
						obj.setNombre(txtNombre.getText());
						obj.setDni(txtDNI.getText());
						obj.setCelular(txtCelular.getText());
						obj.setCorreo(txtCorreo.getText());
						
						int resultado = gestorCliente.actualizar(obj);
						
						if(resultado == 1) {
							JOptionPane.showMessageDialog(this, "Se actualiz� el cliente");
							CargarLista();
							LimpiarFormulario();
						}
						else {
							JOptionPane.showMessageDialog(this, "No se pudo actualizar el cliente");
						}
					}else 
						JOptionPane.showMessageDialog(null, "Correo no valido");
				}else
					JOptionPane.showMessageDialog(null, "Celular no valido");
			}else
				JOptionPane.showMessageDialog(null, "DNI no valido");
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
		cli=null;
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		if(!txtCodigo.getText().equals("")) {
			if(JOptionPane.showConfirmDialog(null, "Se eliminar� el registro seleccionado. �Desea continuar?", 
						"PuercoFarma", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				int codigo = Integer.parseInt(txtCodigo.getText());
				int resultado = gestorCliente.eliminar(codigo);
				
				if(resultado == 1) {
					JOptionPane.showMessageDialog(this, "Se elimin� el cliente");
					CargarLista();
					LimpiarFormulario();
				}
				else {
					JOptionPane.showMessageDialog(this, "No se pudo eliminar el cliente");
				}
			}
		}
	}

}
