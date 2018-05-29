package retratosrobot;

import java.util.NoSuchElementException;

import java.util.Random;

public class Retrato {
	
	/**
	 * Los objetos de la clase <code>Retrato</code> representan
	 * retratos robot en los que se distinguen 5 facciones (pelo,
	 * ojos, nariz, boca y barbilla), cada una de ellas representada
	 * mediante una cadena de caracteres predefinida. Las cadenas
	 * predefinidas para cada facción son las siguientes:
	 * <pre><ul>
	 * 	<li>PELO    : WWWWWWWWW, \\\//////, |||||||||, |"""""""|, |'''''''|</li>
	 * 	<li>OJOS    : | O   O |, |-(· ·)-|, |-[O O]-|, |  \ /  |</li>
	 * 	<li>NARIZ   : @   J   @, {   "   }, [   j   ], <   -   ></li>
	 *  <li>BOCA    : |  ===  |, |   -   |, |  ___  |, |  ---  |</li>
	 *  <li>BARBILLA: \_______/, \,,,,,,,/,  \_____/ ,  \,,,,,/</li>
	 * </ul></pre>
	 */

	
	private static final Random R = new Random();
	
	private static final String [][] RASGOS = {
			{"pelo", "WWWWWWWWW", "\\\\\\//////", "|||||||||", "\"\"\"\"\"\"\"\"\"", "'''''''''"},
			{"ojos", "| O   O |", "|-(Â· Â·)-|", "|-[o o]-|", "|  \\ /  |"},
			{"orejas y nariz", "@   J   @", "{   \"   }", "[   j   ]", "<   -   >"},
			{"boca", "|  ===  |", "|   -   |", "|  ___  |" , "|  ---  |"},
			{"barbilla", "\\_______/", "\\,,,,,,,/"}
	};

	
	private int [] rasgos = new int[RASGOS.length];
	/**
	 * Crea un retrato a partir de opciones especificas para cada faccion
	 * @param pelo número de la opción elegida para el pelo
	 * @param ojos número de la opción elegida para los ojos
	 * @param orejas y nariz número de la opción elegida para las orejas y la nariz
	 * @param boca número de opción elegida para la boca
	 * @param barbilla número de opción elegida para la barbilla
	 * @throws NoSuchElementException si alguna de las opciones es menor que 0 o mayor que el máximo permitido
	 * @see #getMaxOpcion(Faccion)
	 */
	
	public Retrato(int pelo, int ojos, int nariz, int boca, int barbilla) {
		setPelo(pelo);
		setOjos(ojos);
		setNariz(nariz);
		setBoca(boca);
		setBarbilla(barbilla);
	}
	/**
	 * Sirve para generar los rasgos aleatorios
	 */
	public Retrato() {
		setAleatorio();
	}
	/**
	 * Sirve para recorrer todos los parametros insertados en cada rasgo
	 * @param retrato
	 */
	
	public Retrato(Retrato retrato) {
		for (int i=0; i<rasgos.length; i++)
			rasgos[i] = retrato.rasgos[i];
	}
	/**
	 * Sirve para sacar por pantalla el resultado del programa
	 */
	
	@Override
	public String toString() {
		String nl = System.getProperty("line.separator");
		return getPelo() + nl + getOjos() + nl + getNariz() + nl + 
				getBoca() + nl + getBarbilla();  
	}
	/**
	 * Los setters sirven para modificar las distintas variables, pelo, nariz y ojos etc.
	 */

	public void setAleatorio() {
		int nuevo;
		for (Faccion f: Faccion.values()) {
			do {
				nuevo = R.nextInt(RASGOS[f.ordinal()].length - 1) + 1;
			} while (nuevo == rasgos[f.ordinal()]);
			rasgos[f.ordinal()] = nuevo;
		}
			
	}
	/**
	 * Los getters sirven retornar el valor de la variable que hayas elegido, nariz y ojos, pelo etc.
	 * @return
	 */
	
	public String getPelo() {
		return RASGOS[Faccion.PELO.ordinal()][rasgos[Faccion.PELO.ordinal()]];
	}

	public void setPelo(int pelo) {
		if (pelo < 1 || pelo >= RASGOS[Faccion.PELO.ordinal()].length)
			throw new NoSuchElementException("Opcion de pelo incorrecta.");
		rasgos[Faccion.PELO.ordinal()] = pelo;
	}

	public String getOjos() {
		return RASGOS[Faccion.OJOS.ordinal()][rasgos[Faccion.OJOS.ordinal()]];
	}

	public void setOjos(int ojos) {
		if (ojos < 1 || ojos >= RASGOS[Faccion.OJOS.ordinal()].length)
			throw new NoSuchElementException("Opcion de ojos incorrecta.");
		rasgos[Faccion.OJOS.ordinal()] = ojos;
	}

	public String getNariz() {
		return RASGOS[Faccion.NARIZ.ordinal()][rasgos[Faccion.NARIZ.ordinal()]];
	}

	public void setNariz(int nariz) {
		if (nariz < 1 || nariz >= RASGOS[Faccion.NARIZ.ordinal()].length)
			throw new NoSuchElementException("Opcion de nariz incorrecta.");
		rasgos[Faccion.NARIZ.ordinal()] = nariz;
	}

	public String getBoca() {
		return RASGOS[Faccion.BOCA.ordinal()][rasgos[Faccion.BOCA.ordinal()]];
	}

	public void setBoca(int boca) {
		if (boca < 1 || boca >= RASGOS[Faccion.BOCA.ordinal()].length)
			throw new NoSuchElementException("Opcion de boca incorrecta.");
		rasgos[Faccion.BOCA.ordinal()] = boca;
	}

	public String getBarbilla() {
		return RASGOS[Faccion.BARBILLA.ordinal()][rasgos[Faccion.BARBILLA.ordinal()]];
	}

	public void setBarbilla(int barbilla) {
		if (barbilla < 1 || barbilla >= RASGOS[Faccion.BARBILLA.ordinal()].length)
			throw new NoSuchElementException("Opcion de barbilla incorrecta.");
		rasgos[Faccion.BARBILLA.ordinal()] = barbilla;
	}
	
	public void setRasgo(Faccion faccion, int opcion) {
		if (opcion < 1 || opcion >= RASGOS[faccion.ordinal()].length)
			throw new NoSuchElementException("Opcion incorrecta para la facciÃ³n indicada.");
		rasgos[faccion.ordinal()] = opcion;
	}
	/*
	 * Muestra el siguiente rasgo de pelo, de nariz etc
	 */
	public String setSgte(Faccion faccion) {
		rasgos[faccion.ordinal()]++;
		if (rasgos[faccion.ordinal()] == RASGOS[faccion.ordinal()].length)
			rasgos[faccion.ordinal()] = 1;
		return  RASGOS[faccion.ordinal()][rasgos[faccion.ordinal()]];
	}
	/*
	 * Muestra el anterior rasgo de pelo, de nariz etc
	 */
	public String setAnt(Faccion faccion)  {
		rasgos[faccion.ordinal()]--;
		if (rasgos[faccion.ordinal()] == 0)
			rasgos[faccion.ordinal()] = RASGOS[faccion.ordinal()].length - 1;
		return  RASGOS[faccion.ordinal()][rasgos[faccion.ordinal()]];
	}
	/*
	 * Ordenas los rasgos
	 */
	public String getRasgo(Faccion faccion) {
		return RASGOS[faccion.ordinal()][rasgos[faccion.ordinal()]];
	}
	/*
	 * Hace saltar una excepción cuando el rasgo elegido no esta dentro del rango permitido
	 */
	public static String getRasgo(Faccion faccion, int opcion) {
		if (opcion < 1 || opcion >= RASGOS[faccion.ordinal()].length)
			throw new NoSuchElementException("Opcion incorrecta para la facciÃ³n indicada.");
		return RASGOS[faccion.ordinal()][opcion];
	}
	/*
	 * Saca las ultimas opciones de pelo, nariz y ojos etc
	 */
	public static int getMaxOpcion(Faccion faccion) {
		return RASGOS[faccion.ordinal()].length - 1;
	}
	/*
	 * Saca el tipo de rasgo por pantalla
	 */
	public static String getNombreFaccion(Faccion faccion) {
		return RASGOS[faccion.ordinal()][0];
	}
}
