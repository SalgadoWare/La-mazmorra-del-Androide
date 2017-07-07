package negocio.cliente;

import integracion.cliente.DAOCliente;
import integracion.factoriaIntegracion.FactoriaIntegracion;

/** Implementacion del servicio de aplicacion de la clasificacion */
public class SAClienteImp implements SACliente {

	/**
	 * Crea el DAO de cliente y realiza el alta de un nuevo cliente
	 * 
	 * @param transfer del cliente
	 * @return false si ya existia, true si no y se ha insertado.
	 */
	public int altaCliente(TransferCliente tCli) {
		try {
			if (tCli.getTipo().equalsIgnoreCase("vip"))
				Integer.parseInt(((TransferClienteVip) tCli).getDescuento());
			DAOCliente daoCli = FactoriaIntegracion.obtenerInstancia().generaDAOCliente();
			TransferCliente[] coleccionTcliente = daoCli.readAll();

			for(TransferCliente t : coleccionTcliente){
				if(t.equals(tCli)) {
					if(t.getActivo().equalsIgnoreCase("NO")){
						if(!t.getTipo().equalsIgnoreCase(tCli.getTipo()))
							return -4;
						tCli.setId(t.getId());
						tCli.setActivo("Si");
						daoCli.update(tCli);
						return -1;
					}
					else
						return -3;
				}
			}
			
			tCli.setId(String.valueOf(coleccionTcliente.length));
			tCli.setActivo("Si");
			return daoCli.write(tCli);

		} catch (NumberFormatException e) {
			return -2;
		}
	}
	
	public int bajaCliente(TransferCliente objeto) {
		if (objeto == null) {
			return -2; 
		} else {

			DAOCliente daoCli = FactoriaIntegracion.obtenerInstancia().generaDAOCliente();
			try {
				TransferCliente tCli = daoCli.read(Integer.parseInt(objeto.getId()));
				if (tCli != null) {
					if (tCli.getActivo().equals("Si")) {
						tCli.setActivo("No");
						return daoCli.update(tCli);
					} else {
						return -3;
					}
				} else {
					return -1;
				}

			} catch (NumberFormatException e) {
				return -2;
			}
		}
	}

	@Override
	public int actualizarCliente(TransferCliente tCli) {
		try {
			if (tCli.getTipo().equalsIgnoreCase("vip"))
				Integer.parseInt(((TransferClienteVip) tCli).getDescuento());
			DAOCliente daoCli = FactoriaIntegracion.obtenerInstancia().generaDAOCliente();
			TransferCliente tCliAux = daoCli.read(Integer.parseInt(tCli.getId()));

			if (tCliAux != null) {
				if(tCliAux.getTipo() == tCli.getTipo()){
					tCli.setActivo("Si");
					if (tCli.getTipo().equalsIgnoreCase("vip"))
						((TransferClienteVip) tCli).setPuntos(((TransferClienteVip) tCliAux).getPuntos());
					return daoCli.update(tCli);
				} else {
					return -1;
				}	
			} else {
				return -1;
			}
		} catch (NumberFormatException e) {
			return -2;
		}
	}

	@Override
	public TransferCliente mostrarUnCliente(TransferCliente objeto) {
		if (objeto == null) {
			return null;
		} else {
			try {
				DAOCliente daoCli = FactoriaIntegracion.obtenerInstancia().generaDAOCliente();
				return daoCli.read(Integer.parseInt(objeto.getId()));
			} catch (Exception e) {
				return null;
			}
		}
	}

	/** @return lista de transfers con todos los clientes */
	public TransferCliente[] mostrarTodosClientes() {
		DAOCliente daoCli = FactoriaIntegracion.obtenerInstancia().generaDAOCliente();
		return daoCli.readAll();
	}
}
