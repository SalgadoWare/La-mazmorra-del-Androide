package integracion.factoriaIntegracion;

import integracion.clasificacion.DAOClasificacion;
import integracion.cliente.DAOCliente;
import integracion.producto.DAOProducto;
import integracion.proveedor.DAOProveedor;
import integracion.ventas.DAOVentas;

/** Factoria encargada de generar los DAOs */
public abstract class FactoriaIntegracion {
	/** Tipo de la factoria */
	private static FactoriaIntegracion instancia;

	/**
	 * En caso de que la instancia sea null, se crea y despues se devuelve
	 * 
	 * @return intancia
	 */
	public static FactoriaIntegracion obtenerInstancia() {
		if (instancia == null)
			instancia = new FactoriaIntegracionImp();
		return instancia;
	}

	public abstract DAOClasificacion generaDAOClasificacion();

	public abstract DAOCliente generaDAOCliente();

	public abstract DAOProducto generaDAOProducto();

	public abstract DAOProveedor generaDAOProveedor();
	
	public abstract DAOVentas generaDAOVenta();
}
