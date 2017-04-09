package dao;

import java.util.Collection;

public interface IDaoCRUD<T> {
	
	public Collection<T> lister();

	public void creer(T obj);
	
	public void modifier(T obj);
	
	public void supprimer(T obj);
	
	public T getParId(int id);
}
