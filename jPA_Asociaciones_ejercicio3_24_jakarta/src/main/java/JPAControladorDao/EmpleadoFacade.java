package JPAControladorDao;

import java.util.List;

import entidad.Empleado;

public interface EmpleadoFacade extends AbstractFacadeJPA<Empleado>{
	public List <Empleado> mostrarTodos();
}
