package integracion.ventas;

import negocio.ventas.TransferVentas;

public interface DAOVentas {
	
	public TransferVentas read(int id);

	public TransferVentas[] readAll();
	
	public int write(TransferVentas tVen);

	public int update(TransferVentas tVen);

}
