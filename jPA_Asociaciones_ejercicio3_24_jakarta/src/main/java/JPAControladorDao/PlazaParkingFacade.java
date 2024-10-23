package JPAControladorDao;

import java.util.List;

import entidad.PlazaParking;

public interface PlazaParkingFacade extends AbstractFacadeJPA<PlazaParking>{
	public List <PlazaParking> mostrarTodos();
}
