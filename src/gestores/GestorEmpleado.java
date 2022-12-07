package gestores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.IGestorEmpleado;
import modelo.Empleado;
import util.MySQLConnection;

public class GestorEmpleado implements IGestorEmpleado {
	@Override
	public ArrayList<Empleado> listar() {
		ArrayList<Empleado> lista = new ArrayList();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM EMPLEADO";
			stm = cn.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				Empleado obj = new Empleado();
				obj.setCodigo(rs.getInt("cod_emp"));
				obj.setNombre(rs.getString("nombre_emp"));
				obj.setDni(rs.getString("dni_emp"));
				obj.setUsuario(rs.getString("usuario"));
				obj.setClave(rs.getString("clave"));
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
	public int registrar(Empleado obj) {
		int resultado = -1;
		Connection cn = null;
		PreparedStatement stm = null;
		
		try {
			cn = MySQLConnection.getConnection();
			String sql = "INSERT INTO empleado(nombre_emp, dni_emp,usuario,clave) "
					+ " VALUES (?, ?,?,?)";
			stm = cn.prepareStatement(sql);
			stm.setString(1, obj.getNombre());
			stm.setString(2, obj.getDni());
			stm.setString(3, obj.getUsuario());
			stm.setString(4, obj.getClave());
			
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
	public Empleado obtener(int id) {
		Empleado obj = new Empleado();
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT * FROM EMPLEADO WHERE cod_emp = ?";
			stm = cn.prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			while (rs.next()) {
				obj.setCodigo(rs.getInt("cod_emp"));
				obj.setNombre(rs.getString("nombre_emp"));
				obj.setDni(rs.getString("dni_emp"));
				obj.setUsuario(rs.getString("usuario"));
				obj.setClave(rs.getString("clave"));
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
	public int actualizar(Empleado obj) {
		int resultado = -1;
		Connection cn = null;
		PreparedStatement stm = null;
		
		try {
			cn = MySQLConnection.getConnection();
			String sql = "UPDATE empleado SET nombre_emp = ?, dni_emp = ?, usuario = ?, clave = ?"
					+ " WHERE cod_emp = ?";
			stm = cn.prepareStatement(sql);
			stm.setString(1, obj.getNombre());
			stm.setString(2, obj.getDni());
			stm.setString(3, obj.getUsuario());
			stm.setString(4, obj.getClave());
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
			String sql = "DELETE FROM empleado WHERE cod_emp = ?";
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
	public boolean validarAcceso(Empleado obj) {
		boolean esValido= false;
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "{CALL usp_ValidarUsuario(?,?)}";
			stm = cn.prepareStatement(sql);
			stm.setString(1, obj.getUsuario());
			stm.setString(2, obj.getClave());
			rs = stm.executeQuery();
			while (rs.next()) {
				esValido =true;
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
		return esValido;
	}

	@Override
	public int existeEmpleado(String dni) {
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement stm = null;
		try {
			cn = MySQLConnection.getConnection();
			String sql = "SELECT COUNT(DNI_EMP) FROM empleado WHERE DNI_EMP = ?";
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
