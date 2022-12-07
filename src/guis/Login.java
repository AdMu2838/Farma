package guis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gestores.GestorEmpleado;
import menu.MenuPrincipal;
import modelo.Empleado;

import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
public class Login extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lblFondo;
	private JLabel lblUsuario;
	public JTextField txtUsuario;
	private JButton btnSalir;
	private JButton btnIngresar;
	public JPasswordField txtClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 343, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuario = new JLabel("USUARIO");
		lblUsuario.setForeground(new Color(255, 255, 0));
		lblUsuario.setFont(new Font("Calisto MT", Font.BOLD, 14));
		lblUsuario.setBounds(23, 24, 116, 23);
		contentPane.add(lblUsuario);
		
		JLabel lblClave = new JLabel("CONTRASE\u00D1A");
		lblClave.setForeground(new Color(255, 255, 0));
		lblClave.setFont(new Font("Calisto MT", Font.BOLD, 14));
		lblClave.setBounds(23, 65, 116, 23);
		contentPane.add(lblClave);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(136, 23, 157, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(this);
		btnIngresar.setBackground(new Color(176, 196, 222));
		btnIngresar.setFont(new Font("Calibri", Font.BOLD, 14));
		btnIngresar.setBounds(38, 125, 116, 33);
		contentPane.add(btnIngresar);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setIcon(new ImageIcon(Login.class.getResource("/img/cerrar.png")));
		btnSalir.addActionListener(this);
		btnSalir.setBackground(new Color(176, 196, 222));
		btnSalir.setFont(new Font("Calibri", Font.BOLD, 14));
		btnSalir.setBounds(177, 125, 116, 33);
		contentPane.add(btnSalir);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(136, 65, 157, 20);
		contentPane.add(txtClave);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Login.class.getResource("/img/farma.jpg")));
		lblFondo.setBounds(0, 0, 327, 199);
		contentPane.add(lblFondo);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			handle_btnSalir_actionPerformed(e);
		}
		if (e.getSource() == btnIngresar) {
			handle_btnIngresar_actionPerformed(e);
		}
	}
	protected void handle_btnIngresar_actionPerformed(ActionEvent e) {
		
		GestorEmpleado gestorEmpleado = new GestorEmpleado ();
		Empleado empleado = new Empleado();
		empleado.setUsuario(txtUsuario.getText());
		empleado.setClave(txtClave.getText());
		boolean esValido = gestorEmpleado.validarAcceso(empleado);
		
		if(esValido) {
			MenuPrincipal f = new MenuPrincipal();
			f.show();
			f.setExtendedState(MAXIMIZED_BOTH);
			this.dispose();
		}
		else {
			JOptionPane.showMessageDialog(this, "Verifique credenciales");
		}
	}

	protected void handle_btnSalir_actionPerformed(ActionEvent e) {
		dispose();
	}

}
