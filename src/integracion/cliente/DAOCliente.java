package integracion.cliente;

import negocio.cliente.TransferCliente;

public interface DAOCliente {

	public TransferCliente read(int id);

	public TransferCliente[] readAll();
	
	public int write(TransferCliente tCli);

	public int update(TransferCliente tCli);

}
