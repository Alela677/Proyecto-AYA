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

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

}
