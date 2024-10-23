package Test;


import java.util.List;

import Entidad.Libro;
import Entidad.Socio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Test_1_usii_de_EntityManager {
	public static void main(String[]args) {
		
		//CREAMOS LAS TABLAS VACÍAS:
		EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("Persistencia");//el nombre entre
		//paréntesis es el nombre que hay escrito en la etiqueta name en el fichero persistence.xml
		EntityManager emanager=emFactory.createEntityManager();
		/*
		///////////LOS DOS PASOS ANTERIORES SE PUEDEN RESUMIR EN://////////////
		 * EntityManager emanager=Persistence.createEntityManagerFactory("Persistencia").createEntityManager();
		 */
		Libro l1=new Libro("100","autor1","titulo1",(byte)0);
		Libro l2=new Libro("200","autor2","titulo2",(byte)0);
		Libro l3=new Libro("300","autor3","titulo3",(byte)0);
		Libro l4=new Libro("400","autor4","titulo4",(byte)0);
		
		System.out.println("Creando LIBRO..");
		
		Socio s1=new Socio(1,"Laura","Pérez Ruiz");
		Socio s2=new Socio(2,"Salma","Lepe Diaz");
		Socio s3=new Socio(3,"Juan","Roca Diaz");
		
		//el metodo .persist es el que realiza el insert
		emanager.getTransaction().begin(); //es una gestion/transaccion,sirve para asegurarte de que se
		//haga un commit
		
		//el persist es un insert
		emanager.persist(l1);
		emanager.persist(l3);
		emanager.persist(l4);
		
		//lo de abajo de utiliza para actualizar 
		l1.setTitulo("JPA e Hibernate");
		
		//el metodo flush lo que hace es guardar los cambios de forma obligatoria,sin esperar al commit
		emanager.flush();
		emanager.persist(l2);
		emanager.getTransaction().commit();
		
		//comprueba si el registro se ha gestionado o no
		boolean gestionada=emanager.contains(l1);
		System.out.println("l1 esta gestionada-"+gestionada);
		
		emanager.getTransaction().begin(); //es una gestion/transaccion
		l1.setTitulo("PacoM");
		boolean gestionadaN=emanager.contains(l1);
		System.out.println("Esta gestionada-"+gestionadaN);
		emanager.getTransaction().commit();
		
		/*ESTRUCTURA PARA HACER EL COMMIT
		 * emanager.getTransaction().begin();
		 * emanager.getTransaction().commit();
		 */
		
		//buscar un libro
		emanager.getTransaction().begin();
		
		
		//clase .find--> hay que pasarle por parametros el nombre de la clase a buscar
		//seguido de .class y el id. Cada vez que hago un find es como si estuviera cogiendo ese objeto en la
		//bd y volcandolo en el objeto en el que lo voy a referenciar, todo cambio que haga en libroBuscado
		//se verá reflejado en l1 en la BD
		Libro libroBuscado=emanager.find(Libro.class,"200");
		System.out.println(libroBuscado);
		
		
		libroBuscado.setTitulo("Arbol de la vida");
		libroBuscado=emanager.find(Libro.class,"200");
		System.out.println(libroBuscado);
		
		//Consulta con JPA: En vez de hacer el select de la tabla de la BD se hace con la clase Libro
		//ya que esta está ligada a la tabla LIBRO. (la e es el alias, el * no existe por lo tanto
		//para que muestre todos los registros ponemos el alias en el select. la sentencia
		//de abajo equivale a : Select * from libro l)
		TypedQuery<Libro> query=emanager.createQuery("Select e from Libro e",Libro.class);
		List <Libro> list=query.getResultList();//introduce en el array de objetos los 
		//registros de la tabla en la bd
		
		emanager.getTransaction().commit();
		
		/*En el bloque siguiente lo que hace es guardar d nuevo el l1(libeobuscado) q tiene q dar
		 * error y cambiarle el titulo, pero como hemos puesto el .refresh(rollback) antes del commit,
		 * no se guardan los cambios
		 */
		emanager.getTransaction().begin();
		emanager.persist(libroBuscado); //deberia de dar fallo pq estamos intentando insertar un objeto con
		//la misma clave que uno que ya esta insertado lo q pasa que esta mal programado y no lanza la excep
		//ción pero no te inserta el objeto en la BD
		libroBuscado.setTitulo("Hoy es viernes");
		emanager.refresh(libroBuscado); //Rollback
		emanager.getTransaction().commit();
		System.out.println("**Compruebo si ha modificado el titulo ");
		List<Libro>  list2=query.getResultList();
		
		//.detach-->Expulsa el objeto de la BD(lo desvincula) PARA QUE CUANDO SE HAGAN CAMBIOS NO LE AFECTE 
		//A LA FILA. por ej hacer un bucle para cambios en la tabla y que estos cambios no afecten a la fila 
		//de l4
		emanager.getTransaction().begin();
		emanager.detach(l4);
		
		//en el set de abajo al estar desvinculado el objeto a la BD los cambios se hacen sobre el objeto
		//y no sobre la BD
		l4.setAutor("Juanito");
		query=emanager.createQuery("Select e from Libro e",Libro.class);
		System.out.println("Consulta:"+query.getResultList());
		System.out.println("l4 esta persistida:"+emanager.contains(l4));
		
		//actualizamos el objeto de entidad con merge (lo actualiza pero no lo vincula)
		//para vincular el objeto de nuevo a la base de datos hay q hacer un .find
		emanager.merge(l4);
		System.out.println("consulta después del merge:"+query.getResultList());
		System.out.println("****l4 pasa a manage"+emanager.contains(l4));
		System.out.println("l4 sigue sin estar en el contexto de persistencia aunque haga"
				+ "una actualización con merge");
		
		emanager.getTransaction().commit();
		
		// actualizar un libro, si la entidad esta persistida se actualiza solo
        emanager.getTransaction().begin();
        libroBuscado.setAutor("Pepito");
        //emanager.merge(libroBuscado); //actualiza ante cualquier circunstancia
        emanager.getTransaction().commit();
        
		//cerramos los gestionadores
		emanager.close();
		emFactory.close();
	}
}
