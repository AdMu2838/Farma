package interfaces;

import java.util.ArrayList;

import modelo.Empleado;

public interface IGestorEmpleado {
	public ArrayList<Empleado> listar();
	
	public int registrar(Empleado obj);
	
	public Empleado obtener(int id);
	
	public int actualizar(Empleado obj);
	
	public int eliminar(int codigo);
	
	public boolean validarAcceso(Empleado obj);
	
	public int existeEmpleado(String dni);
}
