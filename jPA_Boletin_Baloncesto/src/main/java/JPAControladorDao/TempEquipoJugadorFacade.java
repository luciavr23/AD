package JPAControladorDao;

import java.util.List;

import entidad.TempEquipoJugador;

public interface TempEquipoJugadorFacade extends AbstractFacadeJPA<TempEquipoJugador>{
	public List<TempEquipoJugador> mostrarTodos();
}
