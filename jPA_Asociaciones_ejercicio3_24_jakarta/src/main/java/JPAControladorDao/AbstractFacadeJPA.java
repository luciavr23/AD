package JPAControladorDao;

import jakarta.persistence.EntityManager;

public interface AbstractFacadeJPA<T> {
	//la T es un tipo genérico,para que le podamos pasar la entidad(clase) que queramos
	Boolean create(T entity);
	Boolean update(T entity);
	void remove (T entity);
	T find(Object id);
	EntityManager getEm();
	
}
