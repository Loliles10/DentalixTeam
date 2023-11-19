package mainPack;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.JTextField;

public class VentanaPacienteInterna extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private ConectorBBDD conector = new ConectorBBDD();
    private JTextField tfNombre;
    private JTextField tfApellido;
    private JTextField tfDireccion;
    private JTextField tfTelefono;
    private JTextField tfUltimaConsulta;
    private JTextField textField_5;
	
    /**
	 * Autores:
	 * David Andrade
	 * Pablo Rodriguez
	 * Ian Requena
	 * 2023
	 */
    
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPacienteInterna frame = new VentanaPacienteInterna();
					
					 frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
	                            pantallaInicial.class.getResource("/logoDentilax.png")));
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
		
	}

	public VentanaPacienteInterna() {
		
		//Manejo botones botones
		
		super("Dentilax"); 
		VentanaPacienteInterna.this.setLocationRelativeTo(null);
		setResizable(false);
		// Icono
		ImageIcon icono1 = new ImageIcon("/logoDentilax.png"); 
		VentanaPacienteInterna.this.setIconImage(icono1.getImage()); 

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 1292, 728);
	            
	    contentPane = new JPanel(); 
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    contentPane.setBackground(Color.WHITE);
	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	    
    	JLabel logoBlanco = new JLabel("");
    	logoBlanco.setHorizontalAlignment(SwingConstants.CENTER);
    	contentPane.add(logoBlanco);
    	
    	ImageIcon imagenLogo = new ImageIcon(getClass().getResource("/logoAzul.png"));
    	int ancho = imagenLogo.getIconWidth();
    	int alto = imagenLogo.getIconHeight();
    	
    	logoBlanco.setBounds(0, 0, 100, 100);
    	
    	Icon icono = new ImageIcon(imagenLogo.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT)); 
    	logoBlanco.setIcon(icono);
	    
    	JPanel buttonPanel = new JPanel();
    	buttonPanel.setLayout(new GridLayout(10, 1)); 
    	buttonPanel.setBackground(Color.WHITE);

    	JScrollPane scrollPane = new JScrollPane(buttonPanel);
    	scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    	scrollPane.setBounds(0, 101, 100, 590);

    	contentPane.add(scrollPane);

    	// Tablas
    	DefaultTableModel modeloTabla = new DefaultTableModel();
    	
    	JPanel tablasPanel = new JPanel();
    	tablasPanel.setBackground(new Color(255, 255, 255));
    	tablasPanel.setBounds(97, 0, 1179, 691);
    	contentPane.add(tablasPanel);
    	tablasPanel.setLayout(null);
    	
    	
    	// Cargar la imagen desde la carpeta de recursos
    	String rutaImagen = "/nino.png";  // Ajusta la ruta según la ubicación de tu recurso
    	java.net.URL urlImagen = getClass().getResource(rutaImagen);
    	ImageIcon imagen1 = new ImageIcon(urlImagen);

    	// Escalar la imagen
    	Image newImage = imagen1.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);

    	// Crear un nuevo ImageIcon con la imagen escalada
    	ImageIcon imagenEscalada = new ImageIcon(newImage);

    	// Añadir la imagen al panel
    	JLabel labelImagen = new JLabel(imagenEscalada);
    	tablasPanel.add(labelImagen);
    	labelImagen.setBounds(0, 217, 263, 400);
    	tablasPanel.setVisible(false);
    	
    	
    	
    	JPanel panel = new JPanel();
    	panel.setBackground(new Color(0x008cce)); // Establece el color de fondo usando el código hexadecimal

    	panel.setBounds(0, 0, 1179, 102);
    	tablasPanel.add(panel);
    	panel.setLayout(null);
    	
    	JLabel lblNewLabel = new JLabel("Paciente");
    	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
    	lblNewLabel.setBounds(27, 24, 117, 50);
    	panel.add(lblNewLabel);
    	
    	JLabel lblNewLabel_1 = new JLabel("");
    	lblNewLabel_1.setBounds(154, 24, 136, 50);
    	panel.add(lblNewLabel_1);
    	
    	JLabel lblNewLabel_2 = new JLabel("Nombre");
    	lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_2.setBounds(331, 226, 111, 56);
    	tablasPanel.add(lblNewLabel_2);
    	
    	JLabel lblNewLabel_2_1 = new JLabel("Apellido");
    	lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_2_1.setBounds(331, 293, 111, 56);
    	tablasPanel.add(lblNewLabel_2_1);
    	
    	JLabel lblNewLabel_2_2 = new JLabel("Direccion");
    	lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_2_2.setBounds(331, 360, 111, 56);
    	tablasPanel.add(lblNewLabel_2_2);
    	
    	JLabel lblNewLabel_2_3 = new JLabel("Telefono");
    	lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_2_3.setBounds(331, 437, 111, 56);
    	tablasPanel.add(lblNewLabel_2_3);
    	
    	JLabel lblNewLabel_2_4 = new JLabel("Ultima consulta");
    	lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_2_4.setBounds(331, 504, 128, 56);
    	tablasPanel.add(lblNewLabel_2_4);
    	
    	JLabel lblNewLabel_2_5 = new JLabel("Observaciones");
    	lblNewLabel_2_5.setFont(new Font("Tahoma", Font.BOLD, 15));
    	lblNewLabel_2_5.setBounds(858, 150, 111, 56);
    	tablasPanel.add(lblNewLabel_2_5);
    	
    	tfNombre = new JTextField();
    	tfNombre.setBounds(474, 236, 128, 40);
    	tablasPanel.add(tfNombre);
    	tfNombre.setColumns(10);
    	tfNombre.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyTyped(KeyEvent e) {
    			char c=e.getKeyChar();
    			 if (c == KeyEvent.VK_BACK_SPACE) {
			            return;
    			 }
				
    			if(!Character.isDigit(c)) {
    			e.consume();
    	 JOptionPane.showMessageDialog(null, "Solo se pueden introducir letras", "Advertencia", JOptionPane.WARNING_MESSAGE);
    			}
    		}
    	});
    	
    	tfApellido = new JTextField();
    	tfApellido.setColumns(10);
    	tfApellido.setBounds(474, 303, 128, 40);
    	tablasPanel.add(tfApellido);
    	tfApellido.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyTyped(KeyEvent e) {
    			char c=e.getKeyChar();
    			 if (c == KeyEvent.VK_BACK_SPACE) {
			            return;
    			 }
				
    			if(!Character.isDigit(c)) {
    			e.consume();
    	 JOptionPane.showMessageDialog(null, "Solo se pueden introducir letras", "Advertencia", JOptionPane.WARNING_MESSAGE);
    			}
    		}
    	});
    	
    	tfDireccion = new JTextField();
    	tfDireccion.setColumns(10);
    	tfDireccion.setBounds(474, 370, 128, 40);
    	tablasPanel.add(tfDireccion);
    	
    	tfTelefono = new JTextField();
    	tfTelefono.setColumns(10);
    	tfTelefono.setBounds(474, 447, 128, 40);
    	tablasPanel.add(tfTelefono);
    	tfTelefono.addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyTyped(KeyEvent e) {
    			char c = e.getKeyChar();
    			 if (c == KeyEvent.VK_BACK_SPACE) {
			            return;
    			 }
    			if (!Character.isDigit(c)) {
                    e.consume(); 
                    JOptionPane.showMessageDialog(null, "Solo se pueden introducir números", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
    			
    			
    		}
    	});
    	
    	
    	tfUltimaConsulta = new JTextField();
    	tfUltimaConsulta.setColumns(10);
    	tfUltimaConsulta.setBounds(474, 514, 128, 40);
    	tablasPanel.add(tfUltimaConsulta);
    	
    	textField_5 = new JTextField();
    	textField_5.setBounds(732, 246, 369, 314);
    	tablasPanel.add(textField_5);
    	textField_5.setColumns(10);
    	
    	
    	
    	
    	
    	

    	java.net.URL imgUrl1 = getClass().getResource("/pacientesIcono.png");
    	Icon icon = new ImageIcon(imgUrl1);
    	JButton button1 = new JButton(icon);
    	button1.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
    	button1.setBackground(Color.WHITE);

    	buttonPanel.add(button1);



    	java.net.URL imgUrl2 = getClass().getResource("/doctoresIcono.png");
    	Icon icon2 = new ImageIcon(imgUrl2);
    	JButton button2 = new JButton(icon2);
    	button2.setPreferredSize(new Dimension(icon2.getIconWidth(), icon2.getIconHeight()));
    	button2.setBackground(Color.WHITE);
    	buttonPanel.add(button2);
    	
  

    	java.net.URL imgUrl3 = getClass().getResource("/consultasIcono.png");
    	Icon icon3 = new ImageIcon(imgUrl3);
    	JButton button3 = new JButton(icon3);
    	button3.setPreferredSize(new Dimension(icon3.getIconWidth(), icon3.getIconHeight()));
    	button3.setBackground(Color.WHITE);
    	buttonPanel.add(button3);
    	
    	

    	java.net.URL imgUrl5 = getClass().getResource("/facturacionIcono.png");
    	Icon icon5 = new ImageIcon(imgUrl5);
    	JButton button5 = new JButton(icon5);
    	button5.setPreferredSize(new Dimension(icon5.getIconWidth(), icon5.getIconHeight()));
    	button5.setBackground(Color.WHITE);
    	buttonPanel.add(button5);
    	
    	

    	java.net.URL imgUrl6 = getClass().getResource("/pedidosIcono.png");
    	Icon icon6 = new ImageIcon(imgUrl6);
    	JButton button6 = new JButton(icon6);
    	button6.setPreferredSize(new Dimension(icon6.getIconWidth(), icon6.getIconHeight()));
    	button6.setBackground(Color.WHITE);
    	buttonPanel.add(button6);
    	
    

    	java.net.URL imgUrl7 = getClass().getResource("/proveedoresIcono.png");
    	Icon icon7 = new ImageIcon(imgUrl7);
    	JButton button7 = new JButton(icon7);
    	button7.setPreferredSize(new Dimension(icon7.getIconWidth(), icon7.getIconHeight()));
    	button7.setBackground(Color.WHITE);
    	buttonPanel.add(button7);
    	
 

    	java.net.URL imgUrl8 = getClass().getResource("/tratamientosIcono.png");
    	Icon icon8 = new ImageIcon(imgUrl8);
    	JButton button8 = new JButton(icon8);
    	button8.setPreferredSize(new Dimension(icon8.getIconWidth(), icon8.getIconHeight()));
    	button8.setBackground(Color.WHITE);
    	buttonPanel.add(button8);
    	
    

    	java.net.URL imgUrl9 = getClass().getResource("/especialistasIcono.png");
    	Icon icon9 = new ImageIcon(imgUrl9);
    	JButton button9 = new JButton(icon9);
    	button9.setPreferredSize(new Dimension(icon9.getIconWidth(), icon9.getIconHeight()));
    	button9.setBackground(Color.WHITE);
    	buttonPanel.add(button9);
    	


    	java.net.URL imgUrl10 = getClass().getResource("/usuariosIcono.png");
    	Icon icon10 = new ImageIcon(imgUrl10);
    	JButton button10 = new JButton(icon10);
    	button10.setPreferredSize(new Dimension(icon10.getIconWidth(), icon10.getIconHeight()));
    	button10.setBackground(Color.WHITE);
    	buttonPanel.add(button10);
    	
    	
    	//BOTON GUARDAR
    	
    	java.net.URL imgUrl11 = getClass().getResource("/save.png");
    	Icon icon11= new ImageIcon(imgUrl11);
    	
    	
    	// BOTÓN GUARDAR
    	JButton btnGuardar = new JButton("Guardar");
    	btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 15));
    	btnGuardar.setBounds(487, 603, 115, 48);
    	tablasPanel.add(btnGuardar);
    	
        
        
        
       
        //btnGuardar.setContentAreaFilled(false);
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores de los campos
                String nombre = tfNombre.getText();
                String apellidos = tfApellido.getText();
                String telefono = tfTelefono.getText();
                String direccion = tfDireccion.getText();
                String consulta = tfUltimaConsulta.getText();
                

                // Verificar que todos los campos estén llenos
                if (nombre.isEmpty() || apellidos.isEmpty() || telefono.isEmpty() || direccion.isEmpty()
                        || consulta.isEmpty()) {
                    // Mostrar un mensaje de error si algún campo está vacío
                    JOptionPane.showMessageDialog(null, "Rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                } 
            }
        });
     // Establecer el botón como predeterminado para la tecla "Enter"
      		getRootPane().setDefaultButton(btnGuardar);
    	    
      	// Agrega el ActionListener para la tecla "Enter" en el JFrame
     		addKeyListener(new KeyAdapter() {
     		    @Override
     		    public void keyTyped(KeyEvent e) {
     		        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
     		            // Simular el clic en el botón al presionar "Enter"
     		            btnGuardar.doClick();
     		        }
     		    }
     		});
    	    
    	//BOTON ELIMINAR 
     		
     	JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnEliminar.setBounds(919, 603, 115, 48);
        tablasPanel.add(btnEliminar);
        	
    	
        java.net.URL imgUrl12 = getClass().getResource("/eliminar.png");
        
 
    	btnEliminar.setPreferredSize(new Dimension(96, 96));
    	//btnEliminar.setContentAreaFilled(false);

    	 
    	//BOTON VOLVER
    	JButton btnVolver = new JButton("volver");
    	btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
    	btnVolver.setBounds(707, 603, 115, 48);
    	tablasPanel.add(btnVolver);
    	    
    	java.net.URL imgUrl13 = getClass().getResource("/volverIcono.png");
    	//btnVolver.setContentAreaFilled(false);
    	
    	
    	
    	btnVolver.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			VentanaPrincipal ventanaPrincipal= new VentanaPrincipal();
    			ventanaPrincipal.setVisible(true);
    		}
    	});
    	
    	
	}
}