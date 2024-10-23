package JPAControladorDao;

import java.util.List;

import entidad.Empleado;
import jakarta.persistence.TypedQuery;

public class EmpleadoFacadeImpl extends AbstractFacadeJPAImpl<Empleado> implements EmpleadoFacade{

	public EmpleadoFacadeImpl() {
		super(Empleado.class);
	}

	@Override
	public List<Empleado> mostrarTodos() {
		TypedQuery<Empleado> q=em.createQuery("SELECT p FROM  Empleado AS p",Empleado.class);
		return q.getResultList();
	}

}
