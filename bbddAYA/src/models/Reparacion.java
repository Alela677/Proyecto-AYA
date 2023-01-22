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

	public Reparacion() {
		// TODO Auto-generated constructor stub
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

}
