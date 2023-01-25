package interfaz;

import java.util.List;

public interface ComunesIn<T> {
	

	public void insertar(final T objeto);

	public void actualizar(final T objeto);

	public void borrar(final T objeto);

	public List<T> traerTodos(final T objeto);

	public T buscarPorId(Long id);

}
