package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import connection.DatabaseConnection;
import dto.UsuarioDTO;

public class UsuarioDAO {
	
	private Connection conexion = null;
	private Statement sentencia = null;
	private ResultSet resulSet = null;
	private String query;
	
	public UsuarioDAO() {}
	
	public void registerUser(UsuarioDTO user) {
		
		try {
			query = "";
			conexion = DatabaseConnection.getInstance().conectar();
			sentencia = conexion.createStatement();
			query = "INSERT INTO usuario (usu_nombre, usu_login, usu_password) VALUES ('"+user.getName()+"', '"+user.getUsername()+"' , '"+user.getPassword()+"');";
			sentencia.executeUpdate(query);
			sentencia.close();
			assignRole(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void assignRole(UsuarioDTO user) {
		
		try {
			String code = null;
			query = "";
			conexion = DatabaseConnection.getInstance().conectar();
			sentencia = conexion.createStatement();
			query = "SELECT usu_codigo FROM usuario WHERE usu_login = '"+user.getUsername()+"'";
			resulSet = sentencia.executeQuery(query);
			while (resulSet.next()) {
				code = resulSet.getString("usu_codigo");
			}
			System.out.println(code);
			query = "INSERT INTO usuario_grupo (usg_usuario, usg_grupo) VALUES ('"+code+"', 2);";
			sentencia.executeUpdate(query);
			sentencia.close();
			resulSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public UsuarioDTO getUsuario(String username) {
		UsuarioDTO usuario = null;
		try {
			String usr = "";
			String nombre = "";
			String pwd = "";
			query = "";
			conexion = DatabaseConnection.getInstance().conectar();
			sentencia = conexion.createStatement();
			query = "SELECT * FROM usuario WHERE usu_login = '"+username+"';";
			resulSet = sentencia.executeQuery(query);
			
			while (resulSet.next()) {
				nombre = resulSet.getString("usu_nombre");
				usr = resulSet.getString("usu_login");
				pwd = resulSet.getString("usu_password");
			}
			
			usuario = new UsuarioDTO(nombre, usr, pwd);
			resulSet.close();
			sentencia.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}

	public Integer getIdUsuario(String username) {
		Integer code = null;
		try {
			query = "";
			conexion = DatabaseConnection.getInstance().conectar();
			sentencia = conexion.createStatement();
			query = "SELECT usu_codigo FROM usuario WHERE usu_login = '"+username+"';";
			resulSet = sentencia.executeQuery(query);
			while (resulSet.next()) {
				code = resulSet.getInt("usu_codigo");
			}
			resulSet.close();
			sentencia.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code;
		
	}
	
}
