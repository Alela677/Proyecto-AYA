package main;

import org.hibernate.Session;

import dao.ComunesDAO;
import dao.EmpleadosDAO;
import dao.PropuestaDAO;
import models.Concesionario;
import models.Empleados;
import models.HibernateUtil;
import models.Propuesta;

public class MainApp {

	public static void main(String[] args) {
		Session sesion = HibernateUtil.getSession();

		PropuestaDAO<Propuesta> p = new PropuestaDAO<>(sesion);

		Propuesta pro = new Propuesta(0, null, null, null, 0, null);

//		p.insert(pro);

		Propuesta dev = p.propuestaPorId(3);
		System.out.println(dev.toString());
	}
}
