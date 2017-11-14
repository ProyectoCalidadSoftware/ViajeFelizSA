package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import connection.DatabaseConnection;
import dto.ReservaDTO;

public class ReservaDAO {
	
	private Connection conexion = null;
	private Statement sentencia = null;
	// private ResultSet resulSet = null;
	private String query;
	
	public ReservaDAO() {}
	
	public void reservarAlojamiento(ReservaDTO reservaDTO) {
		try {
			query = "";
			conexion = DatabaseConnection.getInstance().conectar();
			sentencia = conexion.createStatement();
			query = "INSERT INTO reserva (id_alojamiento_reserva, id_usuario_alojamiento, pago_reserva, pago_pendiente_reserva, fecha_inicio_reserva, fecha_fin_reserva) VALUES ('"
					+ reservaDTO.getIdAlojamiento() + "', '" + reservaDTO.getIdUsuario() + "', '" + reservaDTO.getPago()
					+ "', '" + reservaDTO.getPagoPendiente() + "', '" + reservaDTO.getFechaInicio() + "', '"
					+ reservaDTO.getFechaFin() + "');";
			sentencia.executeUpdate(query);
			sentencia.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
