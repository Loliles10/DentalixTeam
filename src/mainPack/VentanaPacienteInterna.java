package mainPack;
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
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
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
		
		// asdasd
		
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
    	tablasPanel.setBounds(99, -1, 1179, 691);
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
    	
    	textField = new JTextField();
    	textField.setBounds(474, 236, 128, 40);
    	tablasPanel.add(textField);
    	textField.setColumns(10);
    	
    	textField_1 = new JTextField();
    	textField_1.setColumns(10);
    	textField_1.setBounds(474, 303, 128, 40);
    	tablasPanel.add(textField_1);
    	
    	textField_2 = new JTextField();
    	textField_2.setColumns(10);
    	textField_2.setBounds(474, 370, 128, 40);
    	tablasPanel.add(textField_2);
    	
    	textField_3 = new JTextField();
    	textField_3.setColumns(10);
    	textField_3.setBounds(474, 447, 128, 40);
    	tablasPanel.add(textField_3);
    	
    	textField_4 = new JTextField();
    	textField_4.setColumns(10);
    	textField_4.setBounds(474, 514, 128, 40);
    	tablasPanel.add(textField_4);
    	
    	textField_5 = new JTextField();
    	textField_5.setBounds(732, 246, 369, 314);
    	tablasPanel.add(textField_5);
    	textField_5.setColumns(10);
    	
    	JButton btnNewButton = new JButton("Listo");
    	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    	btnNewButton.setBounds(487, 603, 115, 48);
    	tablasPanel.add(btnNewButton);
    	
    	JButton btnCancelar = new JButton("Cancelar");
    	btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 15));
    	btnCancelar.setBounds(707, 603, 115, 48);
    	tablasPanel.add(btnCancelar);
    	
    	JButton btnBorrarPerfil = new JButton("Borrar perfil\r\n");
    	btnBorrarPerfil.setFont(new Font("Tahoma", Font.BOLD, 13));
    	btnBorrarPerfil.setBounds(919, 603, 115, 48);
    	tablasPanel.add(btnBorrarPerfil);
    	tablasPanel.setVisible(false);

    	java.net.URL imgUrl1 = getClass().getResource("/pacientesIcono.png");
    	Icon icon = new ImageIcon(imgUrl1);
    	JButton button1 = new JButton(icon);
    	button1.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
    	button1.setBackground(Color.WHITE);

    	buttonPanel.add(button1);

    	// Acción del botón
    	button1.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        try {
    	            bienvenido.setVisible(false);
    	            texto1.setVisible(false);
    	            playBoton.setVisible(false);

    	            if (conector.conectarConBBDD()) {
    	                conector.cargarDatosPacientes(modeloTabla);
    	                tablasPanel.setVisible(true);
    	            } else {
    	                JOptionPane.showMessageDialog(VentanaPacienteInterna.this, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
    	            }
    	        } catch (Exception ex) {
    	            ex.printStackTrace();
    	            JOptionPane.showMessageDialog(VentanaPacienteInterna.this, "Error al cargar los datos de pacientes", "Error", JOptionPane.ERROR_MESSAGE);
    	        }
    	    }
    	});
    	
    	java.net.URL imgUrl2 = getClass().getResource("/doctoresIcono.png");
    	Icon icon2 = new ImageIcon(imgUrl2);
    	JButton button2 = new JButton(icon2);
    	button2.setPreferredSize(new Dimension(icon2.getIconWidth(), icon2.getIconHeight()));
    	button2.setBackground(Color.WHITE);
    	buttonPanel.add(button2);
    	
    	button2.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        bienvenido.setVisible(false);
    	        texto1.setVisible(false);
    	        playBoton.setVisible(false);
    	    }
    	});

    	java.net.URL imgUrl3 = getClass().getResource("/consultasIcono.png");
    	Icon icon3 = new ImageIcon(imgUrl3);
    	JButton button3 = new JButton(icon3);
    	button3.setPreferredSize(new Dimension(icon3.getIconWidth(), icon3.getIconHeight()));
    	button3.setBackground(Color.WHITE);
    	buttonPanel.add(button3);
    	
    	button3.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        bienvenido.setVisible(false);
    	        texto1.setVisible(false);
    	        playBoton.setVisible(false);
    	    }
    	});
    	
    	java.net.URL imgUrl4 = getClass().getResource("/materialIcono.png");
    	Icon icon4 = new ImageIcon(imgUrl4);
    	JButton button4 = new JButton(icon4);
    	button4.setPreferredSize(new Dimension(icon4.getIconWidth(), icon4.getIconHeight()));
    	button4.setBackground(Color.WHITE);
    	buttonPanel.add(button4);
    	
    	button4.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        bienvenido.setVisible(false);
    	        texto1.setVisible(false);
    	        playBoton.setVisible(false);
    	    }
    	});

    	java.net.URL imgUrl5 = getClass().getResource("/facturacionIcono.png");
    	Icon icon5 = new ImageIcon(imgUrl5);
    	JButton button5 = new JButton(icon5);
    	button5.setPreferredSize(new Dimension(icon5.getIconWidth(), icon5.getIconHeight()));
    	button5.setBackground(Color.WHITE);
    	buttonPanel.add(button5);
    	
    	button5.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        bienvenido.setVisible(false);
    	        texto1.setVisible(false);
    	        playBoton.setVisible(false);
    	    }
    	});

    	java.net.URL imgUrl6 = getClass().getResource("/pedidosIcono.png");
    	Icon icon6 = new ImageIcon(imgUrl6);
    	JButton button6 = new JButton(icon6);
    	button6.setPreferredSize(new Dimension(icon6.getIconWidth(), icon6.getIconHeight()));
    	button6.setBackground(Color.WHITE);
    	buttonPanel.add(button6);
    	
    	button6.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        bienvenido.setVisible(false);
    	        texto1.setVisible(false);
    	        playBoton.setVisible(false);
    	    }
    	});

    	java.net.URL imgUrl7 = getClass().getResource("/proveedoresIcono.png");
    	Icon icon7 = new ImageIcon(imgUrl7);
    	JButton button7 = new JButton(icon7);
    	button7.setPreferredSize(new Dimension(icon7.getIconWidth(), icon7.getIconHeight()));
    	button7.setBackground(Color.WHITE);
    	buttonPanel.add(button7);
    	
    	button7.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        bienvenido.setVisible(false);
    	        texto1.setVisible(false);
    	        playBoton.setVisible(false);
    	    }
    	});

    	java.net.URL imgUrl8 = getClass().getResource("/tratamientosIcono.png");
    	Icon icon8 = new ImageIcon(imgUrl8);
    	JButton button8 = new JButton(icon8);
    	button8.setPreferredSize(new Dimension(icon8.getIconWidth(), icon8.getIconHeight()));
    	button8.setBackground(Color.WHITE);
    	buttonPanel.add(button8);
    	
    	button8.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        bienvenido.setVisible(false);
    	        texto1.setVisible(false);
    	        playBoton.setVisible(false);
    	    }
    	});

    	java.net.URL imgUrl9 = getClass().getResource("/especialistasIcono.png");
    	Icon icon9 = new ImageIcon(imgUrl9);
    	JButton button9 = new JButton(icon9);
    	button9.setPreferredSize(new Dimension(icon9.getIconWidth(), icon9.getIconHeight()));
    	button9.setBackground(Color.WHITE);
    	buttonPanel.add(button9);
    	
    	button9.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        bienvenido.setVisible(false);
    	        texto1.setVisible(false);
    	        playBoton.setVisible(false);
    	    }
    	});

    	java.net.URL imgUrl10 = getClass().getResource("/usuariosIcono.png");
    	Icon icon10 = new ImageIcon(imgUrl10);
    	JButton button10 = new JButton(icon10);
    	button10.setPreferredSize(new Dimension(icon10.getIconWidth(), icon10.getIconHeight()));
    	button10.setBackground(Color.WHITE);
    	buttonPanel.add(button10);
    	
    	button10.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        bienvenido.setVisible(false);
    	        texto1.setVisible(false);
    	        playBoton.setVisible(false);
    	    }
    	});
    	
    	java.net.URL imgUrl11 = getClass().getResource("/play.png"); 
    	Icon icon11 = new ImageIcon(imgUrl11);
    	
	}
}