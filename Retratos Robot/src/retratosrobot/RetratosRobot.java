package retratosrobot;

import java.util.Scanner;

public class RetratosRobot {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		mostrarRasgos(Faccion.PELO);
		int pelo = in.nextInt();
		
		mostrarRasgos(Faccion.OJOS);
		int ojos = in.nextInt();
		
		mostrarRasgos(Faccion.NARIZ);
		int nariz = in.nextInt();
		
		mostrarRasgos(Faccion.BOCA);
		int boca = in.nextInt();
		
		mostrarRasgos(Faccion.BARBILLA);
		int barbilla = in.nextInt();
		
		System.out.println(new Retrato(pelo, ojos, nariz, boca, barbilla));
	}
	
	public static void mostrarRasgos(Faccion faccion) {
		System.out.println("Opciones para " + Retrato.getNombreFaccion(faccion));
		for (int i=1; i <= Retrato.getMaxOpcion(faccion); i++) {
			System.out.println(i + " - " + Retrato.getRasgo(faccion, i));
		}
	}

}
