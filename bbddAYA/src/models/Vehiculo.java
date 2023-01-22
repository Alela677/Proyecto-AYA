package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Vehiculos")
public class Vehiculo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String marca;
	@Column
	private String modelo;
	@Column
	private String color;
	@Column
	private int precio;
	@Column
	private String matricula;
	@Column
	private String imagen;

	@OneToOne
	@JoinColumn(name = "concesionario")
	private Concesionario concesionario;

	public Vehiculo() {
	}

	public Vehiculo(String marca, String modelo, String color, int precio, int stock, String img) {
		super();

		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.precio = precio;
		this.imagen = img;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Concesionario getConcesionario() {
		return concesionario;
	}

	public void setConcesionario(Concesionario concesionario) {
		this.concesionario = concesionario;
	}

	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", precio=" + precio
				+ ", imagen=" + imagen + "]";
	}

}
