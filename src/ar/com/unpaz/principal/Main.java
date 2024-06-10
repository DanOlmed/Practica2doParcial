package ar.com.unpaz.principal;
import ar.com.unpaz.model.Agenda;
import ar.com.unpaz.servicio.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import ar.com.unpaz.excepciones.*;

public class Main {

	public static void main(String[] args) {
		menu();
	}
	
	
	public static void menu() {
		int opcion =0;
		
		do {
			System.out.println("***MENU PRINCIPAL***\n");
			System.out.println("1.Listado de dias\n");
			System.out.println("2.Listado de horarios\n");
			System.out.println("3.Listado de actividades\n");
			System.out.println("4.Agenda Completa\n");
			System.out.println("5.SAlir\n");
			
			System.out.println("Seleccionar opcion: ");
			Scanner ingreso = new Scanner(System.in);
			opcion = ingreso.nextInt();
			
			switch(opcion) {
			case 1: listadoDias();
			break;
			case 2: listadoHorarios();
			break;
			case 3: listadoActividades();
			break;
			case 4: agendaCompleta();
			break;
			case 5: ingreso.close();
			System.out.println("FIN DEL PROGRAMA");
			default:
				try {
					if(opcion>5) {
						throw new Excepciones(opcion);
					}
				}catch(Exception e) {
					e.getMessage();
				}
				break;
			}
			
		}while(opcion!=5);
	}
	
	public static void listadoDias() {
		ServicioAgenda servicioAgenda =new ServicioAgenda();
		List<Agenda>sAgenda=new ArrayList<Agenda>();
		sAgenda=servicioAgenda.getListaAgenda();
		for(Agenda agenda:sAgenda) {
			System.out.println(agenda.getDia());
		}
		
		
	}
	public static void listadoHorarios() {
		ServicioAgenda servicioAgenda =new ServicioAgenda();
		List<Agenda>sAgenda=new ArrayList<Agenda>();
		sAgenda=servicioAgenda.getListaAgenda();
		for(Agenda agenda:sAgenda) {
			System.out.println(agenda.getHorario());
		}
	}
	
	public static void listadoActividades() {
		ServicioAgenda servicioAgenda =new ServicioAgenda();
		List<Agenda>sAgenda=new ArrayList<Agenda>();
		sAgenda=servicioAgenda.getListaAgenda();
		for(Agenda agenda:sAgenda) {
			System.out.println(agenda.getActividad());
		}
	}
	
	public static void agendaCompleta() {
		ServicioAgenda servicioAgenda =new ServicioAgenda();
		List<Agenda>sAgenda=new ArrayList<Agenda>();
		sAgenda=servicioAgenda.getListaAgenda();
		System.out.println("utilizando StreamParallel");
		
		 List<String>dias =sAgenda.parallelStream().map(x -> x.getDia())
						.map(x->x.toUpperCase())
						  .collect(Collectors.toList());
		dias.parallelStream().forEachOrdered(System.out::println);
		
		System.out.println("horarios");
		List<String>horarios = sAgenda.parallelStream().map(x->x.getHorario())
								.collect(Collectors.toList());
		horarios.parallelStream().forEachOrdered(System.out::println);
		System.out.println("actividades");
		List<String>actividades = sAgenda.parallelStream().map(x->x.getActividad()).map(x->x.toUpperCase())
				.collect(Collectors.toList());
		actividades.parallelStream().forEachOrdered(System.out::println);
		 
		//Esta version esta realizada implementado CopyOnWriteArrayList
		System.out.println("utilizando CopyOnWriteArrayList");
		System.out.println("Dias               Horarios          Actividad\n");
		CopyOnWriteArrayList <String>test = new CopyOnWriteArrayList<String>();
		for(Agenda agenda:sAgenda) {
			test.add(agenda.getDia());
				
		}
		CopyOnWriteArrayList <String>test1 = new CopyOnWriteArrayList<String>();
		for(Agenda agenda:sAgenda) {
			test1.add(agenda.getHorario());
				
		}
		CopyOnWriteArrayList <String>test2 = new CopyOnWriteArrayList<String>();
		for(Agenda agenda:sAgenda) {
			test2.add(agenda.getActividad());
				
		}
		
		Iterator<String> itr = test.iterator();
		Iterator<String> itr1 = test1.iterator();
		Iterator<String> itr2 = test2.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next()+"               "+itr1.next()+"          "+itr2.next());
		}
		
		System.out.println("\nUtilizando ConcurrentHashMap\n");
				
		
		
		ConcurrentHashMap <String,String> prueba = new ConcurrentHashMap<>();
		
		for(int i =0 ; i<test.size();i++) {
			prueba.put(test.get(i), test1.get(i));
			
		}
		System.out.println(prueba.toString());
		
		
		
						  
								
	}
	
	

}
