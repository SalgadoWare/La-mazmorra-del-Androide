package negocio.clasificacion;

public class TransferClasificacion {

	/**identificador de cada una de las clasificaciones*/
	private String id;
	/**Edad minima de cada clasificacion*/
	private String edadMinima;
	/**Contenidos de la clasificacion*/
	private String contenidos;
	/**Indicador de si la clasificacion esta activa o no*/
	private String activo;
 
	/**Constructora por defecto de los transfers*/
	public TransferClasificacion(){}
	
	/**Crea un transfer con id de una clasificacion
	 * @param id*/
	public TransferClasificacion(String id) {
		this.id = id;
	}
	
	/**Crea un transfer con los contenidos y la edad minima de la clasificacion
	 * @param edad
	 * @param contenidos*/
	public TransferClasificacion(String dEdad, String contenidos) {
		this.contenidos = contenidos;
		this.edadMinima = dEdad;
	}
	
	public TransferClasificacion(String id, String dEdad, String contenidos) {
		this.id = id;
		this.contenidos = contenidos;
		this.edadMinima = dEdad;
	}

	/**Crea un transfer con el id, la informacion de si esta activo,
	 *  la edad minima y los contenidos de la clasificacion
	 *  @param id
	 *  @param activo
	 *  @param edad
	 *  @param contenidos*/
	public TransferClasificacion(String id, String activo, String edadMinima, String contenidos) {
		this.id = id;
		this.activo = activo;
		this.edadMinima = edadMinima;
		this.contenidos = contenidos;
	}

	/**@return contenidos de la clasificacion*/
	public String getContenidos() {
		return contenidos;
	}

	/**Edita el campo de los contenidos
	 * @param contenidos nuevos*/
	public void setContenidos(String contenidos) {
		this.contenidos = contenidos;
	}

	/**@return edad minima de la clasificacion*/
	public String getEdadMinima() {
		return edadMinima;
	}

	/**Edita el campo de la edad minima
	 * @param edad minima nueva*/
	public void setEdadMinima(String edadMinima) {
		this.edadMinima = edadMinima;
	}

	/**@return id de la clasificacion*/
	public String getId() {
		return id;
	}

	/**Edita el campo del id
	 * @param id nuevo*/
	public void setId(String id) {
		this.id = id;
	}

	/**@return campo activo de la clasificacion*/
	public String getActivo() {
		return activo;
	}

	/**Edita el campo activo de la clasificacion
	 * @param nuevo estado del activo*/
	public void setActivo(String activo) {
		this.activo = activo;
	}
	
	public boolean equals(Object o){
		TransferClasificacion c = (TransferClasificacion) o;
		return c.contenidos.equalsIgnoreCase(this.contenidos) &&
				c.edadMinima.equalsIgnoreCase(this.edadMinima);
	}
}
