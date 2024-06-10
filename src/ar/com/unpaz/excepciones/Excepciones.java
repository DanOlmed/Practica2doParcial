package ar.com.unpaz.excepciones;

@SuppressWarnings("serial")
public class Excepciones extends Exception {
	
	public Excepciones(int fallo) {
		super();
		
		if (fallo>5&&fallo<10) {
			System.out.println("\nLA OPCION ELEGIDA DEBE SER ENTRE 1 Y 5 INCLUSIVE\n\n");
		}
		if(fallo>10&&fallo>5) {
			System.out.println("\noooo te fuiste leeeejjoooss\nla opcion debe ser entre 1 y 5\n");
		}
	}
	

}
