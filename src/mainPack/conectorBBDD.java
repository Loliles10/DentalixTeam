package mainPack;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Imports BBDD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// Fin Imports BBDD
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;


public class conectorBBDD {
	
	// Variables
	String url = "jdbc:mysql://localhost:3306/dentilax?useSSL=false";
	String usuario = "root";
	String contrasenia = "1234";
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	boolean credencialesValidas = false;

	// Métodos/Funciones
	protected boolean conectarConBBDD() {
	    try {
	        conexion = DriverManager.getConnection(url, usuario, contrasenia);
	        return true;
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        System.out.println("Error al conectar con la base de datos");
	        return false;
	    }
	}
	
	protected void cerrarConexion() {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	// Método para mostrar la tabla 'paciente'
	protected void cargarDatosPacientes(Component componentePrincipal) {
	    try {
	        // Consulta para ver la tabla entera de paciente
	        String consulta = "SELECT * FROM sys.paciente";
	        Statement statement = conexion.createStatement(); 
	        ResultSet resultado = statement.executeQuery(consulta);

	        DefaultTableModel modeloTabla = (DefaultTableModel) ventanaPrincipal.tablaPacientes.getModel();
	        modeloTabla.setRowCount(0);  // Borra filas existentes

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
	    } catch (Exception ex) {
	        ex.printStackTrace(); 
	        JOptionPane.showMessageDialog(componentePrincipal, "Error al cargar los datos de pacientes", "Error", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
	
	// Método para verificar credenciales 
	public boolean verificarCredencialesEnBaseDeDatos(String usuario, String contrasenia) {
	    
	    try {
	        /*String url = "jdbc:mysql://localhost:3306/sys?useSSL=false";
	        String dbUser = "root";
	        String dbPassword = "1234";
	        conexion = DriverManager.getConnection(url, dbUser, dbPassword);*/
	    	
	    	conectarConBBDD();
	        
	    	// Sentencia SQL para comprobar usuario y contraseña
	        String selectSQL = "SELECT * FROM sys.usuario WHERE Nombre = ? AND contraseña = ?";
	        preparedStatement = (PreparedStatement) conexion.prepareStatement(selectSQL);
	        preparedStatement.setString(1, usuario);
	        preparedStatement.setString(2, contrasenia);
	        resultSet = preparedStatement.executeQuery();
	        
	        // Condicional para controlar si es admin o es doctor
	        if (resultSet.next()) {
	            String rol = resultSet.getString("rol");
	            
	            if ("admin".equals(rol)) {
	                credencialesValidas = true;
	                new ventanaPrincipal().setVisible(true);
	                new ventanaEspectador().setVisible(false);
	            } else if ("doctor".equals(rol)) {
	                credencialesValidas = true;
	                new ventanaEspectador().setVisible(true);
	                new ventanaPrincipal().setVisible(false);
	            } else {
	                JOptionPane.showMessageDialog(null, "Rol no válido", "Error de Rol", JOptionPane.ERROR_MESSAGE);
	            }
	            
	        } else {
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
	            if (conexion != null) {
	                conexion.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return credencialesValidas;
	}
	

	
}

