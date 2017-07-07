package integracion.proveedor;

import negocio.proveedor.TransferProveedor;

public interface DAOProveedor {
	public TransferProveedor read(int id);

	public TransferProveedor[] readAll();

	public int write(TransferProveedor tCla);

	public int update(TransferProveedor tCla);
}
