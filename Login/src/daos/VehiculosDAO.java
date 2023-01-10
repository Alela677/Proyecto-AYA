package daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import models.Vehiculo;

public class VehiculosDAO {

	public static void main(String[] args) {

//		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
//		Vehiculo v1 = new Vehiculo("SEAT", "IBIZA", "ROJO", 17000, 3, "ibiza.jpg");
//		Vehiculo v2 = new Vehiculo("AUDI", "A3", "GRIS", 29000, 2, "audia3.jpg");
//		vehiculos.add(v1);
//		vehiculos.add(v2);
//
//		introducirVehicuclos(vehiculos);
//		consultarVehiculos();
	}

	private static void introducirVehicuclos(ArrayList<Vehiculo> vehiculos) {
		Session sesion = HibernateUtil.getSession();

		sesion.beginTransaction();

		for (Vehiculo vehiculo : vehiculos) {
			sesion.save(vehiculo);
		}

		sesion.getTransaction().commit();
		sesion.close();
	}
	
	
	public static List<Vehiculo> consultarVehiculos() {
		
		Session sesion = HibernateUtil.getSession();
		
		sesion.getTransaction().begin();

		Query query = sesion.createQuery("Select v FROM Vehiculo v");
		List<Vehiculo> listaVehiculos = query.list();
		for (Vehiculo vehiculo : listaVehiculos) {
			System.out.println(vehiculo);
		}
		sesion.getTransaction().commit();
		sesion.close();

		return listaVehiculos;
	}

}
