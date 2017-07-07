package negocio.ventas;

import java.util.HashMap;

public class TransferVentas {
	
	/**Identificador de cada una de las ventas*/
	private String idVenta;
	/**Identificador del cliente asociado a la venta*/
	private String idCliente;
	/**Fecha de cada venta*/
	private String fecha;
	/**Precio de cada venta*/
	private String precio;
	/**Indica si una venta esta activa*/
	private String activo;
	/**Lista de productos incluidos cada venta*/
	private HashMap<Integer, LineaVenta> mapProductos;
	
	/**Constructora por defecto de los transfers*/
	public TransferVentas(){}
	
	/**Crea un transfer con id de una venta
	 * @param id*/
	public TransferVentas(String id) {
		this.idVenta = id;
	}
	
	public TransferVentas(HashMap<Integer, LineaVenta> productos){
		this.mapProductos = productos;
	}
	
	public TransferVentas(String id, String cliente, String fecha, String precio, HashMap<Integer, LineaVenta> mapProductos, String activo){
		this.idVenta = id;
		this.idCliente = cliente;
		this.fecha = fecha;
		this.precio = precio;
		this.mapProductos = mapProductos;
		this.activo = activo;
	}
	
	public TransferVentas(int day, int month, int year) {
		this.precio = "0";
		this.fecha = String.valueOf(day) + '/' + String.valueOf(month) + '/' + String.valueOf(year);
		this.mapProductos = new HashMap<Integer, LineaVenta>();
	}

	
	/**@return precio de la venta*/
	public String getPrecio() {
		return precio;
	}

	/**Edita el campo del precio
	 * @param precio nuevo*/
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	/**@return fecha de la venta*/
	public String getFecha() {
		return fecha;
	}

	/**Edita el campo de la fecha
	 * @param fecha nueva*/
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	/**@return id de la venta*/
	public String getIdVenta() {
		return idVenta;
	}

	/**Edita el campo del id de la venta
	 * @param id nuevo*/
	public void setIdVenta(String id) {
		this.idVenta = id;
	}
	
	/**@return id del cliente asociado a la venta*/
	public String getIdCliente() {
		return idCliente;
	}

	/**Edita el campo del id del cliente asociado a la venta
	 * @param id nuevo*/
	public void setIdCliente(String cliente) {
		this.idCliente = cliente;
	}

	public String getActivo() {
		return this.activo;
	}
	
	
	public void setActivo(String activo){
		this.activo = activo;
	}
	
	public HashMap<Integer, LineaVenta> getProductos() {
		return this.mapProductos;
	}

	public int anadirProducto(String idProd, String cantidadProd) {
		try{
			if (this.mapProductos.containsKey(Integer.parseInt(idProd)) && Integer.parseInt(cantidadProd) > 0){
				LineaVenta producto = mapProductos.get(Integer.parseInt(idProd));
				int cantidad = Integer.parseInt(cantidadProd) + Integer.parseInt(producto.getCantidad());
				producto.setCantidad(String.valueOf(cantidad));
				mapProductos.put(Integer.parseInt(idProd), producto);
				return 1;
			} else if (!this.mapProductos.containsKey(idProd) && Integer.parseInt(cantidadProd) > 0){
				LineaVenta producto = new LineaVenta(idProd, cantidadProd);
				mapProductos.put(Integer.parseInt(idProd), producto);
				return 0;
			} else {
				return 2;
			}
		}catch (NumberFormatException e) {
			return 2;
		}
	}
	
	public int eliminarProducto(String idProd, String cantidadProd) {
		try{
			LineaVenta producto = mapProductos.get(Integer.parseInt(idProd));
			if (producto != null){
				int retorno = 0;
				if (Integer.parseInt(producto.getCantidad()) <= Integer.parseInt(cantidadProd) && Integer.parseInt(cantidadProd) >0){
					producto.setCantidad("0");
					retorno = 0;
				} else if (Integer.parseInt(producto.getCantidad()) > Integer.parseInt(cantidadProd) && Integer.parseInt(cantidadProd) >0){
					producto.setCantidad(String.valueOf(Integer.parseInt(producto.getCantidad()) - Integer.parseInt(cantidadProd)));
					retorno = 1;
				}
				if (Integer.parseInt(producto.getCantidad()) == 0){
					mapProductos.remove(Integer.parseInt(idProd));
				}
				return retorno;
			} else {
				return 2;
			}
		}catch (NumberFormatException e) {
			return 2;
		}
	}
}
