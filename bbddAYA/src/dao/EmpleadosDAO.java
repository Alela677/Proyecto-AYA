package dao;

import java.util.List;

import org.hibernate.Session;

import interfaz.EmpleadosI;
import models.Empleados;
import models.HibernateUtil;

public abstract class EmpleadosDAO<T> extends ComunesDAO<T> implements EmpleadosI<T> {

	public EmpleadosDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Empleados EmpleadoTipo(String tipo) {
		Session sesion = HibernateUtil.getSession();
		sesion.beginTransaction();
		Empleados resultao = (Empleados) sesion.createQuery("FROM Empleados e WHERE e.tipoEmpleado = '" + tipo + "'")
				.uniqueResult();

		return resultao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> consultarNombreOApellidos(String nombre, String apellidos) {
		Session sesion = HibernateUtil.getSession();
		sesion.beginTransaction();

		return sesion
				.createQuery("FROM Empleados e WHERE e.nombre = '" + nombre + " OR e.apellidos = '" + apellidos + "''")
				.list();
	}

}
