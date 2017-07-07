package negocio.clasificacion;

import integracion.clasificacion.DAOClasificacion;
import integracion.factoriaIntegracion.FactoriaIntegracion;
import integracion.producto.DAOProducto;

/** Implementacion del servicio de aplicacion de la clasificacion */
public class SAClasificacionImp implements SAClasificacion {

	/**
	 * Crea el DAO de clasificacion y realiza el alta de una nueva clasificacion
	 * 
	 * @param transfer
	 *            de la clasificacion
	 * @return false si ya existia, true si no y se ha insertado.
	 */
	public int altaClasificacion(TransferClasificacion tCla) {
		try {
			if (tCla.getContenidos().equals("") || tCla.getEdadMinima().equals("")){
				return -2;
			} else {
			Integer.parseInt(tCla.getEdadMinima());
			DAOClasificacion daoCla = FactoriaIntegracion.obtenerInstancia().generaDAOClasificacion();
			TransferClasificacion[] coleccionTclasificacion = daoCla.readAll();

			for (TransferClasificacion t : coleccionTclasificacion) {
				if (t.equals(tCla)) {
					if(t.getActivo().equalsIgnoreCase("NO")){
						tCla.setId(t.getId());
						tCla.setActivo("Si");
						daoCla.update(tCla);
						return -1;
					}
					else
						return -3;
				}
			}
			
				tCla.setId(String.valueOf(coleccionTclasificacion.length));
				tCla.setActivo("Si");
				return daoCla.write(tCla);
			}
			

		} catch (NumberFormatException e) {
			return -2;
		}
	}

	public int bajaClasificacion(TransferClasificacion tCla) {
		if (tCla == null) {
			return -2;
		} else {
			DAOClasificacion daoCla = FactoriaIntegracion.obtenerInstancia().generaDAOClasificacion();
			try {
				TransferClasificacion transfer = daoCla.read(Integer.parseInt(tCla.getId()));
				if (transfer != null) {
					DAOProducto daoPro = FactoriaIntegracion.obtenerInstancia().generaDAOProducto();
					if(!transfer.getActivo().equalsIgnoreCase("No")){
						if (daoPro.readProductosPorClasificacion(Integer.parseInt(tCla.getId())) == null) {
							transfer.setActivo("No");
							return daoCla.update(transfer);
						} else {
							return -3;
						}
					}
					else
						return -4;
				} else {
					return -1;
				}
			} catch (NumberFormatException e) {
				return -2;
			}
		}
	}

	@Override
	public int actualizarClasificacion(TransferClasificacion tCla) {
		try {
			Integer.parseInt(tCla.getEdadMinima());// para no dejar que se
													// guarden strings
			DAOClasificacion daoCla = FactoriaIntegracion.obtenerInstancia().generaDAOClasificacion();
			TransferClasificacion tClaAux = daoCla.read(Integer.parseInt(tCla.getId()));

			if (tClaAux != null) {
				tCla.setActivo("Si");
				return daoCla.update(tCla);
			} else {
				return -1;
			}
		} catch (NumberFormatException e) {
			return -2;
		}
	}

	@Override
	/**
	 * @param id
	 *            de clasificacion
	 * @return transfer de la clasificacion que quieres mostrar
	 */
	public TransferClasificacion mostrarUnaClasificacion(TransferClasificacion tCla) {
		if (tCla == null) {
			return null;
		} else {
			try {
				DAOClasificacion daoCla = FactoriaIntegracion.obtenerInstancia().generaDAOClasificacion();
				return daoCla.read(Integer.parseInt(tCla.getId()));
			} catch (Exception e) {
				return null;
			}
		}
	}

	/** @return lista de transfers con todas las clasificaciones */
	public TransferClasificacion[] mostrarTodasClasificaciones() {
		DAOClasificacion daoCla = FactoriaIntegracion.obtenerInstancia().generaDAOClasificacion();
		return daoCla.readAll();
	}
}
