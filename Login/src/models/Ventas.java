package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ventas")
public class Ventas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idVenta")
	private int id;
	@Column(name = "idVehiculo")
	private int vehiculo;
	@Column(name = "idEmpleado")
	private int empleado;
	@Column(name = "nombreEmpleado")
	private String nombreEmpleado;
	@Column(name = "nombreCliente")
	private String nombreCliente;
	@Column(name = "fechaVenta")
	private String fechaVenta;

	public Ventas() {
		super();
	}

	public Ventas(int id, int vehiculo, int empleado, String nombreEmpleado, String nombreCliente, String fechaVenta) {
		super();
		this.id = id;
		this.vehiculo = vehiculo;
		this.empleado = empleado;
		this.nombreEmpleado = nombreEmpleado;
		this.nombreCliente = nombreCliente;
		this.fechaVenta = fechaVenta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(int vehiculo) {
		this.vehiculo = vehiculo;
	}

	public int getEmpleado() {
		return empleado;
	}

	public void setEmpleado(int empleado) {
		this.empleado = empleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	@Override
	public String toString() {
		return "Ventas [id=" + id + ", vehiculo=" + vehiculo + ", empleado=" + empleado + ", nombreEmpleado="
				+ nombreEmpleado + ", nombreCliente=" + nombreCliente + ", fechaVenta=" + fechaVenta + "]";
	}

}
