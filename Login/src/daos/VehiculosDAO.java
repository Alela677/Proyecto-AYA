package daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import models.Vehiculo;

public class VehiculosDAO{
	
	private static 	StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
	private static SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
	
	
	public static List<Vehiculo> consultaVehiculos() {
		Session sesion = sf.openSession();
		org.hibernate.Query query = sesion.createQuery("FROM Vehiculo");
		List<Vehiculo> listaVehiculos = query.list();
		sesion.close();
		return listaVehiculos;
	}

	
	public List<Vehiculo> buscarTodo(Vehiculo objeto) {
		
		return buscarTodo(objeto);
	}

	public static List<Vehiculo> vehiculosPorColor(String color) {

		Session sesion = sf.openSession();
		Query query = sesion.createQuery("FROM Vehiculo v WHERE v.color = '" + color + "'");
		List<Vehiculo> listaResultado = query.list();
		return listaResultado;

	}

	public static List<Vehiculo> vehiculosPorMarca(String marca) {
		Session sesion = sf.openSession();
		Query query = sesion.createQuery("FROM Vehiculo v WHERE v.marca = '" + marca + "'");
		List<Vehiculo> listaResultado = query.list();
		return listaResultado;

	}

	public static List<Vehiculo> vehiculosPorModelo(String modelo) {
		Session sesion = sf.openSession();
		Query query = sesion.createQuery("FROM Vehiculo v WHERE v.modelo = '" + modelo + "'");
		List<Vehiculo> listaResultado = query.list();
		return listaResultado;

	}

	public static List<Vehiculo> menorVeinte() {

		Session sesion = sf.openSession();
		Query query = sesion.createQuery("FROM Vehiculo v WHERE v.precio < '20000'");
		List<Vehiculo> listaResultado = query.list();
		return listaResultado;

	}

	public static List<Vehiculo> mayorCincuenta() {

		Session sesion = sf.openSession();
		Query query = sesion.createQuery("FROM Vehiculo v WHERE v.precio > '50000'");
		List<Vehiculo> listaResultado = query.list();
		return listaResultado;

	}

	public static List<Vehiculo> entreVeinteCincuenta() {

		Session sesion = sf.openSession();
		Query query = sesion.createQuery("FROM Vehiculo v WHERE v.precio between '20000' AND '50000'");
		List<Vehiculo> listaResultado = query.list();
		return listaResultado;

	}

	public static void main(String[] args) {

//		Vehiculo v1 = new Vehiculo("BMW", "I7", "NEGRO", 137000, 1, "bmw.jpg");
//		Vehiculo v2 = new Vehiculo("KIA", "RIO", "AZUL", 17900, 3, "kia-rio.jpeg");
//		Vehiculo v3 = new Vehiculo("FORD", "FOCUS", "VERDE", 29776, 2, "focus.jpeg");
//		Vehiculo v4 = new Vehiculo("CUPRA", "URBAN REBEL", "VERDE", 29000, 1, "cupra.jpg");
//
//		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
//		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
//
//		Session sesion = sf.openSession();
//		sesion.beginTransaction();
//
//		sesion.save(v1);
//		sesion.save(v2);
//		sesion.save(v3);
//		sesion.save(v4);
//
//		sesion.getTransaction().commit();
//		sesion.close();

	}

}
