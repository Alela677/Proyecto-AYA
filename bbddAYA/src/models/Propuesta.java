package models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Propuesta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPropuesta;

	@OneToOne
	@JoinColumn(name = "empleado")
	private Empleados empleado;
	@OneToOne
	@JoinColumn(name = "cliente")
	private Cliente cliente;
	@OneToOne
	@JoinColumn(name = "vehiculo")
	private Vehiculo vehiculo;
	@Column
	private String estado;
	
	
	public Propuesta() {
		// TODO Auto-generated constructor stub
	}

}
