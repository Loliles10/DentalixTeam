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
import javax.swing.table.TableModel;

import java.sql.PreparedStatement;


public class conectorBBDD {
	
	// Variables
	String url = "jdbc:mysql://localhost:3306/dentilax?useSSL=false";
	String usuario = "root";
	String contrasenia = "1234";
	private Connection conexion; // Conexión
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	boolean credencialesValidas = false;

	// Métodos/Funciones conectarConBBDD
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
	
	// Asegúrate de que la tabla de pacientes tenga un DefaultTableModel configurado
	tablaPersonalizada modeloTabla = new tablaPersonalizada();
	
	// Método para cargar los datos de pacientes
	protected void cargarDatosPacientes(Component componentePrincipal) {
	    try {
	        // Asegurarse de que la conexión a la base de datos se establezca correctamente
	        if (conectarConBBDD()) {
	            // Consulta SQL para obtener datos de la tabla
	            String consulta = "SELECT * FROM dentilax.pacientes";
	            Statement statement = conexion.createStatement();
	            ResultSet resultado = statement.executeQuery(consulta);
	            
	            ventanaPrincipal.tablaPacientes.setModel(modeloTabla);
	            
	            // Configura las columnas de la tabla
	        	modeloTabla.addColumn("PacienteID");
	        	modeloTabla.addColumn("Nombre");
	        	modeloTabla.addColumn("Apellido");
	        	modeloTabla.addColumn("DNI");
	        	modeloTabla.addColumn("FechaNacimiento");
	        	modeloTabla.addColumn("Direccion");
	        	modeloTabla.addColumn("Telefono");
	        	modeloTabla.addColumn("EspecialidadID");

	            // Borra filas existentes de la tabla
	            while (modeloTabla.getRowCount() > 0) {
	                modeloTabla.removeRow(0);
	            }
	            
	            // Agrega filas con datos desde la base de datos
	            while (resultado.next()) {
	                Object[] fila = {
	                    resultado.getInt("PacienteID"),
	                    resultado.getString("Nombre"),
	                    resultado.getString("Apellido"),
	                    resultado.getString("DNI"),
	                    resultado.getDate("FechaNacimiento"),
	                    resultado.getString("Direccion"),
	                    resultado.getString("Telefono"),
	                    resultado.getInt("EspecialidadID")
	                };
	                modeloTabla.addRow(fila);
	            }

	            // Cierra la conexión
	            cerrarConexion();
	        } else {
	            // Manejar errores de conexión
	            JOptionPane.showMessageDialog(componentePrincipal, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(componentePrincipal, "Error al cargar los datos de pacientes", "Error", JOptionPane.ERROR_MESSAGE);
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
	        String selectSQL = "SELECT * FROM dentilax.usuarios WHERE Nombre = ? AND contraseña = ?";
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

