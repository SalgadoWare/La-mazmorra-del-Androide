package negocio.clasificacion;

/**Interfaz de los servicios de aplicacion*/
public interface SAClasificacion {
	public int altaClasificacion(TransferClasificacion objeto);
	public int bajaClasificacion(TransferClasificacion objeto);
	public int actualizarClasificacion(TransferClasificacion objeto);
	TransferClasificacion mostrarUnaClasificacion(TransferClasificacion objeto);
	public TransferClasificacion[] mostrarTodasClasificaciones();
}
