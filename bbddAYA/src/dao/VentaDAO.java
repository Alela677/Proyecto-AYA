package dao;

import java.util.List;

import org.hibernate.Session;

import interfaz.VentaI;
import models.Venta;

public class VentaDAO<T> extends ComunesDAO<T> implements VentaI {

	private Session sesion;

	public VentaDAO(Session session) {
		super(session);
		this.sesion = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Venta> ventasPorCliente(String nombreCliente) {

		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return sesion.createQuery("FROM Venta v WHERE v.nombreCliente = '" + nombreCliente + "'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Venta> ventaPorEmpleado(String nombreEmpleado) {

		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return sesion.createQuery("FROM Venta v WHERE v.nombreEmpleado = '" + nombreEmpleado + "'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Venta> ventaPorMarcaOModelo(String valor) {

		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return sesion
				.createQuery(
						"FROM Venta v WHERE v.marcaVehiculo = '" + valor + "' OR v.modeloVehiculo= '" + valor + "' ")
				.list();
	}

	@Override
	public Venta ventaPorId(int id) {

		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return (Venta) sesion.createQuery("FROM Venta v WHERE v.id = " + id + "").uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Venta> ventasPorFecha(String fecha) {

		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return sesion.createQuery("FROM Venta v WHERE v.fechaVenta = '" + fecha + "'").list();
	}

}
