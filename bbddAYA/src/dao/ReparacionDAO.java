package dao;

import java.util.List;

import org.hibernate.Session;

import interfaz.ReparacioI;

import models.Cliente;
import models.Empleados;
import models.Reparacion;
import models.Vehiculo;

public class ReparacionDAO<T> extends ComunesDAO<T> implements ReparacioI {
	private Session sesion;

	public ReparacionDAO(Session sesion) {
		super(session);
		this.sesion = sesion;
	}

	@Override
	public Empleados buscaMecanico(String nombre) {
		if (!sesion.beginTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return (Empleados) sesion
				.createQuery("SELECT r.empleado.nombre FROM Reparacion r WHERE r.empleado.nombre = '" + nombre + "'")
				.uniqueResult();
	}

	@Override
	public Vehiculo buscarVehiculo(String matricula) {
		if (!sesion.beginTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return (Vehiculo) sesion.createQuery("FROM Vehiculo v WHERE v.matricula = '" + matricula + "'").uniqueResult();
	}

	@Override
	public Cliente buscarCliente(String dni) {
		if (!sesion.beginTransaction().isActive()) {
			sesion.beginTransaction();
		}
		return (Cliente) sesion.createQuery(" FROM Cliente c WHERE c.dni = '" + dni + "'").uniqueResult();
	}

	@Override
	public String fechaReparacion(String fecha) {
		if (!sesion.beginTransaction().isActive()) {
			sesion.beginTransaction();
		}
		return (String) sesion.createQuery(" FROM Reparacion r WHERE r.fecha = '" + fecha + "'").uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reparacion> listaReparaciones() {
		if (!sesion.beginTransaction().isActive()) {
			sesion.beginTransaction();
		}
		return sesion.createQuery("FROM Reparacion r").list();
	}

}
