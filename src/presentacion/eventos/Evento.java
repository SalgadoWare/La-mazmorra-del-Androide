package presentacion.eventos;

/** Enumerados con las acciones que se pueden realizar */
public enum Evento {

	// Mantened orden alfabetico

	abrirActualizarClasificacion, abrirActualizarCliente,  abrirActualizarClienteEstandar, abrirActualizarClienteVip, abrirActualizarProducto, abrirActualizarProveedor,
	
	abrirActualizarVenta,abrirAltaCarrito, abrirAltaClasificacion, abrirAltaCliente, abrirAltaClienteVip, abrirAltaClienteEstandar, abrirAltaProducto,  abrirAltaProveedor,
	
	abrirAnadirProductoAlCarrito, abrirBajaClasificacion, abrirBajaCliente, abrirBajaProducto, abrirBajaProveedor, abrirCancelarVenta, altaCarrito, abrirCerrarVenta,
	
	abrirMenuClasificacion, abrirMenuCliente, abrirMenuPrincipal, abrirMenuProducto, 
	
	abrirMenuProveedores, abrirMenuVenta, abrirMostrarCarrito, abrirMostrarTodasClasificaciones, abrirMostrarTodasVentas, abrirMostrarTodosClientes,
	
	abrirMostrarTodosProductos, abrirMostrarTodosProveedores, abrirMostrarUnaClasificacion, abrirMostrarUnaVenta, 
	
	abrirMostrarUnCliente, abrirMostrarUnProducto, abrirMostrarUnProveedor, abrirQuitarProductoDelCarrito, actualizarClasificacion, actualizarCliente, 
	
	actualizarProducto, actualizarProveedor, actualizarVenta, altaClasificacion, altaCliente, altaClienteEstandar, altaClienteVip,  
	
	altaProducto, altaProveedor, altaClasificacionDuplicada, altaClienteDuplicado, 
	
	altaProductoDuplicado, altaProveedorDuplicado, altaVentaDuplicada, anadirProductoAlCarrito, bajaClasificacion, bajaCliente,
	
	bajaProducto, bajaProveedor, bajaVenta, bajaClasificacionDuplicada, bajaClienteDuplicado,
	
	bajaProveedorDuplicado, bajaVentaDuplicada, cerrarVenta, errorActualizarClasificacion, errorActualizarCliente,
	
	errorActualizarProducto, errorActualizarProveedor, errorActualizarProductoConProveedorInexistente, 
	
	errorActualizarProductoPorIdClasificacion, errorAltaClasificacion, errorAltaCliente, 
	
	errorAltaProducto, errorAltaProveedor, errorAltaVenta, errorAltaProductoSinClasificacion,
	
	errorAltaProductoSinProveedor, errorAnadirProductoAlCarrito, 	errorArgumentos,  errorBajaClasificacion, 
	
	errorBajaCliente, errorBajaProveedor, errorBajaProducto, errorBajaVenta,  errorBajaProductoDuplicado,abrirDevolverVenta, errorCambioTipoCliente, errorCerrarVenta,
	
	errorFueraStock, errorMostrarCarrito,	errorMostrarTodasClasificaciones,  errorMostrarTodosClientes,  errorMostrarTodosProductos,
	
	errorMostrarTodosProveedores,  errorMostrarTodasVentas, errorMostrarUnaClasificacion,  errorQuitarProductoDelCarrito,
	
	errorMostrarUnCliente, errorMostrarUnProducto, errorMostrarUnProveedor, errorMostrarUnaVenta, errorNoExisteCarrito, 

	errorProductosAsignados, mostrarCarrito, mostrarTodasVentas, mostrarTodasClasificaciones, mostrarTodosClientes, mostrarTodosLosProductos, mostrarTodosProveedores, 
	
	mostrarUnaClasificacion, mostrarUnaVenta, mostrarUnCliente,  mostrarUnProducto, mostrarUnProveedor, quitarProductoDelCarrito, abrirVenta, CerrarVenta, errorCerrarVentaCliente, 
	
	errorCerrarVentaCarrito, devolverVenta, mostrarTodosProductos, devolverVentaDuplicada, errorDevolverVenta, 
	
	 
}
