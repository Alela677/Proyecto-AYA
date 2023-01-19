package daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import models.Reparaciones;

public class ReparacionesDAO {

	private static StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
	private static SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();

	public static List<Reparaciones> consultarRepaciones() {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		Query query = sesion.createQuery("FROM Reparaciones r");
		List<Reparaciones> resultado = query.list();
		for (Reparaciones reparaciones : resultado) {
			System.out.println(reparaciones);
		}
		return resultado;

	}

	public static void main(String[] args) {
		consultarRepaciones();
	}
}
