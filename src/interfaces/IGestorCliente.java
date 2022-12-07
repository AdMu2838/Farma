package interfaces;

import java.util.ArrayList;

import modelo.Cliente;

public interface IGestorCliente {
	public ArrayList<Cliente> listar();
	
	public int registrar(Cliente obj);
	
	public Cliente obtener(int id);
	
	public int actualizar(Cliente obj);
	
	public int eliminar(int codigo);
	
	Cliente buscarXDocumento(String documento);
	
	public int existeCliente(String dni);
}
