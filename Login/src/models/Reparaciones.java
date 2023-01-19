package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Reparaciones")
public class Reparaciones {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	String nombreEmpleado;
	@Column
	String marcaVehiculo;
	@Column
	String modeloVehiculo;
	@Column
	String nombreCliente;
	@Column
	int idPiezas;
	@Column
	double totalReparacion;

	public Reparaciones() {
		super();
	}

	public Reparaciones(int id, String nombreEmpledo, String marcaVehiculo, String modeloVehiculo, String nombreCliente,
			int idPiezas, double totalReparacion) {
		super();
		this.id = id;
		this.nombreEmpleado = nombreEmpledo;
		this.marcaVehiculo = marcaVehiculo;
		this.modeloVehiculo = modeloVehiculo;
		this.nombreCliente = nombreCliente;
		this.idPiezas = idPiezas;
		this.totalReparacion = totalReparacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpledo) {
		this.nombreEmpleado = nombreEmpledo;
	}

	public String getMarcaVehiculo() {
		return marcaVehiculo;
	}

	public void setMarcaVehiculo(String marcaVehiculo) {
		this.marcaVehiculo = marcaVehiculo;
	}

	public String getModeloVehiculo() {
		return modeloVehiculo;
	}

	public void setModeloVehiculo(String modeloVehiculo) {
		this.modeloVehiculo = modeloVehiculo;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreClinete) {
		this.nombreCliente = nombreClinete;
	}

	public int getIdPiezas() {
		return idPiezas;
	}

	public void setIdPiezas(int idPiezas) {
		this.idPiezas = idPiezas;
	}

	public double getTotalReparacion() {
		return totalReparacion;
	}

	public void setTotalReparacion(double totalReparacion) {
		this.totalReparacion = totalReparacion;
	}

	@Override
	public String toString() {
		return "Reparaciones [id=" + id + ", nombreEmpledo=" + nombreEmpleado + ", marcaVehiculo=" + marcaVehiculo
				+ ", modeloVehiculo=" + modeloVehiculo + ", nombreClinete=" + nombreCliente + ", idPiezas=" + idPiezas
				+ ", totalReparacion=" + totalReparacion + "]";
	}

}
