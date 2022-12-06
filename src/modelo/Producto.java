package modelo;

public class Producto {
	
	private String codigo;
	private String nombre;
	private int codProv;
	private double precio;
	private String fecha;
	private int stock;
	
	public Producto() {
		super();
	}
	
	public Producto(String codigo, String nombre, int codProv, double precio, String fecha, int stock) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.codProv = codProv;
		this.precio = precio;
		this.fecha = fecha;
		this.stock = stock;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCodProv() {
		return codProv;
	}
	public void setCodProv(int codProv) {
		this.codProv = codProv;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
	
}

