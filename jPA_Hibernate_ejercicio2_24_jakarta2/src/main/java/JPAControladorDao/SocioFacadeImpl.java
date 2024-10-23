package JPAControladorDao;

import java.util.List;

import entidad.Socio;

public class SocioFacadeImpl extends AbstractFacadeJPAImpl<Socio> implements SocioFacade{

	public SocioFacadeImpl() {
		super(Socio.class);
	}

	@Override
	public List<Socio> mostrartodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
