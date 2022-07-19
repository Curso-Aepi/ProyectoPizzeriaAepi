package es.pizzeriagestion;

import java.util.Map;
import java.util.Scanner;

import es.pizzeriainterfaz.ICalcular;
import es.pizzeriainterfaz.ICambioTurno;

/**
 * Esta clase contiene los atributos y m�todos de un empleado
 * @author Jorge Perdomo
 * @version 1.0
 * @see ICalcular
 */
public class Empleado extends Pizzeria implements ICalcular, ICambioTurno{

		// Variables de Clase, he preparado un HashMap para el login del empleado donde el primer String es el Id
		// y el segundo la Contrase�a.
		private String turno; // Try/catch
		private double sueldo;
		private String puesto;
		private String nombreEmpleado;
		//private Map<String, String> login;
		private String id;
		private String contrase�a;
		// A�adir try/catch en contrase�a para revisar parametros.
		
		/**
		 *  Metodo constructor por defecto
		 */
		
		public Empleado() {
			super();
		}
		
		-----
		/**
		 * M�todo constructor parametrizado
		 * @param turno, turno del empleado (Comida/Cena)
		 * @param sueldo, Sueldo del empleado por hora trabajada.
		 * @param puesto, Cargo en la empresa
		 * @param nombreEmpleado, Nombre del empleado
		 * @param login, HashMap con datos para el Login
		 * @param id, Identificador �nico del empleado.
		 */
		public Empleado(String nombre, String numeroDeTelefono, String horario, String direccion, int numeroDeEmpleados, 
				String turno, double sueldo, String puesto, String nombreEmpleado, String id, String contrase�a) {
			super(nombre,numeroDeTelefono, horario, direccion, numeroDeEmpleados);
			this.turno = turno;
			this.sueldo = sueldo;
			this.puesto = puesto;
			this.nombreEmpleado = nombreEmpleado;
			this.id = id;
			this.contrase�a = contrase�a;
		}
		
		// Getters/ Setters:
		/**
		 * M�todo que retorna el turno del empleado
		 * @return Retorna el turno del empleado
		 */
		public String getTurno() {
			return turno;
		}

		/**
		 * M�todo que establece el turno del empleado
		 * @param turno, turno que se le asignar� al empleado
		 */
		public void setTurno(String turno) {
			this.turno = turno;
		}

		/**
		 * M�todo que retorna el turno del empleado
		 * @return Retorna el turno del empleado
		 */
		public double getSueldo() {
			return sueldo;
		}

		/**
		 * M�todo que establece el sueldo del empleado
		 * @param sueldo, sueldo que se le asignar� al empleado
		 */
		public void setSueldo(double sueldo) {
			this.sueldo = sueldo;
		}

		/**
		 * M�todo que retorna el cargo del empleado en la empresa
		 * @return Retorna el puesto del empleado
		 */
		public String getPuesto() {
			return puesto;
		}

		/**
		 * M�todo que establece el puesto del empleado
		 * @param puesto, puesto que se le asignar� al empleado
		 */
		public void setPuesto(String puesto) {
			this.puesto = puesto;
		}

		/**
		 * M�todo que retorna el Nombre del empleado 
		 * @return Retorna el nombre del empleado
		 */
		public String getNombreEmpleado() {
			return nombreEmpleado;
		}

		/**
		 * M�todo que establece el nombre del empleado
		 * @param nombreDeEmpleado, Nombre que se le asignar� al empleado
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
		 * M�todo que retorna el id del empleado
		 * @return id, identificador �nico del empleado.
		 */
		public String getId() {
			return id;
		}

		/**
		 * M�todo que establece el id �nico del empleado
		 * @param id, id que se le asignar� al empleado
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * M�todo toString(), retorna las variables de clase del empleado como cadena de caracteres.
		 */
		
		@Override
		public String toString() {
			return "Empleado [turno=" + turno + ", sueldo=" + sueldo + ", puesto=" + puesto + ", nombre=" + nombreEmpleado
					+ ", login=" + login + "]";
		}
		
		// M�todos de Clase:
		
		/**
		 * M�todo que calcula el sueldo final del empleado teniendo en cuenta las horas extra 
		 * realizadas, que se abonan con un valor de 1,5 veces el sueldo por hora normal. 
		 * Sobreescribe al m�todo calcular de la Interfaz ICalcular.
		 * 
		 */
		@Override
		public double calcular() {
			Scanner lector = new Scanner(System.in);
			System.out.println("Introduzca el n�mero de horas extra del empleado: ");
			int horaExtra = lector.nextInt();
			double sueldoDiaFinal = (sueldo)+(sueldo*horaExtra*1.5);
			lector.close();
			return sueldoDiaFinal;	
		}
		
		
		
		/**
		 * M�todo que revisa el turno del empleado y lo cambia.
		 * Sobreescribe al m�todo calcular de la Interfaz ICambioTurno.
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
