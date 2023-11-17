package mainPack;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Dimension;

import javax.print.DocFlavor.URL;
import javax.swing.Icon;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JTextField;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DoctorConsultar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 private static final Font fuenteLabel = new Font("Montserrat", Font.PLAIN, 20);
	 private static final Font fuenteGrande = new Font("Montserrat", Font.PLAIN, 50);
		int yPosition = 30;
    	int separacionVertical = 70;
    	
	 private JTextField textField_salario;
	 private JTextField textField_idespecialidad;
	 private JTextField textField_email;
	 private JTextField textField_id;
	 ImageIcon icono = new ImageIcon("images/nombre_de_tu_imagen.png");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				DoctorConsultar frame = new DoctorConsultar();
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
    	
    	
    	
     	JPanel panel = new JPanel(); //PANEL DONDE ESTAN LOS LABELS
    	
    	 


    	
    	//BOTONES
    	
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
    	
    	//BOTON GUARDAR
    	
    	java.net.URL imgUrl11 = getClass().getResource("/saveIcono3.png");
    	Icon icon11= new ImageIcon(imgUrl11);
    	  JButton btnGuardar = new JButton(icon11);
    	  btnGuardar.setPreferredSize(new Dimension(icon11.getIconWidth(), icon11.getIconHeight()));
    	   btnGuardar.setBounds(640, 577, 164, 80);
    	    panel.add(btnGuardar);
    	    	
    	    
    	    //BOTON ELIMINAR 
    	
        	java.net.URL imgUrl12 = getClass().getResource("/eliminarIcono1.png");
        	Icon icon12= new ImageIcon(imgUrl12);
            JButton btnEliminar = new JButton(icon12);
        	btnEliminar.setPreferredSize(new Dimension(96, 96));
        	btnEliminar.setBounds(819, 577, 164, 80);
    	    panel.add(btnEliminar);
    	 
    
    	
    	
    	
    	//Panel Principal 
    
    	JScrollPane editarPanel = new JScrollPane();
    	editarPanel.setBounds(100, 0, 1164, 670);
    	contentPane.add(editarPanel);

    	//Panel donde están los labels
   
    	editarPanel.setViewportView(panel);
    	panel.setLayout(null);
    	panel.setBackground(Color.decode("#008cce"));
    	
    	// Cargar la imagen desde la carpeta de recursos
    	String rutaImagen = "/doctorIcono.png";  // Ajusta la ruta según la ubicación de tu recurso
    	java.net.URL urlImagen = getClass().getResource(rutaImagen);
    	ImageIcon imagen1 = new ImageIcon(urlImagen);

    	// Añadir la imagen al panel
    	JLabel labelImagen = new JLabel(imagen1);
    	labelImagen.setBounds(10, 115, 512, 512);
    	panel.add(labelImagen);
    	
    	
    	// COLOR DEL PANEL(FONDO)
    	
    	// ID
    	JLabel label_ID = new JLabel("ID:");
    	label_ID.setBackground(new Color(0, 128, 192));
    	label_ID.setBounds(630, 511, 36, 55);
    	panel.add(label_ID);

    	
    	//Establecemos el tamaño y su fuente
        label_ID.setFont(fuenteLabel);
        label_ID.setBackground(Color.decode("#008cce"));
        
        
        //L NOMBRE
    	JLabel label_Nombre = new JLabel("Nombre:");
    	label_Nombre.setBounds(591, 13, 85, 65);
    	panel.add(label_Nombre);
    	
    	
        label_Nombre.setFont(fuenteLabel);
        label_Nombre.setBackground(Color.decode("#008cce"));

        
        //APELLIDOS
        
    	JLabel label_Apellidos = new JLabel("Apellidos:");
    	label_Apellidos.setBounds(591, 83, 85, 65);
    	panel.add(label_Apellidos);
    	
    	label_Apellidos.setFont(fuenteLabel);

    	
    	// TELEFONO
    	
    	JLabel label_Telefono = new JLabel("Teléfono:");
    	label_Telefono.setBounds(591, 223, 82, 65);
    	panel.add(label_Telefono);
    	
    	label_Telefono.setFont(fuenteLabel);
    	
    	
    	// DIRECCION
    	
    	JLabel label_Direccion = new JLabel("Dirección:");
    	label_Direccion.setBounds(583, 159, 93, 65);
    	panel.add(label_Direccion);
    	
    	label_Direccion.setFont(fuenteLabel);
    	
    	// ID ESPECIALIDAD

    	JLabel label_IDEspecialidad = new JLabel("ID Especialidad:");
    	label_IDEspecialidad.setBounds(526, 435, 150, 65);
    	panel.add(label_IDEspecialidad);
    	
    	label_IDEspecialidad.setFont(fuenteLabel);

    	//SALARIO
    	
    	JLabel label_Salario = new JLabel("Salario:");
    	label_Salario.setBounds(602, 359, 74, 65);
    	panel.add(label_Salario);

    	label_Salario.setFont(fuenteLabel);

    	
    	//EMAIL
    	
    	JLabel label_Email = new JLabel("Email:");
    	label_Email.setBounds(606, 299, 62, 65);
    	panel.add(label_Email);

    	label_Email.setFont(fuenteLabel);

    	String rutaImagen2 = "/guardarIcono.png";  // Ajusta la ruta según la ubicación de tu recurso
    	java.net.URL urlImagen2 = getClass().getResource(rutaImagen2);
    	ImageIcon imagen2 = new ImageIcon(urlImagen2);
    
    	
    	
    	//TextFields separados equitativamente
    	
    	
    
    	

    	JTextField textField_nombre = new JTextField();
    	textField_nombre.setBounds(673, yPosition, 379, 38);
    	panel.add(textField_nombre);

    	Component textField_apellidos = new JTextField();
    	textField_apellidos.setBounds(673, yPosition + separacionVertical, 379, 38);
    	panel.add(textField_apellidos);

    	JTextField textField_telefono = new JTextField();
    	textField_telefono.setBounds(673, yPosition + separacionVertical * 2, 379, 38);
    	panel.add(textField_telefono);

    	JTextField textField_direccion = new JTextField();
    	textField_direccion.setBounds(673, yPosition + separacionVertical * 3, 379, 38);
    	panel.add(textField_direccion);

    	textField_salario = new JTextField();
    	textField_salario.setBounds(673, yPosition + separacionVertical * 4, 379, 38);
    	panel.add(textField_salario);

    	textField_idespecialidad = new JTextField();
    	textField_idespecialidad.setBounds(673, yPosition + separacionVertical * 5, 379, 38);
    	panel.add(textField_idespecialidad);

    	textField_email = new JTextField();
    	textField_email.setBounds(673, yPosition + separacionVertical * 6, 379, 38);
    	panel.add(textField_email);
    	
    	textField_id = new JTextField();
    	textField_id.setBounds(673, yPosition + separacionVertical * 7, 379, 38);
    	panel.add(textField_id);
    	
    	JLabel labelDoctor = new JLabel("DR.REQUENA");
    	labelDoctor.setBounds(113, 45, 468, 47);
    	panel.add(labelDoctor);
    labelDoctor.setFont(fuenteGrande);
    
  
 
    
    	
    	
    	
    	

	}
}
