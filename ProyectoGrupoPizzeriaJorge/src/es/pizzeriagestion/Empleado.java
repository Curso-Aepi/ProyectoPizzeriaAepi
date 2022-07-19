package es.pizzeriagestion;

import java.util.Map;
import java.util.Scanner;

import es.pizzeriainterfaz.ICalcular;
import es.pizzeriainterfaz.ICambioTurno;

/**
 * Esta clase contiene los atributos y métodos de un empleado
 * @author Jorge Perdomo
 * @version 1.0
 * @see ICalcular
 */
public class Empleado extends Pizzeria implements ICalcular, ICambioTurno{

		// Variables de Clase, he preparado un HashMap para el login del empleado donde el primer String es el Id
		// y el segundo la Contraseña.
		private String turno; // Try/catch
		private double sueldo;
		private String puesto;
		private String nombreEmpleado;
		//private Map<String, String> login;
		private String id;
		private String contraseña;
		// Añadir try/catch en contraseña para revisar parametros.
		
		/**
		 *  Metodo constructor por defecto
		 */
		
		public Empleado() {
			super();
		}
		
		-----
		/**
		 * Método constructor parametrizado
		 * @param turno, turno del empleado (Comida/Cena)
		 * @param sueldo, Sueldo del empleado por hora trabajada.
		 * @param puesto, Cargo en la empresa
		 * @param nombreEmpleado, Nombre del empleado
		 * @param login, HashMap con datos para el Login
		 * @param id, Identificador único del empleado.
		 */
		public Empleado(String nombre, String numeroDeTelefono, String horario, String direccion, int numeroDeEmpleados, 
				String turno, double sueldo, String puesto, String nombreEmpleado, String id, String contraseña) {
			super(nombre,numeroDeTelefono, horario, direccion, numeroDeEmpleados);
			this.turno = turno;
			this.sueldo = sueldo;
			this.puesto = puesto;
			this.nombreEmpleado = nombreEmpleado;
			this.id = id;
			this.contraseña = contraseña;
		}
		
		// Getters/ Setters:
		/**
		 * Método que retorna el turno del empleado
		 * @return Retorna el turno del empleado
		 */
		public String getTurno() {
			return turno;
		}

		/**
		 * Método que establece el turno del empleado
		 * @param turno, turno que se le asignará al empleado
		 */
		public void setTurno(String turno) {
			this.turno = turno;
		}

		/**
		 * Método que retorna el turno del empleado
		 * @return Retorna el turno del empleado
		 */
		public double getSueldo() {
			return sueldo;
		}

		/**
		 * Método que establece el sueldo del empleado
		 * @param sueldo, sueldo que se le asignará al empleado
		 */
		public void setSueldo(double sueldo) {
			this.sueldo = sueldo;
		}

		/**
		 * Método que retorna el cargo del empleado en la empresa
		 * @return Retorna el puesto del empleado
		 */
		public String getPuesto() {
			return puesto;
		}

		/**
		 * Método que establece el puesto del empleado
		 * @param puesto, puesto que se le asignará al empleado
		 */
		public void setPuesto(String puesto) {
			this.puesto = puesto;
		}

		/**
		 * Método que retorna el Nombre del empleado 
		 * @return Retorna el nombre del empleado
		 */
		public String getNombreEmpleado() {
			return nombreEmpleado;
		}

		/**
		 * Método que establece el nombre del empleado
		 * @param nombreDeEmpleado, Nombre que se le asignará al empleado
		 */
		public void setNombreEmpleado(String nombreEmpleado) {
			this.nombreEmpleado = nombreEmpleado;
		}


		public Map<String, String> getLogin() {
			return login;
		}


		public void setLogin(Map<String, String> login) {
			this.login = login;
		}
		
		/**
		 * Método que retorna el id del empleado
		 * @return id, identificador único del empleado.
		 */
		public String getId() {
			return id;
		}

		/**
		 * Método que establece el id único del empleado
		 * @param id, id que se le asignará al empleado
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * Método toString(), retorna las variables de clase del empleado como cadena de caracteres.
		 */
		
		@Override
		public String toString() {
			return "Empleado [turno=" + turno + ", sueldo=" + sueldo + ", puesto=" + puesto + ", nombre=" + nombreEmpleado
					+ ", login=" + login + "]";
		}
		
		// Métodos de Clase:
		
		/**
		 * Método que calcula el sueldo final del empleado teniendo en cuenta las horas extra 
		 * realizadas, que se abonan con un valor de 1,5 veces el sueldo por hora normal. 
		 * Sobreescribe al método calcular de la Interfaz ICalcular.
		 * 
		 */
		@Override
		public double calcular() {
			Scanner lector = new Scanner(System.in);
			System.out.println("Introduzca el número de horas extra del empleado: ");
			int horaExtra = lector.nextInt();
			double sueldoDiaFinal = (sueldo)+(sueldo*horaExtra*1.5);
			lector.close();
			return sueldoDiaFinal;	
		}
		
		
		
		/**
		 * Método que revisa el turno del empleado y lo cambia.
		 * Sobreescribe al método calcular de la Interfaz ICambioTurno.
		 */
		@Override
		
		public void cambioTurno() {
			if (turno == "Comida") {
				this.setTurno("Cena");
			}
			else if (turno == "Cena") {
				this.setTurno("Comida");
			}
		}

		}
