package modelo;

public class Cliente {
	private int codigo;
	private String nombre,dni,celular,correo;
	public Cliente() {
		super();
	}
	public Cliente(int codigo, String nombre, String dni, String celular, String correo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.dni = dni;
		this.celular = celular;
		this.correo = correo;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
}
