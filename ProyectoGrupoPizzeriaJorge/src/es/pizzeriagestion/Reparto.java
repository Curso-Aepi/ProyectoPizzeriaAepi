package es.pizzeriagestion;

import es.pizzeriainterfaz.ICalcular;

/**
 * Clase hija Reparto, hereda de Pizzeria
 * 
 * Esta clase se encarga de gestionar los repartos a domicilio
 * 
 * @author Leticia Patón
 * @version 1.0
 *
 */

public class Reparto extends Pizzeria implements ICalcular {

	/**
	 * Variables de la clase Reparto
	 * 
	 * 
	 * @param tipoVehiculo.         Tipo de vehículo usado en el reparto
	 * @param distancia.            Distancia del domicilio en kilómetros
	 * @param precioGasolina.       Precio de la gasolina
	 * @param numeroDeRepartidores. Número de repartidores de la pizzería
	 *
	 */

	int tipoVehiculo;
	double distancia;
	double precioGasolina;
	int numeroDeRepartidores;

	public static final double CONSUMO_MOTO = 0.025;
	public static final double CONSUMO_COCHE = 0.05;
	public static final int TIEMPO_PREPARACION = 15;
	public static final int VELOCIDAD_POBLADO = 40;
	public static final int UNA_HORA = 60;

	/**
	 * Método constructor por defecto
	 */
	public Reparto() {
		super();

	}

	/**
	 * 
	 * Método constructor con argumentos
	 * 
	 * 
	 * @param numeroDeRepartidores Número de repartidores a domicilio
	 * @param tipoVehiculo         Tipo de vehículo usado para repartir (moto o
	 *                             coche)
	 * @param distancia            Distancia en kilómetros al lugar de entrega
	 *                             (máximo 20 kilómetros)
	 * @param precioGasolina       Precio de la gasolina
	 * @param estadoPedido         Estado del pedido (true para entregado, false
	 *                             para pendiente)
	 */
	public Reparto(int tipoVehiculo, double distancia, double precioGasolina, int numeroDeRepartidores) {
		super();

		this.tipoVehiculo = tipoVehiculo;
		this.distancia = distancia;
		this.precioGasolina = precioGasolina;
		this.numeroDeRepartidores = numeroDeRepartidores;

	}

	/**
	 * Devuelve el tipo de vehículo usado en el reparto
	 * 
	 * @return Devuelve el tipo de vehículo usado en el reparto
	 */
	public int getTipoVehiculo() {
		return tipoVehiculo;
	}

	/**
	 * Establece el vehículo usado para el reparto, sólo permite en moto o coche
	 * 
	 * @param tipoVehiculo
	 */
	public void setTipoVehiculo(int tipoVehiculo) {
		if (tipoVehiculo == 1 || tipoVehiculo == 2) {
			this.tipoVehiculo = tipoVehiculo;
		} else {
			System.out.println("Solo tenemos reparto en moto[1] y coche[2]. Revísalo");
		}

	}

	/**
	 * Devuelve la distancia en kilómetros del domicilio que hizo el pedido
	 * 
	 * @return Devuelve la distancia en kilómetros
	 */
	public double getDistancia() {
		return distancia;
	}

	/**
	 * Establece la distancia de entrega (hasta 20 kilómetros)
	 * 
	 * @param distancia
	 */
	// REVISAR
	public void setDistancia(double distancia) {
		if (distancia > 20) {
			System.out.println("El domicilio se encuentra fuera del radio de entrega (20 kilómetros)");

		} else {
			this.distancia = distancia;
		}

	}

	/**
	 * Devuelve el precio de la gasolina
	 * 
	 * @return Devuelve el precio de la gasolina
	 */
	public double getPrecioGasolina() {
		return precioGasolina;
	}

	/**
	 * Establece el precio de la gasolina
	 * 
	 * @param precioGasolina
	 */
	public void setPrecioGasolina(double precioGasolina) {
		this.precioGasolina = precioGasolina;
	}

	/**
	 * Devuelve el número de repartidores
	 * 
	 * @return Devuelve el número de repartidores
	 */
	public int getNumeroDeRepartidores() {
		return numeroDeRepartidores;
	}

	/**
	 * Establece el número de repartidores disponibles. Si no hay ninguno disponible
	 * no se podrán hacer repartos a domicilio
	 * 
	 * @param numeroDeRepartidores
	 */
	public void setNumeroDeRepartidores(int numeroDeRepartidores) {
		if (numeroDeRepartidores > 0) {
			this.numeroDeRepartidores = numeroDeRepartidores;
		} else {
			System.out.println("No hay repartidores disponibles en este momento");
		}

	}

	/**
	 * {@value}
	 * 
	 * @return Devuelve el consumo de la moto
	 */
	public double getCONSUMO_MOTO() {
		return CONSUMO_MOTO;
	}

	/**
	 * @return consumoMoto
	 */
	public static double getConsumoMoto() {
		return CONSUMO_MOTO;
	}

	/**
	 * @return consumoCoche
	 */
	public static double getConsumoCoche() {
		return CONSUMO_COCHE;
	}

	/**
	 * @return tiempoPreparacion
	 */
	public static int getTiempoPreparacion() {
		return TIEMPO_PREPARACION;
	}

	/**
	 * @return velocidadPoblado
	 */
	public static int getVelocidadPoblado() {
		return VELOCIDAD_POBLADO;
	}

	/**
	 * @return unaHora
	 */
	public static int getUnaHora() {
		return UNA_HORA;
	}

	/**
	 * Método toString
	 * 
	 */

	@Override
	public String toString() {
		return "Reparto [tipoVehiculo=" + tipoVehiculo + ", distancia=" + distancia + ", precioGasolina="
				+ precioGasolina + ", numeroDeRepartidores=" + numeroDeRepartidores + "]";
	}

	/***
	 * Método tiempoDeEntrega calcula cuánto tarda en llegar el pedido. Suponemos
	 * una velocidad media de 40 km/h (máximo 40 kilómetros en 60 minutos) en
	 * poblado y aumentamos el precio de 5 en 5 kilómetros de distancia. Además le
	 * añadimos 15 minutos de preparación del pedido.
	 * 
	 * @return Devuelve el tiempo de entrega del pedido a domicilio
	 */

	public double tiempoDeEntrega() {
		double tiempoEntrega = 0;
		if (this.numeroDeRepartidores <= 0) {
			System.out.println("No hay repartidores disponibles en este momento. Entrega pendiente");
		} else {

		}
		if (this.distancia > 0 && this.distancia <= 5) {
			tiempoEntrega = (UNA_HORA * 5) / VELOCIDAD_POBLADO + TIEMPO_PREPARACION;
		} else if (this.distancia > 5 && this.distancia <= 10) {
			tiempoEntrega = (UNA_HORA * 10) / VELOCIDAD_POBLADO + TIEMPO_PREPARACION;
		} else if (this.distancia > 10 && this.distancia <= 15) {
			tiempoEntrega = (UNA_HORA * 15) / VELOCIDAD_POBLADO + TIEMPO_PREPARACION;
		} else if (this.distancia > 15 && this.distancia <= 20) {
			tiempoEntrega = (UNA_HORA * 20) / VELOCIDAD_POBLADO + TIEMPO_PREPARACION;
		} else {
			System.out.println("No es posible realizar la entrega a más de 20 kilómetros de distancia");
		}

		return tiempoEntrega;

	}

	/**
	 * El método calcular calcula el gasto de gasolina en el reparto a domicilio en
	 * función de si se hizo en coche o en moto. Al hacer viaje de ida y vuelta
	 * multiplicamos el gasto por 2.
	 * 
	 * @return gastoGasolina. Devuelve el gasto en gasolina en entregas a domicilio
	 * @see ICalcular
	 * 
	 */
	@Override
	public double calcular() {
		double gastoGasolina = 0;

		switch (this.tipoVehiculo) {
		case 1: {
			gastoGasolina = (CONSUMO_MOTO * this.distancia * precioGasolina) * 2;
			break;
		}
		case 2:
			gastoGasolina = (CONSUMO_COCHE * this.distancia * precioGasolina) * 2;
			break;
		}

		return gastoGasolina;

	}

}
