package es.pizzeriagestion;

import es.pizzeriainterfaz.ICambioTurno;

/**

 * Esta clase nos ayuda a saber los cocineros que hay actualmente en la cocina y tarer mas cocineros o retirarlos dependiendo de la situación.
 * 
 * @author: Ricardo Murillo Fernández

 * @version: 22/07/2022/A

 */

public class Cocina implements ICambioTurno {
	
// ------------------------------------------------------------------ VARIABLES
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	/**
	 * @param cocinero			Cocineros trabajando actualmente en cocina.
	 * @param mesa				Puedes ver la mesa donde esta un pedido.
	 * @param pedido			Variable de clase Pedido.
	 * @param turno				Turno de cocinas (Mañana o tarde).
	 */
	
	private int cocinero;
	
	private Pedido pedido;
	
	private int mesa;
	
	String turno;

	
	
	
	// ------------------------------------------------------------------ CONSTRUCTORES
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////



public Cocina() {

}

public Cocina(int cocinero, Pedido pedido, int comanda, String turno) {
		super();
		this.cocinero = cocinero;
		this.pedido = pedido;
		this.mesa = comanda;
		this.turno = turno;
	}




//------------------------------------------------------------------ MÉTODOS GET/SET
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	

public int getCocinero() {
	return cocinero;
}

public void setCocinero(int cocinero) {
	this.cocinero = cocinero;
}

public Pedido getPedido() {
	return pedido;
}

public void setPedido(Pedido pedido) {
	this.pedido = pedido;
}

public int getMesa() {
	return mesa;
}

public void setMesa(int mesa) {
	this.mesa = mesa;
}

public String getTurno() {
	return turno;
}

public void setTurno(String turno) {
	this.turno = turno;
}





//------------------------------------------------------------------ MÉTODOS PROPIOS
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////



/**

* Método que suma un cocinero en la cocina cuando haga falta.

* @param int cocinero			contiene la cantidad de cocineros que estan este momento en la cocina.

* @return Saca un aviso en consola y los cocineros actuales que hay en la cocina.

*/
	
public void aniadirCocinero() {
		cocinero++;
		System.out.println("\nUn nuevo cocinero viene en camino. Recuerda que ya sois: " + cocinero + " cocineros.\n");	
}




/**

* Método que retira un cocinero de la cocina cuando haga falta.

* @param int cocinero			contiene la cantidad de cocineros que estan este momento en la cocina.

* @return Saca un aviso en consola y los cocineros actuales que hay en la cocina. Si no hay concineros en el momento de querer retirar uno, no te lo permite y te da un aviso por consola.

*/

public void quitarCocinero() {
	if(cocinero > 0) {
		cocinero--;
		System.out.println("\nHemos retirado un cocinero. Recuerda que ya sois: " + cocinero + " cocineros.\n");
	}else if(cocinero == 0){
		System.out.println("\nLo siento pero tienes " +  cocinero + " y, lógicamente no podemos quitar más.\n");
	}
}



@Override

	public void cambioTurno() {
		if (turno == "Comida" && pedido.getIdPedido() > 15) {
			this.setTurno("Cena");
		}
		else if (turno == "Cena" && pedido.getIdPedido() < 10) {
			this.setTurno("Comida");
		}
	}
	
	


	

}
