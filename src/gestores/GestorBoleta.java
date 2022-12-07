package gestores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import interfaces.IBoleta;
import modelo.Boleta;
import modelo.BoletaDetalle;
import util.MySQLConnection;

public class GestorBoleta implements IBoleta {
	
	@Override
	public int registrar(Boleta obj) {
		int resultado = -1;
		Connection cn = null;
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;
		PreparedStatement pstm3 = null;
		
		try {
			cn = MySQLConnection.getConnection();
			cn.setAutoCommit(false);
			String sql1 = "SELECT * FROM BOLETA";
			pstm1 = cn.prepareStatement(sql1);
			ResultSet rs = pstm1.executeQuery();
			String codigo = "B0000";
			while(rs.next()) {
				codigo = rs.getString("num_boleta");
			}
			int numero = Integer.parseInt(codigo.substring(1))+1;
			DecimalFormat df = new DecimalFormat("0000");
			codigo = "B"+df.format(numero);
			obj.setNumero(codigo); 
			System.out.println("CORRELATIVOS GENERADO ---> "+ codigo);
			
			String sql2 = "INSERT INTO boleta VALUES (?, ?, ?, ?, ?)";
			pstm2 = cn.prepareStatement(sql2);
			pstm2.setString(1,obj.getNumero());
			pstm2.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(obj.getFecha()));
			pstm2.setInt(3, obj.getCliente());
			pstm2.setInt(4, obj.getVendedor());
			pstm2.setDouble(5, obj.calcularTotal());
			resultado = pstm2.executeUpdate();
			
			String sql3 = "INSERT INTO detalle_boleta VALUES (?, ?, ?, ?, ?)";
			for(BoletaDetalle detalle: obj.getDetalles()) { 
				pstm3= cn.prepareStatement(sql3);
				pstm3.setString(1, obj.getNumero());
				pstm3.setString(2, detalle.getProducto());
				pstm3.setInt(3, detalle.getCantidad());
				pstm3.setDouble(4, detalle.getPrecio());
				pstm3.setDouble(5,detalle.getImporte());
				resultado = pstm3.executeUpdate();
			}
			cn.commit();
		}catch(Exception e) {
			System.out.println("ERROR EN LA BD: "+e.getMessage());
			try {
				
				cn.rollback();
			} catch (Exception e2) {
				System.err.println(e2.getMessage());
			}
		}finally {
			try {
				if (pstm3 != null)pstm3.close();
				if (pstm2 != null)pstm2.close();
				if (pstm1 != null)pstm1.close();
				if (cn != null)cn.close();
			} catch (Exception e2) {
				System.err.println("ERROR EN FINALLY : "+ e2.getMessage());
			}
		}
		return resultado;
	}

}
