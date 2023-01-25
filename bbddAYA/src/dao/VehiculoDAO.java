package dao;

import java.util.List;

import org.hibernate.Session;

import interfaz.VehiculosI;
import models.HibernateUtil;

public class VehiculoDAO<T> extends ComunesDAO<T> implements VehiculosI<T> {

	@SuppressWarnings("unchecked")
	@Override
	public List<T> consultaColumna(String columna) {
		Session sesion = HibernateUtil.getSession();
		sesion.beginTransaction();

		return sesion.createQuery("SELECT v.'" + columna + "' FROM Vehiculos v").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> consultarPrecio(char comparacion, int precio) {
		Session sesion = HibernateUtil.getSession();
		sesion.beginTransaction();

		return sesion.createQuery("FROM Vehiculos v WHERE  v.precio '" + comparacion + "' " + precio + "").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> consultarPrecioEntre(double precio1, double precio2) {
		Session sesion = HibernateUtil.getSession();
		sesion.beginTransaction();

		return sesion.createQuery("FROM Vehiculos v WHERE v.precio BETWEEN " + precio1 + " AND " + precio2 + "").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> filtrarPorColumna(String columna, String valor) {
		Session sesion = HibernateUtil.getSession();
		sesion.beginTransaction();

		return sesion.createQuery("FROM Vehiculos v WHERE v.'" + columna + "'= '" + valor + "'").list();
	}

}
