package interfaz;

import java.util.List;

public interface VehiculosI<T> {

	public List<T> consultaColumna(String columna);

	public List<T> consultarPrecio(char comparacion, int precio);

	public List<T> consultarPrecioEntre(double precio1, double precio2);

	public List<T> filtrarPorColumna(String columna, String valor);
}
