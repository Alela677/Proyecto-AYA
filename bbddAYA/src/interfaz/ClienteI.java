package interfaz;

import java.util.List;

import models.Cliente;

public interface ClienteI {

	List<Cliente> listaClientes();

	Cliente buscarPorDni(String dni);

	Cliente buscarPorApellidosONombre(String apellido, String nombre);

	Cliente buscarPorTelefono(int telefono);
}
