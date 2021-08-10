package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {
	private static Connection conexion;

	public Connection getConexion() {
		return conexion;
	}

//	Funcion que realiza la conexion con la base de datos.
	public void ConectarBD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://192.168.0.40:3306?useTimezone=true&serverTimezone=UTC", "remote", "aZsX1!dC");
			System.out.println("Conexion establecida.");

		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("No ha podido conectar con la base de datos.");
			System.out.println(ex);

		}

	}

//	Funcion que cierra la conexion con la base de datos.
	public void desconectarBD() {
		try {
			conexion.close();
			System.out.println("Conexion finalizada.");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("ERROR: No hay conexion.");

		}
	}

//	Funcion que recibe por parametro una accion y una query y realiza una consulta en la base de datos.
	public String Consulta(String accion, String query) {
		String resultado = "";
		String id = "";

		try {
			String sql = "Select * from cliente where id = ? ";
			String QueryDB = "USE s22ud22ej1";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(QueryDB);
			PreparedStatement consulta = conexion.prepareStatement(sql);
			consulta.setInt(1, Integer.parseInt(query));
			ResultSet res = consulta.executeQuery();
			
			while (res.next()) {
				resultado += "ID: " + res.getString("id") + 
							"  |  " + res.getString("nombre") +
							" " + res.getString("apellido") +
							"  |  Direccion: " + res.getString("direccion") +
							"  |  DNI: " + res.getString("dni") +
							"  |  Fecha: " + res.getString("fecha");
				
			}
			
			res.close();
			return resultado;
			
		} catch (SQLException e) {
			System.out.println(e);
			return "Error al " + accion + " los datos";
			
		}
	}
	
//	Funcion que realiza un update en la base de datos.
	public String Editar(String nombre, String accion, String query) {
		try {
			String QueryDB = "USE s22ud22ej1";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(QueryDB);
			Statement st = conexion.createStatement();
			st.executeUpdate(query);
			return ("Datos " + nombre + " correctamente");
			
		} catch (SQLException e) {
			return ("Error al " + accion + " datos");
			
		}
	}
}