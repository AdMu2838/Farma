package guis;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class GuiAyuda extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton btnSalir;
	
	public static String ayu;
	public JButton btncorre;
	public JButton btnInstagram;
	private JLabel lblAutor;
	private JEditorPane panel;
	private JButton btnFacebook;
	private JButton btnTwitter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiAyuda frame = new GuiAyuda();
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
	public GuiAyuda() {
		getContentPane().setForeground(Color.LIGHT_GRAY);
		ayu=ayu;
		getContentPane().setBackground(new Color(211, 211, 211));
		setBounds(100, 100, 587, 427);
		getContentPane().setLayout(null);
		
		btnFacebook = new JButton("");
		btnFacebook.addActionListener(this);
		btnFacebook.setBackground(new Color(0, 0, 0));
		btnFacebook.setIcon(new ImageIcon(GuiAyuda.class.getResource("/img/faceb.png")));
		btnFacebook.setBounds(114, 239, 48, 47);
		getContentPane().add(btnFacebook);
		
		btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(GuiAyuda.class.getResource("/img/close.png")));
		btnSalir.addActionListener(this);
		btnSalir.setFont(new Font("Calibri", Font.BOLD, 12));
		btnSalir.setBounds(464, 104, 81, 67);
		getContentPane().add(btnSalir);
		
		btncorre = new JButton("");
		btncorre.addActionListener(this);
		btncorre.setIcon(new ImageIcon(GuiAyuda.class.getResource("/img/email.png")));
		btncorre.setBounds(330, 239, 48, 47);
		getContentPane().add(btncorre);
		
		btnInstagram = new JButton("");
		btnInstagram.addActionListener(this);
		btnInstagram.setIcon(new ImageIcon(GuiAyuda.class.getResource("/img/instag.png")));
		btnInstagram.setBounds(217, 239, 48, 47);
		getContentPane().add(btnInstagram);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(112, 48, 271, 18);
		getContentPane().add(separator);
		
		panel = new JEditorPane();
		panel.setBackground(new Color(102, 204, 204));
		panel.setFont(new Font("Calibri", Font.BOLD, 14));
		panel.setText("       AGUSTIN DAVID MAMANI USCAMAYTA\r\n\r\n       ALEXIS MAMANI MAMANI\r\n\r\n       JOEL CHINO PARI");
		panel.setBounds(112, 58, 271, 138);
		getContentPane().add(panel);
		
		lblAutor = new JLabel("AUTORES");
		lblAutor.setForeground(SystemColor.textHighlight);
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAutor.setBounds(172, 25, 131, 14);
		getContentPane().add(lblAutor);
		
		btnTwitter = new JButton("");
		btnTwitter.addActionListener(this);
		btnTwitter.setIcon(new ImageIcon(GuiAyuda.class.getResource("/img/twitter.png")));
		btnTwitter.setBounds(439, 239, 48, 47);
		getContentPane().add(btnTwitter);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnTwitter) {
			handle_btnTwitter_actionPerformed(e);
		}
		if (e.getSource() == btncorre) {
			handle_btncorre_actionPerformed(e);
		}
		if (e.getSource() == btnInstagram) {
			handle_btnInstagram_actionPerformed(e);
		}
		if (e.getSource() == btnFacebook) {
			handle_btnFacebook_actionPerformed(e);
		}
		if (e.getSource() == btnSalir) {
			handle_btnSalir_actionPerformed(e);
		}
	}
	protected void handle_btnSalir_actionPerformed(ActionEvent e) {
		dispose();
		ayu=null;
	}
	protected void handle_btnFacebook_actionPerformed(ActionEvent e) {
		
	}
	protected void handle_btnInstagram_actionPerformed(ActionEvent e)  {
		try {
			Desktop.getDesktop().browse(new URL("https://www.instagram.com/").toURI());
		}catch(Exception e1){
			}
		
	}
	protected void handle_btncorre_actionPerformed(ActionEvent e) {
		
	}
	protected void handle_btnTwitter_actionPerformed(ActionEvent e) {
		try {
			Desktop.getDesktop().browse(new URL("https://twitter.com/home").toURI());
		}catch(Exception e1){
			}
	}
}
