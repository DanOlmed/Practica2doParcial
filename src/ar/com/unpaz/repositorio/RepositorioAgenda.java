package ar.com.unpaz.repositorio;
import java.io.*;
import java.util.*;

import ar.com.unpaz.funciones.Funciones;
import ar.com.unpaz.model.Agenda;

public class RepositorioAgenda implements Funciones {
	
	public List<Agenda> getListaAgenda(){
		File agendaFile = new File("C:\\Users\\giser\\OneDrive\\Escritorio\\practicaParcia2do.txt");
		FileReader agendaReader;
		List<Agenda>agendaList = new ArrayList<Agenda>();
		
		
		try {
			agendaReader = new FileReader(agendaFile);
			BufferedReader bfReader = new BufferedReader(agendaReader);
			String linea = "";
			while((linea=bfReader.readLine())!=null) {
				String data [] = linea.split(",");
				Agenda sAgenda = new Agenda();
				sAgenda.setDia(data[0]);
				sAgenda.setHorario(data[1]);
				sAgenda.setActividad(data[2]);
				agendaList.add(sAgenda);
				
			}
			if(bfReader!=null) {
				try {
					bfReader.close();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return agendaList;
	}
	
	

}
