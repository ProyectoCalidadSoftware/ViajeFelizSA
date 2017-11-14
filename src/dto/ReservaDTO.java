package dto;

public class ReservaDTO {
	
	private Integer id;
	private Integer idAlojamiento;
	private Integer idUsuario;
	private Integer pago;
	private Integer pagoPendiente;
	private String fechaInicio;
	private String fechaFin;
	
	public ReservaDTO(Integer idAlojamiento, Integer idUsuario, Integer pago, Integer pagoPendiente,
			String fechaInicio, String fechaFin) {
		this.idAlojamiento = idAlojamiento;
		this.idUsuario = idUsuario;
		this.pago = pago;
		this.pagoPendiente = pagoPendiente;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdAlojamiento() {
		return idAlojamiento;
	}

	public void setIdAlojamiento(Integer idAlojamiento) {
		this.idAlojamiento = idAlojamiento;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getPago() {
		return pago;
	}

	public void setPago(Integer pago) {
		this.pago = pago;
	}

	public Integer getPagoPendiente() {
		return pagoPendiente;
	}

	public void setPagoPendiente(Integer pagoPendiente) {
		this.pagoPendiente = pagoPendiente;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
}