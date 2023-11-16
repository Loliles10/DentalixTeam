package mainPack;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DoctorConsultar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaPrincipal frame = new ventanaPrincipal();
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
	
	
	public DoctorConsultar() {
		
		// Dimensiones
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 1280, 720);
	            
	    // Estilos del JPanel
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    contentPane.setBackground(Color.WHITE);
	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	    
	    // Código de Ventana Principal...
	    
	    // Logo Fondo azul
    	JLabel logoBlanco = new JLabel("");
    	logoBlanco.setHorizontalAlignment(SwingConstants.CENTER);
    	contentPane.add(logoBlanco);

    	ImageIcon imagen = new ImageIcon(getClass().getResource("/logoAzul.png"));
    	int ancho = imagen.getIconWidth();
    	int alto = imagen.getIconHeight();
    	logoBlanco.setBounds(0, 0, ancho, alto);

    	Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
    	logoBlanco.setIcon(icono);
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(0, 101, 100, 590); 
	    contentPane.add(scrollPane);

	    JPanel buttonPanel = new JPanel();
	    buttonPanel.setLayout(new GridLayout(10, 1));
	    scrollPane.setViewportView(buttonPanel); 

    	buttonPanel.setBackground(Color.WHITE);

    	// Botón 1 
    	java.net.URL imgUrl = getClass().getResource("/pacientesIcono.png");
    	Icon icon = new ImageIcon(imgUrl);
    	JButton button1 = new JButton(icon);
    	button1.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
    	button1.setBackground(Color.WHITE);
    	buttonPanel.add(button1);
    	
    	

    	// Botón 2 
    	java.net.URL imgUrl2 = getClass().getResource("/doctoresIcono.png");
    	Icon icon2 = new ImageIcon(imgUrl2);
    	JButton button2 = new JButton(icon2);
    	button2.setPreferredSize(new Dimension(icon2.getIconWidth(), icon2.getIconHeight()));
    	button2.setBackground(Color.WHITE);
    	buttonPanel.add(button2);
    	
    	
    	// Botón 3
    	java.net.URL imgUrl3 = getClass().getResource("/consultasIcono.png");
    	Icon icon3 = new ImageIcon(imgUrl3);
    	JButton button3 = new JButton(icon3);
    	button3.setPreferredSize(new Dimension(icon3.getIconWidth(), icon3.getIconHeight()));
    	button3.setBackground(Color.WHITE);
    	buttonPanel.add(button3);
    
    	// Botón 4 
    	java.net.URL imgUrl4 = getClass().getResource("/materialIcono.png");
    	Icon icon4 = new ImageIcon(imgUrl4);
    	JButton button4 = new JButton(icon4);
    	button4.setPreferredSize(new Dimension(icon4.getIconWidth(), icon4.getIconHeight()));
    	button4.setBackground(Color.WHITE);
    	buttonPanel.add(button4);
    	
    

    	// Botón 5
    	java.net.URL imgUrl5 = getClass().getResource("/facturacionIcono.png");
    	Icon icon5 = new ImageIcon(imgUrl5);
    	JButton button5 = new JButton(icon5);
    	button5.setPreferredSize(new Dimension(icon5.getIconWidth(), icon5.getIconHeight()));
    	button5.setBackground(Color.WHITE);
    	buttonPanel.add(button5);
    	
    	

    	// Botón 6
    	java.net.URL imgUrl6 = getClass().getResource("/pedidosIcono.png");
    	Icon icon6 = new ImageIcon(imgUrl6);
    	JButton button6 = new JButton(icon6);
    	button6.setPreferredSize(new Dimension(icon6.getIconWidth(), icon6.getIconHeight()));
    	button6.setBackground(Color.WHITE);
    	buttonPanel.add(button6);
    	
    

    	// Botón 7 
    	java.net.URL imgUrl7 = getClass().getResource("/proveedoresIcono.png");
    	Icon icon7 = new ImageIcon(imgUrl7);
    	JButton button7 = new JButton(icon7);
    	button7.setPreferredSize(new Dimension(icon7.getIconWidth(), icon7.getIconHeight()));
    	button7.setBackground(Color.WHITE);
    	buttonPanel.add(button7);
    	
    	
    	// Botón 8 
    	java.net.URL imgUrl8 = getClass().getResource("/tratamientosIcono.png");
    	Icon icon8 = new ImageIcon(imgUrl8);
    	JButton button8 = new JButton(icon8);
    	button8.setPreferredSize(new Dimension(icon8.getIconWidth(), icon8.getIconHeight()));
    	button8.setBackground(Color.WHITE);
    	buttonPanel.add(button8);
    	

    	// Botón 9 
    	java.net.URL imgUrl9 = getClass().getResource("/especialistasIcono.png");
    	Icon icon9 = new ImageIcon(imgUrl9);
    	JButton button9 = new JButton(icon9);
    	button9.setPreferredSize(new Dimension(icon9.getIconWidth(), icon9.getIconHeight()));
    	button9.setBackground(Color.WHITE);
    	buttonPanel.add(button9);
    	
    	
    	// Botón 10 
    	java.net.URL imgUrl10 = getClass().getResource("/usuariosIcono.png");
    	Icon icon10 = new ImageIcon(imgUrl10);
    	JButton button10 = new JButton(icon10);
    	button10.setPreferredSize(new Dimension(icon10.getIconWidth(), icon10.getIconHeight()));
    	button10.setBackground(Color.WHITE);
    	buttonPanel.add(button10);
    	
    
    	
    	// Boton de play
    	java.net.URL imgUrl11 = getClass().getResource("/play.png");
    	Icon icon11 = new ImageIcon(imgUrl11);
    	JScrollPane editarPanel = new JScrollPane();
    	editarPanel.setBounds(100, 0, 1164, 670);
    	contentPane.add(editarPanel);

    	JPanel panel = new JPanel();
    	editarPanel.setViewportView(panel);
    	panel.setLayout(null);

    	JLabel label = new JLabel("ID:");
    	label.setBounds(0, 1, 576, 65);
    	panel.add(label);
    	JTextField idField = new JTextField();
    	idField.setBounds(586, 1, 576, 65);
    	panel.add(idField);

    	JLabel label_1 = new JLabel("Nombre:");
    	label_1.setBounds(0, 76, 576, 65);
    	panel.add(label_1);
    	JTextField nombreField = new JTextField();
    	nombreField.setBounds(586, 76, 576, 65);
    	panel.add(nombreField);

    	JLabel label_2 = new JLabel("Apellidos:");
    	label_2.setBounds(0, 151, 576, 65);
    	panel.add(label_2);
    	JTextField apellidosField = new JTextField();
    	apellidosField.setBounds(586, 151, 576, 65);
    	panel.add(apellidosField);

    	JLabel label_3 = new JLabel("Teléfono:");
    	label_3.setBounds(0, 226, 576, 65);
    	panel.add(label_3);
    	
    	JTextField telefonoField = new JTextField();
    	telefonoField.setBounds(586, 226, 576, 65);
    	panel.add(telefonoField);

    	JLabel label_4 = new JLabel("Dirección:");
    	label_4.setBounds(0, 301, 576, 65);
    	panel.add(label_4);
    	JTextField direccionField = new JTextField();
    	direccionField.setBounds(586, 301, 576, 65);
    	panel.add(direccionField);

    	JLabel label_5 = new JLabel("ID Especialidad:");
    	label_5.setBounds(0, 376, 576, 65);
    	panel.add(label_5);
    	JTextField idEspecialidadField = new JTextField();
    	idEspecialidadField.setBounds(586, 376, 576, 65);
    	panel.add(idEspecialidadField);

    	JLabel label_6 = new JLabel("Salario:");
    	label_6.setBounds(0, 451, 576, 65);
    	panel.add(label_6);
    	JTextField salarioField = new JTextField();
    	salarioField.setBounds(586, 451, 576, 65);
    	panel.add(salarioField);

    	JLabel label_7 = new JLabel("Email:");
    	label_7.setBounds(0, 526, 576, 65);
    	panel.add(label_7);
    	JTextField emailField = new JTextField();
    	emailField.setBounds(586, 526, 576, 65);
    	panel.add(emailField);

    	JButton guardarButton = new JButton("Guardar");
    	guardarButton.setBounds(0, 601, 576, 65);
    	panel.add(guardarButton);
    	guardarButton.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        // Aquí puedes agregar el código para guardar los cambios
    	    }
    	});

    	// Unicamente espectador
    	
	}
	
}