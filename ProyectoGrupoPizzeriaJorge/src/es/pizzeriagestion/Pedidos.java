package es.pizzeriagestion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import es.pizzeriagestion.Pizzeria;
import es.pizzeriagestion.Menus;


/**

 * Esta clase nos ayuda a crear un pedido que comprende una pizza con sus variantes de sabor, masa y tamaño y la cantidad de estas.
 * El pedido nos dice si tenemos bebidas, saca un id para cara pedido y si es para lleva o no.
 * 
 * @author: Ricardo Murillo Fernández

 * @version: 22/07/2022/A

 */


/**
 * @param idPedido			ID de cada uno de los pedidos.
 * @param numPizzas			Número de pizzas del mismo sabor que tiene un pedido.
 * @param tipoPedido		Pedido a domicilio o en restaurante.
 * @param precioPedido			Precio total del pedido.
 */




public class Pedidos extends Pizzeria  {
	
	

// ------------------------------------------------------------------ VARIABLES
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * @param idPedido			ID de cada uno de los pedidos.
	 * @param numPizzas			Número de pizzas del mismo sabor que tiene un pedido.
	 * @param tipoPedido		Pedido a domicilio o en restaurante.
	 * @param precioPedido			Precio total del pedido.
	 */
	
	// ID de cada uno de los pedidos.
	private int idPedido;
	
	// Número de pizzas del mismo sabor que tiene un pedido.
	private int numPizzas;

	// Variable de tipo Menu.
	private Menus menu;

	// Pedido para llevar o no
	private int tipoPedido;

	// Una comanda es una parte del pedido, lo que pedidria un cliente si son cuatro, por ejemplo.
	private String comanda;
	
	
	
	
	

// ------------------------------------------------------------------ CONSTRUCTORES
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
	public Pedidos() {

	}

	public Pedidos(String nombre, String numeroDeTelefono, String horario, String direccion, int numeroDeEmpleados,
			int idPedido, int tipoPedido, int numPizzas, int precioPedido, Menus menu) {
		super(nombre, numeroDeTelefono, horario, direccion, numeroDeEmpleados);
		this.idPedido = idPedido;
		this.tipoPedido = tipoPedido;
		this.numPizzas = numPizzas;
		this.menu = menu;
	}

	
	
	
	
// ------------------------------------------------------------------ MÉTODOS GET/SET
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Menus getMenu() {
		return menu;
	}

	public void setMenu(Menus menu) {
		this.menu = menu;
	}

	public int getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(int tipoPedido) {
		this.tipoPedido = tipoPedido;
	}
	
	public int getNumPizzas() {
		return numPizzas;
	}

	public void setNumPizzas(int numPizzas) {
		this.numPizzas = numPizzas;
	}

	
	
	
	
// ------------------------------------------------------------------ MÉTODOS PROPIOS
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	

	/**

     * Método que pinta por pantalla un pedido completo que consta de una comanda, su id y el tipo de pedido (a domicilio o en restaurante).
      
     * @param String comanda			Podemos entenderlo como uno de los servicios que completan un pedido. (pizza, masa, tamaño, sabor y cantidad y numero de bebida)

     * @return Devuelve el ID de el pedido y su tipo (restaurante o domicilio) y una comanda si ya se ha creado previamente.

     */

	public void nuevoPedido(String comanda) {
		idPedido++;			
		System.out.println("\nNUEVO PEDIDO\n----------------\n" + "ID de pedido: " + idPedido + ".\nPedido para: " + tipoPedido() + comanda + "\n");
	}
	
	
	
	/**

     * Método que crea una Lista de Array de objetos para poder juntar la cantidad de pizzas que quieres de un sabor. Recordemos que un objeto Menu lo entendemos
     * como una pizza y hay que sumarle la cantidad que queremos. Una vez complatado el ArrayList, lo convertimos a String para para que nos devuelva la comanda que pasamos al medido.
      
     * @param Menus menu			Este parametro es un objeto de la clase menú (Una pizza).
     * @param int numPizzas			Este parametro indica la cantidad de pizzas de un sabor que quiere el cliente.

     * @return Devuelve una comanda. Un String que contiene tanto la pizza, la masa, el tamaño, el sabor, la cantidad (int) y numero de bebidas que podría querer un cliente.

     */
	
	public String servicio(Menus menu, int numPizzas) {
		String cantidad, sabor, bebidas, masa, tamanio;

		ArrayList<Object> servicio = new ArrayList<Object>();
			servicio.add(numPizzas);
			servicio.add(menu.getSaborPizza());
			servicio.add(menu.getTamanioPizza());
			servicio.add(menu.getTipoMasa());
			servicio.add(menu.getNumeroDeBebidas());
					
			cantidad = "'" + (servicio.get(0) + "' pizza de");
			sabor = ("sabor nº: '" + servicio.get(1) + "'.");
			tamanio = ("Tamaño: '" + servicio.get(2) + "' y");
			masa = ("masa: '" + servicio.get(3) + "'.");
			bebidas =("Para beber: '" + servicio.get(4) + "' bebidas.");
			comanda = ("\n- " + cantidad + " " + sabor + " " + tamanio + " " + masa + " " + bebidas);
		
		return comanda;
	}
	

	
	/**

     * Método para saber qué tipo de pedido quiere el cliente. Esto es si va a ser un pedido para llevar o no. Para averiguar esto una un condicional que usa una variable tipoPedido pero el valor por defecto es "Restaurante"
     *  Si el valor es 1 Se asigna domicilio.
      
     * @param int tipoPedido			Variable tipo int que, según el condicional. 

     * @return Devuelve un String que usa la variable tipoPedido para saber, con un if, si es "Domicilio" o "Restaurante".

     */
	
	public String tipoPedido() {

		if (this.tipoPedido == 1) {
			return "Domicilio";
		}
		return "Restaurante";

	}


	
	
	

// ------------------------------------------------------------------ MÉTODOS OVERRIDE
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	


	@Override
	public String toString() {
		return "Pedidos [idPedido=" + idPedido + ", numPizzas=" + numPizzas + ", menu=" + menu + ", tipoPedido="
				+ tipoPedido + "]";
	}



	

}
