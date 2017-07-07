package negocio.ventas;

public class LineaVenta{
	private String id, cantidad, precio;
	
	public LineaVenta(String id, String cantidad, String precio){
		this.id=id;
		this.cantidad=cantidad;
		this.precio=precio;
	}
	
	
	public LineaVenta(String idProd, String cantidad2) {
	this.id=idProd;
	this.cantidad = cantidad2;
	}


	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	public String getCantidad(){
		return this.cantidad;
	}
	
	public void setCantidad(String cantidad){
		this.cantidad=cantidad;
	}
	
	public String getPrecio(){
		return this.precio;
	}
	
	public void setPrecio(String precio){
		this.precio=precio;
	}

}
