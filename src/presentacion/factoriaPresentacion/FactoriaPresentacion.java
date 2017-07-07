package presentacion.factoriaPresentacion;

import negocio.ventas.TransferVentas;
import presentacion.GUI;
import presentacion.TipoGUI;

/**Factoria encargada de generar las GUI de la aplicacion*/
public abstract class FactoriaPresentacion {
	/**Tipo de la factoria*/
	private static FactoriaPresentacion instancia;

	/**En caso de que la instancia sea null, se crea y
	 * despues se devuelve
	 * @return intancia*/
	public static FactoriaPresentacion obtenerInstancia() {
		if (instancia == null)
			instancia = new FactoriaPresentacionImp();
		return instancia;
	}

	public abstract GUI crearGUIMenuPrincipal();
	public abstract GUI crearGUIMenuClasificacion();
	public abstract GUI crearGUIMenuCliente();
	public abstract GUI crearGUIMenuProducto();
	public abstract GUI crearGUIMenuProveedor();
	public abstract GUI crearGUIMenuVenta();
	
	public abstract GUI crearGUIClasificacion(TipoGUI tipo);
	public abstract GUI crearGUICliente(TipoGUI tipo);
	public abstract GUI crearGUIProducto(TipoGUI tipo);
	public abstract GUI crearGUIProveedor(TipoGUI tipo);
	public abstract GUI crearGUIVenta(TipoGUI tipo);
	public abstract GUI crearGUIVenta(TipoGUI tipo, TransferVentas tVen);
	

}
