import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

public class eliminarPaciente extends JFrame {

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
					eliminarPaciente frame = new eliminarPaciente();
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
	public eliminarPaciente() {
		// Dimensiones
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 1280, 720);
	            
	    // Estilos del JPanel
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    contentPane.setBackground(Color.WHITE);
	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	    
	    JLabel lblNewLabel = new JLabel("Nombre");
	    lblNewLabel.setFont(new Font("Montserrat Medium", Font.PLAIN, 20));
	    lblNewLabel.setBounds(131, 130, 157, 32);
	    contentPane.add(lblNewLabel);
	    
	    JLabel lblNewLabel_1 = new JLabel("Documento");
	    lblNewLabel_1.setFont(new Font("Montserrat Medium", Font.PLAIN, 20));
	    lblNewLabel_1.setBounds(131, 83, 157, 35);
	    contentPane.add(lblNewLabel_1);
	    
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
	    
	    btnNewButton = new JButton("Eliminar");
	    btnNewButton.addActionListener(new ActionListener() { 
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		try {
	    			
	    			Class.forName("com.mysql.jdbc.Driver");
	    			java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/dentilax?useSSL=false", "root", "1234");
	    			
	    			JOptionPane.showMessageDialog(null, "Correcto.");
	    			
	    			int numdocPaciente = Integer.parseInt(documentoField.getText());
		    		String nombre = nombreTextField.getText();
		    		
		    		String query = "DELETE FROM sys.paciente WHERE (idPaciente, nombre) = ('"+numdocPaciente+"', '"+nombre+"')";
		    		
		    		Statement stmt = (Statement) conexion.createStatement();
		    		
		    		stmt.executeUpdate(query);
		    		
		    		JOptionPane.showMessageDialog(null, "Eliminado.");
	    			
	    		} catch (Exception s) {
	    			System.out.println("Error.");  
	    			s.printStackTrace();	
	    		}
	    		
	    	}
	    });
	    
	    btnNewButton.setForeground(new Color(255, 255, 255));  // Establece el color del texto en blanco
	    btnNewButton.setBackground(new Color(0, 140, 206));  // Establece el color de fondo a #008cce
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
