package JPAControladorDao;

import java.util.List;

import entidad.Temporada;


public interface TemporadaFacade extends AbstractFacadeJPA<Temporada>{
	public List<Temporada> mostrarTodos();
}
