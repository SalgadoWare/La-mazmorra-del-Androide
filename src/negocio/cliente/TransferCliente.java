package negocio.cliente;

public class TransferCliente {

	/**identificador de cada una de los clientes*/
	protected String id;
	/**Nombre de cada cliente*/
	protected String nombre;
	/**Direccion del cliente*/
	protected String direccion;
	/**Correo del cliente*/
	protected String correo;
	/**Indicador de si el cliente esta activo o no*/
	protected String activo;
 
	/**Constructora por defecto de los transfers*/
	public TransferCliente(){}
	
	/**Crea un transfer con id de un cliente
	 * @param id*/
	public TransferCliente(String id_s) {
		this.id = id_s;
	}
	
	/**Crea un transfer con el nombre, la direccion y el correo del cliente
	 * @param nombre
	 * @param direccion
	 * @param correo*/
	public TransferCliente(String nombre, String direccion, String correo) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
	}
	
	public TransferCliente(String id, String nombre, String direccion, String correo) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
	}

	public TransferCliente(String id, String activo, String nombre, String direccion, String correo) {
		this.id = id;
		this.activo = activo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
	}

	/**@return nombre del cliente*/
	public String getNombre() {
		return nombre;
	}

	/**Edita el campo del nombre
	 * @param nombre nuevo*/
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**@return direccion del cliente*/
	public String getDireccion() {
		return direccion;
	}

	/**Edita el campo de la direccion
	 * @param direccion nueva*/
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**@return correo del cliente*/
	public String getCorreo() {
		return correo;
	}

	/**Edita el campo del correo
	 * @param direccion nueva*/
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	/**@return id del cliente*/
	public String getId() {
		return id;
	}

	/**Edita el campo del id
	 * @param id nuevo*/
	public void setId(String id) {
		this.id = id;
	}

	/**@return campo activo del cliente*/
	public String getActivo() {
		return activo;
	}

	/**Edita el campo activo del cliente
	 * @param nuevo estado del activo*/
	public void setActivo(String activo) {
		this.activo = activo;
	}
	
	public String getTipo() {
		return "default";
	}
	
	public boolean equals(Object o){
		TransferCliente c = (TransferCliente) o;
		return c.correo.equalsIgnoreCase(this.correo);
	}
}
