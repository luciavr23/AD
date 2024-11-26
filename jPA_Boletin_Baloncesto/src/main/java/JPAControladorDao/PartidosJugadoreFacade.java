package JPAControladorDao;

import java.util.List;

import entidad.PartidosJugadore;


public interface PartidosJugadoreFacade extends AbstractFacadeJPA<PartidosJugadore>{
	public List<PartidosJugadore> mostrarTodos();
}
