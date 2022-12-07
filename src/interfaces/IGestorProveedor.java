package interfaces;

import java.util.ArrayList;

import modelo.Proveedor;

public interface IGestorProveedor {
	public ArrayList<Proveedor> listar();
	
	public int registrar(Proveedor obj);
	
	public Proveedor obtener(int id);
	
	public int actualizar(Proveedor obj);
	
	public int eliminar(int codigo);
}
