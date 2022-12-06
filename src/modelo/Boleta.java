package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Boleta {

	private String numero;
	private Date fecha;
	private int cliente;
	private int vendedor;
	private double total;

	// Lista de detalles
	private List<BoletaDetalle> detalles;
	
	public Boleta() {
		detalles = new ArrayList<BoletaDetalle>();
	}
	
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getCliente() {
		return cliente;
	}
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	public int getVendedor() {
		return vendedor;
	}
	public void setVendedor(int vendedor) {
		this.vendedor = vendedor;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public List<BoletaDetalle> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<BoletaDetalle> detalles) {
		this.detalles = detalles;
	}
	
	public double calcularTotal() {
		total = 0;
		for(BoletaDetalle detalle : detalles) {
			total += detalle.getImporte();
		}
		return total;
	}
	
}
