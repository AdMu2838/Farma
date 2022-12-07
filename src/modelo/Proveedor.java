package modelo;

public class Proveedor {
	private int codigo;
	private String nombre;
	private int celular;
	private String direccion;
	public Proveedor() {
		super();
	}
	public Proveedor(int codigo, String nombre, int celular, String direccion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.celular = celular;
		this.direccion = direccion;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String toString() {
		return this.nombre;
	}
}
