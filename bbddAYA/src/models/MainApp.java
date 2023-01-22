package models;



import org.hibernate.Session;

public class MainApp {

	public static void main(String[] args) {

		Concesionario c1 = new Concesionario();
		c1.setNombre("AYA");
		Empleados e1 = new Empleados();
		Vehiculo v1 = new Vehiculo();
		e1.setConcesionario(c1);
		v1.setConcesionario(c1);

		Session sesion = HibernateUtil.getSession();
		sesion.beginTransaction();
		
		sesion.save(c1);
		sesion.save(e1);
		sesion.save(v1);

		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();
	}
}
