package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Test_0_Asociaciones_OnetoOne_Unidir {
	public static void main(String[]args) {
		try {
			EntityManagerFactory emfactory=Persistence.createEntityManagerFactory("Persistencia");
			EntityManager emanager=emfactory.createEntityManager();
			emanager.close();
			emfactory.close();
		}catch(Exception e) {
			System.out.println("--Ha ocurrido un error dentro de la BD--");
		}
		
	}
}
