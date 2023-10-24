import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.print.DocFlavor.URL;
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
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import java.awt.Font;

public class ventanaPrincipal extends JFrame {

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
	
	
	public ventanaPrincipal() {
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

    	// Carga la imagen
    	ImageIcon imagen = new ImageIcon(getClass().getResource("/logoAzul.png"));
    	int ancho = imagen.getIconWidth();
    	int alto = imagen.getIconHeight();
    	logoBlanco.setBounds(0, 0, ancho, alto);

    	// Asigna la imagen al JLabel
    	Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
    	logoBlanco.setIcon(icono);
	    
	    // Creamos un JScrollPane
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(0, 101, 100, 590); // Cambiamos el ancho a 100 píxeles
	    contentPane.add(scrollPane);

	    // Creamos un panel para contener los botones
	    JPanel buttonPanel = new JPanel();
	    buttonPanel.setLayout(new GridLayout(10, 1)); // GridLayout para alinear los botones verticalmente
	    scrollPane.setViewportView(buttonPanel); // Establecemos el panel como contenido del JScrollPane

	    // Establece el color de fondo en blanco para el panel principal
    	buttonPanel.setBackground(Color.WHITE);

    	// Botón 1 sin texto y con imagen
    	java.net.URL imgUrl = getClass().getResource("/pacientesIcono.png");
    	Icon icon = new ImageIcon(imgUrl);
    	JButton button1 = new JButton(icon);
    	// Ajusta el tamaño del botón al de la imagen
    	button1.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
    	// Establece el color de fondo del botón en blanco
    	button1.setBackground(Color.WHITE);
    	// Agrega el botón al panel
    	buttonPanel.add(button1);

    	// Botón 2 sin texto y con imagen
    	java.net.URL imgUrl2 = getClass().getResource("/doctoresIcono.png");
    	Icon icon2 = new ImageIcon(imgUrl2);
    	JButton button2 = new JButton(icon2);
    	button2.setPreferredSize(new Dimension(icon2.getIconWidth(), icon2.getIconHeight()));
    	button2.setBackground(Color.WHITE);
    	buttonPanel.add(button2);

    	// Botón 3 sin texto y con imagen
    	java.net.URL imgUrl3 = getClass().getResource("/consultasIcono.png");
    	Icon icon3 = new ImageIcon(imgUrl3);
    	JButton button3 = new JButton(icon3);
    	button3.setPreferredSize(new Dimension(icon3.getIconWidth(), icon3.getIconHeight()));
    	button3.setBackground(Color.WHITE);
    	buttonPanel.add(button3);

    	// Botón 4 sin texto y con imagen
    	java.net.URL imgUrl4 = getClass().getResource("/materialIcono.png");
    	Icon icon4 = new ImageIcon(imgUrl4);
    	JButton button4 = new JButton(icon4);
    	button4.setPreferredSize(new Dimension(icon4.getIconWidth(), icon4.getIconHeight()));
    	button4.setBackground(Color.WHITE);
    	buttonPanel.add(button4);

    	// Botón 5 sin texto y con imagen
    	java.net.URL imgUrl5 = getClass().getResource("/facturacionIcono.png");
    	Icon icon5 = new ImageIcon(imgUrl5);
    	JButton button5 = new JButton(icon5);
    	button5.setPreferredSize(new Dimension(icon5.getIconWidth(), icon5.getIconHeight()));
    	button5.setBackground(Color.WHITE);
    	buttonPanel.add(button5);

    	// Botón 6 sin texto y con imagen
    	java.net.URL imgUrl6 = getClass().getResource("/pedidosIcono.png");
    	Icon icon6 = new ImageIcon(imgUrl6);
    	JButton button6 = new JButton(icon6);
    	button6.setPreferredSize(new Dimension(icon6.getIconWidth(), icon6.getIconHeight()));
    	button6.setBackground(Color.WHITE);
    	buttonPanel.add(button6);

    	// Botón 7 sin texto y con imagen
    	java.net.URL imgUrl7 = getClass().getResource("/proveedoresIcono.png");
    	Icon icon7 = new ImageIcon(imgUrl7);
    	JButton button7 = new JButton(icon7);
    	button7.setPreferredSize(new Dimension(icon7.getIconWidth(), icon7.getIconHeight()));
    	button7.setBackground(Color.WHITE);
    	buttonPanel.add(button7);

    	// Botón 8 sin texto y con imagen
    	java.net.URL imgUrl8 = getClass().getResource("/tratamientosIcono.png");
    	Icon icon8 = new ImageIcon(imgUrl8);
    	JButton button8 = new JButton(icon8);
    	button8.setPreferredSize(new Dimension(icon8.getIconWidth(), icon8.getIconHeight()));
    	button8.setBackground(Color.WHITE);
    	buttonPanel.add(button8);

    	// Botón 9 sin texto y con imagen
    	java.net.URL imgUrl9 = getClass().getResource("/especialistasIcono.png");
    	Icon icon9 = new ImageIcon(imgUrl9);
    	JButton button9 = new JButton(icon9);
    	button9.setPreferredSize(new Dimension(icon9.getIconWidth(), icon9.getIconHeight()));
    	button9.setBackground(Color.WHITE);
    	buttonPanel.add(button9);

    	// Botón 10 sin texto y con imagen
    	java.net.URL imgUrl10 = getClass().getResource("/usuariosIcono.png");
    	Icon icon10 = new ImageIcon(imgUrl10);
    	JButton button10 = new JButton(icon10);
    	button10.setPreferredSize(new Dimension(icon10.getIconWidth(), icon10.getIconHeight()));
    	button10.setBackground(Color.WHITE);
    	buttonPanel.add(button10);
    	
    	// Texto de ventana principal
    	JLabel lblNewLabel = new JLabel("<html><font color='#008CCE'>¡Bienvenido</font> admin<font color='#008CCE'>!</font></html>");
    	lblNewLabel.setFont(new Font("Montserrat Medium", Font.BOLD, 60));
    	lblNewLabel.setBounds(387, 210, 725, 62);
    	contentPane.add(lblNewLabel);
    	
    	JLabel lblNewLabel_1 = new JLabel("<html><div align='center'>Pulsa para un tutorial corto y te<br>mostramos cómo utilizar la<br> aplicación</div></html>");
    	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
    	lblNewLabel_1.setFont(new Font("Montserrat Medium", Font.PLAIN, 20));
    	lblNewLabel_1.setBounds(499, 282, 421, 109);
    	contentPane.add(lblNewLabel_1);
    	
    	
    	// Boton de play
    	java.net.URL imgUrl11 = getClass().getResource("/play.png");
    	Icon icon11 = new ImageIcon(imgUrl11);
    	JButton playBoton = new JButton(icon11);
    	playBoton.setBounds(679, 400, 57, 55);
    	playBoton.setPreferredSize(new Dimension(icon10.getIconWidth(), icon10.getIconHeight()));
    	playBoton.setBackground(Color.WHITE);
    	contentPane.add(playBoton);

    	// Agrega un ActionListener al botón
    	playBoton.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        // Ruta del archivo de video
    	        String videoPath = "/Dentilax/recursos/tutorial1.mkv";

    	        try {
    	            // Abre el archivo de video con el reproductor predeterminado
    	            Desktop.getDesktop().open(new File(videoPath));
    	        } catch (IOException ex) {
    	            ex.printStackTrace();
    	            // Maneja cualquier error que pueda ocurrir al abrir el video
    	        }
    	    }
    	});
    	
	}
	
}
