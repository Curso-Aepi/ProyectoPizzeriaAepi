package es.pizzeriagestion;

import es.pizzeriainterfaz.ICalcular;
import java.util.ArrayList;
import java.util.InputMismatchException;


import es.pizzeriainterfaz.IAniadirMenu;

/**
 * Clase hija Menú
 * 
 * Esta clase gestiona los menús de una pizzería
 * 
 * @author Leticia Patón
 * @version 1.0
 *
 * 
 */

public class Menus extends Pizzeria implements ICalcular, IAniadirMenu {

	String tamanioPizza;
	String tipoMasa;
	int saborPizza;
	int numeroDeBebidas;
	public static final int PIZZA_PEQUENIA = 3;
	public static final int PIZZA_MEDIANA = 5;
	public static final int PIZZA_FAMILIAR = 7;
	public static final double MASA_FINA = 6.5;
	public static final int MASA_NORMAL = 5;
	public static final int MASA_SINGLUTEN = 8;
	public static final int PRECIO_VEGETAL = 4;
	public static final double PRECIO_CARNE = 4.5;
	public static final double PRECIO_CARBONARA = 3.5;
	public static final double PRECIO_BEBIDA = 2.5;

	/**
	 * Método constructor por defecto
	 * 
	 */
	public Menu() {
		super();
	}

	/**
	 * Método constructor con argumentos
	 * 
	 * @param nombre            Nombre de la pizzería
	 * @param numeroDeTelefono  Número de teléfono de la pizzería
	 * @param horario           Horario de la pizzería
	 * @param direccion         Dirección de la pizzería
	 * @param numeroDeEmpleados Número de empleados totales
	 * @param tamanioPizza      Tamaño de la pizza (pequeña, mediana, familiar)
	 * @param tipoMasa          Tipo de masa de la pizza (fina, normal, sin gluten)
	 * @param numeroPizza       Número de pizza elegida (1 pizza vegetal, 2 pizza de
	 *                          carne, 3 pizza carbonara)
	 * @param numeroDeBebidas   Número de bebidas totales
	 * 
	 */
	public Menu(String nombre, String numeroDeTelefono, String horario, String direccion, int numeroDeEmpleados,
			String tamanioPizza, String tipoMasa, int saborPizza, int numeroDeBebidas) {
		super(nombre, numeroDeTelefono, horario, direccion, numeroDeEmpleados);
		this.tamanioPizza = tamanioPizza;
		this.tipoMasa = tipoMasa;
		this.saborPizza = saborPizza;
		this.numeroDeBebidas = numeroDeBebidas;

	}

	/**
	 * Devuelve el tamaño de la pizza
	 * 
	 * @return Devuelve el tamaño de la pizza (pequeña, mediana, familiar)
	 */
	public String getTamanioPizza() {
		return tamanioPizza;
	}

	/**
	 * Establece el tamaño de la pizza
	 * 
	 * @param tamanioPizza Establece el tamaño de la pizza (pequeña, mediana,
	 *                     familiar)
	 */
	public void setTamanioPizza(String tamanioPizza) {
		try {
			this.tamanioPizza = tamanioPizza;
		} catch (InputMismatchException e) {
			System.out.println("Dato incorrecto");
		}

	}

	/**
	 * Devuelve el tipo de masa
	 * 
	 * @return Devuelve el tipo de masa (fina, normal, sin gluten)
	 */
	public String getTipoMasa() {
		return tipoMasa;
	}

	/**
	 * Establece el tipo de masa (fina, normal, sin gluten)
	 * 
	 * @param tipoMasa
	 */
	public void setTipoMasa(String tipoMasa) {
		try {
			this.tipoMasa = tipoMasa;
		} catch (InputMismatchException e) {
			System.out.println("Dato incorrecto");
		}

	}

	/**
	 * Devuelve el número de pizza
	 * 
	 * @return Devuelve el número de pizza (1 vegetal, 2 de carne, 3 carbonara)
	 */
	public int getSaborPizza() {
		return saborPizza;
	}

	/**
	 * Establece el número de pizza (1 vegetal, 2 de carne, 3 carbonara)
	 * 
	 * @param saborPizza
	 */
	public void setSaborPizza(int saborPizza) {
		try {
			this.saborPizza = saborPizza;
		} catch (InputMismatchException e) {
			System.out.println("Dato incorrecto");
		}

	}

	/**
	 * Devuelve el número de bebidas pedidas
	 * 
	 * @return Devuelve el número de bebidas pedidas
	 */
	public int getNumeroDeBebidas() {
		return numeroDeBebidas;
	}

	/**
	 * Establece el número de bebidas
	 * 
	 * @param numeroDeBebidas Establece el número de bebidas pedidas
	 */
	public void setNumeroDeBebidas(int numeroDeBebidas) {
		try {
			this.numeroDeBebidas = numeroDeBebidas;
		} catch (InputMismatchException e) {
			System.out.println("Dato incorrecto");
		}
	}

	/**
	 * 
	 * @return Devuelve el precio de la pizza pequeña El valor de la pizza pequeña
	 *         es {@value}
	 * 
	 */
	public static int getPizzaPequenia() {
		return PIZZA_PEQUENIA;
	}

	/**
	 * 
	 * @return Devuelve el precio de la pizza mediana El valor de la pizza mediana
	 *         es {@value}
	 * 
	 */
	public static int getPizzaMediana() {
		return PIZZA_MEDIANA;
	}

	/**
	 * 
	 * @return Devuelve el precio de la pizza familiar El valor de la pizza famliar
	 *         es {@value}
	 * 
	 */
	public static int getPizzaFamiliar() {
		return PIZZA_FAMILIAR;
	}

	/**
	 * 
	 * @return Devuelve el precio de la masa fina El valor de la masa fina es
	 *         {@value}
	 * 
	 */
	public static double getMasaFina() {
		return MASA_FINA;
	}

	/**
	 * 
	 * @return Devuelve el precio de la masa normal El valor de la masa normal es
	 *         {@value}
	 */
	public static int getMasaNormal() {
		return MASA_NORMAL;
	}

	/**
	 * 
	 * @return Devuelve el precio de la masa sin gluten. El valor de la masa sin
	 *         gluten es {@value}
	 * 
	 */
	public static int getMasaSingluten() {
		return MASA_SINGLUTEN;
	}

	/**
	 * 
	 * @return Devuelve el precio de la pizza vegetal.
	 * 
	 *         El valor de la masa vegetal es {@value}
	 */
	public static int getPrecioVegetal() {
		return PRECIO_VEGETAL;
	}

	/**
	 * 
	 * @return Devuelve el precio de la pizza de carne. El valor de la pizza de
	 *         carne es {@value}
	 */
	public static double getPrecioCarne() {
		return PRECIO_CARNE;
	}

	/**
	 * 
	 * @return Devuelve el precio de la pizza carbonara. El valor de la pizza
	 *         carbonara es {@value}
	 */
	public static double getPrecioCarbonara() {
		return PRECIO_CARBONARA;
	}

	/**
	 * 
	 * @return Devuelve el precio de las bebidas. El valor del precio de las bebidas
	 *         es {@value}
	 */
	public static double getPrecioBebida() {
		return PRECIO_BEBIDA;
	}

	/**
	 * Método toString
	 * 
	 */
	@Override
	public String toString() {
		return "Menu [tamanioPizza=" + tamanioPizza + ", tipoMasa=" + tipoMasa + ", saborPizza=" + saborPizza + "]";
	}

	/**
	 * Método para añadir un menú
	 * 
	 * @see IAniadirMenu
	 * 
	 */
	@Override
	public void aniadirMenu() {
		ArrayList<Object> listaMenu = new ArrayList<>();
		listaMenu.add(this.tamanioPizza);
		listaMenu.add(this.tipoMasa);
		listaMenu.add(this.saborPizza);
		listaMenu.add(this.numeroDeBebidas);

		System.out.println("----- Menú -----");
		System.out.println("Tamaño pizza: " + this.tamanioPizza);
		System.out.println("Tipo de masa: " + this.tipoMasa);
		System.out.println("Sabor pizza: " + this.saborPizza);
		System.out.println("Número de bebidas: " + this.numeroDeBebidas);

	}

	/**
	 * Este método calcula el precio final del menú
	 * 
	 * @see ICalcular
	 * 
	 */
	@Override
	public double calcular() {
		double precioPizzas = 0;
		double precioBebidas = 0;
		double precio = 0;

		switch (this.tamanioPizza) {

		case "pequeña":
			precio = PIZZA_PEQUENIA;
			precioPizzas += precio;
			break;

		case "mediana":
			precio = PIZZA_MEDIANA;
			precioPizzas += precio;
			break;

		case "familiar":
			precio = PIZZA_FAMILIAR;
			precioPizzas += precio;
			break;

		default:
			System.out.println("Revisa el tamaño de la pizza");
			break;

		}

		switch (this.tipoMasa) {
		case "fina":
			precio = MASA_FINA;
			precioPizzas += precio;
			break;

		case "normal":
			precio = MASA_NORMAL;
			precioPizzas += precio;
			break;

		case "sin gluten":
			precio = MASA_SINGLUTEN;
			precioPizzas += precio;
			break;

		default:
			System.out.println("Revisa el tipo de masa");
			break;
		}

		switch (this.saborPizza) {

		case 1:
			precio = PRECIO_VEGETAL;
			precioPizzas += precio;
			break;

		case 2:
			precio = PRECIO_CARNE;
			precioPizzas += precio;
			break;

		case 3:
			precio = PRECIO_CARBONARA;
			precioPizzas += precio;
			break;

		default:
			System.out.println("Pizza incorrecta. Revisa el tipo de pizza");
			break;

		}

		precioBebidas = PRECIO_BEBIDA * this.numeroDeBebidas;
		double precioTotal = precioBebidas + precioPizzas;

		System.out.println("Precio de las bebidas = " + precioBebidas + " €");
		System.out.println("Precio de las pizzas = " + precioPizzas + " €");
		System.out.println("Precio total: ");
		return precioTotal;
	}

}
