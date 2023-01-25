package interfaz;

import java.util.List;

import models.Empleados;

public interface EmpleadosI {

	public List<Empleados> EmpleadoTipo(String tipo);

	public List<Empleados> consultarNombreOApellidos(String nombre, String apellidos);

	Empleados buscarUnEmpleadoPorColumna(String columna, String valor);

	List<Empleados> listarEmpleadoPorColumna(String columna);
}
