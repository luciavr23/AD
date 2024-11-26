package JPAControladorDao;

import java.util.List;

import entidad.PartidosJugadore;
import jakarta.persistence.TypedQuery;

public class PartidosJugadoreFacadeImpl extends AbstractFacadeJPAImpl<PartidosJugadore> implements PartidosJugadoreFacade{

	public PartidosJugadoreFacadeImpl() {
		super(PartidosJugadore.class);
	}

	@Override
	public List<PartidosJugadore> mostrarTodos() {
		TypedQuery<PartidosJugadore> q = this.getEm().createQuery("SELECT p FROM PartidosJugadore AS p",PartidosJugadore.class);
		return q.getResultList();
	}
	
}
