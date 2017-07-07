package negocio.proveedor;

public class TransferProveedor {

	private String id, nombre, pais, activo;

	public TransferProveedor(String nombre2, String pais2) {
		this.nombre = nombre2;
		this.pais = pais2;
	}

	public TransferProveedor(String id2, String activo2, String nombre2, String pais2) {
		id = id2;
		activo = activo2;
		nombre = nombre2;
		pais = pais2;
	}

	public TransferProveedor(String id2) {
		id = id2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public boolean equals(Object o) {
		TransferProveedor t = (TransferProveedor) o;
		return nombre.equalsIgnoreCase(t.getNombre()) && pais.equalsIgnoreCase(t.getPais());
	}

}
