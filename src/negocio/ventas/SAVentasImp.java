package negocio.ventas;



import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import integracion.cliente.DAOCliente;
import integracion.factoriaIntegracion.FactoriaIntegracion;
import integracion.producto.DAOProducto;
import integracion.ventas.DAOVentas;
import negocio.cliente.TransferCliente;
import negocio.cliente.TransferClienteVip;
import negocio.producto.TransferProducto;

public class SAVentasImp implements SAVentas {

	public int devolverVenta(TransferVentas tVen){
		if (tVen == null) {
			return -2;
		} else {
			DAOVentas daoVen = FactoriaIntegracion.obtenerInstancia().generaDAOVenta();
			try {
				TransferVentas transfer = daoVen.read(Integer.parseInt(tVen.getIdVenta()));
				if (transfer != null) {
					if(!transfer.getActivo().equalsIgnoreCase("No")){
						DAOProducto daoPro = FactoriaIntegracion.obtenerInstancia().generaDAOProducto();
						HashMap<Integer, LineaVenta> mapProductos = transfer.getProductos();
						Collection<LineaVenta> coleccionProductos = mapProductos.values();
						Iterator<LineaVenta> iteradorProductos = coleccionProductos.iterator();
						while(iteradorProductos.hasNext()){
							LineaVenta producto = iteradorProductos.next();
							
							String idProd = producto.getId();
							TransferProducto tPro = daoPro.read(Integer.parseInt(idProd));
							
							String cantidadProd = producto.getCantidad();
							String stock = String.valueOf(Integer.parseInt(tPro.getStock()) + Integer.parseInt(cantidadProd));
							
							tPro.setStock(stock);
							daoPro.update(tPro);
							
						}
						transfer.setActivo("No");
						return daoVen.update(transfer);
					}
					else
						return -3;
				} else {
					return -1;
				}
			} catch (NumberFormatException e) {
				return -2;
			}
		}
	}
	
	@Override
	public int cerrarVenta(TransferVentas tVen) {
		try {
			DAOCliente daoCli = FactoriaIntegracion.obtenerInstancia().generaDAOCliente();
			int idCli = Integer.parseInt(tVen.getIdCliente());
			TransferCliente tCli = daoCli.read(idCli);
			
			if (tCli != null){
				if (tCli.getActivo().equals("Si")){
					DAOProducto daoPro = FactoriaIntegracion.obtenerInstancia().generaDAOProducto();
					HashMap<Integer, LineaVenta> mapProductos = tVen.getProductos();
					Collection<LineaVenta> coleccionProductos = mapProductos.values();
					Iterator<LineaVenta> iteradorProductos = coleccionProductos.iterator();
				
					while(iteradorProductos.hasNext()){
						LineaVenta producto = iteradorProductos.next();
						
						String idProd = producto.getId();
						TransferProducto tPro = daoPro.read(Integer.parseInt(idProd));
						
						String cantidadProd = producto.getCantidad();
						if (tPro != null){
							String stock = tPro.getStock();
							
							if (tPro.getActivo().equals("Si") && Integer.parseInt(cantidadProd) <= Integer.parseInt(stock)){
								
								tPro.setStock(String.valueOf(Integer.parseInt(stock) - Integer.parseInt(cantidadProd)));
								daoPro.update(tPro);
								
								String precioTotal = tVen.getPrecio();
								tVen.setPrecio(String.valueOf(Integer.parseInt(precioTotal) + Integer.parseInt(tPro.getPrecio()) *  Integer.parseInt(cantidadProd)));
								producto.setPrecio(tPro.getPrecio());
								
							} else if (tPro.getActivo().equals("Si") && Integer.parseInt(cantidadProd) > Integer.parseInt(stock)){
								
								tVen.eliminarProducto(idProd, String.valueOf(Integer.parseInt(cantidadProd) - Integer.parseInt(stock)));
								tPro.setStock("0");
								daoPro.update(tPro);
								
								String precioTotal = tVen.getPrecio();
								tVen.setPrecio(String.valueOf(Integer.parseInt(precioTotal) + Integer.parseInt(tPro.getPrecio()) * Integer.parseInt(stock)));
								producto.setPrecio(tPro.getPrecio());
							} else {
								tVen.eliminarProducto(idProd, producto.getCantidad());
								mapProductos.remove(Integer.parseInt(idProd));
								coleccionProductos = mapProductos.values();
								iteradorProductos = coleccionProductos.iterator();
							}
						} else if (tPro == null){
							tVen.eliminarProducto(idProd, producto.getCantidad());
							mapProductos.remove(Integer.parseInt(idProd));
							coleccionProductos = mapProductos.values();
							iteradorProductos = coleccionProductos.iterator();
						}
					}
					
					if (!mapProductos.isEmpty()){
						DAOVentas daoVen = FactoriaIntegracion.obtenerInstancia().generaDAOVenta();
						TransferVentas[] coleccionVentas = daoVen.readAll();
						
						tVen.setIdVenta(String.valueOf(coleccionVentas.length));
						tVen.setActivo("Si");
						
						if (tCli.getTipo().equals("Vip")){
							String des = ((TransferClienteVip) tCli).getDescuento();
							String puntos = ((TransferClienteVip) tCli).getPuntos();
							((TransferClienteVip) tCli).setPuntos(String.valueOf(Integer.parseInt(puntos) + 10));
							
							daoCli.update((TransferClienteVip) tCli);
							
							String precioTotal = tVen.getPrecio();
							
							tVen.setPrecio(String.valueOf(Integer.parseInt(precioTotal) - ((Integer.parseInt(precioTotal) * Integer.parseInt(des))/100)));
						}
						
						daoVen.write(tVen);
						
						return 0;
					} else {
						return -2;
					}
				} else {
					return -1;
				}
			} else {
				return -1;
			}
		} catch (NumberFormatException e) {
			return -3;
		}
		
	}

	/**
	 * @param id de la venta
	 * @return transfer de la venta que quieres mostrar
	 */
	public TransferVentas mostrarUnaVenta(TransferVentas tVen) {
		if (tVen == null) {
			return null;
		} else {
			try {
				DAOVentas daoVen = FactoriaIntegracion.obtenerInstancia().generaDAOVenta();
				return daoVen.read(Integer.parseInt(tVen.getIdVenta()));
			} catch (Exception e) {
				return null;
			}
		}
	}

	@Override
	public TransferVentas[] mostrarTodasVentas() {
		DAOVentas daoVen = FactoriaIntegracion.obtenerInstancia().generaDAOVenta();
		return daoVen.readAll();
	}

}
