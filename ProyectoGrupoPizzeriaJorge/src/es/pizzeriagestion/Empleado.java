package es.pizzeriagestion;

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
		private String contrasenia;
		
		
		/**
		 *  Metodo constructor por defecto
		 */
		
		public Empleado() {
			super();
		}
		
		
		/**
		 * Método constructor parametrizado
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
		 * @param contrasenia, Contraseña que se le asigna al empleado.
		 */
		public Empleado(String nombre, String numeroDeTelefono, String horario, String direccion, int numeroDeEmpleados, 
				String turno, double sueldo, String puesto, String nombreEmpleado, String id, String contrasenia) {
			super(nombre, numeroDeTelefono, horario, direccion, numeroDeEmpleados);
			this.turno = turno;
			this.sueldo = sueldo;
			this.puesto = puesto;
			this.nombreEmpleado = nombreEmpleado;
			this.id = id;
			this.contrasenia = contrasenia;
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
		
		public String getContrasenia() {
			return contrasenia;
		}
		
		/**
		 * Método que establece la contraseña del empleado
		 * @param contrasenia, Contraseña que se le asignará al empleado. 
		 * 
		 * El método comprueba primero que la longitud de la contraseña
		 * sea de un mínimo de 8 caracteres y después que contenga al menos un dígito. Para ello conviete el String contraseña en un
		 * array de chars y revisa uno por uno con un bucle for mejorado que al menos uno de los caracteres sea un dígito, de ser así
		 * valida la contraseña y se cambia, enviando mensaje de confirmación. Si alguna de las condiciones no se cumple, informa
		 * por consola de los parámetros que debe cumplir la contraseña para ser aceptada.
		 */
		
		public void setContrasenia(String contrasenia) {
			boolean contraseniaCorrecta = false;
			if (contrasenia.length()> 8) {
				for (char c : contrasenia.toCharArray()) {
					if (Character.isDigit(c)) {
						contraseniaCorrecta = true;
					}
				}
			}
			if (contraseniaCorrecta) {
				this.contrasenia = contrasenia;
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
					+ nombreEmpleado + ", id=" + id + ", contraseña=" + contrasenia + "]";
		}
		
		// Métodos de Clase:
		
		/**
		 * Método que calcula el sueldo por hora de las horas extra del empleado.
		 * En este caso se abonan a 1,5 veces el sueldo por hora normal.
		 * En el main solicitaremos las horas extra para multiplicarlas por el valor de retorno del método.
		 * @return sueldoHoraExtra, el valor al que se abonan las horas extra.
		 */
		@Override
		
		// Sacar Scanner, debe ir en método main !!!!
		public double calcular() {
			double sueldoHoraExtra = (sueldo*1.5);
			return sueldoHoraExtra;	
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

		/**
		 * Método para revisar el login. Toma como argumentos dos String id y contraseña y los compara con las variables de clase.
		 * @param id, toma como argumento el id del empleado
		 * @param contrasenia, toma como argumento la contraseña del empleado
		 * @return loginEstado, retorna true si id y contraseña que metemos como argumento coinciden con las de empleado,
		 * de otra forma retorna false.
		 */
		public boolean login(String id, String contrasenia) {
			boolean loginEstado = false;
			if (id.equalsIgnoreCase(this.id)) {
				if (contrasenia.equalsIgnoreCase(this.contrasenia)) {
					loginEstado = true;
				}
			}
			return loginEstado;
		}
	}

