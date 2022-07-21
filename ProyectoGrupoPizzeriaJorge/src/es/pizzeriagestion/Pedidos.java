package es.pizzeria.gestion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import es.pizzariainterfaz.ICalcularTotal;



/**
 * @author ricardomurillo
 *
 *
 * VARIABLES
 * 
 * @param PLUS_ENVIO		Dinero extra cuando el envío es a domicilio.
 * @param idPedido			ID de cada uno de los pedidos.
 * @param numPizzas			Número de pizzas del mismo sabor que tiene un pedido.
 * @param tipoPedido		Pedido a domicilio o en restaurante.
 * 
 * 
 * MÉTODO nuevoPedido()
 * 
 * @param menu				Recoge los valores Masa, Tamaño y sabor.
 * @param numPizzas			Recoge el número de pizzas que lleva cada menu.
 * @param <plato>			Lista de arrays de Objetos para unir el menu con el numero de pizzas y el id del pedido.
 * @return					Lista de objetos con el contenido de un pedido.
 * 
 * 
 * MÉTODO tipoPedido()
 * 
 * @param nuevoPedido()		Devuelve Domicilio si es igual a 1 o Restaurante si es igual 0. Por defecto devuelve Restaurante.
 * 
 */




public class Pedidos extends Pizzeria implements ICalcularTotal  {
	
	

// ------------------------------------------------------------------ VARIABLES
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	final static double PLUS_ENVIO = 3.95;

	private int idPedido, numPizzas;

	// Variable de tipo Menu para recoger la comanda.
	private Menu menu;

	// tipoPedido para saber si es en restaurante o a domicilio
	private int tipoPedido;

	
	
	

// ------------------------------------------------------------------ CONSTRUCTORES
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
	public Pedidos() {

	}

	public Pedidos(String nombre, int numeroDeTelefono, String horario, String direccion, int numeroDeEmpleados,
			int idPedido, int tipoPedido, int numPizzas, Menu menu) {
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

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
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

	
	
	public void nuevoPedido(Menu menu, int numPizzas) {
		idPedido++;
		int cantidad, sabor;
		String masa, tamanio;	
		
		ArrayList<Object> plato = new ArrayList<Object>();
			plato.add(numPizzas);
			plato.add(menu.getNumeroPizza());
			plato.add(menu.getTamanioPizza());
			plato.add(menu.getTipoMasa());
					
			cantidad = (int) plato.get(0);
			sabor = (int) plato.get(1);
			tamanio = (String) plato.get(2);
			masa = (String) plato.get(3);
			
		System.out.println("\nNUEVO PEDIDO\n----------------\n" + "ID de pedido: " + idPedido + "\nCantidad: " + cantidad + ".\nSabor nº: " + sabor
				+ ".\nTamaño: "+ tamanio + ".\nMasa: " + masa + ".\nPedido para: " + tipoPedido() + "\n");
	}
	

	public String tipoPedido() {

		if (this.tipoPedido == 1) {
			return "Domicilio";
		}
		return "Restaurante";

	}


	

// ------------------------------------------------------------------ MÉTODOS OVERRIDE
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	

	@Override
	public void calculoPrecioTotal() {
		if (this.tipoPedido == 1) {
			menu.precio += PLUS_ENVIO;
		}
	}

	@Override
	public String toString() {
		return "Pedidos [idPedido=" + idPedido + ", numPizzas=" + numPizzas + ", menu=" + menu + ", tipoPedido="
				+ tipoPedido + "]";
	}



	

}
