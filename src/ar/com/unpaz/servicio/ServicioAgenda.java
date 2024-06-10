package ar.com.unpaz.servicio;

import java.util.List;

import ar.com.unpaz.funciones.Funciones;
import ar.com.unpaz.model.Agenda;
import ar.com.unpaz.repositorio.*;
import java.util.*;

public class ServicioAgenda implements Funciones {
	
	public List<Agenda>getListaAgenda(){
		
		RepositorioAgenda repo = new RepositorioAgenda();
		List<Agenda> agendaLista = new ArrayList<Agenda>();
		agendaLista=repo.getListaAgenda();
			
		
		return agendaLista;
		
	}

}
