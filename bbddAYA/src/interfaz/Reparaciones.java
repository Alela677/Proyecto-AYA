package interfaz;

import models.Cliente;
import models.Empleados;
import models.Vehiculo;

public interface Reparaciones {

	Empleados buscaMecanico(String nombre);

	Vehiculo buscarVehiculo(String matricula);

	Cliente buscarCliente(String dni);

	String fechaReparacion(String fecha);

}
