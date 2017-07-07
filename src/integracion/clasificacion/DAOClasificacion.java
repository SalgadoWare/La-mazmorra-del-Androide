package integracion.clasificacion;

import negocio.clasificacion.TransferClasificacion;

public interface DAOClasificacion {

	public TransferClasificacion read(int id);
	
	public TransferClasificacion[] readAll();

	public int write(TransferClasificacion tCla);

	public int update(TransferClasificacion tCla);
}
