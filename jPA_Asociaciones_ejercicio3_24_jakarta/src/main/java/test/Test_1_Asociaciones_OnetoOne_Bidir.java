package test;

import entidad.Direccion;
import entidad.Empleado;
import entidad.PlazaParking;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Test_1_Asociaciones_OnetoOne_Bidir {
	public static void main(String[]args) {
		try {
			EntityManagerFactory emfactory=Persistence.createEntityManagerFactory("Persistencia");
			EntityManager emanager=emfactory.createEntityManager();
			
			Direccion d1=new Direccion(1l,"calle1","ciudad1","pais1",41001l);
			Direccion d2=new Direccion(2l,"calle2","ciudad2","pais2",41002l);
			
			PlazaParking p1=new PlazaParking("p100",1,01);
			PlazaParking p2=new PlazaParking("p200",2,02);
			
			Empleado e1=new Empleado("e1","Luisa","Ruiz",d1,p1);
			Empleado e2=new Empleado("e2","Luis","Rio",d2,p2);
			emanager.getTransaction().begin();
			emanager.persist(d1);
			emanager.persist(p1);
			emanager.persist(e1);//como a empleado  le pasamos plazaparking y direccion 
			//hay que persistir perimero plaza parking y direccion
			p1.setEmpleado(e1); //como en plaza parking tenemos instanciado un empleado tenemos que
			//pasarle el empleado para asignarle el valor al atributo
			
			emanager.persist(d2);
			emanager.persist(p2);
			emanager.persist(e2);//como a empleado  le pasamos plazaparking y direccion 
			//hay que persistir perimero plaza parking y direccion
			p2.setEmpleado(e2); //pasarle el empleado para asignarle el valor al atributo
			emanager.getTransaction().commit();
			
			//CONSULTA
			System.out.println("**Empleados de la BD:**");
			TypedQuery <Empleado> query=emanager.createQuery("Select e from Empleado e",Empleado.class);
			System.out.println(query.getResultList());
			emanager.close();
			emfactory.close();
		}catch(Exception e) {
			System.out.println("--Ha ocurrido un error dentro de la BD--");
		}
		
	}
}
