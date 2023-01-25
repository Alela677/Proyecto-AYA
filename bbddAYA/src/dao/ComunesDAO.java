package dao;

import java.util.List;

import org.hibernate.Session;

import interfaz.ComunesIn;
import models.HibernateUtil;

public class ComunesDAO<T> implements ComunesIn<T> {
	
	
	
	public ComunesDAO() {
		super();

	}

	@Override
	public void insertar(T objeto) {
		Session sesion = HibernateUtil.getSession();
		sesion.beginTransaction();
		sesion.save(objeto);
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();

	}

	@Override
	public void actualizar(T objeto) {

		Session sesion = HibernateUtil.getSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(objeto);
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();
	}

	@Override
	public void borrar(T objeto) {

		Session sesion = HibernateUtil.getSession();
		sesion.beginTransaction();
		sesion.delete(objeto);
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> traerTodos(T objeto) {

		Session sesion = HibernateUtil.getSession();
		sesion.beginTransaction();

		return sesion.createQuery("FROM " + objeto + "").list();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public T buscarPorId(Long id) {
		
		Session sesion = HibernateUtil.getSession();
		sesion.beginTransaction();
		
		return (T) sesion.get(this.getClass(), id);
	}

}
