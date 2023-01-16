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

	private static StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
	private static SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();

	public static List<Empleados> consultarEmpleados() {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		Query query = sesion.createQuery("FROM Empleados e");
		List<Empleados> listaEmpleados = query.list();
		sesion.getTransaction().commit();
		sesion.close();
		return listaEmpleados;

	}

	public static void eliminaEmpleado(Empleados empleado) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.delete(empleado);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public static void actualizarEmpleado(Empleados empleado) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(empleado);
		sesion.getTransaction().commit();
		sesion.close();

	}

	public static List<String> consultarComboBox(String campoConsultar) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		Query query = sesion.createQuery("SELECT e."+campoConsultar+" FROM Empleados e");
		List<String> resultadoDepartamento = query.list();
		sesion.flush();
		sesion.getTransaction().commit();
		sesion.close();
		return resultadoDepartamento;

	}
	
	public static List<Empleados> consultarFiltro(String campoConsultar , String campo) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		Query query = sesion.createQuery(" FROM Empleados e WHERE e."+campoConsultar+" = '"+campo+"' ");
		List<Empleados> resultadoDepartamento = query.list();
		sesion.flush();
		sesion.getTransaction().commit();
		sesion.close();
		return resultadoDepartamento;

	}
	
	public static List<Empleados> consultarFiltroId(int campo) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		Query query = sesion.createQuery(" FROM Empleados e WHERE e.id= '"+campo+"'");
		List<Empleados> resultadoDepartamento = query.list();
		sesion.flush();
		sesion.getTransaction().commit();
		sesion.close();
		return resultadoDepartamento;

	}
	public static List<Empleados> consultarNombre(String nombreBuscar) {	
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		Query query = sesion.createQuery("FROM Empleados e WHERE e.nombre = '" + nombreBuscar + "'");
		List<Empleados> listaEmpleados = query.list();
		return listaEmpleados;
	}
	
	public static List<Empleados> consultarApellido(String apellidos) {	
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		Query query = sesion.createQuery("FROM Empleados e WHERE e.apellidos LIKE  '%"+apellidos+"%'");
		List<Empleados> listaEmpleados = query.list();
		return listaEmpleados;
	}
	
	public static void main(String[] args) {

//		Empleados e1 = new Empleados("LUISsss", "ROBLES GARCIA", "12345678A", "MECANICO", "TRABAJADOR", "2022/09/15",
//				null, "empleado1.jpg");
//		Empleados e2 = new Empleados("MARIA", "RUIZ LEAL", "12345678B", "VENTAS","TRABAJADOR", "2022/12/22", null, "empleado2.jpg");
//		Empleados e3 = new Empleados("LUIS", "AGUILAR ASTORGA", "12345678C", "MECANICO","TRABAJADOR", "2022/11/12", null, "empleado3.jpg");
//		Empleados e4 = new Empleados("LAURA", "ORTEGA GARCIA", "12345678D", "VENTAS","TRABAJADOR", "2022/10/17", null, "empleado4.jpg");
//		
//		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
//		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
//
//		Session sesion = sf.openSession();
//		sesion.beginTransaction();
//		
//		sesion.save(e1);
//		sesion.save(e2);
//		sesion.save(e3);
//		sesion.save(e4);
//		sesion.getTransaction().commit();
//
//		sesion.close();
	consultarFiltroId(13);
	}

	

}
