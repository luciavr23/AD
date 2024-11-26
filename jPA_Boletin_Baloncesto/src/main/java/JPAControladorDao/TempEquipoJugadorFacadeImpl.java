package JPAControladorDao;

import java.util.List;

import entidad.PartidosJugadore;
import entidad.TempEquipoJugador;
import jakarta.persistence.TypedQuery;

public class TempEquipoJugadorFacadeImpl extends AbstractFacadeJPAImpl<TempEquipoJugador> implements TempEquipoJugadorFacade{

	public TempEquipoJugadorFacadeImpl() {
		super(TempEquipoJugador.class);
	}

	@Override
	public List<TempEquipoJugador> mostrarTodos() {
		TypedQuery<TempEquipoJugador> q = this.getEm().createQuery("SELECT p FROM TempEquipoJugador AS p",TempEquipoJugador.class);
		return q.getResultList();
	}
	
}
