package presentacion.controlador;

import presentacion.eventos.Evento;

/**Encargado de la comunicacion entre el funcionamiento del
 *  programa y la interfaz*/
public abstract class Controlador {
	/**Tipo del Singleton*/
	private static Controlador instancia;

	/**En caso de que la instancia sea null, se crea y
	 * despues se devuelve
	 * @return intancia*/
	public static Controlador obtenerInstancia() {

		if (instancia == null)
			instancia = new ControladorImp();

		return instancia;
	}

	public abstract void accion(Evento evento, Object objeto);
}