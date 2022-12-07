package gestores;

import interfaces.IGestorCliente;
import modelo.Cliente;
import util.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GestorCliente implements IGestorCliente {
	@Override
	public ArrayList<Cliente> listar() {
		ArrayList<Cliente> lista = new ArrayList();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM CLIENTE";
			stm = cn.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				Cliente obj = new Cliente();
				obj.setCodigo(rs.getInt("cod_cli"));
				obj.setNombre(rs.getString("nom_cli"));
				obj.setDni(rs.getString("dni"));
				obj.setCelular(rs.getString("celular"));
				obj.setCorreo(rs.getString("correo"));
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
	public int registrar(Cliente obj) {
		int resultado = -1;
		Connection cn = null;
		PreparedStatement stm = null;
		
		try {
			cn = MySQLConnection.getConnection();
			String sql = "INSERT INTO cliente(nom_cli,dni,celular,correo) VALUES (?,?,?,?)";
			stm = cn.prepareStatement(sql);
			stm.setString(1, obj.getNombre());
			stm.setString(2, obj.getDni());
			stm.setString(3, obj.getCelular());
			stm.setString(4, obj.getCorreo());
			
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
	public Cliente obtener(int id) {
		Cliente obj = new Cliente();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM CLIENTE WHERE cod_cli = ?";
			stm = cn.prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			while (rs.next()) {
				obj.setCodigo(rs.getInt("cod_cli"));
				obj.setNombre(rs.getString("nom_cli"));
				obj.setDni(rs.getString("dni"));
				obj.setCelular(rs.getString("celular"));
				obj.setCorreo(rs.getString("correo"));
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
	public int actualizar(Cliente obj) {
		int resultado = -1;
		Connection cn = null;
		PreparedStatement stm = null;
		
		try {
			cn = MySQLConnection.getConnection();
			String sql = "UPDATE cliente SET nom_cli = ?, dni = ?,celular = ?, correo = ?"
					+ " WHERE cod_cli = ?";
			stm = cn.prepareStatement(sql);
			stm.setString(1, obj.getNombre());
			stm.setString(2, obj.getDni());
			stm.setString(3, obj.getCelular());
			stm.setString(4, obj.getCorreo());
			stm.setInt(5, obj.getCodigo());
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
			String sql = "DELETE FROM cliente WHERE cod_cli = ?";
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

	@Override
	public Cliente buscarXDocumento(String documento) {
		Cliente obj = new Cliente();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "{CALL usp_BuscarCliente(?)}";
			stm = cn.prepareStatement(sql);
			stm.setString(1, documento);
			rs = stm.executeQuery();
			while (rs.next()) {
				obj.setCodigo(rs.getInt("cod_cli"));
				obj.setNombre(rs.getString("nom_cli"));
				obj.setDni(rs.getString("dni"));
				obj.setCelular(rs.getString("celular"));
				obj.setCorreo(rs.getString("correo"));
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
	public int existeCliente(String dni) {
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT COUNT(DNI) FROM CLIENTE WHERE DNI = ?";
			stm = cn.prepareStatement(sql);
			stm.setString(1, dni);
			rs = stm.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		} 
	}
}
