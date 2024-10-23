package JPAControladorDao;

import java.util.List;

import entidad.PlazaParking;
import jakarta.persistence.TypedQuery;

public class PlazaParkingFacadeImpl extends AbstractFacadeJPAImpl<PlazaParking> implements PlazaParkingFacade{

	public PlazaParkingFacadeImpl() {
		super(PlazaParking.class);
	}

	@Override
	public List<PlazaParking> mostrarTodos() {
		TypedQuery<PlazaParking> q=em.createQuery("SELECT p FROM  PlazaParking AS p",PlazaParking.class);
		return q.getResultList();
	}

}
