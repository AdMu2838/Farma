package gestores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.IGestorProveedor;
import modelo.Proveedor;
import util.MySQLConnection;

public class GestorProveedor implements IGestorProveedor {
	@Override
	public ArrayList<Proveedor> listar() {
		ArrayList<Proveedor> lista = new ArrayList();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM proveedor";
			stm = cn.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				Proveedor obj = new Proveedor();
				obj.setCodigo(rs.getInt("cod_prov"));
				obj.setNombre(rs.getString("nom_prov"));
				obj.setCelular(rs.getInt("celular_prov"));
				obj.setDireccion(rs.getString("dir_prov"));
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
	public int registrar(Proveedor obj) {
		int resultado = -1;
		Connection cn = null;
		PreparedStatement stm = null;
		
		try {
			cn = MySQLConnection.getConnection();
			String sql = "INSERT INTO proveedor(nom_prov, celular_prov,dir_prov) "
					+ " VALUES (?, ?,?)";
			stm = cn.prepareStatement(sql);
			stm.setString(1, obj.getNombre());
			stm.setInt(2, obj.getCelular());
			stm.setString(3, obj.getDireccion());
			
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
	public Proveedor obtener(int id) {
		Proveedor obj = new Proveedor();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM proveedor WHERE cod_prov = ?";
			stm = cn.prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			while (rs.next()) {
				obj.setCodigo(rs.getInt("cod_prov"));
				obj.setNombre(rs.getString("nom_prov"));
				obj.setCelular(rs.getInt("celular_prov"));
				obj.setDireccion(rs.getString("dir_prov"));
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
	public int actualizar(Proveedor obj) {
		int resultado = -1;
		Connection cn = null;
		PreparedStatement stm = null;
		
		try {
			cn = MySQLConnection.getConnection();
			String sql = "UPDATE proveedor SET nom_prov = ?, celular_prov=?,dir_prov = ?"
					+ " WHERE cod_prov = ?";
			stm = cn.prepareStatement(sql);
			stm.setString(1, obj.getNombre());
			stm.setInt(2, obj.getCelular());
			stm.setString(3, obj.getDireccion());
			stm.setInt(4, obj.getCodigo());
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
	public int eliminar(int codigo) {
		int resultado = -1;
		Connection cn = null;
		PreparedStatement stm = null;
		
		try {
			cn = MySQLConnection.getConnection();
			String sql = "DELETE FROM proveedor WHERE cod_prov = ?";
			stm = cn.prepareStatement(sql);
			stm.setInt(1, codigo);
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
}
