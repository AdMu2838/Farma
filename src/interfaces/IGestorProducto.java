package interfaces;

import java.util.ArrayList;

import modelo.Producto;
import modelo.ProductoVendido;
import modelo.Proveedor;

public interface IGestorProducto {
	public ArrayList<Producto> listar();
	
	public int registrar(Producto obj);
	
	public Producto obtener(String id);
	
	public int actualizar(Producto obj);
	
	public int eliminar(String codigo);
	
	public ArrayList<Proveedor> listarProveedor();
	
	Producto buscarXCodigo(String codigo);
	
	public ArrayList<Producto> buscarXNombre(String nombre);
	
	public ArrayList<ProductoVendido> listar1();
}
