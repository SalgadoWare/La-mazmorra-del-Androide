package integracion.producto;

import negocio.producto.TransferProducto;

public interface DAOProducto {

	
	
	public TransferProducto read(int id);
	
	public TransferProducto[] readAll();

	public int write(TransferProducto tPro);

	public int update(TransferProducto tPro);

	TransferProducto[] readProductosPorProovedor(int idProveedor);

	TransferProducto[] readProductosPorClasificacion(int idClasificacion);
}
