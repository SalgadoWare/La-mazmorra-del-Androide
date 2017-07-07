package presentacion.controlador;

import java.util.HashMap;

import negocio.clasificacion.SAClasificacion;
import negocio.clasificacion.TransferClasificacion;
import negocio.cliente.SACliente;
import negocio.cliente.TransferCliente;
import negocio.factoriaNegocio.FactoriaNegocio;
import negocio.producto.SAProducto;
import negocio.producto.TransferProducto;
import negocio.proveedor.SAProveedor;
import negocio.proveedor.TransferProveedor;
import negocio.ventas.LineaVenta;
import negocio.ventas.SAVentas;
import negocio.ventas.TransferVentas;
import presentacion.GUI;
import presentacion.TipoGUI;
import presentacion.eventos.Evento;
import presentacion.factoriaPresentacion.FactoriaPresentacion;

/** Implementacion del controlador */
public class ControladorImp extends Controlador {

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * Ejecuta las acciones seleccionadas a traves de la interfaz, ya sea
	 * realizar cambios en los datos de la aplicacion o mostrar otras interfaces
	 * graficas
	 */
	public void accion(Evento evento, Object objeto) {
		switch (evento) {

		// Mantened el orden alfabetico

		case abrirActualizarClasificacion:
			FactoriaPresentacion.obtenerInstancia().crearGUIClasificacion(TipoGUI.actualizar);
			break;

		case abrirActualizarCliente:
			FactoriaPresentacion.obtenerInstancia().crearGUICliente(TipoGUI.actualizar);
			break;
			
		case abrirActualizarClienteEstandar:
			FactoriaPresentacion.obtenerInstancia().crearGUICliente(TipoGUI.actualizarEstandar);
			break;
			
		case abrirActualizarClienteVip:
			FactoriaPresentacion.obtenerInstancia().crearGUICliente(TipoGUI.actualizarVip);
			break;

		case abrirActualizarProducto:
			FactoriaPresentacion.obtenerInstancia().crearGUIProducto(TipoGUI.actualizar);
			break;
			
		case abrirActualizarProveedor:
			FactoriaPresentacion.obtenerInstancia().crearGUIProveedor(TipoGUI.actualizar);
			break;

		case abrirAltaClasificacion:
			FactoriaPresentacion.obtenerInstancia().crearGUIClasificacion(TipoGUI.alta);
			break;

		case abrirAltaCliente:
			FactoriaPresentacion.obtenerInstancia().crearGUICliente(TipoGUI.alta);
			break;
			
		case abrirAltaClienteEstandar:
			FactoriaPresentacion.obtenerInstancia().crearGUICliente(TipoGUI.altaEstandar);
			break;
			
		case abrirVenta:
			FactoriaPresentacion.obtenerInstancia().crearGUIVenta(TipoGUI.abrirVenta);
			break;
			
		case abrirAltaClienteVip:
			FactoriaPresentacion.obtenerInstancia().crearGUICliente(TipoGUI.altaVip);
			break;
			
		case abrirAltaProducto:
			FactoriaPresentacion.obtenerInstancia().crearGUIProducto(TipoGUI.alta);
			break;
			
		case abrirAltaProveedor:
			FactoriaPresentacion.obtenerInstancia().crearGUIProveedor(TipoGUI.alta);
			break;
			
		case abrirBajaClasificacion:
			FactoriaPresentacion.obtenerInstancia().crearGUIClasificacion(TipoGUI.baja);
			break;

		case abrirBajaCliente:
			FactoriaPresentacion.obtenerInstancia().crearGUICliente(TipoGUI.baja);
			break;

		case abrirBajaProducto:
			FactoriaPresentacion.obtenerInstancia().crearGUIProducto(TipoGUI.baja);
			break;
			
		case abrirBajaProveedor:
			FactoriaPresentacion.obtenerInstancia().crearGUIProveedor(TipoGUI.baja);
			break;
			
		case abrirCerrarVenta:
			FactoriaPresentacion.obtenerInstancia().crearGUIVenta(TipoGUI.baja);
			break;
			
		case abrirDevolverVenta:
			FactoriaPresentacion.obtenerInstancia().crearGUIVenta(TipoGUI.devolverVenta);
			break;

		case altaClasificacion:
			gestionarAltaClasificacion((TransferClasificacion) objeto);
			break;

		case altaCliente:
			gestionarAltaCliente((TransferCliente) objeto);
			break;

		case altaProducto:
			gestionarAltaProducto((TransferProducto) objeto);
			break;

		case altaProveedor:
			gestionarAltaProveedor((TransferProveedor) objeto);
			break;
			
		case abrirMenuClasificacion:
			FactoriaPresentacion.obtenerInstancia().crearGUIMenuClasificacion();
			break;

		case abrirMenuCliente:
			FactoriaPresentacion.obtenerInstancia().crearGUIMenuCliente();
			break;

		case abrirMenuPrincipal:
			FactoriaPresentacion.obtenerInstancia().crearGUIMenuPrincipal();
			break;

		case abrirMenuProducto:
			FactoriaPresentacion.obtenerInstancia().crearGUIMenuProducto();
			break;

		case abrirMenuProveedores:
			FactoriaPresentacion.obtenerInstancia().crearGUIMenuProveedor();
			break;
			
		case abrirMenuVenta:
			FactoriaPresentacion.obtenerInstancia().crearGUIMenuVenta();
			break;
			
		case abrirMostrarUnaClasificacion:
			FactoriaPresentacion.obtenerInstancia().crearGUIClasificacion(TipoGUI.mostrarUno);
			break;
			
		case abrirMostrarUnaVenta:
			FactoriaPresentacion.obtenerInstancia().crearGUIVenta(TipoGUI.mostrarUno);
			break;

		case abrirMostrarUnCliente:
			FactoriaPresentacion.obtenerInstancia().crearGUICliente(TipoGUI.mostrarUno);
			break;
			
		case abrirMostrarUnProducto:
			FactoriaPresentacion.obtenerInstancia().crearGUIProducto(TipoGUI.mostrarUno);
			break;
			
		case abrirMostrarUnProveedor:
			FactoriaPresentacion.obtenerInstancia().crearGUIProveedor(TipoGUI.mostrarUno);
			break;

		case actualizarClasificacion:
			gestionarActualizarClasificacion((TransferClasificacion) objeto);
			break;

		case actualizarCliente:
			gestionarActualizarCliente((TransferCliente) objeto);
			break;

		case actualizarProducto:
			gestionarActualizarProducto((TransferProducto) objeto);
			break;

		case actualizarProveedor:
			gestionarActualizarProveedores((TransferProveedor) objeto);
			break;
			
		case bajaClasificacion:
			gestionarBajaClasificacion((TransferClasificacion) objeto);
			break;

		case bajaCliente:
			gestionarBajaCliente((TransferCliente) objeto);
			break;

		case bajaProducto:
			gestionarBajaProducto((TransferProducto) objeto);
			break;
			
		case bajaProveedor:
			gestionarBajaProveedor((TransferProveedor) objeto);
			break;

		case devolverVenta:
			gestionarDevolverVenta((TransferVentas) objeto);
			break;
			
		case cerrarVenta:
			gestionarCerrarVenta((TransferVentas) objeto);
			break;

		case mostrarCarrito:
			gestionarMostrarCarrito((HashMap<Integer, LineaVenta>) objeto);
			break;
			
		case mostrarTodasClasificaciones:
			gestionarMostrarTodasLasClasificaciones();
			break;
			
		case mostrarTodasVentas:
			gestionarMostrarTodasLasVentas();
			break;

		case mostrarTodosClientes:
			gestionarMostrarTodosLosClientes();
			break;

		case mostrarTodosProductos:
			gestionarMostrarTodosLosProductos();
			break;
			
		case mostrarTodosProveedores:
			gestionarMostrarTodosProveedores();
			break;

		case mostrarUnaClasificacion:
			gestionarMostrarUnaClasificacion((TransferClasificacion) objeto);
			break;
			
		case mostrarUnaVenta:
			gestionarMostrarUnaVenta((TransferVentas) objeto);
			break;

		case mostrarUnCliente:
			gestionarMostrarUnCliente((TransferCliente) objeto);
			break;

		case mostrarUnProducto:
			gestionarMostrarUnProducto((TransferProducto) objeto);
			break;
			
		case mostrarUnProveedor:
			gestionarMostrarUnProveedor((TransferProveedor) objeto);
			break;
			
		default:
			break;
		}
	}

	// Id escribiendo todas los actualizar sucesivamente, luego todas las altas,
	// y as sucesivamente

	//Gestionar Actualizar 

	private void gestionarActualizarClasificacion(TransferClasificacion tCla) {

		SAClasificacion saClasificacion = FactoriaNegocio.obtenerInstancia().generarSAClasificacion();
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUIClasificacion(TipoGUI.actualizar);

		switch (saClasificacion.actualizarClasificacion(tCla)) {

		case 0:
			vista.actualizar(Evento.actualizarClasificacion, tCla.getId());
			break;

		case -1:
			vista.actualizar(Evento.errorActualizarClasificacion, null);
			break;

		case -2:
			vista.actualizar(Evento.errorArgumentos, null);
			break;
		}
	}
	
	private void gestionarActualizarCliente(TransferCliente tCli) {

		SACliente saCliente = FactoriaNegocio.obtenerInstancia().generarSACliente();
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUICliente(TipoGUI.actualizar);

		switch (saCliente.actualizarCliente(tCli)) {

		case 0:
			vista.actualizar(Evento.actualizarCliente, tCli.getId());
			break;

		case -1:
			vista.actualizar(Evento.errorActualizarCliente, null);
			break;

		case -2:
			vista.actualizar(Evento.errorArgumentos, null);
			break;
		}
	}
	
	
	private void gestionarActualizarProducto(TransferProducto tPro) {
		SAProducto saProducto = FactoriaNegocio.obtenerInstancia().generarSAProducto();
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUIProducto(TipoGUI.actualizar);

		switch (saProducto.actualizarProducto(tPro)) {

		case 0:
			vista.actualizar(Evento.actualizarProducto, tPro.getId());
			break;

		case -1:
			vista.actualizar(Evento.errorActualizarProducto, null);
			break;

		case -2:
			vista.actualizar(Evento.errorArgumentos, null);
			break;

		case -3:
			vista.actualizar(Evento.errorActualizarProductoPorIdClasificacion, null);
			break;
			
		case -4: 
			vista.actualizar(Evento.errorActualizarProductoConProveedorInexistente, null);
			break;
		
		
		}
	}
	
	private void gestionarActualizarProveedores(TransferProveedor tProv) {
		SAProveedor saProveedor = FactoriaNegocio.obtenerInstancia().generarSAProveedor();
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUIProveedor(TipoGUI.actualizar);

		switch (saProveedor.actualizarProveedor(tProv)) {

		case 0:
			vista.actualizar(Evento.actualizarProveedor, tProv.getId());
			break;

		case -1:
			vista.actualizar(Evento.errorActualizarProveedor, null);
			break;

		case -2:
			vista.actualizar(Evento.errorArgumentos, null);
			break;

		case -3:
			vista.actualizar(Evento.errorActualizarProductoPorIdClasificacion, null);
			break;
			
		case -4: 
			vista.actualizar(Evento.errorActualizarProductoConProveedorInexistente, null);
			break;
		
		
		}
		
	}
	

	
	private void gestionarAltaClasificacion(TransferClasificacion tCla) {

		SAClasificacion saClasificacion = FactoriaNegocio.obtenerInstancia().generarSAClasificacion();
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUIClasificacion(TipoGUI.alta);

		switch (saClasificacion.altaClasificacion(tCla)) {

		case 0:
			vista.actualizar(Evento.altaClasificacion, tCla.getId());
			break;

		case -1:
			vista.actualizar(Evento.altaClasificacionDuplicada, null);
			break;

		case -2:
			vista.actualizar(Evento.errorArgumentos, null);
			break;

		case -3:
			vista.actualizar(Evento.errorAltaClasificacion, null);
			break;
		}
	}

	private void gestionarAltaCliente(TransferCliente tCli) {

		SACliente saCliente = FactoriaNegocio.obtenerInstancia().generarSACliente();
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUICliente(TipoGUI.alta);

		switch (saCliente.altaCliente(tCli)) {

		case 0:
			vista.actualizar(Evento.altaCliente, tCli.getId());
			break;

		case -1:
			vista.actualizar(Evento.altaClienteDuplicado, null);
			break;

		case -2:
			vista.actualizar(Evento.errorArgumentos, null);
			break;

		case -3:
			vista.actualizar(Evento.errorAltaCliente, null);
			break;
		case -4:
			vista.actualizar(Evento.errorCambioTipoCliente, null);
			break;
		}
	}
	
	
	private void gestionarAltaProducto(TransferProducto tPro) {

		SAProducto saProducto = FactoriaNegocio.obtenerInstancia().generarSAProducto();
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUIProducto(TipoGUI.alta);

		switch (saProducto.altaProducto(tPro)) {

		case 0:
			vista.actualizar(Evento.altaProducto, tPro.getId());
			break;

		case -1:
			vista.actualizar(Evento.altaProductoDuplicado, null);
			break;

		case -2:
			vista.actualizar(Evento.errorArgumentos, null);
			break;

		case -3:
			vista.actualizar(Evento.errorAltaProducto, null);
			break;

		case -4:
			vista.actualizar(Evento.errorAltaProductoSinClasificacion, null);
			break;
		case -5:
			vista.actualizar(Evento.errorAltaProductoSinProveedor, null);
			break;
		}

	}
	
	private void gestionarAltaProveedor(TransferProveedor tProv) {
		
		SAProveedor saProveedor = FactoriaNegocio.obtenerInstancia().generarSAProveedor();
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUIProveedor(TipoGUI.alta);

		switch (saProveedor.altaProveedor(tProv)) {

		case 0:
			vista.actualizar(Evento.altaProveedor, tProv.getId());
			break;

		case -1:
			vista.actualizar(Evento.altaProveedorDuplicado, null);
			break;

		case -2:
			vista.actualizar(Evento.errorArgumentos, null);
			break;

		case -3:
			vista.actualizar(Evento.errorAltaProveedor, null);
			break;
		}

	}
	
	
	//Gestionar Bajas

	private void gestionarBajaClasificacion(TransferClasificacion tCla) {
		SAClasificacion saClasificacion = FactoriaNegocio.obtenerInstancia().generarSAClasificacion();
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUIClasificacion(TipoGUI.baja);

		switch (saClasificacion.bajaClasificacion(tCla)) {

		case 0:
			vista.actualizar(Evento.bajaClasificacion, tCla.getId());
			break;

		case -1:
			vista.actualizar(Evento.errorBajaClasificacion, null);
			break;

		case -2:
			vista.actualizar(Evento.errorArgumentos, null);
			break;

		case -3:
			vista.actualizar(Evento.errorProductosAsignados, null);
			break;
		case -4:
			vista.actualizar(Evento.bajaClasificacionDuplicada, null);
			break;
		}
	}

	private void gestionarBajaCliente(TransferCliente tCli) {
		SACliente saCliente = FactoriaNegocio.obtenerInstancia().generarSACliente();
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUICliente(TipoGUI.baja);

		switch (saCliente.bajaCliente(tCli)) {

		case 0:
			vista.actualizar(Evento.bajaCliente, tCli.getId());
			break;

		case -1:
			vista.actualizar(Evento.errorBajaCliente, null);
			break;

		case -2:
			vista.actualizar(Evento.errorArgumentos, null);
			break;

		case -3:
			vista.actualizar(Evento.bajaClienteDuplicado, null);
			break;
		}
	}
	
	private void gestionarBajaProducto(TransferProducto tPro) {
		SAProducto saProducto = FactoriaNegocio.obtenerInstancia().generarSAProducto();
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUIProducto(TipoGUI.baja);

		switch (saProducto.bajaProducto(tPro)) {

		case 0:
			vista.actualizar(Evento.bajaProducto, tPro.getId());
			break;

		case -1:
			vista.actualizar(Evento.errorBajaProducto, null);
			break;

		case -2:
			vista.actualizar(Evento.errorArgumentos, null);
			break;

		case -3:
			vista.actualizar(Evento.errorBajaProductoDuplicado, null);
			break;
		}
	}

	private void gestionarBajaProveedor(TransferProveedor tPro) {
		SAProveedor saProveedor = FactoriaNegocio.obtenerInstancia()
				.generarSAProveedor();
		
		GUI vista = FactoriaPresentacion.obtenerInstancia()
				.crearGUIProveedor(TipoGUI.baja);

		switch (saProveedor.bajaProveedor(tPro)) {

		case 0:
			vista.actualizar(Evento.bajaProveedor, tPro.getId());
			break;

		case -1:
			vista.actualizar(Evento.errorBajaProveedor, null);
			break;

		case -2:
			vista.actualizar(Evento.errorArgumentos, null);
			break;

		case -3:
			vista.actualizar(Evento.errorProductosAsignados, null);
			break;
			
		case -4:
			vista.actualizar(Evento.bajaProveedorDuplicado, null);
		
		}
	}
	
	private void gestionarCerrarVenta(TransferVentas tVen){
		SAVentas saVentas = FactoriaNegocio.obtenerInstancia().generarSAVenta();
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUIVenta(null);

		switch (saVentas.cerrarVenta(tVen)) {

		case 0:
			vista.actualizar(Evento.cerrarVenta, tVen);
			FactoriaPresentacion.obtenerInstancia().crearGUIMenuVenta();
			break;

		case -1:
			vista.actualizar(Evento.errorCerrarVentaCliente, tVen);
			FactoriaPresentacion.obtenerInstancia().crearGUIVenta(TipoGUI.abrirVenta, tVen);
			break;

		case -2:
			vista.actualizar(Evento.errorCerrarVentaCarrito, tVen);
			FactoriaPresentacion.obtenerInstancia().crearGUIVenta(TipoGUI.abrirVenta, tVen);
			break;
		case -3:
			vista.actualizar(Evento.errorArgumentos, tVen);
			FactoriaPresentacion.obtenerInstancia().crearGUIVenta(TipoGUI.abrirVenta, tVen);
			break;
		}

	}
	
	private void gestionarDevolverVenta(TransferVentas tVen){
		SAVentas saVentas = FactoriaNegocio.obtenerInstancia().generarSAVenta();
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUIVenta(TipoGUI.devolverVenta);
		switch (saVentas.devolverVenta(tVen)) {

		case 0:
			vista.actualizar(Evento.devolverVenta, tVen);
			break;

		case -1:
			vista.actualizar(Evento.errorDevolverVenta, null);
			break;

		case -2:
			vista.actualizar(Evento.errorArgumentos, null);
			break;

		case -3:
			vista.actualizar(Evento.devolverVentaDuplicada, null);
			break;
		}
	}
	

	//Gestionar mostrar una/o
	
	private void gestionarMostrarUnaClasificacion(TransferClasificacion tCla) {

		SAClasificacion saClasificacion = FactoriaNegocio.obtenerInstancia().generarSAClasificacion();
		tCla = saClasificacion.mostrarUnaClasificacion(tCla);
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUIClasificacion(TipoGUI.mostrarUno);
		if (tCla == null) {
			vista.actualizar(Evento.errorMostrarUnaClasificacion, null);
		} else {
			vista.actualizar(Evento.mostrarUnaClasificacion, tCla);
		}

	}
	

	private void gestionarMostrarUnCliente(TransferCliente tCli) {

		SACliente saCliente = FactoriaNegocio.obtenerInstancia().generarSACliente();
		tCli = saCliente.mostrarUnCliente(tCli);
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUICliente(TipoGUI.mostrarUno);
		if (tCli == null) {
			vista.actualizar(Evento.errorMostrarUnCliente, null);
		} else {
			vista.actualizar(Evento.mostrarUnCliente, tCli);
		}

	}
	
	private void gestionarMostrarUnProducto(TransferProducto tPro) {

		SAProducto saProducto = FactoriaNegocio.obtenerInstancia().generarSAProducto();
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUIProducto(TipoGUI.mostrarUno);
		TransferProducto tProRead;

		if (null == (tProRead = saProducto.mostrarUnProducto(tPro))) {
			vista.actualizar(Evento.errorMostrarUnProducto, null);
		}
		else {
			vista.actualizar(Evento.mostrarUnProducto, tProRead);
		}
	}
	
	
	private void gestionarMostrarUnProveedor(TransferProveedor objeto) {
		SAProveedor saProveedor = FactoriaNegocio.obtenerInstancia().generarSAProveedor();
		objeto = saProveedor.mostrarUnProveedor(objeto);
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUIProveedor(TipoGUI.mostrarUno);
		if (objeto == null) {
			vista.actualizar(Evento.errorMostrarUnProveedor, null);
		} else {
			vista.actualizar(Evento.mostrarUnProveedor, objeto);
		}

	}

	private void gestionarMostrarUnaVenta(TransferVentas tVen) {

		SAVentas saVenta = FactoriaNegocio.obtenerInstancia().generarSAVenta();
		tVen = saVenta.mostrarUnaVenta(tVen);
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUIVenta(TipoGUI.mostrarUno);
		if (tVen == null) {
			vista.actualizar(Evento.errorMostrarUnaVenta, null);
		} else {
			vista.actualizar(Evento.mostrarUnaVenta, tVen);
		}

	}
	
	//Gestionar mostrar todas/os
	
	private void gestionarMostrarCarrito(HashMap<Integer, LineaVenta> mapProductos){
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUIVenta(null);
		vista.setVisible(false);

		if (mapProductos.isEmpty()) {
			vista.actualizar(Evento.errorMostrarCarrito, null);
		} else {
			vista.actualizar(Evento.mostrarCarrito, mapProductos);
		}

	}
	
	private void gestionarMostrarTodasLasClasificaciones() {

		SAClasificacion saClasificacion = FactoriaNegocio.obtenerInstancia().generarSAClasificacion();

		TransferClasificacion[] tMTCla;
		tMTCla = saClasificacion.mostrarTodasClasificaciones();
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUIClasificacion(null);
		vista.setVisible(false);

		if (tMTCla.length == 0) {
			vista.actualizar(Evento.errorMostrarTodasClasificaciones, null);
			FactoriaPresentacion.obtenerInstancia().crearGUIMenuClasificacion();
		} else {
			vista.actualizar(Evento.mostrarTodasClasificaciones, tMTCla);
		}
	}
	
	private void gestionarMostrarTodasLasVentas() {

		SAVentas saVenta = FactoriaNegocio.obtenerInstancia().generarSAVenta();

		TransferVentas[] tVen;
		tVen = saVenta.mostrarTodasVentas();
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUIVenta(null);
		vista.setVisible(false);

		if (tVen.length == 0) {
			vista.actualizar(Evento.errorMostrarTodasVentas, null);
			FactoriaPresentacion.obtenerInstancia().crearGUIMenuVenta();
		} else {
			vista.actualizar(Evento.mostrarTodasVentas, tVen);
		}
	}

	private void gestionarMostrarTodosLosClientes() {

		SACliente saCliente = FactoriaNegocio.obtenerInstancia().generarSACliente();

		TransferCliente[] tCli;
		tCli = saCliente.mostrarTodosClientes();
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUICliente(null);
		vista.setVisible(false);

		if (tCli.length == 0) {
			vista.actualizar(Evento.errorMostrarTodosClientes, null);
			FactoriaPresentacion.obtenerInstancia().crearGUIMenuCliente();
		} else {
			vista.actualizar(Evento.mostrarTodosClientes, tCli);
		}

	}
	
	private void gestionarMostrarTodosLosProductos() {

		SAProducto saProducto = FactoriaNegocio.obtenerInstancia().generarSAProducto();

		TransferProducto[] tMTPro;
		tMTPro = saProducto.mostrarTodosProductos();
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUIProducto(null);
		vista.setVisible(false);

		if (tMTPro.length == 0) {
			vista.actualizar(Evento.errorMostrarTodosProductos, null);
			FactoriaPresentacion.obtenerInstancia().crearGUIMenuProducto();
		} else {
			vista.actualizar(Evento.mostrarTodosLosProductos, tMTPro);
		}
	}
	
	private void gestionarMostrarTodosProveedores() {
		SAProveedor saProveedor = FactoriaNegocio.obtenerInstancia().generarSAProveedor();

		TransferProveedor[] tMTProv;
		tMTProv = saProveedor.mostrarTodosProveedor();
		GUI vista = FactoriaPresentacion.obtenerInstancia().crearGUIProveedor(null);
		vista.setVisible(false);

		if (tMTProv.length == 0) {
			vista.actualizar(Evento.errorMostrarTodosProveedores, null);
			FactoriaPresentacion.obtenerInstancia().crearGUIMenuProveedor();
		} else {
			vista.actualizar(Evento.mostrarTodosProveedores, tMTProv);
		}
	}



}
