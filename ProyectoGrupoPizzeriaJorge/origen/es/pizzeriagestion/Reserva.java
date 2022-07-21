package es.pizzeriagestion;
/**
 * 
 * @author Nicolás Teso
 *
 */
public class Reserva {
/**
 * Creamos las variables de la clase Reserva
 */
	private int reserva;
	private boolean ninios, alergenos;
/**
 * Constructor por defecto
 */
	public Reserva() {
		super();
	}
/**
 * 
 * @param reserva
 * @param ninios
 * @param alergenos
 */
	public Reserva(int reserva, boolean ninios, boolean alergenos) {
		super();
		this.reserva = reserva;
		this.ninios = ninios;
		this.alergenos = alergenos;
	}
/**
 * Creamos los getter y setter de nustra clase
 * @return
 */
	public int getReserva() {
		return reserva;
	}


	public void setReserva(int reserva) {
		this.reserva = reserva;
	}


	public boolean isNiños() {
		return ninios;
	}


	public void setNiños(boolean ninios) {
		this.ninios = ninios;
	}


	public boolean isAlergenos() {
		return alergenos;
	}


	public void setAlergenos(boolean alergenos) {
		this.alergenos = alergenos;
	}
/**
 * Constructor ToString
 */
	@Override
	public String toString() {
		return "Reserva [reserva=" + reserva + ", niños=" + ninios + ", alergenos=" + alergenos + "]";
	}
/**
 * Creamos el método nuevaReserva que nos permite añadir una reserva.
 */
	public void nuevaReserva() {
		int i = 0;
		System.out.println("Se ha añadido una reserva " + i++);
	}
/**
 * Creamos el método quitarReserva que nos permite eliminar una reserva.
 */
	public void quitarReserva() {
		int i = 0;
		System.out.println("Se ha eliminado una reserva " + i--);
	}
/**
 * Creamos el método modReserva que nos permite modificar la reserva añadiendo o quitando personas.
 */
	public void modReserva() {
		int personas = 0;
		if (personas > 0) {
			System.out.println("Añadir persona a la reserva" + personas++);
		}else if (personas < 0){
			System.out.println("Eliminar persona de la reserva" + personas--);
		}else {
			System.out.println("La reserva no se ha modificado.");
		}
	}
/**
 * Creamos el método ninios que nos permite indicar la presencia o ausencia de niños en la reserva.	
 */
	public void ninios() {
		int i = 0;
		if (i > 0) {
			ninios = true;
		}else {
			ninios = false;
			}
	}
/**
 * Creamos el método alergenos que nos indica la presencia o ausencia de alergenos en la reserva.
 */
	public void alergenos() {
		int j = 0;
		if (j > 0){			
			alergenos = true;
		} else {
			alergenos = false;
		}
		
	}
}
