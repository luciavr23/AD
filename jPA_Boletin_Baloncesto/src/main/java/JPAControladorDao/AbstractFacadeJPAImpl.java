package JPAControladorDao;

import jakarta.persistence.EntityManager;
import util.UtilJPA;

public abstract class AbstractFacadeJPAImpl<T> implements AbstractFacadeJPA<T>{

	private Class<T> entityClass;
	protected EntityManager em;
	
	public AbstractFacadeJPAImpl(Class<T> entityClass) {
		this.entityClass=entityClass;
		em=UtilJPA.getEntityManager();
	}
	
	@Override
	public Boolean create(T entity) {
		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ha ocurrido un error al GUARDAR,clave duplicada");
			return false;
		}
}
	
	@Override
	public Boolean update(T entity) {
		em.getTransaction().begin();
		try {
			em.merge(entity);
			em.getTransaction().commit();
			System.out.println("Actualización exitosa");
			return true;
		}catch(Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ha ocurrido un error");
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public void remove(T entity) {
		em.getTransaction().begin();
		em.remove(em.merge(entity));
		em.getTransaction().commit();
	}
	
	@Override
	public T find(Object id) {
		return em.find(entityClass, id);
	}
	
	@Override
	public EntityManager getEm() {
		return em;
		}
}
	
