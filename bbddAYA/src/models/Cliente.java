package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCliente;
	@Column
	private String nombre;
	@Column
	private String apellidos;
	@Column
	private String direccion;
	@Column
	private String dni;
	@Column
	private int telefono;

	public Cliente() {

	}

	public Cliente(int idCliente, String nombre, String apellidos, String direccion, String dni, int telefono) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.dni = dni;
		this.telefono = telefono;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion="
				+ direccion + ", dni=" + dni + ", telefono=" + telefono + "]";
	}

}
