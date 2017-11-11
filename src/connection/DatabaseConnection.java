package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private final String URL = "jdbc:postgresql://localhost:5432/viajefeliz";
	private final String USUARIO = "postgres";
	private final String PASS = "root";
	private Connection conexion;
	private static DatabaseConnection baseDatos;
	
	public static DatabaseConnection getInstance() {
		if (baseDatos == null) {
			baseDatos = new DatabaseConnection();
		}
		return baseDatos;
	}
	
	private DatabaseConnection() {
		this.conexion = null;
	}
	
	@SuppressWarnings("finally")
	public Connection conectar() {
		try {
			Class.forName("org.postgresql.Driver");
			conexion = DriverManager.getConnection(URL, USUARIO, PASS);			
			System.out.println("Conexión exitosa ...");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			return conexion;
		}
	}

}
