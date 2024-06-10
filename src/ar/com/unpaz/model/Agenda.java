package ar.com.unpaz.model;

public class Agenda {
	public String dia;
	public String horario;
	public String actividad;
	
	
	
	
	
	
	
	public Agenda(String dia, String horario, String actividad) {
		super();
		this.dia = dia;
		this.horario = horario;
		this.actividad = actividad;
	}
	public Agenda() {
		super();
		
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getActividad() {
		return actividad;
	}
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	
	

}
