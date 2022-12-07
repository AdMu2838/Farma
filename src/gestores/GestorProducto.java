package gestores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.IGestorProducto;
import modelo.Producto;
import modelo.ProductoVendido;
import modelo.Proveedor;
import util.MySQLConnection;

public class GestorProducto implements IGestorProducto {
	@Override
	public ArrayList<Producto> listar() {
		ArrayList<Producto> lista = new ArrayList();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM producto";
			stm = cn.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				Producto obj = new Producto();
				obj.setCodigo(rs.getString("cod_producto"));
				obj.setNombre(rs.getString("nom_producto"));
				obj.setCodProv(rs.getInt("cod_prov"));
				obj.setPrecio(rs.getDouble("precio_producto"));
				obj.setFecha(rs.getString("fecha_venci"));
				obj.setStock(rs.getInt("stock"));
				lista.add(obj);
			}
		} catch (Exception e) {
			System.out.println("Error en BD: " + e.getMessage());
		}finally {
			try {
				if(stm != null) stm.close();
				if(cn != null) cn.close();
			} catch (Exception e2) {
				System.out.println("Error en Finally; " + e2.getMessage());
			}
		}
		return lista;
	}

	@Override
	public int registrar(Producto obj) {
		int resultado = -1;
		Connection cn = null;
		PreparedStatement stm = null;
		
		try {
			cn = MySQLConnection.getConnection();
			String sql = "INSERT INTO producto(cod_producto, nom_producto,cod_prov,precio_producto,fecha_venci,stock) "
					+ " VALUES (?, ?,?,?,?,?)";
			stm = cn.prepareStatement(sql);
			stm.setString(1, obj.getCodigo());
			stm.setString(2, obj.getNombre());
			stm.setInt(3, obj.getCodProv());
			stm.setDouble(4, obj.getPrecio());
			stm.setString(5, obj.getFecha());
			stm.setInt(6, obj.getStock());
			
			resultado = stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) stm.close();
				if (cn != null) cn.close();	
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultado;
	}

	@Override
	public Producto obtener(String id) {
		Producto obj = new Producto();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM producto WHERE cod_producto = ?";
			stm = cn.prepareStatement(sql);
			stm.setString(1, id);
			rs = stm.executeQuery();
			while (rs.next()) {
				obj.setCodigo(rs.getString("cod_producto"));
				obj.setNombre(rs.getString("nom_producto"));
				obj.setCodProv(rs.getInt("cod_prov"));
				obj.setPrecio(rs.getDouble("precio_producto"));
				obj.setFecha(rs.getString("fecha_venci"));
				obj.setStock(rs.getInt("stock"));
			}
		} catch (Exception e) {
			System.out.println("Error en BD: " + e.getMessage());
		}finally {
			try {
				if(stm != null) stm.close();
				if(cn != null) cn.close();
			} catch (Exception e2) {
				System.out.println("Error en Finally; " + e2.getMessage());
			}
		}
		return obj;
	}

	@Override
	public int actualizar(Producto obj) {
		int resultado = -1;
		Connection cn = null;
		PreparedStatement stm = null;
		
		try {
			cn = MySQLConnection.getConnection();
			String sql = "UPDATE producto SET nom_producto = ?, cod_prov=?,precio_producto = ?, fecha_venci=?,stock=?"
					+ " WHERE cod_producto = ?";
			stm = cn.prepareStatement(sql);
			
			stm.setString(1, obj.getNombre());
			stm.setInt(2, obj.getCodProv());
			stm.setDouble(3, obj.getPrecio());
			stm.setString(4, obj.getFecha());
			stm.setInt(5, obj.getStock());
			stm.setString(6, obj.getCodigo());
			resultado = stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) stm.close();
				if (cn != null) cn.close();	
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultado;
	}

	@Override
	public int eliminar(String codigo) {
		int resultado = -1;
		Connection cn = null;
		PreparedStatement stm = null;
		
		try {
			cn = MySQLConnection.getConnection();
			String sql = "DELETE FROM producto WHERE cod_producto = ?";
			stm = cn.prepareStatement(sql);
			stm.setString(1, codigo);
			resultado = stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) stm.close();
				if (cn != null) cn.close();	
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultado;
	}

	@Override
	public ArrayList<Proveedor> listarProveedor() {
		ArrayList <Proveedor> lista = new ArrayList();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "{CALL usp_ListarProveedor()}";
			stm = cn.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				Proveedor obj = new Proveedor(rs.getInt("cod_prov"),rs.getString("nombre"),rs.getInt("celular_prov"),rs.getString("dir_prov"));
				lista.add(obj);
			}
		} catch (Exception e) {
			System.out.println("Error en BD: " + e.getMessage());
		}finally {
			try {
				if(stm != null) stm.close();
				if(cn != null) cn.close();
			} catch (Exception e2) {
				System.out.println("Error en Finally; " + e2.getMessage());
			}
		}
		return lista;
	}

	@Override
	public Producto buscarXCodigo(String codigo) {
		Producto obj = new Producto();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "{CALL usp_BuscarProductoXCodigo(?)}";
			stm = cn.prepareStatement(sql);
			stm.setString(1, codigo);
			rs = stm.executeQuery();
			while (rs.next()) {
				obj.setCodigo(rs.getString("cod_producto"));
				obj.setNombre(rs.getString("nom_producto"));
				obj.setCodProv(rs.getInt("cod_prov"));
				obj.setPrecio(rs.getDouble("precio_producto"));
				obj.setFecha(rs.getString("fecha_venci"));
				obj.setStock(rs.getInt("stock"));
			}
		} catch (Exception e) {
			System.out.println("Error en BD: " + e.getMessage());
		}finally {
			try {
				if(stm != null) stm.close();
				if(cn != null) cn.close();
			} catch (Exception e2) {
				System.out.println("Error en Finally; " + e2.getMessage());
			}
		}
		return obj;
	}

	@Override
	public ArrayList<Producto> buscarXNombre(String nombre){
		ArrayList<Producto> lista = new ArrayList();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM producto WHERE nom_producto LIKE ?";
			stm = cn.prepareStatement(sql);
			stm.setString(1, "%" + nombre + "%");
			rs = stm.executeQuery();
			while (rs.next()) {
				Producto obj = new Producto();
				obj.setCodigo(rs.getString("cod_producto"));
				obj.setNombre(rs.getString("nom_producto"));
				obj.setCodProv(rs.getInt("cod_prov"));
				obj.setPrecio(rs.getDouble("precio_producto"));
				obj.setFecha(rs.getString("fecha_venci"));
				obj.setStock(rs.getInt("stock"));
				lista.add(obj);
			}
		} catch (Exception e) {
			System.out.println("Error en BD: " + e.getMessage());
		}finally {
			try {
				if(stm != null) stm.close();
				if(cn != null) cn.close();
			} catch (Exception e2) {
				System.out.println("Error en Finally; " + e2.getMessage());
			}
		}
		return lista;
	}

	@Override
	public ArrayList<ProductoVendido> listar1() {
		ArrayList<ProductoVendido> lista = new ArrayList();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "{CALL usp_ProductosVendidos}";
			stm = cn.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				ProductoVendido obj = new ProductoVendido();
				obj.setCodigoProducto(rs.getString("NOM_PRODUCTO"));
				obj.setCantidad(rs.getInt("cantidad"));
				lista.add(obj);
			}
		} catch (Exception e) {
			System.out.println("Error en BD: " + e.getMessage());
		}finally {
			try {
				if(stm != null) stm.close();
				if(cn != null) cn.close();
			} catch (Exception e2) {
				System.out.println("Error en Finally; " + e2.getMessage());
			}
		}
		return lista;
	}
}
