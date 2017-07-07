package integracion.factoriaIntegracion;


import integracion.clasificacion.DAOClasificacion;
import integracion.clasificacion.DAOClasificacionImp;
import integracion.cliente.DAOCliente;
import integracion.cliente.DAOClienteImp;
import integracion.producto.DAOProducto;
import integracion.producto.DAOProductoImp;
import integracion.proveedor.DAOProveedor;
import integracion.proveedor.DAOProveedorImp;
import integracion.ventas.DAOVentas;
import integracion.ventas.DAOVentasImp;

public class FactoriaIntegracionImp extends FactoriaIntegracion {

	@Override
	/**@return DAO de la Clasificacion*/
	public DAOClasificacion generaDAOClasificacion() {
		return new DAOClasificacionImp();
	}
	
	@Override
	/**@return DAO de la Cliente*/
	public DAOCliente generaDAOCliente() {
		return new DAOClienteImp();
	}

	@Override
	public DAOProducto generaDAOProducto() {
		return new DAOProductoImp();
	}

	@Override
	public DAOProveedor generaDAOProveedor() {
		return new DAOProveedorImp();
	}
	
	@Override
	public DAOVentas generaDAOVenta() {
		return new DAOVentasImp();
	}

}
