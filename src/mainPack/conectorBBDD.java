package mainPack;

// Imports BBDD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// Fin Imports BBDD
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.sql.PreparedStatement;

/**
 * Autores: David Andrade Pablo Rodriguez Ian Requena 2023
 */

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

	public void cargarDatosPacientes(DefaultTableModel modeloTabla) {
		try {
			Vector<String> columnas = new Vector<>();
			columnas.add("idPaciente");
			columnas.add("nombre");
			columnas.add("apellidos");
			columnas.add("dirección");
			columnas.add("teléfono");

			modeloTabla.setColumnIdentifiers(columnas);

			String consulta = "SELECT * FROM dentilax.paciente";
			Statement statement = conexion.createStatement();
			ResultSet resultado = statement.executeQuery(consulta);

			while (modeloTabla.getRowCount() > 0) {
				modeloTabla.removeRow(0);
			}

			while (resultado.next()) {
				Object[] fila = { 
						resultado.getInt("idPaciente"), 
						resultado.getString("nombre"),
						resultado.getString("apellidos"), 
						resultado.getString("dirección"),
						resultado.getString("teléfono") 
						};
				modeloTabla.addRow(fila);
			}

			cerrarConexion();

		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al cargar los datos de pacientes", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public boolean verificarCredencialesEnBaseDeDatos(String usuario, String contrasenia) {

		try {
			/*
			 * String url = "jdbc:mysql://localhost:3306/sys?useSSL=false"; String dbUser =
			 * "root"; String dbPassword = "1234"; conexion =
			 * DriverManager.getConnection(url, dbUser, dbPassword);
			 */

			conectarConBBDD();

			// Sentencia SQL para comprobar usuario y contraseña
			String selectSQL = "SELECT * FROM dentilax.usuario WHERE Nombre = ? AND contraseña = ?";
			preparedStatement = (PreparedStatement) conexion.prepareStatement(selectSQL);
			preparedStatement.setString(1, usuario);
			preparedStatement.setString(2, contrasenia);
			resultSet = preparedStatement.executeQuery();

			// Condicional para controlar si es admin o es doctor
			if (resultSet.next()) {
				String rol = resultSet.getString("rol");

				if ("administrador".equals(rol)) {
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
				JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error de Inicio de Sesión",
						JOptionPane.ERROR_MESSAGE);
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
