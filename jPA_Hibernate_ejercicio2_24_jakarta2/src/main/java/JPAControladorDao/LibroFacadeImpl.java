package JPAControladorDao;

import java.util.List;

import entidad.Libro;
import jakarta.persistence.TypedQuery;

public class LibroFacadeImpl extends AbstractFacadeJPAImpl<Libro> implements LibroFacade{



	public LibroFacadeImpl() {
		super(Libro.class);
	}

	@Override
	public List<Libro> mostrartodos() {
		TypedQuery<Libro> q=em.createQuery("SELECT p FROM  Libro AS p",Libro.class);
		return q.getResultList();
	}

}
