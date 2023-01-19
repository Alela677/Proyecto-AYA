package daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import models.Ventas;

public class VentasDAO {

	private static StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
	private static SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();

	public static List<Ventas> consultarVentas() {

		Session sesion = sf.openSession();
		sesion.beginTransaction();
		Query query = sesion.createQuery("From Ventas");
		List<Ventas> resultado = query.list();
		sesion.close();
		return resultado;
	}

	public static List<Object[]> consultaVendedor() {

		Session sesion = sf.openSession();
		sesion.beginTransaction();

		Query query = sesion.createQuery(
				"SELECT v.empleado,v.nombreEmpleado, COUNT(v.nombreEmpleado) FROM Ventas v GROUP BY v.nombreEmpleado ");
		List<Object[]> listaResultado = query.list();
		sesion.close();
		return listaResultado;
	}

	public static List<Ventas> ordenarCampos(String campo) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		Query query = sesion.createQuery("FROM Ventas v ORDER BY v." + campo + "");
		List<Ventas> resultado = query.list();
		sesion.close();
		return resultado;

	}

	public static List<Ventas> ordenarAño() {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		Query query = sesion.createQuery("FROM Ventas v ORDER BY YEAR(v.fechaVenta)");
		List<Ventas> resultado = query.list();
		sesion.close();
		return resultado;

	}

	public static List<Ventas> ordenarMes() {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		Query query = sesion.createQuery("FROM Ventas v ORDER BY MONTH(v.fechaVenta)");
		List<Ventas> resultado = query.list();
		sesion.close();
		return resultado;

	}

	public static List<Ventas> ordenarFecha() {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		Query query = sesion.createQuery("FROM Ventas v ORDER BY v.fechaVenta");
		List<Ventas> resultado = query.list();
		sesion.close();
		return resultado;

	}

}
