package menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import guis.GuiAyuda;
import guis.GuiBoleta;
import guis.GuiCliente;
import guis.GuiConsultaProducto;
import guis.GuiEmpleado; 
import guis.GuiProducto;
import guis.GuiProductoVendido;
import guis.GuiProveedor;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.SystemColor;

public class MenuPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuPrincipal;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnDetalle;
	private JMenuItem mntmCerrar;
	private JMenuItem mntmEmpleado;
	private JMenuItem mntmCliente;
	private JMenuItem mntmProveedor;
	private JMenuItem mntmProducto;
	private JMenuItem mntmBoleta;
	public static JDesktopPane scretory;
	private JLabel lblFondo;
	public JMenu mnNewMenu;
	public JMenuItem mntmAyuda;
	private JMenu mnConsulta;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmProductoVendido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setForeground(new Color(0, 0, 0));
		setTitle("  PUERCOFARMA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 505);
		
		menuPrincipal = new JMenuBar();
		menuPrincipal.setBackground(Color.WHITE);
		setJMenuBar(menuPrincipal);
		
		mnArchivo = new JMenu("ARCHIVO");
		mnArchivo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/archivo.png")));
		mnArchivo.setFont(new Font("Castellar", Font.BOLD, 12));
		menuPrincipal.add(mnArchivo);
		
		mntmCerrar = new JMenuItem("Salir");
		mntmCerrar.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/cerrar.png")));
		mntmCerrar.addActionListener(this);
		mntmCerrar.setBackground(new Color(128, 128, 128));
		mntmCerrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnArchivo.add(mntmCerrar);
		
		mnMantenimiento = new JMenu("MANTENIMIENTO");
		mnMantenimiento.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/mantinimiento.png")));
		mnMantenimiento.setFont(new Font("Castellar", Font.BOLD, 12));
		menuPrincipal.add(mnMantenimiento);
		
		mntmEmpleado = new JMenuItem("Empleado");
		mntmEmpleado.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/empleado.png")));
		mntmEmpleado.addActionListener(this);
		mntmEmpleado.setBackground(new Color(128, 128, 128));
		mntmEmpleado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnMantenimiento.add(mntmEmpleado);
		
		mntmCliente = new JMenuItem("Cliente");
		mntmCliente.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/clients.png")));
		mntmCliente.addActionListener(this);
		mntmCliente.setBackground(new Color(128, 128, 128));
		mntmCliente.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnMantenimiento.add(mntmCliente);
		
		mntmProducto = new JMenuItem("Producto");
		mntmProducto.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/producto.png")));
		mntmProducto.addActionListener(this);
		mntmProducto.setBackground(new Color(128, 128, 128));
		mntmProducto.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnMantenimiento.add(mntmProducto);
		
		mntmProveedor = new JMenuItem("Proveedor");
		mntmProveedor.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/proveedor.png")));
		mntmProveedor.addActionListener(this);
		mntmProveedor.setBackground(new Color(128, 128, 128));
		mntmProveedor.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnMantenimiento.add(mntmProveedor);
		
		mnConsulta = new JMenu("CONSULTAS");
		mnConsulta.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/consulta.png")));
		mnConsulta.setFont(new Font("Castellar", Font.BOLD, 12));
		menuPrincipal.add(mnConsulta);
		
		mntmNewMenuItem = new JMenuItem("CODIGO PRODUCTO ");
		mntmNewMenuItem.addActionListener(this);
		mnConsulta.add(mntmNewMenuItem);
		
		mntmProductoVendido = new JMenuItem("Productos Vendidos");
		mntmProductoVendido.addActionListener(this);
		mnConsulta.add(mntmProductoVendido);
		
		mnDetalle = new JMenu("INFORME");
		mnDetalle.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/informe.png")));
		mnDetalle.setBackground(new Color(255, 255, 255));
		mnDetalle.setFont(new Font("Castellar", Font.BOLD, 12));
		menuPrincipal.add(mnDetalle);
		
		mntmBoleta = new JMenuItem("Boleta");
		mntmBoleta.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/boleta.png")));
		mntmBoleta.addActionListener(this);
		mntmBoleta.setBackground(new Color(128, 128, 128));
		mntmBoleta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnDetalle.add(mntmBoleta);
		
		mnNewMenu = new JMenu("CONTACTOS");
		mnNewMenu.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/contacto.png")));
		mnNewMenu.setFont(new Font("Castellar", Font.BOLD, 12));
		menuPrincipal.add(mnNewMenu);
		
		mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/ayuda.png")));
		mntmAyuda.setBackground(new Color(192, 192, 192));
		mntmAyuda.addActionListener(this);
		mntmAyuda.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmAyuda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		scretory = new JDesktopPane();
		scretory.setBackground(new Color(175, 238, 238));
		contentPane.add(scretory, BorderLayout.CENTER);
		scretory.setLayout(new CardLayout(0, 0));
		
		lblFondo = new JLabel("");
		lblFondo.setForeground(new Color(175, 238, 238));
		scretory.add(lblFondo, "name_239568979309800");
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmProductoVendido) {
			actionPerformedMntmProductoVendido(e);
		}
		if (e.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItem(e);
		}
		if (e.getSource() == mntmAyuda) {
			handle_mntmAyuda_actionPerformed(e);
		}
		if (e.getSource() == mntmBoleta) {
			actionPerformedMntmBoleta(e);
		}
		if (e.getSource() == mntmProveedor) {
			actionPerformedMntmProveedor(e);
		}
		if (e.getSource() == mntmProducto) {
			actionPerformedMntmProducto(e);
		}
		if (e.getSource() == mntmCliente) {
			actionPerformedMntmCliente(e);
		}
		if (e.getSource() == mntmEmpleado) {
			actionPerformedMntmEmpleado(e);
		}
		if (e.getSource() == mntmCerrar) {
			handleMntmCerrarActionPerformed(e);
		}
	}
	protected void handleMntmCerrarActionPerformed(ActionEvent e) {
		System.exit(DISPOSE_ON_CLOSE);
	}
	
	
	protected void actionPerformedMntmEmpleado(ActionEvent e) {
		String em = GuiEmpleado.emple;
		
			if(em==null) {
				GuiEmpleado emp = new GuiEmpleado();
				scretory.add(emp);
				emp.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "ya esta activo");
			}
		
		
	}
	protected void actionPerformedMntmCliente(ActionEvent e) {
		String c = GuiCliente.cli;
		
			if(c==null) {
				GuiCliente cl = new GuiCliente();
				scretory.add(cl);
				cl.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "ya esta activo");
			}
		
		
	}
	protected void actionPerformedMntmProducto(ActionEvent e) {
		String p = GuiProducto.pro;
		
		if(p==null) {
			GuiProducto pr = new GuiProducto();
			scretory.add(pr);
			pr.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "ya esta activo");
		}
	}
	protected void actionPerformedMntmProveedor(ActionEvent e) {
        String pr = GuiProveedor.prov;
		
		if(pr==null) {
			GuiProveedor pro = new GuiProveedor();
			scretory.add(pro);
			pro.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "ya esta activo");
		}
	}
	
	protected void actionPerformedMntmBoleta(ActionEvent e) {
		 String b = GuiBoleta.bol;
			
			if(b==null) {
				GuiBoleta bo = new GuiBoleta();
				scretory.add(bo);
				bo.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "ya esta activo");
			}
	}
	protected void handle_mntmAyuda_actionPerformed(ActionEvent e) {
		 String a = GuiAyuda.ayu;
			
			if(a==null) {
				GuiAyuda ay = new GuiAyuda();
				scretory.add(ay);
				ay.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "ya esta activo");
			}
	}
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		String c = GuiConsultaProducto.conPro;
		if(c==null) {
			GuiConsultaProducto conpr = new GuiConsultaProducto();
			scretory.add(conpr);
			conpr.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "ya esta activo");
		}
	}
	protected void actionPerformedMntmProductoVendido(ActionEvent e) {
		String p = GuiProductoVendido.proVen;
		if(p==null) {
			GuiProductoVendido proVen = new GuiProductoVendido();
			scretory.add(proVen);
			proVen.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "ya esta activo");
		}
	}

}
