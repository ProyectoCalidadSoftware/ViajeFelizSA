package dto;

public class AlojamientoDTO {
	
	private Integer id;
	private String nombre;
	private boolean tipo;
	private Integer cantidadPersonas;
	private Integer cantidadHabitaciones;
	private Integer cantidadBanos;
	private boolean calefaccion;
	private boolean aireAcondicionado;
	private boolean mascotas;
	private String ciudad;
	private String direccion;
	private String barrio;
	private String descripcion;
	private Integer precio;
	
	public AlojamientoDTO (String nombre, boolean tipo, Integer cantidadPersonas, Integer cantidadHabitaciones,
			Integer cantidadBanos, boolean calefaccion, boolean aireAcondicionado, boolean mascotas, String ciudad,
			String direccion, String barrio, String descripcion, Integer precio) {
		
		this.nombre = nombre;
		this.tipo = tipo;
		this.cantidadPersonas = cantidadPersonas;
		this.cantidadHabitaciones = cantidadHabitaciones;
		this.cantidadBanos = cantidadBanos;
		this.calefaccion = calefaccion;
		this.aireAcondicionado = aireAcondicionado;
		this.mascotas = mascotas;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.barrio = barrio;
		this.descripcion = descripcion;
		this.precio = precio;
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean getTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public Integer getCantidadPersonas() {
		return cantidadPersonas;
	}

	public void setCantidadPersonas(Integer cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}

	public Integer getCantidadHabitaciones() {
		return cantidadHabitaciones;
	}

	public void setCantidadHabitaciones(Integer cantidadHabitaciones) {
		this.cantidadHabitaciones = cantidadHabitaciones;
	}

	public Integer getCantidadBanos() {
		return cantidadBanos;
	}

	public void setCantidadBanos(Integer cantidadBanos) {
		this.cantidadBanos = cantidadBanos;
	}

	public boolean isCalefaccion() {
		return calefaccion;
	}

	public void setCalefaccion(boolean calefaccion) {
		this.calefaccion = calefaccion;
	}

	public boolean isAireAcondicionado() {
		return aireAcondicionado;
	}

	public void setAireAcondicionado(boolean aireAcondicionado) {
		this.aireAcondicionado = aireAcondicionado;
	}

	public boolean isMascotas() {
		return mascotas;
	}

	public void setMascotas(boolean mascotas) {
		this.mascotas = mascotas;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}	

}