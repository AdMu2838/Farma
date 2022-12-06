package modelo;

public class Empleado {
	private int codigo;
	private String nombre,dni,usuario,clave;
	
	
	public Empleado() {
		super();
	}


	public Empleado(int codigo, String nombre, String dni, String usuario, String clave) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.dni = dni;
		this.usuario = usuario;
		this.clave = clave;
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


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
}
