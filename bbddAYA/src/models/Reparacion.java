package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Reparacion")
public class Reparacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idReparacion;

	@Column
	private String pieza;

	@Column
	private double coste;

	@OneToOne
	@JoinColumn
	private Empleados empleado;

	@OneToOne
	@JoinColumn
	private Vehiculo vehiculo;

	@Column
	private String fecha;

	public Reparacion() {

	}

	public Reparacion(int idReparacion, String pieza, double coste, Empleados empleado, Vehiculo vehiculo,
			String fecha) {
		super();
		this.idReparacion = idReparacion;
		this.pieza = pieza;
		this.coste = coste;
		this.empleado = empleado;
		this.vehiculo = vehiculo;
		this.fecha = fecha;
	}

	public int getIdReparacion() {
		return idReparacion;
	}

	public void setIdReparacion(int idReparacion) {
		this.idReparacion = idReparacion;
	}

	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	@Override
	public String toString() {
		return "Reparacion [idReparacion=" + idReparacion + ", pieza=" + pieza + ", coste=" + coste + ", empleado="
				+ empleado + ", vehiculo=" + vehiculo + ", fecha=" + fecha + "]";
	}

}
