package negocio.producto;

public class TransferProducto {

	
	private String precio,stock,idClasificacion,so, name, id, activo, idProveedor;
	
	
	public TransferProducto(String precio, String stock, String idC, String so, String name, String idProveedor) {

		this.precio = precio;
		this.stock = stock;
		this.idClasificacion = idC;
		this.so = so;
		this.name = name;
		this.idProveedor = idProveedor;
		this.activo = "Si";
	}
	
	public TransferProducto(String id, String activo, String precio, String stock, String idC, String so, String name, String idProveedor) {
		this.id = id;
		this.precio = precio;
		this.stock = stock;
		this.idClasificacion = idC;
		this.so = so;
		this.name = name;
		this.idProveedor = idProveedor;
		this.activo = activo;
	}


	public TransferProducto(String id) {
		this.id = id;
	}

	public TransferProducto(String id, String precio, String stock, String idC, String so, String name, String idProveedor) {
		this.id = id;
		this.precio = precio;
		this.stock = stock;
		this.idClasificacion = idC;
		this.so = so;
		this.name = name;
		this.idProveedor = idProveedor;
		this.activo = "Si";
	}

	public String getPrecio() {
		return precio;
	}



	public void setPrecio(String price) {
		this.precio = price;
	}



	public String getStock() {
		return stock;
	}



	public void setStock(String stock) {
		this.stock = stock;
	}



	public String getIdClasificacion() {
		return idClasificacion;
	}



	public void setIdClasificacion(String idClasificacion) {
		this.idClasificacion = idClasificacion;
	}



	public String getSo() {
		return so;
	}



	public void setSo(String so) {
		this.so = so;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public boolean equals(Object o){
		TransferProducto p = (TransferProducto) o;
		return p.name.equalsIgnoreCase(this.name);
	}

	public String getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}
}
