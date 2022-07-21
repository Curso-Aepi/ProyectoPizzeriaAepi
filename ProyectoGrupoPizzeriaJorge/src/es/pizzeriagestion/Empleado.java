package es.pizzeriagestion;

import es.pizzeriainterfaz.ICalcular;
import es.pizzeriainterfaz.ICambioTurno;

/**
 * Esta clase contiene los atributos y m�todos de un empleado
 * @author Jorge Perdomo
 * @version 1.0
 * @see ICalcular, Pizzeria.
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
		 * M�todo constructor en la clase hija parametrizado. Dado que no necesitamos los par�metros de la clase padre
		 * en los m�todos de clase, llamamos al constructor por defecto de la clase padre.
		 * @param turno, turno del empleado (Comida/Cena). El c�digo revisa que el turno que introducimos sea "Comida" o "Cena".
		 * o lanza un error personalizado informando de los par�metros correctos.
		 * @param sueldo, Sueldo del empleado por hora trabajada.
		 * @param puesto, Cargo en la empresa
		 * @param nombreEmpleado, Nombre del empleado
		 * @param login, HashMap con datos para el Login
		 * @param id, Identificador �nico del empleado.
		 * @param contrasenia, Contrase�a que se le asigna al empleado. El c�digo revisa que la contrase�a introducida tenga al
		 * menos 8 caracteres y un d�gito o lanza un error personalizado informando de los par�metros necesarios.
		 */
		public Empleado(String turno, double sueldo, String puesto, String nombreEmpleado, String id, String contrasenia) {
			super();
			try {
				if (turno.equalsIgnoreCase("Comida")|| turno.equalsIgnoreCase("Cena") ) {
					this.turno = turno;
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("El turno ha de ser 'Comida' o 'Cena'.");
			}
			this.sueldo = sueldo;
			try {
				if (puesto.equalsIgnoreCase("Manager")|| puesto.equalsIgnoreCase("Administrativo")||puesto.equalsIgnoreCase("Cocinero")||
						puesto.equalsIgnoreCase("Repartidor")||puesto.equalsIgnoreCase("Camarero")) {
					this.puesto = puesto;
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("El puesto ha de ser 'Manager', 'Administrativo', 'Cocinero', 'Repartidor' o 'Camarero'");
			}
			this.nombreEmpleado = nombreEmpleado;
			this.id = id;
			try {
				if (contrasenia.length()>= 8) {
					for (char c : contrasenia.toCharArray()) {
						if (Character.isDigit(c)) {
							this.contrasenia = contrasenia;
						}
					}
				} else {
					throw new Exception();
				}
			}catch (Exception ex) {
				System.out.println("La contrase�a debe tener un m�nimo de ocho caracteres y al menos un n�mero.");
			}	
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
			try {
				if (turno.equalsIgnoreCase("Comida")|| turno.equalsIgnoreCase("Cena") ) {
					this.turno = turno;
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("El turno ha de ser 'Comida' o 'Cena'.");
			}
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


		/**
		 * M�todo que retorna la contrase�a del empleado 
		 * @return Retorna la contrase�a del empleado
		 */
		
		public String getContrasenia() {
			return contrasenia;
		}
		
		/**
		 * M�todo que establece la contrase�a del empleado
		 * @param contrasenia, Contrase�a que se le asignar� al empleado. 
		 * 
		 * El m�todo comprueba primero que la longitud de la contrase�a
		 * sea de un m�nimo de 8 caracteres y despu�s que contenga al menos un d�gito. Para ello conviete el String contrase�a en un
		 * array de chars y revisa uno por uno con un bucle for mejorado que al menos uno de los caracteres sea un d�gito, de ser as�
		 * valida la contrase�a y se cambia, enviando mensaje de confirmaci�n. Si alguna de las condiciones no se cumple, informa
		 * por consola de los par�metros que debe cumplir la contrase�a para ser aceptada.
		 */
		
		public void setContrasenia(String contrasenia) {
			try {
				if (contrasenia.length()>= 8) {
					for (char c : contrasenia.toCharArray()) {
						if (Character.isDigit(c)) {
							this.contrasenia = contrasenia;
						}
					}
				} else {
					throw new Exception();
				}
			}catch (Exception ex) {
				System.out.println("La contrase�a debe tener un m�nimo de ocho caracteres y al menos un n�mero.");
			}
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
			return "Empleado [turno=" + turno + ", sueldo=" + sueldo + ", puesto=" + puesto + ", nombreEmpleado="
					+ nombreEmpleado + ", id=" + id + ", contrase�a=" + contrasenia + "]";
		}
		
		// M�todos de Clase:
		
		/**
		 * M�todo que calcula el sueldo por hora de las horas extra del empleado.
		 * En este caso se abonan a 1,5 veces el sueldo por hora normal.
		 * En el main solicitaremos las horas extra para multiplicarlas por el valor de retorno del m�todo.
		 * @return sueldoHoraExtra, el valor al que se abonan las horas extra.
		 */
		@Override
		
		// Sacar Scanner, debe ir en m�todo main !!!!
		public double calcular() {
			double sueldoHoraExtra = (sueldo*1.5);
			return sueldoHoraExtra;	
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

		/**
		 * M�todo para revisar el login. Toma como argumentos dos String id y contrase�a y los compara con las variables de clase.
		 * Si coinciden informa de que se concede el acceso al programa, en caso contrario lanza error personalizado.
		 * @param id, toma como argumento el id del empleado
		 * @param contrasenia, toma como argumento la contrase�a del empleado
		 */
		public void login(String id, String contrasenia) {
			try {
				if (id.equalsIgnoreCase(this.id)) {
					if (contrasenia.equalsIgnoreCase(this.contrasenia)) {
						System.out.println("Acceso correcto.");	
					} else {
						throw new Exception();
					}
				}
			} catch (Exception loginIncorrecto) {
				System.out.println("Los datos de acceso no son correctos.");
			}
			
		}
	}
