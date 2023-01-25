package interfaz;

import java.util.List;

import models.Empleados;

public interface EmpleadosI<T> {
	
	
	public Empleados EmpleadoTipo(String tipo);
	
	public List<T> consultarNombreOApellidos(String nombre , String apellidos);
	
	
	
	
	
	
}
