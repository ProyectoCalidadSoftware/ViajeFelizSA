package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.DatabaseConnection;
import dto.AlojamientoDTO;

public class AlojamientoDAO {

	private Connection conexion = null;
	private Statement sentencia = null;
	private ResultSet resulSet = null;
	private String query;

	public AlojamientoDAO() {}

	public void postularAlojamiento(AlojamientoDTO alojamiento) {
		try {
			query = "";
			conexion = DatabaseConnection.getInstance().conectar();
			sentencia = conexion.createStatement();
			query = "INSERT INTO alojamiento (nombre_alojamiento, tipo_alojamiento, personas_alojamiento, "
					+ "habitaciones_alojamiento, banos_alojamiento, calefaccion_alojamiento, aire_acondicionado_alojamiento, "
					+ "mascotas_alojamiento, ciudad_alojamiento, barrio_alojamiento, descripcion_alojamiento, precio_alojamiento) "
					+ "VALUES ('"+alojamiento.getNombre()+"', '"+alojamiento.getTipo()+"', '"+alojamiento.getCantidadPersonas()+"', "
					+ "'"+alojamiento.getCantidadHabitaciones()+"', '"+alojamiento.getCantidadBanos()+"', '"+alojamiento.isCalefaccion()+"', "
					+ "'"+alojamiento.isAireAcondicionado()+"', '"+alojamiento.isMascotas()+"', '"+alojamiento.getCiudad()+"', '"+alojamiento.getBarrio()+"', "
					+ "'"+alojamiento.getDescripcion()+"', '"+alojamiento.getPrecio()+"');";
			sentencia.executeUpdate(query);
			sentencia.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<AlojamientoDTO> getAllAlojamientos() {
		
		ArrayList<AlojamientoDTO> alojamientos = null;
		String nombre;
		boolean tipo;
		Integer cantidadPersonas;
		Integer cantidadHabitaciones;
		Integer cantidadBanos;
		boolean calefaccion;
		boolean aireAcondicionado;
		boolean mascotas;
		String ciudad;
		String direccion;
		String barrio;
		String descripcion;
		Integer precio;
		
		try {
			alojamientos = new ArrayList<>();
			query = "";
			conexion = DatabaseConnection.getInstance().conectar();
			sentencia = conexion.createStatement();
			query = "SELECT * FROM alojamiento;";
			resulSet = sentencia.executeQuery(query);
			
			while (resulSet.next()) {
				nombre = resulSet.getString("nombre_alojamiento");
				tipo = resulSet.getBoolean("tipo_alojamiento");
				cantidadPersonas = resulSet.getInt("personas_alojamiento");
				cantidadHabitaciones = resulSet.getInt("habitaciones_alojamiento");
				cantidadBanos = resulSet.getInt("banos_alojamiento");
				calefaccion = resulSet.getBoolean("calefaccion_alojamiento");
				aireAcondicionado = resulSet.getBoolean("aire_acondicionado_alojamiento");
				mascotas = resulSet.getBoolean("mascotas_alojamiento");
				ciudad = resulSet.getString("ciudad_alojamiento");
				direccion = resulSet.getString("direccion_alojamiento");
				barrio = resulSet.getString("barrio_alojamiento");
				descripcion = resulSet.getString("descripcion_alojamiento");
				precio = resulSet.getInt("precio_alojamiento");
				System.out.println(nombre + " " + tipo);
				alojamientos.add(new AlojamientoDTO(nombre, tipo, cantidadPersonas, cantidadHabitaciones, cantidadBanos, 
						calefaccion, aireAcondicionado, mascotas, ciudad, barrio, direccion, descripcion, precio));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return alojamientos;
	}

}
