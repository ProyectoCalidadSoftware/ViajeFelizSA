package operations;

import dao.EncuestaDAO;
import dto.EncuestaDTO;
import pojo.Constantes;

public class EncuestaServices {

	public EncuestaServices() {
	}

	public void saveEncuesta(String ubicacion, String habitaciones, String servicio, String limpieza, String calidad,
			String comodidad, String comida, String mascotas, String idAlojamiento) {

		Integer ubicacionEncuesta = Integer.parseInt(ubicacion);
		Integer habitacionEncuesta = Integer.parseInt(habitaciones);
		Integer servicioEncuesta = Integer.parseInt(servicio);
		Integer limpiezaEncuesta = Integer.parseInt(limpieza);
		Integer calidadEncuesta = Integer.parseInt(calidad);
		Integer comodidadEncuesta = Integer.parseInt(comodidad);
		Integer comidaEncuesta = Integer.parseInt(comida);
		Integer mascotasEncuesta = Integer.parseInt(mascotas);
		Integer idAlojamientoEncuesta = Integer.parseInt(idAlojamiento);
		Double promedioAlojamiento = (ubicacionEncuesta + habitacionEncuesta + servicioEncuesta + limpiezaEncuesta
				+ calidadEncuesta + comodidadEncuesta + comidaEncuesta + mascotasEncuesta) / Constantes.CANTIDAD_PARAMETROS_ENCUESTA;

		EncuestaDAO encuesta = new EncuestaDAO();
		EncuestaDTO encAlojamiento = new EncuestaDTO(ubicacionEncuesta, habitacionEncuesta, servicioEncuesta,
				limpiezaEncuesta, calidadEncuesta, comodidadEncuesta, comidaEncuesta, mascotasEncuesta);
		encAlojamiento.setIdAlojamiento(idAlojamientoEncuesta);
		encAlojamiento.setPromedio(promedioAlojamiento);

		encuesta.saveEncuesta(encAlojamiento);

	}

}
