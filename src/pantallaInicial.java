import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
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

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//BBDD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//BBDD

// Pantalla Inicial - Inicio - Login

public class pantallaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel logoInicio;
	private JLabel logoLogin;

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
                
             	// Logo en página de login (creamos un JLabel para mostrar el logo)
                logoLogin = new JLabel("");
                logoLogin.setHorizontalAlignment(SwingConstants.CENTER); // Centramos la alineación del JLabel
                logoLogin.setBounds(270, 100, 500, 500);  // Establecemos las coordenadas y dimensiones del JLabel

                // Cargamos una imagen desde un archivo ubicado en el recurso "/logoDentilax.png"
                ImageIcon imagen = new ImageIcon(getClass().getResource("/logoDentilax.png"));

                // Escalamos la imagen para que se ajuste al tamaño del JLabel
                Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(logoLogin.getWidth(), logoLogin.getHeight(), Image.SCALE_DEFAULT));

                // Asignamos el icono (imagen) al JLabel
                logoLogin.setIcon(icono);

                logoLogin.setBounds(222, 100, 500, 500); // Ajustamos nuevamente las coordenadas y dimensiones del JLabel
                contentPane.add(logoLogin); // Agregamos el JLabel al contenedor principal (contentPane)

            	// Formulario de Login
                // Usuario
                JTextField usuarioTextField = new JTextField();
                usuarioTextField.setBounds(770, 250, 200, 30);
                String usuario = usuarioTextField.getText();      
                contentPane.add(usuarioTextField);
                
                // Contraseña
                JPasswordField contraseniaTextField = new JPasswordField();
                contraseniaTextField.setBounds(770, 300, 200, 30);
                contentPane.add(contraseniaTextField);

                // Agregar el JCheckBox debajo de los campos de contraseña
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
                
                // Comprobar si hay datos, sino sale en rojo
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
                        boolean conexionExitosa = conectarABaseDeDatos(); // Variable para controlar la conexión

                        if (conexionExitosa) {
                            JOptionPane.showMessageDialog(contentPane, "Conexión a la base de datos exitosa");

                            boolean credencialesValidas = verificarCredencialesEnBaseDeDatos(usuario, new String(contrasenia));

                            if (credencialesValidas) {
                                // Oculta la ventana actual
                                setVisible(false);

                            } else {
                                // Credenciales incorrectas, muestra un mensaje de error
                                JOptionPane.showMessageDialog(contentPane, "Credenciales incorrectas", "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(contentPane, "No se pudo conectar a la base de datos", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
                        }
                    }  

                    // Conexión a Base de Datos
					private boolean conectarABaseDeDatos() {
						
					    try {
					    	String url = "jdbc:mysql://localhost:3306/sys?useSSL=false";
						    String usuario = "root";
						    String contrasenia = "1234";

						    Connection conexion = null; 
					        conexion = DriverManager.getConnection(url, usuario, contrasenia);
					        if (conexion != null) {
					            conexion.close();
					        }
					        return true;
					    } catch (SQLException e) {
					        e.printStackTrace();
					        return false;
					    } 
					} 

					// Metodo para verificar credencial 
					public boolean verificarCredencialesEnBaseDeDatos(String usuario, String contrasenia) {
					    Connection connection = null;
					    PreparedStatement preparedStatement = null;
					    ResultSet resultSet = null;
					    boolean credencialesValidas = false;

					    try {
					        String url = "jdbc:mysql://localhost:3306/sys?useSSL=false";
					        String dbUser = "root";
					        String dbPassword = "1234";
					        connection = DriverManager.getConnection(url, dbUser, dbPassword);
					        
					        String sql = "SELECT * FROM usuario WHERE Nombre = ? AND contraseña = ?";
					        preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
					        preparedStatement.setString(1, usuario);
					        preparedStatement.setString(2, contrasenia);
					        resultSet = preparedStatement.executeQuery();
					        
					        if (resultSet.next()) {
					            String rol = resultSet.getString("rol");
					            
					            if ("admin".equals(rol)) {
					                // Credenciales correctas y rol 'admin', abre la ventana principal
					                credencialesValidas = true;
					                new ventanaPrincipal().setVisible(true);
					                new ventanaEspectador().setVisible(false);
					            } else if ("doctor".equals(rol)) {
					                // Credenciales correctas y rol 'doctor', abre la ventana del espectador
					                credencialesValidas = true;
					                new ventanaEspectador().setVisible(true);
					                new ventanaPrincipal().setVisible(false);
					            } else {
					                // Rol no reconocido
					                JOptionPane.showMessageDialog(null, "Rol no válido", "Error de Rol", JOptionPane.ERROR_MESSAGE);
					            }
					        } else {
					            // Credenciales incorrectas
					            JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
					        }
					    } catch (SQLException e) {
					        e.printStackTrace(); 
					    } finally {
					        try {
					            if (resultSet != null) {
					                resultSet.close();
					            }
					            if (preparedStatement != null) {
					                preparedStatement.close();
					            }
					            if (connection != null) {
					                connection.close();
					            }
					        } catch (SQLException e) {
					            e.printStackTrace();
					        }
					    }

					    return credencialesValidas;
					}
					
					// Hints de Botones
	                TextPrompt usuario = new TextPrompt("Usuario", usuarioTextField); // hint
	                TextPrompt contrasenia = new TextPrompt("Contrasenia", contraseniaTextField); // hint
					
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
