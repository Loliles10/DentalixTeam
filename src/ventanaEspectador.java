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

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ventanaEspectador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel bienvenido;
	private JLabel texto1;
	private JButton playBoton;
	private JTable tablaPacientes;
	
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
	
	
	public ventanaEspectador() {
		
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
    	
    	button1.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        bienvenido.setVisible(false);
    	        texto1.setVisible(false);
    	        playBoton.setVisible(false);
    	        cargarDatosPacientes();
    	    }
    	});

    	// Botón 2 
    	java.net.URL imgUrl2 = getClass().getResource("/doctoresIcono.png");
    	Icon icon2 = new ImageIcon(imgUrl2);
    	JButton button2 = new JButton(icon2);
    	button2.setPreferredSize(new Dimension(icon2.getIconWidth(), icon2.getIconHeight()));
    	button2.setBackground(Color.WHITE);
    	buttonPanel.add(button2);
    	
    	button2.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        // Oculta los JLabels 'bienvenido' y 'texto1'
    	        bienvenido.setVisible(false);
    	        texto1.setVisible(false);
    	        playBoton.setVisible(false);
    	    }
    	});

    	// Botón 3
    	java.net.URL imgUrl3 = getClass().getResource("/consultasIcono.png");
    	Icon icon3 = new ImageIcon(imgUrl3);
    	JButton button3 = new JButton(icon3);
    	button3.setPreferredSize(new Dimension(icon3.getIconWidth(), icon3.getIconHeight()));
    	button3.setBackground(Color.WHITE);
    	buttonPanel.add(button3);
    	
    	button3.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        // Oculta los JLabels 'bienvenido' y 'texto1'
    	        bienvenido.setVisible(false);
    	        texto1.setVisible(false);
    	        playBoton.setVisible(false);
    	    }
    	});

    	// Botón 4 
    	java.net.URL imgUrl4 = getClass().getResource("/materialIcono.png");
    	Icon icon4 = new ImageIcon(imgUrl4);
    	JButton button4 = new JButton(icon4);
    	button4.setPreferredSize(new Dimension(icon4.getIconWidth(), icon4.getIconHeight()));
    	button4.setBackground(Color.WHITE);
    	buttonPanel.add(button4);
    	
    	button4.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        // Oculta los JLabels 'bienvenido' y 'texto1'
    	        bienvenido.setVisible(false);
    	        texto1.setVisible(false);
    	        playBoton.setVisible(false);
    	    }
    	});

    	// Botón 5
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

    	// Botón 6
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

    	// Botón 7 
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

    	// Botón 8 
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

    	// Botón 9 
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

    	// Botón 10 
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
    	
    	// Texto de ventana principal
    	bienvenido = new JLabel("<html><font color='#008CCE'>¡Bienvenido</font> doctor<font color='#008CCE'>!</font></html>");
    	bienvenido.setFont(new Font("Montserrat Medium", Font.BOLD, 60));
    	bienvenido.setBounds(387, 210, 725, 62);
    	contentPane.add(bienvenido);
    	
    	texto1 = new JLabel("<html><div align='center'>No puedes<br>editar nada<br> solo observar :)</div></html>");
    	texto1.setHorizontalAlignment(SwingConstants.CENTER);
    	texto1.setFont(new Font("Montserrat Medium", Font.PLAIN, 20));
    	texto1.setBounds(499, 282, 421, 109);
    	contentPane.add(texto1); 
    	
    	// Boton de play
    	java.net.URL imgUrl11 = getClass().getResource("/play.png");
    	Icon icon11 = new ImageIcon(imgUrl11);
    	playBoton = new JButton(icon11);
    	playBoton.setBounds(679, 400, 57, 55);
    	playBoton.setPreferredSize(new Dimension(icon10.getIconWidth(), icon10.getIconHeight()));
    	playBoton.setBackground(Color.WHITE);
    	contentPane.add(playBoton);
    	
    	playBoton.addMouseListener(new MouseAdapter() {
    	    @Override
    	    public void mouseEntered(MouseEvent e) {
    	        setCursor(new Cursor(Cursor.HAND_CURSOR));
    	    }

    	    @Override
    	    public void mouseExited(MouseEvent e) {
    	        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    	    }
    	});

    	playBoton.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        String videoPath = "C:\\Users\\ianre\\git\\DentalixTeam\\recursos\\cancion2.mp4";

    	        try {
    	            Desktop.getDesktop().open(new File(videoPath));
    	        } catch (IOException ex) {
    	            ex.printStackTrace();
    	        }
    	    }
    	});
    	
    	// Zona de tablas
    	JPanel tablasPanel = new JPanel();
    	tablasPanel.setBackground(new Color(255, 255, 255));
    	tablasPanel.setBounds(99, 0, 1167, 691);
    	contentPane.add(tablasPanel);
    	
    	// Unicamente espectador
    	
	}
	
	private void cargarDatosPacientes() {
        try {
            // Conexión a la base de datos
            String url = "jdbc:mysql://localhost:3306/dentilax?useSSL=false";
            String usuario = "root";
            String contrasenia = "1234";
            Connection conexion = DriverManager.getConnection(url, usuario, contrasenia);

            String consulta = "SELECT * FROM sys.paciente";
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(consulta);

            DefaultTableModel modeloTabla = new DefaultTableModel();

            modeloTabla.addColumn("ID/Documento");
            modeloTabla.addColumn("Nombre");
            modeloTabla.addColumn("Apellidos");
            modeloTabla.addColumn("Dirección");
            modeloTabla.addColumn("Teléfono");

            while (resultado.next()) {
                Object[] fila = {
                    resultado.getInt("idPaciente"),
                    resultado.getString("nombre"),
                    resultado.getString("apellidos"),
                    resultado.getString("dirección"),
                    resultado.getInt("teléfono")
                };
                modeloTabla.addRow(fila);
            }
            
            conexion.close();

            JTable tablaPacientes = new JTable(modeloTabla);
            
            JPanel panel = new JPanel(new BorderLayout());
            panel.add(new JScrollPane(tablaPacientes), BorderLayout.CENTER);

            JOptionPane.showMessageDialog(this, panel, "Tabla de Pacientes", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception ex) {
            ex.printStackTrace(); 
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de pacientes", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
