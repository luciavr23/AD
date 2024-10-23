package JPAControladorDao;

import java.util.List;
import entidad.Socio;

public interface SocioFacade extends AbstractFacadeJPA<Socio>{
	public List<Socio> mostrartodos();
}
