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
    PreparedStatement statementPaciente = null;
    PreparedStatement statementDoctor = null;
    ResultSet resultadoPaciente = null;
    ResultSet resultadoDoctor = null;

    try {
        // Verificar si la conexión está cerrada y abrir si es necesario
        if (conexion == null || conexion.isClosed()) {
            conectarConBBDD();
        }

        // CONSULTA SQL para la tabla 'dentilax.paciente'
        String consultaPaciente = "SELECT nombre, apellidos, idPaciente, ultimaConsulta FROM dentilax.paciente WHERE nombre LIKE ? OR idPaciente LIKE ?";
        statementPaciente = conexion.prepareStatement(consultaPaciente);
        statementPaciente.setString(1, "%" + criterio + "%");
        statementPaciente.setString(2, "%" + criterio + "%");

        resultadoPaciente = statementPaciente.executeQuery();

        // CONSULTA SQL para la tabla 'dentilax.doctor'
        String consultaDoctor = "SELECT nombre, apellidos, idDoctor, email FROM dentilax.doctor WHERE nombre LIKE ? OR idDoctor LIKE ?";
        statementDoctor = conexion.prepareStatement(consultaDoctor);
        statementDoctor.setString(1, "%" + criterio + "%");
        statementDoctor.setString(2, "%" + criterio + "%");

        resultadoDoctor = statementDoctor.executeQuery();

        // Limpiar la tabla antes de agregar nuevos resultados
        modeloTabla.setRowCount(0);

        // Procesar y mostrar los resultados para 'dentilax.paciente'
        while (resultadoPaciente.next()) {
            String nombre = resultadoPaciente.getString("nombre");
            String apellidos = resultadoPaciente.getString("apellidos");
            int idPaciente = resultadoPaciente.getInt("idPaciente");
            String ultimaConsulta = resultadoPaciente.getString("ultimaConsulta");

            // Agregar la fila a la tabla
            modeloTabla.addRow(new Object[]{nombre, apellidos, idPaciente, ultimaConsulta});

            System.out.println("Nombre Paciente: " + nombre + ", Apellidos: " + apellidos + ", ID Paciente: "
                    + idPaciente + ", Última Consulta: " + ultimaConsulta);
        }

        // Procesar y mostrar los resultados para 'dentilax.doctor'
        while (resultadoDoctor.next()) {
            String nombreDoctor = resultadoDoctor.getString("nombre");
            String apellidosDoctor = resultadoDoctor.getString("apellidos");
            int idDoctor = resultadoDoctor.getInt("idDoctor");
            String emailDoctor = resultadoDoctor.getString("email");

            // Agregar la fila a la tabla
            modeloTabla.addRow(new Object[]{nombreDoctor, apellidosDoctor, idDoctor, emailDoctor});

            System.out.println("Nombre Doctor: " + nombreDoctor + ", Apellidos: " + apellidosDoctor + ", ID Doctor: "
                    + idDoctor + ", Email: " + emailDoctor);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error SQL al realizar la búsqueda", "Error",
                JOptionPane.ERROR_MESSAGE);
    } finally {
        cerrarRecursos(resultadoPaciente, statementPaciente);
        cerrarRecursos(resultadoDoctor, statementDoctor);
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
	
	public void cargarDatosDoctores(DefaultTableModel modeloTabla) {
	    try {
	        Vector<String> columnas = new Vector<>();
	        columnas.add("Nombre");
	        columnas.add("Apellidos");
	        columnas.add("ID");
	        columnas.add("Email");

	        modeloTabla.setColumnIdentifiers(columnas);

	        // CONSULTA SQL
	        String consulta = "SELECT nombre, apellidos, idDoctor, email FROM dentilax.doctor";
	        Statement statement = conexion.createStatement();
	        ResultSet resultado = statement.executeQuery(consulta);

	        while (modeloTabla.getRowCount() > 0) {
	            modeloTabla.removeRow(0);
	        }

	        while (resultado.next()) {
	            Object[] fila = {
	                resultado.getString("nombre"),
	                resultado.getString("apellidos"),
	                resultado.getInt("idDoctor"),
	                resultado.getString("email")
	            };
	            modeloTabla.addRow(fila);
	        }

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error SQL al cargar los datos de doctores", "Error",
	                JOptionPane.ERROR_MESSAGE);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error al cargar los datos de doctores", "Error",
	                JOptionPane.ERROR_MESSAGE);
	    }
	}

	private String obtenerEspecialidad(int idEspecialidad) {
	    try {
	        String consultaEspecialidad = "SELECT nombre FROM dentilax.especialidad WHERE idEspecialidad = ?";
	        PreparedStatement statementEspecialidad = conexion.prepareStatement(consultaEspecialidad);
	        statementEspecialidad.setInt(1, idEspecialidad);
	        ResultSet resultadoEspecialidad = statementEspecialidad.executeQuery();

	        if (resultadoEspecialidad.next()) {
	            return resultadoEspecialidad.getString("nombre");
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return "";
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
