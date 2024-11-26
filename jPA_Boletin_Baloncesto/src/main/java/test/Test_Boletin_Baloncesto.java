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
		System.out.println("CONSULTA 1");
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
		System.out.println("CONSULTA 2");
		System.out.println("\nEquipos en los que ha jugado Sr.Rafael Martinez en 2009-2010");
		TypedQuery <Tuple> query2=tef.getEm().createQuery(
				"SELECT tef.equipo.nombreEquipo,tef.salario FROM TempEquipoJugador tef WHERE tef.jugadore.nombreJugador='Rafa Martinez' AND tef.temporada.nombre='2009_2010'",Tuple.class);
	
		List <Tuple> arrayQ2=query2.getResultList();
		for(Tuple t:arrayQ2) {
			System.out.println("\nNombre equipo:"+t.get(0)+",salario:"+t.get(1));
		}
		
		//CONSULTA 3:Nombres de los jugadores que han cambiado de equipo en esta temporada (2010_2011)
		System.out.println("CONSULTA 3");
		System.out.println("\nJugadores que han cambiado de equipo en esta temporada 2010_2011");
		TypedQuery <Tuple> query3=tef.getEm().createQuery(
				"SELECT tef.equipo.nombreEquipo,tef.salario FROM TempEquipoJugador tef WHERE tef.jugadore.nombreJugador='Rafa Martinez' AND tef.temporada.nombre='2009_2010'",Tuple.class);
	
		List <Tuple> arrayQ3=query2.getResultList();
		
		for(Tuple t:arrayQ2) {
			System.out.println("\nNombre equipo:"+t.get(0)+",salario:"+t.get(1));
		}
	}
}
