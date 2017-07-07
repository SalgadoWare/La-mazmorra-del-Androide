package negocio.cliente;

public class TransferClienteVip extends TransferCliente {
	
	/**Descuento aplicable del cliente vip*/
	private String descuento;
	/**Puntos acumulados del cliente vip*/
	private String puntos;
	
	/**Constructora por defecto de los transfers*/
	public TransferClienteVip(){
		super();
	}
	
	/**Crea un transfer con id de un cliente
	 * @param id*/
	public TransferClienteVip(String id) {
		super(id);
	}
	
	/**Crea un transfer con el nombre, la direccion, el correo y el descuento del cliente
	 * @param nombre
	 * @param direccion
	 * @param correo
	 * @param descuento*/
	public TransferClienteVip(String nombre, String direccion, String correo, String descuento) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		this.descuento = descuento;
		this.puntos = "0";
	}
	
	public TransferClienteVip(String id, String nombre, String direccion, String correo, String descuento) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		this.descuento = descuento;
	}

	public TransferClienteVip(String id, String activo, String nombre, String direccion, String correo, String descuento, String puntos) {
		this.id = id;
		this.activo = activo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		this.descuento = descuento;
		this.puntos = puntos;
	}
	
	/**@return descuento aplicable del cliente vip*/
	public String getDescuento() {
		return descuento;
	}
	
	/**Edita el campo del descuento
	 * @param descuento nuevo*/
	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}
	
	/**@return puntos acumulados del cliente vip*/
	public String getPuntos() {
		return puntos;
	}
	
	/**Edita el campo de los puntos
	 * @param puntos nuevos*/
	public void setPuntos(String puntos) {
		this.puntos = puntos;
	}
	
	@Override
	public String getTipo() {
		return "Vip";
	}
	
	@Override
	public String toString() {
		return "Id: " + id + "\n    Cliente " + getTipo() + "\n    Nombre: "  + nombre
			+ "\n    Direccion: " + direccion + "\n    Correo: " + correo
			+ "\n    Descuento: "+ descuento + "%\n    Puntos: " + puntos;
	}

}
