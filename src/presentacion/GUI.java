package presentacion;

import presentacion.eventos.Evento;

/**Interfaz encargada de las GUI*/
public interface GUI {
	public void actualizar(Evento evento, Object objeto);
	void setVisible(boolean b);
}
