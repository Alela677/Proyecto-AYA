package daos;

import java.util.List;

public  interface InterfazComunesDAO<T> {

	public void insert(T objeto);

	public void update(T objeto);

	public void delete(T objeto);

	public List<T> buscarTodo(T objeto);

}
