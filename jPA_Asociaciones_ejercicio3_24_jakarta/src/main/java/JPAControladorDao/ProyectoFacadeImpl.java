package JPAControladorDao;

import java.util.List;

import entidad.Proyecto;
import jakarta.persistence.TypedQuery;

public class ProyectoFacadeImpl extends AbstractFacadeJPAImpl<Proyecto> implements ProyectoFacade{

	public ProyectoFacadeImpl() {
		super(Proyecto.class);
	}

	@Override
	public List<Proyecto> mostrarTodos() {
		TypedQuery<Proyecto> q=em.createQuery("SELECT p FROM  Proyecto AS p",Proyecto.class);
		return q.getResultList();
	}

}
