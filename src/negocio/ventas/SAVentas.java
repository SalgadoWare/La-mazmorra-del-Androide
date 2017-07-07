package negocio.ventas;


public interface SAVentas {
	
	public int devolverVenta(TransferVentas tVen);
	
	public int cerrarVenta(TransferVentas tVen);
	
	TransferVentas mostrarUnaVenta(TransferVentas tVen);

	public TransferVentas[] mostrarTodasVentas();

}
