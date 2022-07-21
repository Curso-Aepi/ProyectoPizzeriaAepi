package es.pizzeriagestion;
/**
 * 
 * @author Nicolás Teso
 *
 */
public class Inventario {

	private int bebidas, masas, menaje;
	private boolean aseo, limpieza;
/**
 * Creamos las variables de la clase Inventario	
 */
	public Inventario() {
		super();
	}
/**
 * 
 * @param bebidas
 * @param masas
 * @param menaje
 * @param aseo
 * @param limpieza
 */
	public Inventario(int bebidas, int masas, int menaje, boolean aseo, boolean limpieza) {
		super();
		this.bebidas = bebidas;
		this.masas = masas;
		this.menaje = menaje;
		this.aseo = aseo;
		this.limpieza = limpieza;
	}
/**
 * Creamos los getter y setter de la clase.
 * @return
 */
	public int getBebidas() {
		return bebidas;
	}

	public void setBebidas(int bebidas) {
		this.bebidas = bebidas;
	}

	public int getMasas() {
		return masas;
	}

	public void setMasas(int masas) {
		this.masas = masas;
	}

	public int getMenaje() {
		return menaje;
	}

	public void setMenaje(int menaje) {
		this.menaje = menaje;
	}

	public boolean isAseo() {
		return aseo;
	}

	public void setAseo(boolean aseo) {
		this.aseo = aseo;
	}

	public boolean isLimpieza() {
		return limpieza;
	}

	public void setLimpieza(boolean limpieza) {
		this.limpieza = limpieza;
	}
/***
 * Creamos el constructor ToString.
 */
	@Override
	public String toString() {
		return "Inventario [bebidas=" + bebidas + ", masas=" + masas + ", menaje=" + menaje + ", aseo=" + aseo
				+ ", limpieza=" + limpieza + "]";
	}
/**
 * Creamos el método "reponer" que indica si hay suficiente o no productos en el almacén.	
 */
	public void reponer() {
		int bebida = 0;
		if (bebida >= 25) {
			System.out.println("Hay suficiente bebida.");
		} else if  (bebida < 10){
			System.out.println("Es necesario reponer la bebida.");
		}
		int masaPequeña = 0;
		if (masaPequeña >= 25) {
			System.out.println("Hay suficiente masa pequeña.");
		} else if (masaPequeña < 10) {
			System.out.println("Es necesario reponer la masa pequeña");
		}
		int masaMediana = 0;
		if (masaMediana >= 25) {
			System.out.println("Hay suficiente masa mediana.");
		} else if (masaPequeña < 10) {
			System.out.println("Es necesario reponer la masa mediana.");
		}
	
		int masaFamiliar = 0;
		if (masaFamiliar >= 25) {
			System.out.println("Hay suficiente masa familiar.");
		} else if (masaPequeña < 10) {
			System.out.println("Es necesario reponer la masa familiar.");
		}
		
		int masaSinGluten = 0;
		if (masaSinGluten >= 25) {
			System.out.println("Hay suficiente masa Sin Gluten.");
		} else if (masaSinGluten < 10) {
			System.out.println("Es necesario reponer la masa Sin Gluten");
	}
	}
/**
 * El método almacén nos imprime por pantalla las existencias del almacén.	
 */
	public void almacen() {
		System.out.println("Las bibidas son: " + bebidas + " Las masas son " + masas);
		
	}
/**
 * Creamos un método "modAlmacen" que nos permite modificar (introducir o extraer productos).	
 */
	public void modAlmacen() {
		// añadir y quitar llamando a getter y setter.
		int numBebidas = 0;
		numBebidas = getBebidas();
		if (numBebidas < 25) {
			System.out.println(getBebidas());
		}
		int numMasa = 0;
		numMasa = getMasas();
		if (numMasa < 25) {
			System.out.println(getMasas());
		}
		int numMenaje = 0;
		numMenaje = getMenaje();
		if (numMenaje < 25) {
			System.out.println(getMenaje());
		}
		
	}
}

