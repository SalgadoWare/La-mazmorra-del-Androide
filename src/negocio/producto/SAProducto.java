package negocio.producto;

public interface SAProducto {

	public int altaProducto(TransferProducto tPro);
	public int bajaProducto(TransferProducto tPro);
	public int actualizarProducto(TransferProducto tPro);
	public TransferProducto mostrarUnProducto(TransferProducto tPro);
	public TransferProducto[] mostrarTodosProductos();
}
