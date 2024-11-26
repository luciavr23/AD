package JPAControladorDao;

import java.util.List;

import entidad.Temporada;
import jakarta.persistence.TypedQuery;

public class TemporadaFacadeImpl extends AbstractFacadeJPAImpl<Temporada> implements TemporadaFacade{

	public TemporadaFacadeImpl() {
		super(Temporada.class);
	}

	@Override
	public List<Temporada> mostrarTodos() {
		TypedQuery<Temporada> q = this.getEm().createQuery("SELECT p FROM Temporada AS p",Temporada.class);
		return q.getResultList();
	}
	
}
