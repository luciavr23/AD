package JPAControladorDao;

import java.util.List;

import entidad.Direccion;

public interface DireccionFacade extends AbstractFacadeJPA<Direccion>{
	public List <Direccion> mostrarTodos();
}
