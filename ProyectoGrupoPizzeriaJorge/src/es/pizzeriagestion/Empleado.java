package es.pizzeriagestion;

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

		
		private String turno; 
		private double sueldo;
		private String puesto;
		private String nombreEmpleado;
		private String id;
		private String contraseña;
		
		
		/**
		 *  Metodo constructor por defecto
		 */
		
		public Empleado() {
			super();
		}
		
		
		/**
		 * Método constructor parametrizado
		 * Pasamos los datos de la pizzería como valores default ya que no cambian para esta ubicación, en este caso:
		 * @param nombre, nombre de la pizzeria.
		 * @param numeroDeTelefono, Número de Teléfono de la pizzería.
		 * @param horario, Horario de apertura de la pizzería.
		 * @param dirección, Dirección de la pizzería.
		 * @param numeroDeEmpleados, Número de empleados de la pizzería.
		 * @param turno, turno del empleado (Comida/Cena)
		 * @param sueldo, Sueldo del empleado por hora trabajada.
		 * @param puesto, Cargo en la empresa
		 * @param nombreEmpleado, Nombre del empleado
		 * @param login, HashMap con datos para el Login
		 * @param id, Identificador único del empleado.
		 */
		public Empleado(String nombre, String numeroDeTelefono, String horario, String direccion, int numeroDeEmpleados, 
				String turno, double sueldo, String puesto, String nombreEmpleado, String id, String contraseña) {
			super("Pizzería Aepi","910000000", "12:00 - 23:00", "Calle Grande Nº 1", numeroDeEmpleados);
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
			if (turno.equalsIgnoreCase("Comida")|| turno.equalsIgnoreCase("Cena") ) {
				this.turno = turno;
				System.out.println("Turno asignado correctamente a "+this.turno);
			}
			else {
				System.out.println("El turno ha de ser 'Comida' o 'Cena'.");
			}
			
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


		/**
		 * Método que retorna la contraseña del empleado 
		 * @return Retorna la contraseña del empleado
		 */
		
		public String getContraseña() {
			return contraseña;
		}
		
		/**
		 * Método que establece la contraseña del empleado
		 * @param contraseña, Contraseña que se le asignará al empleado. 
		 * 
		 * El método comprueba primero que la longitud de la contraseña
		 * sea de un mínimo de 8 caracteres y después que contenga al menos un dígito. Para ello conviete el String contraseña en un
		 * array de chars y revisa uno por uno con un bucle for mejorado que al menos uno de los caracteres sea un dígito, de ser así
		 * valida la contraseña y se cambia, enviando mensaje de confirmación. Si alguna de las condiciones no se cumple, informa
		 * por consola de los parámetros que debe cumplir la contraseña para ser aceptada.
		 */
		
		public void setContraseña(String contraseña) {
			boolean contraseñaCorrecta = false;
			if (contraseña.length()> 8) {
				for (char c : contraseña.toCharArray()) {
					if (Character.isDigit(c)) {
						contraseñaCorrecta = true;
					}
				}
			}
			if (contraseñaCorrecta) {
				this.contraseña = contraseña;
				System.out.println("Se ha cambiado la contraseña correctamente.");
			}
			else {
				System.out.println("La contraseña debe tener un mínimo de ocho caracteres y al menos un número.");
			}
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
			return "Empleado [turno=" + turno + ", sueldo=" + sueldo + ", puesto=" + puesto + ", nombreEmpleado="
					+ nombreEmpleado + ", id=" + id + ", contraseña=" + contraseña + "]";
		}
		
		// Métodos de Clase:
		
		/**
		 * Método que calcula el sueldo final del empleado teniendo en cuenta las horas extra 
		 * realizadas, que se abonan con un valor de 1,5 veces el sueldo por hora normal. 
		 * Sobreescribe al método calcular de la Interfaz ICalcular.
		 * 
		 */
		@Override
		
		// Sacar Scanner, debe ir en método main !!!!
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
