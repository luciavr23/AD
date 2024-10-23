package JPAControladorDao;

import java.util.List;

import entidad.Libro;

public interface LibroFacade extends AbstractFacadeJPA<Libro>{
	public List<Libro> mostrartodos();
}
