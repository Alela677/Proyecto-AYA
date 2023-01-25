package main;

import java.util.List;

import org.hibernate.Session;

import dao.ReparacionDAO;
import models.HibernateUtil;
import models.Reparacion;

public class MainApp {

	public static void main(String[] args) {
		Session sesion = HibernateUtil.getSession();

	}
}
