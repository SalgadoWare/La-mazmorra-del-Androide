package negocio.proveedor;

import integracion.factoriaIntegracion.FactoriaIntegracion;
import integracion.producto.DAOProducto;
import integracion.proveedor.DAOProveedor;

public class SAProveedorImp implements SAProveedor {

	@Override
	public int altaProveedor(TransferProveedor tProv) {

		if (tProv.getNombre().length() != 0 && tProv.getPais().length() != 0) {
			DAOProveedor daoProv = FactoriaIntegracion.obtenerInstancia()
					.generaDAOProveedor();
			TransferProveedor[] coleccionTclasificacion = daoProv.readAll();

			for (TransferProveedor t : coleccionTclasificacion) {
				if (t.equals(tProv)) {
					if (t.getActivo().equalsIgnoreCase("NO")) {
						tProv.setId(t.getId());
						tProv.setActivo("Si");
						daoProv.update(tProv);
						return -1;
					} else
						return -3;
				}
			}

			tProv.setId(String.valueOf(coleccionTclasificacion.length));
			tProv.setActivo("Si");
			return daoProv.write(tProv);
		} else {
			return -2;
		}

	}

	@Override
	public int bajaProveedor(TransferProveedor tProv) {
		if (tProv == null) {
			return -2;
		} else {
			DAOProveedor daoProv = FactoriaIntegracion.obtenerInstancia()
					.generaDAOProveedor();
			try {
				TransferProveedor transferLeido = daoProv.read(Integer
						.parseInt(tProv.getId()));

				if (transferLeido != null) {
					DAOProducto daoPro = FactoriaIntegracion.obtenerInstancia()
							.generaDAOProducto();
					if (!transferLeido.getActivo().equalsIgnoreCase("No")) {
						if (daoPro.readProductosPorProovedor(Integer
								.parseInt(tProv.getId())) == null) {
							transferLeido.setActivo("No");
							return daoProv.update(transferLeido);
						} else {
							return -3;
						}
					} else
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
	public int actualizarProveedor(TransferProveedor tProv) {
		
		if (tProv.getNombre().length() != 0 && tProv.getPais().length() != 0) {
			
			DAOProveedor daoProv = FactoriaIntegracion.obtenerInstancia().generaDAOProveedor();
			TransferProveedor tProvAux = daoProv.read(Integer.parseInt(tProv.getId()));

			if (tProvAux != null) {
				tProv.setActivo("Si");
				return daoProv.update(tProv);
			} else {
				return -1;
			}
		} else {
			return -2;
		}
	}

	@Override
	public TransferProveedor mostrarUnProveedor(TransferProveedor objeto) {
		if (objeto == null) {
			return null;
		} else {
			try {
				DAOProveedor daoProv = FactoriaIntegracion.obtenerInstancia().generaDAOProveedor();
				return daoProv.read(Integer.parseInt(objeto.getId()));
			} catch (Exception e) {
				return null;
			}
		}
	}

	@Override
	public TransferProveedor[] mostrarTodosProveedor() {
		DAOProveedor daoProv = FactoriaIntegracion.obtenerInstancia().generaDAOProveedor();
		return daoProv.readAll();
	}

}
