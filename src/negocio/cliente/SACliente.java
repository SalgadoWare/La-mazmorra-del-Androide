package negocio.cliente;

/**Interfaz de los servicios de aplicacion*/
public interface SACliente {
	public int altaCliente(TransferCliente objeto);
	public int bajaCliente(TransferCliente objeto);
	public int actualizarCliente(TransferCliente objeto);
	TransferCliente mostrarUnCliente(TransferCliente objeto);
	public TransferCliente[] mostrarTodosClientes();
}
