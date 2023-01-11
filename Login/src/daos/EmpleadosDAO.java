package daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import models.Empleados;

public class EmpleadosDAO {
	
	
	public static List<Empleados> consultarEmpleados() {

		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();

		Session sesion = sf.openSession();
		sesion.beginTransaction();

		Query query = sesion.createQuery("FROM Empleados e");
		List<Empleados> listaEmpleados = query.list();
		sesion.getTransaction().commit();
		sesion.close();
		return listaEmpleados;

	}

	public static void eliminaEmpleado(String dni) {
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();

		Session sesion = sf.openSession();
		sesion.beginTransaction();

		Query query = sesion.createQuery("FROM Empleados e WHERE e.dni = '" + dni + "'");
		Empleados emple = (Empleados) query.uniqueResult();
		sesion.delete(emple);

		sesion.getTransaction().commit();
		sesion.close();
	}
}
