package es.pizzeriagestion;

import es.pizzeriainterfaz.ICalcular;

/**
 * Esta clase contiene los atributos y m�todos del departamento de contabilidad.
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
	 * @param propinas, la cantidad de propinas recibidas en el d�a.
	 * @param numeroDeEmpleados, El n�mero de empleados de la empresa.
	 */
	private double ingresos;
	private double gastos;
	private double propinas;
	private int numeroDeEmpleados;
	
	
	/**
	 * M�todo constructor por defecto
	 */
	public Contabilidad() {
		super();
	}
	
	/**
	 * M�todo constructor parametrizado
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
	 * M�todo que retorna los ingresos diarios.
	 * @return Retorna los ingresos diarios
	 */
	public double getIngresos() {
		return ingresos;
	}
	
	/**
	 * M�todo que establece los ingresos diarios
	 * @param ingresos, ingresos diarios de la pizzer�a.
	 */
	public void setIngresos(double ingresos) {
		this.ingresos = ingresos;
	}
	
	/**
	 * M�todo que retorna los gastos diarios.
	 * @return Retorna los gastos diarios
	 */
	public double getGastos() {
		return gastos;
	}
	
	/**
	 * M�todo que establece los gastos diarios
	 * @param gastos, gastos diarios de la pizzer�a.
	 */
	public void setGastos(double gastos) {
		this.gastos = gastos;
	}
	
	/**
	 * M�todo que retorna las propinas diarias.
	 * @return Retorna las propinas diarias
	 */
	public double getPropinas() {
		return propinas;
	}

	/**
	 * M�todo que establece las propinas diarias recibidas.
	 * @param propinas, propinas diarias de la pizzer�a.
	 */
	public void setPropinas(double propinas) {
		this.propinas = propinas;
	}
	
	/**
	 * M�todo que retorna el n�mero de empleados.
	 * @return Retorna el n�mero de empleados.
	 */
	public int getNumeroEmpleados() {
		return numeroDeEmpleados;
	}

	/**
	 * M�todo que establece el n�mero de empleados
	 * @param numeroDeEmpleados, n�mero de empleados de la empresa un d�a dado.
	 */
	public void setNumeroEmpleados(int numeroEmpleados) {
		this.numeroDeEmpleados = numeroEmpleados;
	}

	
	/**
	 * M�todo que devuelve las variables de clase de un objeto como cadena de caracteres.
	 */
	
	@Override
	public String toString() {
		return "Contabilidad [ingresos=" + ingresos + ", gastos=" + gastos + ", propinas=" + propinas
				+ ", numeroEmpleados=" + numeroDeEmpleados + "]";
	}
	
	// M�todos de clase:
	
	/**
	 *  M�todo implementado por la interfaz ICalcular, en esta clase Contabilidad hace el c�lculo de la caja diaria:
	 * 
	 */
	@Override
	public double calcular() {
		double cajaDiaria = ingresos+propinas;	
		return cajaDiaria;
	}
	
	/**
	 *  M�todo Beneficios, calcula el beneficio diario en funcion de los ingresos, las propinas y los gastos:
	 * @return beneficioDia, Cantidad de beneficios generados en el d�a.
	 */
	
	public double beneficio() {
		double beneficioDia = 0;
		beneficioDia = (this.ingresos+this.propinas-this.gastos);
		return beneficioDia;
	}

	
	
	
}
