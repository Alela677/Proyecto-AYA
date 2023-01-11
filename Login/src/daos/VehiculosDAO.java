package daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import models.Vehiculo;

public class VehiculosDAO {

	public static List<Vehiculo> consultaVehiculos() {
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();

		Session sesion = sf.openSession();
		org.hibernate.Query query = sesion.createQuery("FROM Vehiculo");
		List<Vehiculo> listaVehiculos = query.list();
		sesion.close();
		return listaVehiculos;
	}

	public static List<Vehiculo> vehiculosPorColor(String color) {

		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();

		Session sesion = sf.openSession();
		Query query = sesion.createQuery("FROM Vehiculo v WHERE v.color = '" + color + "'");
		List<Vehiculo> listaResultado = query.list();
		return listaResultado;

	}

	public static List<Vehiculo> vehiculosPorMarca(String marca) {

		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();

		Session sesion = sf.openSession();
		Query query = sesion.createQuery("FROM Vehiculo v WHERE v.marca = '" + marca + "'");
		List<Vehiculo> listaResultado = query.list();
		return listaResultado;

	}

	public static List<Vehiculo> vehiculosPorModelo(String modelo) {

		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();

		Session sesion = sf.openSession();
		Query query = sesion.createQuery("FROM Vehiculo v WHERE v.modelo = '" + modelo + "'");
		List<Vehiculo> listaResultado = query.list();
		return listaResultado;

	}
}
