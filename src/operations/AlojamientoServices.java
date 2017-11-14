package operations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import dao.AlojamientoDAO;
import dao.ReservaDAO;
import dao.UsuarioDAO;
import dto.AlojamientoDTO;
import dto.ReservaDTO;
import pojo.Constantes;
import pojo.Fechas;

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
	
	public ArrayList<AlojamientoDTO> searchReservarByParameters(String fechaInicio, String fechaFin, String tipo, String numHabitaciones, String ciudad) {
		boolean tipoAl = false;
		Integer numHabit = Integer.parseInt(numHabitaciones);
		if (tipo.equals("casa")) {
			tipoAl = Constantes.TIPO_CASA;
		}
		
		AlojamientoDAO alojamientoDAO = new AlojamientoDAO();
		ArrayList<AlojamientoDTO> alList = alojamientoDAO.getAlojamientosByParameters(fechaInicio, fechaFin, tipoAl, numHabit, ciudad);
		return alList;
	}
	
	public AlojamientoDTO getAlojamientoById(String id) {   
		AlojamientoDTO alojamientoDTO = null;
        try {
        	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            String dateIniSemanaSanta = Fechas.FECHA_INICIO_SEMANA_SANTA;
            String dateFinSemanaSanta = Fechas.FECHA_FIN_SEMANA_SANTA;
            String dateIniTemporadaAlta = Fechas.FECHA_FIN_SEMANA_SANTA;
            String dateFinTemporadaAlta = Fechas.FECHA_FIN_SEMANA_SANTA;
            
            Date dateNow = Calendar.getInstance().getTime();
            Date dateIniSS = formatter.parse(dateIniSemanaSanta);
            Date dateFinSS = formatter.parse(dateFinSemanaSanta);
            Date dateIniTA = formatter.parse(dateIniTemporadaAlta);
            Date dateFinTA = formatter.parse(dateFinTemporadaAlta);
            
            AlojamientoDAO alojamientoDAO = new AlojamientoDAO();
            alojamientoDTO = alojamientoDAO.getAlojamientoById(Integer.parseInt(id));
            
            if (dateNow.equals(dateIniSS) || dateNow.equals(dateFinSS) || dateNow.equals(dateIniTA)
					|| dateNow.equals(dateFinTA) || (dateNow.after(dateIniSS) && dateNow.before(dateFinSS))
					|| (dateNow.after(dateIniTA) && dateNow.before(dateFinTA))) {
            	Integer precio = alojamientoDTO.getPrecio(); 
            	Integer precioTotal = (int) (precio * 0.3) + precio;   
            	alojamientoDTO.setPrecio(precioTotal);				
			}
            else {
            	Integer precio = alojamientoDTO.getPrecio(); 
            	Integer precioTotal = (int) (precio * 0.1) + precio;   
            	alojamientoDTO.setPrecio(precioTotal);	
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		return alojamientoDTO;
	}
	
	public void reservarAlojamiento(String idAl, String user, String precio, String pagoRestante, String fechaIni, String fechaFin) {
		Integer id = Integer.parseInt(idAl);
		Integer pago = Integer.parseInt(precio);
		Integer pagoPendiente = Integer.parseInt(pagoRestante);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Integer idUsuario = usuarioDAO.getIdUsuario(user);
		ReservaDAO reservaDAO = new ReservaDAO();
		reservaDAO.reservarAlojamiento(new ReservaDTO(id, idUsuario, pago, pagoPendiente, fechaIni, fechaFin));
	}

}
