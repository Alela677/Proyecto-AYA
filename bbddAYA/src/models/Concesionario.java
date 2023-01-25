package models;

import java.io.Serializable;
<<<<<<< HEAD

=======
import java.util.List;

import javax.persistence.CascadeType;
>>>>>>> 66ae24b5bb24fe5fa454a4d2e927eb06a37831c7
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD

=======
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
>>>>>>> 66ae24b5bb24fe5fa454a4d2e927eb06a37831c7
import javax.persistence.Table;

@Entity
@Table(name = "Concesionario")
public class Concesionario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idConcesionario;
	@Column
	private String nombre;
	@Column
	private String localidad;

	public Concesionario() {
		// TODO Auto-generated constructor stub
	}

	public int getIdConcesionario() {
		return idConcesionario;
	}

	public void setIdConcesionario(int idConcesionario) {
		this.idConcesionario = idConcesionario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
