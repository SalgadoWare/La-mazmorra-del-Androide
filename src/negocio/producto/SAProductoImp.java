package negocio.producto;

import integracion.clasificacion.DAOClasificacion;
import integracion.factoriaIntegracion.FactoriaIntegracion;
import integracion.producto.DAOProducto;
import integracion.proveedor.DAOProveedor;
import negocio.clasificacion.TransferClasificacion;
import negocio.proveedor.TransferProveedor;

public class SAProductoImp implements SAProducto {

	@Override
	public int altaProducto(TransferProducto tPro) {
		try {
			Integer idClasificacion = Integer.parseInt(tPro.getIdClasificacion());
			Integer.parseInt(tPro.getPrecio());

			DAOClasificacion daoCla = FactoriaIntegracion.obtenerInstancia().generaDAOClasificacion();
			TransferClasificacion tCla = daoCla.read((int) idClasificacion);

			Integer idProveedor = Integer.parseInt(tPro.getIdProveedor());

			DAOProveedor daoProv = FactoriaIntegracion.obtenerInstancia().generaDAOProveedor();
			TransferProveedor tProv = daoProv.read((int) idProveedor);

			if (tProv != null && tProv.getActivo().equalsIgnoreCase("si")) {
				if (tCla != null && tCla.getActivo().equalsIgnoreCase("si")) {
					DAOProducto daoPro = FactoriaIntegracion.obtenerInstancia().generaDAOProducto();
					TransferProducto[] coleccionTproducto = daoPro.readAll();

					for (TransferProducto pro : coleccionTproducto) {
						if (pro.equals(tPro)) {
							if (pro.getActivo().equalsIgnoreCase("NO")) {
								tPro.setId(pro.getId());
								tPro.setActivo("Si");
								daoPro.update(tPro);
								return -1;
							} else
								return -3;
						}
					}

					tPro.setId(String.valueOf(coleccionTproducto.length));
					return daoPro.write(tPro);
				} else {
					return -4;
				}
			} else {
				return -5;
			}

		} catch (NumberFormatException e) {
			return -2;
		}
	}

	@Override
	public int bajaProducto(TransferProducto tPro) {
		if (tPro == null) {
			return -2;
		} else {

			DAOProducto daoPro = FactoriaIntegracion.obtenerInstancia().generaDAOProducto();
			try {
				TransferProducto transferProducto = daoPro.read(Integer.parseInt(tPro.getId()));
				if (transferProducto != null) {
					if (transferProducto.getActivo().equalsIgnoreCase("Si")) {
						transferProducto.setActivo("No");
						return daoPro.update(transferProducto);
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
	public int actualizarProducto(TransferProducto tPro) {
		try {
			// para no dejar que se guarden strings
			Integer.parseInt(tPro.getPrecio());
			Integer.parseInt(tPro.getStock());

			DAOProducto daoPro = FactoriaIntegracion.obtenerInstancia().generaDAOProducto();
			TransferProducto tProAAux = daoPro.read(Integer.parseInt(tPro.getId()));

			if (tProAAux != null) {

				DAOClasificacion daoCla = FactoriaIntegracion.obtenerInstancia().generaDAOClasificacion();
				TransferClasificacion tClaAux = daoCla.read(Integer.parseInt(tPro.getIdClasificacion()));

				DAOProveedor daoProv = FactoriaIntegracion.obtenerInstancia().generaDAOProveedor();
				TransferProveedor tProvAux = daoProv.read(Integer.parseInt(tPro.getIdProveedor()));

				if (tProvAux != null && tProvAux.getActivo().equalsIgnoreCase("si")) {
					if (tClaAux != null && tClaAux.getActivo().equalsIgnoreCase("si")) {
						tPro.setActivo("Si");
						return daoPro.update(tPro);
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

	@Override
	public TransferProducto mostrarUnProducto(TransferProducto tPro) {
		if (tPro == null) {
			return null;
		} else {
			try {
				DAOProducto daoPro = FactoriaIntegracion.obtenerInstancia().generaDAOProducto();
				return daoPro.read(Integer.parseInt(tPro.getId()));
			} catch (Exception e) {
				return null;
			}
		}
	}

	@Override
	public TransferProducto[] mostrarTodosProductos() {
		DAOProducto daoPro = FactoriaIntegracion.obtenerInstancia().generaDAOProducto();
		return daoPro.readAll();
	}
}
