package daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import models.Usuarios;
import models.Vehiculo;

public class UsuariosDAO extends ComunesDAO<Usuarios> {
	private static Session sesion = HibernateUtil.getSession();

	public static void main(String[] args) {

//		ArrayList<Usuarios> user = new ArrayList<Usuarios>();
//		user.add(new Usuarios(1, "Luis", "1234"));
//		user.add(new Usuarios(2, "David", "1234"));
//		user.add(new Usuarios(3, "Maria", "1234"));
//
//		introducirUsuarios(user);

		
	}
	
	
	
	public static void introducirUsuarios(ArrayList<Usuarios> user) {
		sesion = HibernateUtil.getSession();
		sesion.getTransaction().begin();

		for (Usuarios usuarios : user) {
			sesion.save(usuarios);
		}

		sesion.getTransaction().commit();
		sesion.close();

	}

	public static Usuarios consultarUsuarios(String nombre1, String password1) {

		sesion = HibernateUtil.getSession();
		sesion.getTransaction().begin();

		System.out.println(nombre1 + password1);
		Query query = sesion.createQuery("FROM Usuarios WHERE nombre = :nombre AND password= :password");

		query.setParameter("nombre", nombre1);
		query.setParameter("password", password1);
		Usuarios nuevo = (Usuarios) query.uniqueResult();
		System.out.println(nuevo.toString());
		sesion.flush();

		sesion.getTransaction().commit();
		sesion.close();
		return nuevo;

	}

	

}
