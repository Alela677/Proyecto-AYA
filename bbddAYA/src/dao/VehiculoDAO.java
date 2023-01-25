package dao;

import java.util.List;

import org.hibernate.Session;

import interfaz.VehiculosI;
import models.Vehiculo;

public class VehiculoDAO<T> extends ComunesDAO<T> implements VehiculosI {

	// Session de la base de datos
	private Session sesion;

	public VehiculoDAO(Session session) {
		super(session);
		this.sesion = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> consultaColumna(String columna) {

		if (!sesion.beginTransaction().isActive()) {
			sesion.beginTransaction();
		}
		return sesion.createQuery("SELECT v.'" + columna + "' FROM Vehiculos v").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> consultarPrecio(char comparacion, int precio) {

		if (!sesion.beginTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return sesion.createQuery("FROM Vehiculos v WHERE  v.precio '" + comparacion + "' " + precio + "").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> consultarPrecioEntre(double precio1, double precio2) {

		if (!sesion.beginTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return sesion.createQuery("FROM Vehiculos v WHERE v.precio BETWEEN " + precio1 + " AND " + precio2 + "").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> filtrarPorColumna(String columna, String valor) {

		if (!sesion.beginTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return sesion.createQuery("FROM Vehiculos v WHERE v.'" + columna + "'= '" + valor + "'").list();
	}

}
