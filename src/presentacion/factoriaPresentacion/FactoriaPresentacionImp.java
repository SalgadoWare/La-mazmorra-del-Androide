package presentacion.factoriaPresentacion;

import negocio.ventas.TransferVentas;
import presentacion.GUI;
import presentacion.TipoGUI;
import presentacion.clasificacion.GUIClasificacion;
import presentacion.clasificacion.GUIMenuClasificacion;
import presentacion.cliente.GUICliente;
import presentacion.cliente.GUIMenuCliente;
import presentacion.menuprincipal.GUIMenuPrincipal;
import presentacion.producto.GUIMenuProducto;
import presentacion.producto.GUIProducto;
import presentacion.proveedor.GUIMenuProveedor;
import presentacion.proveedor.GUIProveedor;
import presentacion.ventas.GUIMenuVentas;
import presentacion.ventas.GUIVentas;

/** Implementacion del resto de metodos de la Factoria de Presentacion */
public class FactoriaPresentacionImp extends FactoriaPresentacion {

	@Override
	/** @return interfaz grafica del menu principal */
	public GUI crearGUIMenuPrincipal() {
		return new GUIMenuPrincipal();
	}

	@Override
	/**
	 * @return interfaz grafica de los mensajes resultantes de cada una de las
	 *         acciones de clasificacion
	 */
	public GUI crearGUIClasificacion(TipoGUI tipo) {
		return new GUIClasificacion(tipo);
	}

	@Override
	/**
	 * @return interfaz grafica de los mensajes resultantes de cada una de las
	 *         acciones de cliente
	 */
	public GUI crearGUICliente(TipoGUI tipo) {
		return new GUICliente(tipo);
	}

	@Override
	public GUI crearGUIProducto(TipoGUI tipo) {
		return new GUIProducto(tipo);
	}

	@Override
	public GUI crearGUIProveedor(TipoGUI tipo) {
		return new GUIProveedor(tipo);
	}
	
	@Override
	public GUI crearGUIVenta(TipoGUI tipo) {
		return new GUIVentas(tipo);
	}
	
	@Override
	public GUI crearGUIVenta(TipoGUI tipo, TransferVentas tVen) {
		return new GUIVentas(tipo, tVen);
	}

	@Override
	public GUI crearGUIMenuProveedor() {
		return new GUIMenuProveedor();
	}

	@Override
	public GUI crearGUIMenuClasificacion() {
		return new GUIMenuClasificacion();
	}

	@Override
	public GUI crearGUIMenuCliente() {
		return new GUIMenuCliente();
	}

	@Override
	public GUI crearGUIMenuProducto() {
		return new GUIMenuProducto();
	}
	
	@Override
	public GUI crearGUIMenuVenta() {
		return new GUIMenuVentas();
	}
}
