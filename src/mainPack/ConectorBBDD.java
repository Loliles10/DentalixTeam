package mainPack;

// Imports BBDD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.sql.PreparedStatement;

/**
 * Autores: David Andrade Pablo Rodriguez Ian Requena 2023
 */

public class ConectorBBDD {

	// Variables
	String url = "jdbc:mysql://localhost:3306/dentilax";
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

	public void realizarBusqueda(String criterio, DefaultTableModel modeloTabla) {
		PreparedStatement statement = null;
		ResultSet resultado = null;

		try {
			// Verificar si la conexión está cerrada y abrir si es necesario
			if (conexion == null || conexion.isClosed()) {
				conectarConBBDD();
			}
			// CONSULTA SQL con criterio de búsqueda
			String consulta = "SELECT nombre, apellidos, idPaciente, ultimaConsulta FROM dentilax.paciente WHERE nombre LIKE ?";
			statement = conexion.prepareStatement(consulta);
			statement.setString(1, "%" + criterio + "%");

			resultado = statement.executeQuery();

			// Limpiar la tabla antes de agregar nuevos resultados
			modeloTabla.setRowCount(0);

			if (!resultado.next()) {
				// No se encontraron resultados
				System.out.println("No se encontraron resultados para la búsqueda: " + criterio);
			} else {
				// Procesar y mostrar los resultados
				do {
					// Procesar y mostrar los resultados, puedes cambiar esto según tus necesidades
					String nombre = resultado.getString("nombre");
					String apellidos = resultado.getString("apellidos");
					int idPaciente = resultado.getInt("idPaciente");
					String ultimaConsulta = resultado.getString("ultimaConsulta");

					// Agregar la fila a la tabla
					modeloTabla.addRow(new Object[] { nombre, apellidos, idPaciente, ultimaConsulta });

					System.out.println("Nombre: " + nombre + ", Apellidos: " + apellidos + ", ID Paciente: "
							+ idPaciente + ", Última Consulta: " + ultimaConsulta);
				} while (resultado.next());
			}
			// Resto del código para procesar el resultado...
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error SQL al realizar la búsqueda", "Error",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			cerrarRecursos(resultado, statement);
		}
	}

	// Método para cerrar los recursos (ResultSet y PreparedStatement)
	private void cerrarRecursos(ResultSet rs, PreparedStatement stmt) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void cargarDatosPacientes(DefaultTableModel modeloTabla) {
		try {
			Vector<String> columnas = new Vector<>();
			columnas.add("Nombre");
			columnas.add("Apellidos");
			columnas.add("Documento");
			columnas.add("Última Consulta");

			modeloTabla.setColumnIdentifiers(columnas);

			// CONSULTA SQL
			String consulta = "SELECT nombre, apellidos, idPaciente, ultimaConsulta FROM dentilax.paciente";
			Statement statement = conexion.createStatement();
			ResultSet resultado = statement.executeQuery(consulta);

			while (modeloTabla.getRowCount() > 0) {
				modeloTabla.removeRow(0);
			}

			while (resultado.next()) {
				Object[] fila = { resultado.getString("nombre"), resultado.getString("apellidos"),
						resultado.getInt("idPaciente"), resultado.getString("ultimaConsulta") };
				modeloTabla.addRow(fila);
			}

			//cerrarConexion();

		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error SQL al cargar los datos de pacientes", "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception ex) {
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
					new VentanaPrincipal().setVisible(true);
					new VentanaDoctor().setVisible(false);
				} else if ("doctor".equals(rol)) {
					credencialesValidas = true;
					new VentanaDoctor().setVisible(true);
					new VentanaPrincipal().setVisible(false);
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
