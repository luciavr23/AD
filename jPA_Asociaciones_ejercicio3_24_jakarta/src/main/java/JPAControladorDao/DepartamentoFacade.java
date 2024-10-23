package JPAControladorDao;

import java.util.List;

import entidad.Departamento;

public interface DepartamentoFacade extends AbstractFacadeJPA<Departamento>{
	public List <Departamento> mostrarTodos();
}
