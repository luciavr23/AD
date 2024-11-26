package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import JPAControladorDao.*;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

public class Test_Boletin_Baloncesto {
	public static void main(String[] args) {
		
		EquipoFacadeImpl ef=new EquipoFacadeImpl();
		JugadoreFacadeImpl jf=new JugadoreFacadeImpl();
		PartidoFacadeImpl pf=new PartidoFacadeImpl();
		PartidosJugadoreFacadeImpl pjf=new PartidosJugadoreFacadeImpl();
		TempEquipoJugadorFacadeImpl tef=new TempEquipoJugadorFacadeImpl();
		TemporadaFacadeImpl tf=new TemporadaFacadeImpl();
		
		//CONSULTA 1:Obtener un listado de los nombres de los equipos con los puntos a favor obtenidos en la
		//temporada 2009-2010
		/*Date fechaIni=new Date();
		Date fechaFin=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat ("dd/MM/yyyy");
		try {
			fechaIni=sdf.parse("01/01/2009");
			fechaFin=sdf.parse("31/12/2010");
		}catch(ParseException e) {
			fechaIni=null;
		}*/
		System.out.println("---CONSULTA 1---");
		System.out.println("Listado de los nombres de los equipos con los puntos a favor temporada 2009-2010:");
		/*SELECT E.NOMBRE_EQUIPO, 
		(SELECT SUM(P.PUNTOS_VISITANTE) FROM PARTIDOS AS P WHERE P.TEMPORADA='T2' AND P.CODEQUIPO_VISITANTE=E.CODEQUIPO)+
		(SELECT SUM(P.PUNTOS_LOCAL) FROM PARTIDOS AS P WHERE  P.TEMPORADA='T2' AND P.CODEQUIPO_LOCAL=E.CODEQUIPO)
		FROM EQUIPOS E;*/
		TypedQuery <Tuple> query1=pf.getEm().createQuery(
				"SELECT e.nombreEquipo,(SELECT SUM(p.puntosVisitante) FROM Partido AS p WHERE p.temporadaBean.nombre='2009_2010' AND p.equipo2.codequipo=e.codequipo)+"
				+ "(SELECT SUM(p.puntosLocal) FROM Partido AS p WHERE p.temporadaBean.nombre='2009_2010' AND p.equipo1.codequipo=e.codequipo) FROM Equipo e",Tuple.class);
	
		List <Tuple> arrayQ1=query1.getResultList();
		for(Tuple t:arrayQ1) {
			System.out.println("\nNombre equipo:"+t.get(0)+"-->Puntos a favor:"+t.get(1));
		}
		
		//CONSULTA 2:¿En qué equipos jugó el Sr Rafael Martinez en la temporada 2009-2010? Mostrar el
		//nombre del equipo y el salario en miles de euros
		System.out.println("\n---CONSULTA 2---");
		System.out.println("\nEquipos en los que ha jugado Sr.Rafael Martinez en 2009-2010");
		TypedQuery <Tuple> query2=tef.getEm().createQuery(
				"SELECT tef.equipo.nombreEquipo,tef.salario FROM TempEquipoJugador tef WHERE tef.jugadore.nombreJugador='Rafa Martinez' AND tef.temporada.nombre='2009_2010'",Tuple.class);
	
		List <Tuple> arrayQ2=query2.getResultList();
		for(Tuple t:arrayQ2) {
			System.out.println("\nNombre equipo:"+t.get(0)+",salario:"+t.get(1));
		}
		
		//CONSULTA 3:Nombres de los jugadores que han cambiado de equipo en esta temporada (2010_2011)
		/*SELECT J.NOMBREJUGADOR FROM TEMP_EQUIPO_JUGADOR AS TEJ,JUGADORES AS J 
		 * WHERE CODTEMP='T2' AND TEJ.CODJUGADOR='j5' AND TEJ.CODJUGADOR=J.CODJUGADOR 
		 * HAVING COUNT(DISTINCT CODEQUIPO)>1;*/
		System.out.println("\n---CONSULTA 3--- ");
		System.out.println("\nJugadores que han cambiado de equipo en esta temporada 2010_2011");
		TypedQuery <Tuple> query3=tef.getEm().createQuery(
				"SELECT tef.jugadore.nombreJugador FROM TempEquipoJugador tef WHERE tef.temporada.nombre='2008_2009' GROUP BY tef.jugadore.nombreJugador HAVING COUNT(DISTINCT tef.equipo.codequipo)>1",Tuple.class);
	
		List <Tuple> arrayQ3=query3.getResultList();
		
		for(Tuple t:arrayQ3) {
			System.out.println("\nEl jugador: "+t.get(0)+"ha cambiado de equipo");
		}
		
		//CONSULTA 4:Nombres de los jugadores que han cambiado de equipo en la misma temporada . Muestra
		//el nombre del jugador, la temporada y el no de veces que ha cambiado
				/*SELECT J.NOMBRE_JUGADOR,COUNT(DISTINCT TEJ.CODEQUIPO),TEJ.CODTEMP FROM TEMP_EQUIPO_JUGADOR AS TEJ,JUGADORES AS J 
				 * WHERE TEJ.CODJUGADOR='J5' AND TEJ.CODJUGADOR=J.CODJUGADOR 
				 * group by TEJ.CODTEMP HAVING COUNT(DISTINCT CODEQUIPO)>1;*/
		System.out.println("\n---CONSULTA 4--- ");
		System.out.println("\nJugadores que han cambiado de equipo en la misma temporada");
		TypedQuery <Tuple> query4=tef.getEm().createQuery(
				"SELECT tef.jugadore.nombreJugador,tef.temporada.nombre,COUNT(DISTINCT tef.equipo.codequipo) FROM TempEquipoJugador tef GROUP BY tef.temporada.nombre,tef.jugadore.nombreJugador HAVING COUNT(DISTINCT tef.equipo.codequipo)>1",Tuple.class);
			
		List <Tuple> arrayQ4=query4.getResultList();
				
		for(Tuple t:arrayQ4) {
			System.out.println("\nEl jugador: "+t.get(0)+"ha cambiado de equipo "+t.get(2)+" veces en la temporada "+t.get(1));
		}
		
		//CONSULTA 5:Obener un listado de los jugadores que no han cambiado de equipo nunca.En el listado
		//tiene que aparecer el código y nombre de dicho jugador.
						/**/
		System.out.println("\n---CONSULTA 5--- ");
		System.out.println("\nJugadores que no han cambiado de equipo nunca");
		TypedQuery <Tuple> query5=tef.getEm().createQuery(
				"SELECT tef.jugadore.nombreJugador,tef.jugadore.codjugador FROM TempEquipoJugador tef GROUP BY tef.jugadore.nombreJugador,tef.jugadore.codjugador HAVING COUNT(DISTINCT tef.equipo.codequipo)<2",Tuple.class);
					
		List <Tuple> arrayQ5=query5.getResultList();
						
		for(Tuple t:arrayQ5) {
			System.out.println("\nEl jugador "+t.get(0)+" con código "+t.get(1)+" nunca ha cambiado de equipo");
		}
				
		//CONSULTA 6:Obtener los códigos de los jugadores que jueguen en el equipo 'e1' donde su sueldo
		//maximo en cualquier temporada sea menor o igual que el menor sueldo de cualquier
		//jugador de la temporada 't2'.		
		System.out.println("\n---CONSULTA 6--- ");
		System.out.println("\nJugadores que no han cambiado de equipo nunca");
		TypedQuery <Tuple> query6=tef.getEm().createQuery(
				"SELECT tef.jugadore.codjugador FROM TempEquipoJugador tef WHERE tef.equipo.codequipo =:parametro1 GROUP BY tef.jugadore.codjugador HAVING MAX(tef.salario)<=(SELECT MIN(tef2.salario) from TempEquipoJugador tef2 WHERE tef2.temporada.codtemp =:parametro2)",Tuple.class);
		String codJug="e1";
		String temp="t2";
		query6.setParameter("parametro1", codJug);		
		query6.setParameter("parametro2", temp);
		List <Tuple> arrayQ6=query6.getResultList();
						
		for(Tuple t:arrayQ6) {
			System.out.println("\nCódigo de jugador:"+t.get(0));
		}		
				
	}
}
