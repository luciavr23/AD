package JPAControladorDao;

import java.util.List;

import entidad.Equipo;
import jakarta.persistence.TypedQuery;

public class EquipoFacadeImpl extends AbstractFacadeJPAImpl<Equipo> implements EquipoFacade{

	public EquipoFacadeImpl() {
		super(Equipo.class);
	}

	@Override
	public List<Equipo> mostrarTodos() {
		TypedQuery<Equipo> q = this.getEm().createQuery("SELECT p FROM Equipo AS p",Equipo.class);
		return q.getResultList();
	}
	
}
