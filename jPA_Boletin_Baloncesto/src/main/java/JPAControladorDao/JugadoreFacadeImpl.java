package JPAControladorDao;

import java.util.List;

import entidad.Jugadore;
import jakarta.persistence.TypedQuery;

public class JugadoreFacadeImpl extends AbstractFacadeJPAImpl<Jugadore> implements JugadoreFacade{

	public JugadoreFacadeImpl() {
		super(Jugadore.class);
	}

	@Override
	public List<Jugadore> mostrarTodos() {
		TypedQuery<Jugadore> q = this.getEm().createQuery("SELECT p FROM Jugadore AS p",Jugadore.class);
		return q.getResultList();
	}
	
}
