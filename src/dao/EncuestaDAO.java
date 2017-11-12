package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import connection.DatabaseConnection;
import dto.EncuestaDTO;

public class EncuestaDAO {
	
	private Connection conexion = null;
	private Statement sentencia = null;
	// private ResultSet resulSet = null;
	private String query;
	
	public EncuestaDAO() {}
	
	public void saveEncuesta(EncuestaDTO encuesta) {
		try {
			query = "";
			conexion = DatabaseConnection.getInstance().conectar();
			sentencia = conexion.createStatement();
			query = "INSERT INTO encuesta (puntaje_ubicacion_encuesta, puntaje_habitaciones_encuesta, puntaje_servicio_encuesta, "
					+ "puntaje_limpieza_encuesta, puntaje_calidad_encuesta, puntaje_comodidad_encuesta, puntaje_comida_encuesta, "
					+ "puntaje_mascotas_encuesta, promedio_encuesta, id_encuesta_alojamiento) "
					+ "VALUES ('"+encuesta.getUbicacion()+"', '"+encuesta.getHabitacion()+"', '"+encuesta.getServicio()+"', "
					+ "'"+encuesta.getLimpieza()+"', '"+encuesta.getCalidad()+"', '"+encuesta.getComodidad()+"', "
					+ "'"+encuesta.getComida()+"', '"+encuesta.getMascotas()+"', '"+encuesta.getPromedio()+"', '"+encuesta.getIdAlojamiento()+"');";
			sentencia.executeUpdate(query);
			sentencia.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
