package test;


import java.util.List;

import JPAControladorDao.LibroFacadeImpl;
import JPAControladorDao.SocioFacadeImpl;
import entidad.Libro;
import entidad.Socio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Test_2_facade_en_consola {
	public static void main(String[]args) {
		
		Libro l1=new Libro("100","autor1","titulo1",(byte)0);
		Libro l2=new Libro("200","autor2","titulo2",(byte)0);
		Libro l3=new Libro("300","autor3","titulo3",(byte)0);
		Libro l4=new Libro("400","autor4","titulo4",(byte)0);
		
		LibroFacadeImpl lf=new LibroFacadeImpl();
		lf.create(l1);
		lf.create(l2);
		lf.create(l3);
		lf.create(l4);
		List <Libro> listaLibros=lf.mostrartodos();
		System.out.println(listaLibros);
		
		l4.setAutor("Gala");
		l4.setTitulo("Los incomprendidos");
		boolean result=lf.update(l4);
		System.out.println("Cambio realizado:"+result);
		lf.remove(l3);
		
		Socio s1=new Socio(1,"Perez","Juan");
		Socio s2=new Socio(2,"Vega","Marita");
		Socio s3=new Socio(3,"Lopez","Pepita");
		SocioFacadeImpl sf=new SocioFacadeImpl();
		sf.create(s1);
		sf.create(s2);
		sf.create(s3);
		List <Socio> listaSocios=sf.mostrartodos();
		System.out.println(listaSocios);
		s1.setApellidos("Lobo");
		sf.update(s1);
		sf.remove(s3);
	}
}
