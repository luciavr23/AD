package test;

import JPAControladorDao.DepartamentoFacadeImpl;
import JPAControladorDao.DireccionFacadeImpl;
import JPAControladorDao.EmpleadoFacadeImpl;
import JPAControladorDao.PlazaParkingFacadeImpl;
import JPAControladorDao.ProyectoFacadeImpl;
import entidad.Departamento;
import entidad.Direccion;
import entidad.Empleado;
import entidad.PlazaParking;
import entidad.Proyecto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Test_2_Asociaciones_OnetoMany {
	public static void main(String[]args) {
		try {
		/*AQUI NO HAY ENTITY MANAGER PQ VAMOS A UTILIZAR EL FACADE, CUANDO UTILIZAMOS FACADE NO NOS HACE FALTA 
		 * EL ENTITY YA Q VAMOS A HACER LOS PERSIST Y REMOVES CON LOS METODOS DE LOS FACADE*/
			
			//1-creo objetos los java
			Direccion d1=new Direccion(1l,"calle1","ciudad1","pais1",41001l);
			Direccion d2=new Direccion(2l,"calle2","ciudad2","pais2",41002l);
			
			PlazaParking p1=new PlazaParking("p100",1,01);
			PlazaParking p2=new PlazaParking("p200",2,02);
			
			Empleado e1=new Empleado("e1","Luisa","Ruiz",d1);
			Empleado e2=new Empleado("e2","Luis","Rio",d2);
			
			Proyecto py1=new Proyecto(1,"p1");
			Proyecto py2=new Proyecto(2,"p2");
			
			Departamento dep1=new Departamento(1,"contabilidad",1000.0);
		
			//2-Creamos los facade para llamar a sus métodos
			PlazaParkingFacadeImpl pf=new PlazaParkingFacadeImpl();
			DireccionFacadeImpl df=new DireccionFacadeImpl();
			EmpleadoFacadeImpl ef=new EmpleadoFacadeImpl();
			ProyectoFacadeImpl pyf=new ProyectoFacadeImpl();
			
			DepartamentoFacadeImpl dpf= new DepartamentoFacadeImpl();
			
			//el orden es importante a continuacion,hay que empezar a persistir con
			//los entity que no esten interrelacionados 
			
			//creo las direcciones en la BD ya que se las tendremos que pasar a los empleados 
			df.create(d1);
			df.create(d2);
			
			//creo las plazas en la BD ya que se las tendremos que pasar a los empleados
			pf.create(p1);
			pf.create(p2);
			
			//asigno plaza parking y direccion a los empleados y por ultimo creo a los empleados
			//en la BD
			
			e2.setPlaza(p2);
			p2.setEmpleado(e2); //AHORA SI HACEMOS LA BIDIRECCIONALIDAD PORQUE E2 YA Q
			ef.create(e2);
			
			e1.setPlaza(p1);
			p1.setEmpleado(e1);
			ef.create(e1);
			
			
			//creo dpto
			dep1.addEmpleado(e2);						
			dep1.addEmpleado(e1);
			dpf.create(dep1);
			
			pyf.create(py1);
			pyf.create(py2);
			
			dep1.addProyecto(py1);
			dep1.addProyecto(py2);
			dpf.update(dep1);
			
			
			
		//	dpf.update(dep1); Esto hace falta si el orden de arriba esta
			//invertido, es decir ,creamos el dpto y desp añadimos empleados
	
		}catch(Exception e) {
			System.out.println("--Ha ocurrido un error dentro de la BD--");
		}
		
	}
}
