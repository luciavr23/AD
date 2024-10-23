package JPAControladorDao;

import java.util.List;

import entidad.Proyecto;

public interface ProyectoFacade extends AbstractFacadeJPA<Proyecto>{
	public List <Proyecto> mostrarTodos();
}
