package negocio.proveedor;

public interface SAProveedor {
	public int altaProveedor(TransferProveedor objeto);

	public int bajaProveedor(TransferProveedor objeto);

	public int actualizarProveedor(TransferProveedor objeto);

	TransferProveedor mostrarUnProveedor(TransferProveedor objeto);

	public TransferProveedor[] mostrarTodosProveedor();

}
