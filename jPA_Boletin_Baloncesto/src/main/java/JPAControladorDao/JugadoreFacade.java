package JPAControladorDao;

import java.util.List;

import entidad.Jugadore;


public interface JugadoreFacade extends AbstractFacadeJPA<Jugadore>{
	public List<Jugadore> mostrarTodos();
}
