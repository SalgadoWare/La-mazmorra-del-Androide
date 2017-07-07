package negocio.factoriaNegocio;

import negocio.clasificacion.SAClasificacion;
import negocio.clasificacion.SAClasificacionImp;
import negocio.cliente.SACliente;
import negocio.cliente.SAClienteImp;
import negocio.producto.SAProducto;
import negocio.producto.SAProductoImp;
import negocio.proveedor.SAProveedor;
import negocio.proveedor.SAProveedorImp;
import negocio.ventas.SAVentas;
import negocio.ventas.SAVentasImp;

/** Genera los distintos servicios de aplicacion */
public class FactoriaNegocioImp extends FactoriaNegocio {

	@Override
	/** @return servicio de aplicacion de la Clasificacion */
	public SAClasificacion generarSAClasificacion() {
		return new SAClasificacionImp();
	}

	@Override
	/** @return servicio de aplicacion de la Cliente */
	public SACliente generarSACliente() {
		return new SAClienteImp();
	}

	@Override
	public SAProducto generarSAProducto() {
		return new SAProductoImp();
	}

	@Override
	public SAProveedor generarSAProveedor() {
		return new SAProveedorImp();
	}
	
	@Override
	public SAVentas generarSAVenta() {
		return new SAVentasImp();
	}
}
