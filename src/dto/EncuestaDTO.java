package dto;

public class EncuestaDTO {
	
	private Integer ubicacion;
	private Integer habitacion;
	private Integer servicio;
	private Integer limpieza;
	private Integer calidad;
	private Integer comodidad;
	private Integer comida;
	private Integer mascotas;
	private Double promedio;
	private Integer idAlojamiento;
	
	public EncuestaDTO(Integer ubicacion, Integer habitacion, Integer servicio, Integer limpieza, Integer calidad,
			Integer comodidad, Integer comida, Integer mascotas) {
		this.ubicacion = ubicacion;
		this.habitacion = habitacion;
		this.servicio = servicio;
		this.limpieza = limpieza;
		this.calidad = calidad;
		this.comodidad = comodidad;
		this.comida = comida;
		this.mascotas = mascotas;
	}

	public Integer getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Integer ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Integer habitacion) {
		this.habitacion = habitacion;
	}

	public Integer getServicio() {
		return servicio;
	}

	public void setServicio(Integer servicio) {
		this.servicio = servicio;
	}

	public Integer getLimpieza() {
		return limpieza;
	}

	public void setLimpieza(Integer limpieza) {
		this.limpieza = limpieza;
	}

	public Integer getCalidad() {
		return calidad;
	}

	public void setCalidad(Integer calidad) {
		this.calidad = calidad;
	}

	public Integer getComodidad() {
		return comodidad;
	}

	public void setComodidad(Integer comodidad) {
		this.comodidad = comodidad;
	}

	public Integer getComida() {
		return comida;
	}

	public void setComida(Integer comida) {
		this.comida = comida;
	}

	public Integer getMascotas() {
		return mascotas;
	}

	public void setMascotas(Integer mascotas) {
		this.mascotas = mascotas;
	}

	public Double getPromedio() {
		return promedio;
	}

	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}

	public Integer getIdAlojamiento() {
		return idAlojamiento;
	}

	public void setIdAlojamiento(Integer idAlojamiento) {
		this.idAlojamiento = idAlojamiento;
	}
		
}