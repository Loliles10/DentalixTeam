package mainPack;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// Pantalla Inicial - Inicio - Login

public class pantallaInicial extends JFrame {

	// Variables
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel logoInicio;
	private JLabel logoLogin;
	private conectorBBDD conector = new conectorBBDD();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantallaInicial frame = new pantallaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
 
	/**
	 * JFrame de la Pantalla Inicial
	 */
	public pantallaInicial() {
		
		// Dimensiones
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 1280, 720);
	            
	    // Estilos del JPanel
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    contentPane.setBackground(Color.WHITE);
	    setContentPane(contentPane);
	    contentPane.setLayout(null); 
	    
	    Font montserratFont = new Font("Montserrat", Font.PLAIN, 20);
	    contentPane.setFont(montserratFont);
	    
	    // Logo en página de inicio
	    logoInicio = new JLabel("");
	    logoInicio.setHorizontalAlignment(SwingConstants.CENTER);
	    logoInicio.setBounds(370, 100, 500, 500);  // Tamaño
	    
	    // Variable de imagen (ImageIcon)
	    ImageIcon imagen = new ImageIcon(getClass().getResource("/logoDentilax.png"));
	    Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(logoInicio.getWidth(), logoInicio.getHeight(), Image.SCALE_DEFAULT));
	    logoInicio.setIcon(icono);
	    
	    // Al hacer click en el JLabel (imagen de logo de Dentilax)...
	    logoInicio.addMouseListener((MouseListener) new MouseAdapter() {
	    	
	    	@Override
            public void mouseClicked(MouseEvent e) {
	    		
	    		// Ocultar logo 1 y cambiar forma de cursor
	    		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	            logoInicio.setVisible(false); 
                contentPane.remove(logoInicio);
                contentPane.repaint(); 
                
                logoLogin = new JLabel("");
                logoLogin.setHorizontalAlignment(SwingConstants.CENTER);
                logoLogin.setBounds(270, 100, 500, 500);

                ImageIcon imagen = new ImageIcon(getClass().getResource("/logoDentilax.png"));

                Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(logoLogin.getWidth(), logoLogin.getHeight(), Image.SCALE_DEFAULT));

                logoLogin.setIcon(icono);

                logoLogin.setBounds(222, 100, 500, 500); 
                contentPane.add(logoLogin);

            	// Formulario de Login
                // Usuario
                JTextField usuarioTextField = new JTextField();
                usuarioTextField.setBounds(770, 250, 200, 30);
                contentPane.add(usuarioTextField);
                
                // Contraseña
                JPasswordField contraseniaTextField = new JPasswordField();
                contraseniaTextField.setBounds(770, 300, 200, 30);
                contentPane.add(contraseniaTextField);

                JCheckBox recordarCheckBox = new JCheckBox("Recordar mi contraseña");
                recordarCheckBox.setBounds(770, 350, 200, 30);
                recordarCheckBox.setOpaque(false);
                contentPane.add(recordarCheckBox);
                
                // Botón Login #008CCE
                JButton loginBoton = new JButton("Login");
                loginBoton.setBounds(770, 400, 200, 40); 
                loginBoton.setBackground(new Color(0, 140, 206)); 
                loginBoton.setForeground(Color.WHITE); 
                contentPane.add(loginBoton);
                
                loginBoton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String usuario = usuarioTextField.getText();
                        char[] contrasenia = contraseniaTextField.getPassword();

                        if (usuario.isEmpty()) {
                            usuarioTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                        } else {
                            usuarioTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                        } 

                        if (contrasenia.length == 0) {
                            contraseniaTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                        } else {
                            contraseniaTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                        }
                        
                        // Conexión
                        boolean conexionExitosa = conector.conectarConBBDD(); 

                        if (conexionExitosa) {
                            //JOptionPane.showMessageDialog(contentPane, "Conexión a la base de datos exitosa");
                        	
                        	System.out.println("Conexión a la base de datos exitosa");
                        	
                        	boolean credencialesValidas = conector.verificarCredencialesEnBaseDeDatos(usuario, new String(contrasenia));

                            if (credencialesValidas) {
                                setVisible(false);

                            } else {
                                JOptionPane.showMessageDialog(contentPane, "Credenciales incorrectas", "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(contentPane, "No se pudo conectar a la base de datos", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
                        }
                        
                    }    

					// Hints de Botones
	                TextPrompt usuario = new TextPrompt("Usuario", usuarioTextField);
	                TextPrompt contrasenia = new TextPrompt("Contrasenia", contraseniaTextField); 
					
                });
                
                contentPane.repaint();
                
            } 
	    	
	    	@Override
    	    public void mouseEntered(MouseEvent e) {
    	        if (logoInicio.isVisible()) {
    	            setCursor(new Cursor(Cursor.HAND_CURSOR));
    	        }
    	    }

    	    @Override
    	    public void mouseExited(MouseEvent e) {
    	        if (logoInicio.isVisible()) {
    	            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    	        }
    	    }
            
        });
	    
        contentPane.add(logoInicio);
	    
	}

}
