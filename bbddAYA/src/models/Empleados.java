package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "Empleados")
public class Empleados implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "dni")
	private String dni;
	@Column(name = "departamento")
	private String departamento;
	@Column(name = "cargo")
	private String cargo;
	@Column(name = "fechaAlta")
	private String fechaAlta;

	@Column(name = "imagen")
	private String imagenEmpleado;
	@Column(name = "contraseña")
	private String contraseña;
	@Column
	private String tipoEmpleado;

	@OneToOne
	@JoinColumn(name = "concesionario")
	private Concesionario concesionario;

	public Empleados() {

	}

	public Empleados(String nombre, String apellidos, String dni, String departamento, String cargo, String fechaAlta,
			String fechaBaja, String imagenEmpleado, String contraseña) {

		super();

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.departamento = departamento;
		this.cargo = cargo;
		this.fechaAlta = fechaAlta;

		this.imagenEmpleado = imagenEmpleado;
		this.contraseña = contraseña;
	}

	public String getImagenEmpleado() {
		return imagenEmpleado;
	}

	public void setImagenEmpleado(String imagenEmpleado) {
		this.imagenEmpleado = imagenEmpleado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Concesionario getConcesionario() {
		return concesionario;
	}

	public void setConcesionario(Concesionario concesionario) {
		this.concesionario = concesionario;
	}

	public String getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(String tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	@Override
	public String toString() {
		return "Empleados [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni
				+ ", departamento=" + departamento + ", cargo=" + cargo + ", fechaAlta=" + fechaAlta + ",imagenEmpleado=" + imagenEmpleado + ", contraseña=" + contraseña + "]";
	}

}
