package es.pizzeriagestion;

import es.pizzeriainterfaz.ICalcular;

/**
 * Esta clase contiene los atributos y métodos del departamento de contabilidad.
 * @author Jorge Perdomo
 * @version 1.0
 * @see ICalcular
 *
 */
public class Contabilidad extends Pizzeria implements ICalcular{
		
	
	/**
	 * Variables de clase:
	 * @param ingresos, los ingresos diarios de la pizzeria.
	 * @param gastos, los gastos diarios de la pizzeria.
	 * @param propinas, la cantidad de propinas recibidas en el día.
	 * @param numeroDeEmpleados, El número de empleados de la empresa.
	 */
	private double ingresos;
	private double gastos;
	private double propinas;
	private int numeroDeEmpleados;
	
	
	/**
	 * Método constructor por defecto
	 */
	public Contabilidad() {
		super();
	}
	
	/**
	 * Método constructor parametrizado
	 * @param ingresos
	 * @param gastos
	 * @param propinas
	 * @param numeroEmpleados
	 */
	public Contabilidad(double ingresos, double gastos, double propinas, int numeroEmpleados) {
		super();
		this.ingresos = ingresos;
		this.gastos = gastos;
		this.propinas = propinas;
		this.numeroDeEmpleados = numeroEmpleados;
	}

	
	
	/**
	 * Método que retorna los ingresos diarios.
	 * @return Retorna los ingresos diarios
	 */
	public double getIngresos() {
		return ingresos;
	}
	
	/**
	 * Método que establece los ingresos diarios
	 * @param ingresos, ingresos diarios de la pizzería.
	 */
	public void setIngresos(double ingresos) {
		this.ingresos = ingresos;
	}
	
	/**
	 * Método que retorna los gastos diarios.
	 * @return Retorna los gastos diarios
	 */
	public double getGastos() {
		return gastos;
	}
	
	/**
	 * Método que establece los gastos diarios
	 * @param gastos, gastos diarios de la pizzería.
	 */
	public void setGastos(double gastos) {
		this.gastos = gastos;
	}
	
	/**
	 * Método que retorna las propinas diarias.
	 * @return Retorna las propinas diarias
	 */
	public double getPropinas() {
		return propinas;
	}

	/**
	 * Método que establece las propinas diarias recibidas.
	 * @param propinas, propinas diarias de la pizzería.
	 */
	public void setPropinas(double propinas) {
		this.propinas = propinas;
	}
	
	/**
	 * Método que retorna el número de empleados.
	 * @return Retorna el número de empleados.
	 */
	public int getNumeroEmpleados() {
		return numeroDeEmpleados;
	}

	/**
	 * Método que establece el número de empleados
	 * @param numeroDeEmpleados, número de empleados de la empresa un día dado.
	 */
	public void setNumeroEmpleados(int numeroEmpleados) {
		this.numeroDeEmpleados = numeroEmpleados;
	}

	
	/**
	 * Método que devuelve las variables de clase de un objeto como cadena de caracteres.
	 */
	
	@Override
	public String toString() {
		return "Contabilidad [ingresos=" + ingresos + ", gastos=" + gastos + ", propinas=" + propinas
				+ ", numeroEmpleados=" + numeroDeEmpleados + "]";
	}
	
	// Métodos de clase:
	
	/**
	 *  Método implementado por la interfaz ICalcular, en esta clase Contabilidad hace el cálculo de la caja diaria:
	 * 
	 */
	@Override
	public double calcular() {
		double cajaDiaria = ingresos+propinas;	
		return cajaDiaria;
	}
	
	/**
	 *  Método Beneficios, calcula el beneficio diario en funcion de los ingresos, las propinas y los gastos:
	 * @return beneficioDia, Cantidad de beneficios generados en el día.
	 */
	
	public double beneficio() {
		double beneficioDia = 0;
		beneficioDia = (this.ingresos+this.propinas-this.gastos);
		return beneficioDia;
	}

	
	
	
}
