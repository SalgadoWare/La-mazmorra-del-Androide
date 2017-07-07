package negocio.factoriaNegocio;

import negocio.clasificacion.SAClasificacion;
import negocio.cliente.SACliente;
import negocio.producto.SAProducto;
import negocio.proveedor.SAProveedor;
import negocio.ventas.SAVentas;

/** Factoria encargada de generar los Servecios de aplicacion */
public abstract class FactoriaNegocio {
	/** Tipo de la factoria */
	private static FactoriaNegocio instancia;

	/**
	 * En caso de que la instancia sea null, se crea y despues se devuelve
	 * 
	 * @return intancia
	 */
	public static FactoriaNegocio obtenerInstancia() {
		if (instancia == null)
			instancia = new FactoriaNegocioImp();
		return instancia;
	}

	public abstract SAClasificacion generarSAClasificacion();

	public abstract SACliente generarSACliente();

	public abstract SAProducto generarSAProducto();

	public abstract SAProveedor generarSAProveedor();
	
	public abstract SAVentas generarSAVenta();
}
