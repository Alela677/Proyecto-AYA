package dao;

import org.hibernate.Query;
import org.hibernate.Session;

import interfaz.Reparaciones;
import models.Cliente;
import models.Empleados;
import models.HibernateUtil;
import models.Vehiculo;

public class ReparacioDAO implements Reparaciones {

	@Override
	public Empleados buscaMecanico(String nombre) {
		Session sesion = HibernateUtil.getSession();
		sesion.beginTransaction();

		return (Empleados) sesion
				.createQuery("SELECT r.empleado.nombre FROM Reparacion r WHERE r.empleado.nombre = '" + nombre + "'")
				.uniqueResult();
	}

	@Override
	public Vehiculo buscarVehiculo(String matricula) {
		
		return null;
	}

	@Override
	public Cliente buscarCliente(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fechaReparacion(String fecha) {
		// TODO Auto-generated method stub
		return null;
	}

}
