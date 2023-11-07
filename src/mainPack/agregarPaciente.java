package mainPack;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class agregarPaciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField documentoField;
	private JTextField nombreTextField;
	private JTextField apellidosTextField;
	private JTextField direccionTextField;
	private JTextField telfTextField;
	private JButton btnNewButton;
	private JButton aceptarBoton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agregarPaciente frame = new agregarPaciente();
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
	public agregarPaciente() { 
		
		// Dimensiones
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 1280, 720);
	            
	    // Estilos del JPanel
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    contentPane.setBackground(Color.WHITE);
	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	    // Fin Estilos del JPanel
	    
	    JLabel lblNewLabel = new JLabel("Nombre");
	    lblNewLabel.setFont(new Font("Montserrat Medium", Font.PLAIN, 20));
	    lblNewLabel.setBounds(131, 130, 157, 32);
	    contentPane.add(lblNewLabel);
	    
	    JLabel lblNewLabel_1 = new JLabel("Documento");
	    lblNewLabel_1.setFont(new Font("Montserrat Medium", Font.PLAIN, 20));
	    lblNewLabel_1.setBounds(131, 83, 157, 35);
	    contentPane.add(lblNewLabel_1);
	    
	    JLabel lblNewLabel_2 = new JLabel("Apellidos");
	    lblNewLabel_2.setFont(new Font("Montserrat Medium", Font.PLAIN, 20));
	    lblNewLabel_2.setBounds(131, 172, 157, 29);
	    contentPane.add(lblNewLabel_2);
	    
	    JLabel lblNewLabel_3 = new JLabel("Dirección");
	    lblNewLabel_3.setFont(new Font("Montserrat Medium", Font.PLAIN, 20));
	    lblNewLabel_3.setBounds(131, 211, 157, 31);
	    contentPane.add(lblNewLabel_3);
	    
	    JLabel lblNewLabel_4 = new JLabel("Teléfono");
	    lblNewLabel_4.setFont(new Font("Montserrat Medium", Font.PLAIN, 20));
	    lblNewLabel_4.setBounds(131, 252, 157, 32);
	    contentPane.add(lblNewLabel_4);
	    
	    documentoField = new JTextField();
	    documentoField.setFont(new Font("Montserrat", Font.PLAIN, 20));
	    documentoField.setBounds(298, 83, 204, 35);
	    contentPane.add(documentoField);
	    documentoField.setColumns(10);
	    
	    nombreTextField = new JTextField();
	    nombreTextField.setFont(new Font("Montserrat", Font.PLAIN, 20));
	    nombreTextField.setBounds(298, 130, 204, 32);
	    contentPane.add(nombreTextField);
	    nombreTextField.setColumns(10);
	    
	    apellidosTextField = new JTextField();
	    apellidosTextField.setFont(new Font("Montserrat", Font.PLAIN, 20));
	    apellidosTextField.setBounds(298, 171, 204, 30);
	    contentPane.add(apellidosTextField);
	    apellidosTextField.setColumns(10);
	    
	    direccionTextField = new JTextField();
	    direccionTextField.setFont(new Font("Montserrat", Font.PLAIN, 20));
	    direccionTextField.setBounds(298, 211, 204, 31);
	    contentPane.add(direccionTextField);
	    direccionTextField.setColumns(10);
	    
	    telfTextField = new JTextField();
	    telfTextField.setFont(new Font("Montserrat", Font.PLAIN, 20));
	    telfTextField.setBounds(298, 252, 204, 32);
	    contentPane.add(telfTextField);
	    telfTextField.setColumns(10);
	    
	    btnNewButton = new JButton("Agregar");
	    
	    btnNewButton.addActionListener(new ActionListener() { 
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		try {
	    			
	    			Class.forName("com.mysql.jdbc.Driver");
	    			java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/dentilax?useSSL=false", "root", "1234");
	    			
	    			JOptionPane.showMessageDialog(null, "Correcto.");
	    			
	    			int numdocPaciente = Integer.parseInt(documentoField.getText());
		    		String nombre = nombreTextField.getText();
		    		String apellidos = apellidosTextField.getText();
		    		String direccion = direccionTextField.getText();
		    		int telfPaciente = Integer.parseInt(telfTextField.getText());
		    		
		    		String query = "INSERT INTO sys.paciente (idPaciente, nombre, apellidos, dirección, teléfono) values ('"+numdocPaciente+"', '"+nombre+"', '"+apellidos+"', '"+direccion+"', '"+telfPaciente+"')";
		    		
		    		Statement stmt = (Statement) conexion.createStatement();
		    		
		    		stmt.executeUpdate(query);
		    		
		    		JOptionPane.showMessageDialog(null, "Insertado.");
	    			
	    		} catch (Exception s) {
	    			System.out.println("Error."); 
	    			s.printStackTrace();	
	    		}
	    		
	    	}
	    });
	    
	    btnNewButton.setForeground(new Color(255, 255, 255)); 
	    btnNewButton.setBackground(new Color(0, 140, 206)); 
	    btnNewButton.setFont(new Font("Montserrat", Font.BOLD, 20));
	    btnNewButton.setBounds(131, 339, 157, 44);
	    
	    contentPane.add(btnNewButton);
	    
	    aceptarBoton = new JButton("Listo");
	    
	    aceptarBoton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            dispose();

	            ventanaPrincipal ventanaPrincipal = new ventanaPrincipal(); 
	            ventanaPrincipal.setVisible(true);
	        }
	    });
	    
	    aceptarBoton.setForeground(Color.WHITE);
	    aceptarBoton.setFont(new Font("Montserrat", Font.BOLD, 20));
	    aceptarBoton.setBackground(new Color(0, 140, 206));
	    aceptarBoton.setBounds(131, 407, 157, 44);
	    
	    contentPane.add(aceptarBoton);
	    
	}
}
