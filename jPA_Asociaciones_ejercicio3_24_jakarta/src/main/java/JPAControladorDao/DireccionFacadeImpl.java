package JPAControladorDao;

import java.util.List;

import entidad.Direccion;
import jakarta.persistence.TypedQuery;

public class DireccionFacadeImpl extends AbstractFacadeJPAImpl<Direccion> implements DireccionFacade{

	public DireccionFacadeImpl() {
		super(Direccion.class);
	}

	@Override
	public List<Direccion> mostrarTodos() {
		TypedQuery<Direccion> q=em.createQuery("SELECT p FROM  Direccion AS p",Direccion.class);
		return q.getResultList();
	}

}
