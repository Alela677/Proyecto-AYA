package interfaz;

import java.util.List;

import models.Vehiculo;

public interface VehiculosI {

	List<Vehiculo> consultaColumna(String columna);

	List<Vehiculo> consultarPrecio(char comparacion, int precio);

	List<Vehiculo> consultarPrecioEntre(double precio1, double precio2);

	List<Vehiculo> filtrarPorColumna(String columna, String valor);
	

}
