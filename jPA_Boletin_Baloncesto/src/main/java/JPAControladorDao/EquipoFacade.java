package JPAControladorDao;

import java.util.List;

import entidad.Equipo;


public interface EquipoFacade extends AbstractFacadeJPA<Equipo>{
	public List<Equipo> mostrarTodos();
}
