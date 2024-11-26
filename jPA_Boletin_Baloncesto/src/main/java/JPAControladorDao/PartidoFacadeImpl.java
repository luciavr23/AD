package JPAControladorDao;

import java.util.List;

import entidad.Partido;
import jakarta.persistence.TypedQuery;

public class PartidoFacadeImpl extends AbstractFacadeJPAImpl<Partido> implements PartidoFacade{

	public PartidoFacadeImpl() {
		super(Partido.class);
	}

	@Override
	public List<Partido> mostrarTodos() {
		TypedQuery<Partido> q = this.getEm().createQuery("SELECT p FROM Partido AS p",Partido.class);
		return q.getResultList();
	}
	
}
