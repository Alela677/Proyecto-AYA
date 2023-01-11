package daos;

import java.util.List;

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
}
