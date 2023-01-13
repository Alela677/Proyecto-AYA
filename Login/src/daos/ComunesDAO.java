package daos;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ComunesDAO<T> implements InterfazComunesDAO<T> {

	private StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
	private SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();

	@Override
	public void insert(T objeto) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.save(objeto);
		sesion.flush();
		sesion.getTransaction().commit();
		sesion.close();
	}

	@Override
	public void update(T objeto) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(objeto);
		sesion.flush();
		sesion.getTransaction().commit();
		sesion.close();
	}

	@Override
	public void delete(T objeto) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.delete(objeto);
		sesion.flush();
		sesion.getTransaction().commit();
		sesion.close();

	}

	@Override
	public List<T> buscarTodo(T objeto) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		Query query = sesion.createQuery("FROM '" + objeto + "' o");
		List<T> listaResultado = query.list();
		sesion.flush();
		sesion.getTransaction().commit();
		sesion.close();
		return listaResultado;
	}

}
