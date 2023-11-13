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

public class ventanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel bienvenido;
    private JLabel texto1;
    private JButton playBoton;
    private conectorBBDD conector = new conectorBBDD();
	
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
					ventanaPrincipal frame = new ventanaPrincipal();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
		
	}

	public ventanaPrincipal() {
		
		// asdasd
		
		super("Dentilax"); 
		ventanaPrincipal.this.setLocationRelativeTo(null);
		setResizable(false);
		// Icono
		ImageIcon icono1 = new ImageIcon("/logoDentilax.png"); 
		ventanaPrincipal.this.setIconImage(icono1.getImage()); 

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
    	Tabla table = new Tabla(modeloTabla);
    	
    	JPanel tablasPanel = new JPanel();
    	tablasPanel.setBackground(new Color(255, 255, 255));
    	tablasPanel.setBounds(99, -1, 1179, 691);
    	contentPane.add(tablasPanel);
    	tablasPanel.setLayout(null);
    	tablasPanel.setVisible(false);

    	tablasPanel.add(table);

    	JScrollPane scrollPaneT = new JScrollPane(table);
    	scrollPaneT.setBounds(0, 0, 1180, 691);
    	tablasPanel.add(scrollPaneT);
    	scrollPaneT.setBackground(new Color(255, 255, 255));

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
    	                JOptionPane.showMessageDialog(ventanaPrincipal.this, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
    	            }
    	        } catch (Exception ex) {
    	            ex.printStackTrace();
    	            JOptionPane.showMessageDialog(ventanaPrincipal.this, "Error al cargar los datos de pacientes", "Error", JOptionPane.ERROR_MESSAGE);
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
    	
    	bienvenido = new JLabel("<html><font color='#008CCE'>¡Bienvenido</font> admin<font color='#008CCE'>!</font></html>");
    	bienvenido.setFont(new Font("Montserrat Medium", Font.BOLD, 60));
    	bienvenido.setBounds(387, 210, 725, 62);
    	contentPane.add(bienvenido);
    	
    	texto1 = new JLabel("<html><div align='center'>Pulsa para un tutorial corto y te<br>mostramos cómo utilizar la<br> aplicación</div></html>");
    	texto1.setHorizontalAlignment(SwingConstants.CENTER);
    	texto1.setFont(new Font("Montserrat Medium", Font.PLAIN, 20));
    	texto1.setBounds(499, 282, 421, 109);
    	contentPane.add(texto1);
    	
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
    	        String videoPath = "C:\\Users\\ianre\\git\\DentalixTeam\\recursos\\tutorial1.mkv";

    	        try {
    	            Desktop.getDesktop().open(new File(videoPath));
    	        } catch (IOException ex) {
    	            ex.printStackTrace();
    	        }
    	    }
    	});
    	
	}
}