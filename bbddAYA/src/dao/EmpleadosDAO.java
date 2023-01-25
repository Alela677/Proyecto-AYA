package dao;

import java.util.List;

import org.hibernate.Session;

import interfaz.EmpleadosI;
import models.Empleados;

public class EmpleadosDAO<T> extends ComunesDAO<T> implements EmpleadosI {

	private Session sesion;

	public EmpleadosDAO(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleados> EmpleadoTipo(String tipo) {
		if (!sesion.beginTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return sesion.createQuery("FROM Empleados e WHERE e.tipoEmpleado = '" + tipo + "'").list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleados> consultarNombreOApellidos(String nombre, String apellidos) {
		if (!sesion.beginTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return sesion
				.createQuery("FROM Empleados e WHERE e.nombre = '" + nombre + " OR e.apellidos = '" + apellidos + "''")
				.list();
	}

	@Override
	public Empleados buscarUnEmpleadoPorColumna(String columna, String valor) {
		if (!sesion.beginTransaction().isActive()) {
			sesion.beginTransaction();
		}
		return (Empleados) sesion.createQuery("FROM Empleados e WHERE e." + columna + " = '" + valor + "' ").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleados> listarEmpleadoPorColumna(String columna) {
		if (!sesion.beginTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return sesion.createQuery("FROM Empleados e WHERE e." + columna + "").list();
	}

}
