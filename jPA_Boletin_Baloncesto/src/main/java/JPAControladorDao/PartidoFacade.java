package JPAControladorDao;

import java.util.List;

import entidad.Partido;


public interface PartidoFacade extends AbstractFacadeJPA<Partido>{
	public List<Partido> mostrarTodos();
}
