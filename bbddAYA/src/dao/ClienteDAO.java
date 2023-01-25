package dao;

import java.util.List;

import org.hibernate.Session;

import interfaz.ClienteI;
import models.Cliente;

public class ClienteDAO<T> extends ComunesDAO<T> implements ClienteI {

	private Session sesion;

	public ClienteDAO(Session session) {
		super(session);
		this.sesion = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listaClientes() {
		if (!sesion.beginTransaction().isActive()) {
			sesion.beginTransaction();
		}
		return sesion.createQuery("FROM Clientes").list();
	}

	@Override
	public Cliente buscarPorDni(String dni) {
		if (!sesion.beginTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return (Cliente) sesion.createQuery("FROM Clientes c WHERE c.dni = '" + dni + "'").uniqueResult();
	}

	@Override
	public Cliente buscarPorApellidosONombre(String apellido, String nombre) {
		if (!sesion.beginTransaction().isActive()) {
			sesion.beginTransaction();
		}
		return (Cliente) sesion
				.createQuery("FROM Clientes c WHERE c.nombre = '" + nombre + "' OR c.apellidos LIKE '" + apellido + "'")
				.uniqueResult();
	}

	@Override
	public Cliente buscarPorTelefono(int telefono) {
		if (!sesion.beginTransaction().isActive()) {
			sesion.beginTransaction();
		}
		return (Cliente) sesion.createQuery("FROM Clientes c WHERE c.telefono = '" + telefono + "'").uniqueResult();
	}

}
