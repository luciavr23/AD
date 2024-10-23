package JPAControladorDao;

import java.util.List;

import entidad.Departamento;
import jakarta.persistence.TypedQuery;

public class DepartamentoFacadeImpl extends AbstractFacadeJPAImpl<Departamento> implements DepartamentoFacade{

	public DepartamentoFacadeImpl() {
		super(Departamento.class);
	}

	@Override
	public List<Departamento> mostrarTodos() {
		TypedQuery<Departamento> q=em.createQuery("SELECT p FROM  Departamento AS p",Departamento.class);
		return q.getResultList();
	}

}
