package operations;

import dao.AlojamientoDAO;
import dto.AlojamientoDTO;
import pojo.Constantes;

public class AlojamientoServices {

	public AlojamientoServices() {}

	public void postular(String nombreAlojamiento, String tipoAlojamiento, String cantidadPersonasAlojamiento, String cantidadHabitacionesAlojamiento,
			String cantidadBanosAlojamiento, String calefaccionAlojamiento, String aireAcondicionadoAlojamiento, String mascotasAlojamiento, String ciudadAlojamiento,
			String direccionAlojamiento, String barrioAlojamiento, String descripcionAlojamiento, String precioAlojamiento) {

		String nombre = nombreAlojamiento;
		boolean tipo = Constantes.TIPO_CABANA;
		Integer cantidadPersonas = null;
		Integer cantidadHabitaciones = Integer.parseInt(cantidadHabitacionesAlojamiento);
		Integer cantidadBanos = Integer.parseInt(cantidadBanosAlojamiento);
		boolean calefaccion = false;
		boolean aireAcondicionado = false;
		boolean mascotas = false;
		String ciudad = ciudadAlojamiento;
		String direccion = direccionAlojamiento;
		String barrio = barrioAlojamiento;
		String descripcion = descripcionAlojamiento;
		Integer precio = Integer.parseInt(precioAlojamiento);
		
		if (tipoAlojamiento.equals("casa")) {
			tipo = Constantes.TIPO_CASA;
		}
		
		if (cantidadPersonasAlojamiento.equals("personal")) {
			cantidadPersonas = Constantes.TIPO_PERSONAL;
		}
		else if (cantidadPersonasAlojamiento.equals("doble")) {
			cantidadPersonas = Constantes.TIPO_DOBLE;
		}
		else if (cantidadPersonasAlojamiento.equals("familiar")) {
			cantidadPersonas = Constantes.TIPO_FAMILIAR;
		}
		else if (cantidadPersonasAlojamiento.equals("multiple")) {
			cantidadPersonas = Constantes.TIPO_MULTIPLE;
		}
		
		if (calefaccionAlojamiento.equals("on")) {
			calefaccion = true;
		}
		
		if (aireAcondicionadoAlojamiento.equals("on")) {
			aireAcondicionado = true;
		}
		
		if (mascotasAlojamiento.equals("on")) {
			mascotas = true;
		}
		
		AlojamientoDAO alojamiento = new AlojamientoDAO();
		alojamiento.postularAlojamiento(new AlojamientoDTO(nombre, tipo, cantidadPersonas, cantidadHabitaciones,
				cantidadBanos, calefaccion, aireAcondicionado, mascotas, ciudad, direccion, barrio, descripcion, precio));

	}

}
