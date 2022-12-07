package modelo;

public class ProductoVendido {
	private String codigoProducto;
	private int cantidad;
	public ProductoVendido() {
		super();
	}
	public ProductoVendido(String codigoProducto, int cantidad) {
		super();
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
	}
	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
