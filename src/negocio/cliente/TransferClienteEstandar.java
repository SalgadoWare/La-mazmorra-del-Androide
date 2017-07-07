package negocio.cliente;

public class TransferClienteEstandar extends TransferCliente {
	
	/**Constructora por defecto de los transfers*/
	public TransferClienteEstandar(){
		super();
	}
	
	/**Crea un transfer con id de un cliente
	 * @param id*/
	public TransferClienteEstandar(String id) {
		super(id);
	}
	
	/**Crea un transfer con el nombre, la direccion, el correo y el descuento del cliente
	 * @param nombre
	 * @param direccion
	 * @param correo
	 * @param descuento*/
	public TransferClienteEstandar(String nombre, String direccion, String correo) {
		super(nombre, direccion, correo);
	}
	
	public TransferClienteEstandar(String id, String nombre, String direccion, String correo) {
		super(id, nombre, direccion, correo);
	}

	public TransferClienteEstandar(String id, String activo, String nombre, String direccion, String correo) {
		super(id, activo, nombre, direccion, correo);
	}
	
	@Override
	public String getTipo() {
		return "Estandar";
	}
	
	@Override
	public String toString() {
		return "Id: " + id + "\n    Cliente " + getTipo() + "\n    Nombre: " + nombre
			+ "\n    Direccion: " + direccion + "\n    Correo: " + correo;
	}

}
