package es.pizzeria;

import es.pizzeriagestion.Empleado;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import es.pizzeriagestion.Contabilidad;
import es.pizzeriagestion.Pizzeria;
import es.pizzeriainterfaz.ICalcular;
import es.pizzeriainterfaz.ICambioTurno;

/**
 * Esta es la clase Principal del Proyecto. Contiene el método Main.
 * @author Jorge, Leticia, Ricardo y Nicolás
 * @version 1.0
 * 
 *
 */
public class ProyectoGrupoPizzeriaJorge {

	public static void main(String[] args) {
		
		/** 
		 * Para comenzar instanciamos la clase Empleado y generamos datos de acceso para los empleados mediante un HashMap
		 * 
		 */
		
		Empleado leticia = new Empleado("Comida", 10, "Manager", "Leticia", "001", "manager123");
		Empleado ricardo = new Empleado("Cena", 9, "Cocinero", "Ricardo", "002", "cocinero123");
		Empleado nico = new Empleado("Comida", 9, "Repartidor", "Nico", "003", "repartidor123");
		Empleado jorge = new Empleado("Comida", 7, "Administrativo", "Jorge", "004", "administrativo321");
				
		
		Map<String, Empleado> datosEmpleados = new HashMap<>();
		datosEmpleados.put(leticia.getId(), leticia);
		datosEmpleados.put(ricardo.getId(), ricardo);
		datosEmpleados.put(nico.getId(), nico);
		datosEmpleados.put(jorge.getId(), jorge);
		/**
		 * Definimos objeto lector de la clase Scanner para recoger los imputs del usuario a lo largo del programa.
		 */
		
		Scanner lector = new Scanner(System.in);
		
		/**
		 * Pedimos login al usuario. A través de un imput recogemos la id y la contraseña del empleado y llamamos al método login
		 * de la clase empleado para que compare los valores con los datos del HashMap.
		 */
		

		System.out.println("Introduzca el id del empleado: ");
		String id = lector.next();
		System.out.println("Introduzca la Contraseña del empleado: ");
		String contrasenia = lector.next();
			
		datosEmpleados.entrySet().forEach((entry) -> {
			String key = (String) entry.getKey();
			Empleado value = (Empleado) entry.getValue();

			if (value.login(id, contrasenia)) {
				System.out.println("Acceso concedido.");
				System.out.println("");
				
					int opcion = 0;
					do {
						System.out.println("¿Qué opción desea realizar?");
						System.out.println("1. Calcular horas extra:");
						System.out.println("2. Cambiar turno a empleado: ");
						System.out.println("3. Calcular caja diaria: ");
						System.out.println("4. Calcular beneficios del día: ");
						System.out.println("5. Crear menú");
						System.out.println("6. Añadir menú");
						System.out.println("7. Añadir Cocinero");
						System.out.println("8. Entregas a domicilio");
						System.out.println("10. Salir ");
						opcion = lector.nextInt();
						
						switch (opcion) {
							case 1: {
								System.out.println("Introduzca el nombre del empleado: ");
								String nombre = lector.next();
								
								datosEmpleados.entrySet().forEach((entryDos) -> {
									String keyDos = (String) entryDos.getKey();
									Empleado valueDos = (Empleado) entryDos.getValue();
									
									if (nombre.equalsIgnoreCase(valueDos.getNombreEmpleado())) {
										System.out.println("Introduzca el número de horas extra realizadas:");
										int horasExtra = lector.nextInt();
										System.out.println("El importe extra a abonar al empleado "+nombre+" es de "+(horasExtra*valueDos.calcular())+" €");
									}
									else {
										System.out.println("No consta empleado con dicho nombre.");
									}
								});
								break;	
								}
							case 2: {
								System.out.println("Introduzca el nombre del empleado: ");
								String nombre = lector.next();
								
								datosEmpleados.entrySet().forEach((entryDos) -> {
									String keyDos = (String) entryDos.getKey();
									Empleado valueDos = (Empleado) entryDos.getValue();
									
									if (nombre.equalsIgnoreCase(valueDos.getNombreEmpleado())) {
										valueDos.cambioTurno();
										System.out.println("Se ha cambiado el turno a "+valueDos.getTurno());
									}
									else {
										System.out.println("No consta empleado con dicho nombre.");
									}
								});
								break;	
							}	
							case 3: {
								System.out.println("Introduzca ingresos del día:");
								double ingresos = lector.nextDouble();
								System.out.println("Introduzca gastos del día:");
								double gastos = lector.nextDouble();
								System.out.println("Introduzca las propinas del día:");
								double propinas = lector.nextDouble();
								System.out.println("Introduzca el numero de empleados del día:");
								int numeroEmpleados = lector.nextInt();
								
								Contabilidad contabilidadDia = new Contabilidad(ingresos, gastos, propinas, numeroEmpleados);
								System.out.println("La caja del día de hoy es de: "+(contabilidadDia.calcular())+" €");
								break;
							}
							case 4: {
								System.out.println("Introduzca ingresos del día:");
								double ingresos = lector.nextDouble();
								System.out.println("Introduzca gastos del día:");
								double gastos = lector.nextDouble();
								System.out.println("Introduzca las propinas del día:");
								double propinas = lector.nextDouble();
								System.out.println("Introduzca el numero de empleados del día:");
								int numeroEmpleados = lector.nextInt();
								
								Contabilidad contabilidadDia = new Contabilidad(ingresos, gastos, propinas, numeroEmpleados);
								System.out.println("Los beneficios de hoy son de: "+(contabilidadDia.beneficio())+" €");
								break;
							}
							case 5:
								Menu menu = new Menu();
								System.out.println("¿Número de pizzas?");
								int numeroPizzas = lector.nextInt();
								double precioTotalMenus = 0;
								for (int i = 1; i <= numeroPizzas; i++) {
									System.out.println("------ Pizza " + i + "/" + numeroPizzas + " ------");
									System.out.println("¿Tamaño de la pizza?\n[1]Pequeña [2]Mediana [3]familiar: ");
									try {
										menu.setTamanioPizza(lector.nextInt());
									} catch (Exception e) {
										e.getMessage();
									}

									System.out.println("¿Tipo de masa?\n[1]Normal [2]Fina [3]Sin gluten: ");
									try {
										menu.setTipoMasa(lector.nextInt());
									} catch (Exception e) {

										e.getMessage();
									}

									System.out.println("¿Sabor de la pizza?\n[1]Vegetal [2]De carne [3]Carbonara: ");

									try {
										menu.setSaborPizza(lector.nextInt());
									} catch (Exception e) {

										e.getMessage();
									}

									System.out.println("¿Número de bebidas? ");
									try {
										menu.setNumeroDeBebidas(lector.nextInt());
									} catch (Exception e) {

										e.getMessage();
									}

									menu.aniadirMenu();
									precioTotalMenus += menu.calcular();
									System.out.println("Precio del menú = " + menu.calcular() + "€");
							
								}

								System.out.println("Precio total = " + precioTotalMenus + "€");
								break;
							
							case 6:
								
								System.out.println("\n¡HOLA! BIENVENIDO A PEDIDOS\n");
								
								Menus pizza = new Menus();
								Pedidos pedido = new Pedidos();
								ArrayList<String>totalPedido = new ArrayList<>();
								String comensal;
								
								System.out.println("¿Quiere sumar una pizza a su pedido?\n 0.Añadir pizza \n 2.Terminar pedido");
								int bucle = lector.nextInt();
								
								while(bucle != 2) {
									System.out.println("¿De qué quiere la pizza?\n 1.Vegetal.\n 2.Carne.\n 3.Carbonara.");
									pizza.setSaborPizza(lector.nextInt());
									System.out.println("\nPor favor, introduzaca el tamaño:\nEscriba pequeña, mediana o familiar.");
									pizza.setTamanioPizza(lector.next());
									System.out.println("\n¿Qué tipo de masa quiere?\nEscriba fina, normal o sin gluten.");
									pizza.setTipoMasa(lector.next());
									System.out.println("\nOk. Por último, ¿Cuántas bebidas quiere?\nEscriba en número cuántas.");
									pizza.setNumeroDeBebidas(lector.nextInt());
									System.out.println("¿De este tipo de pizza, quiere 1, 2 o más pizzas?\nEscriba en número cuántaso.");
									comensal = pedido.servicio(pizza, lector.nextInt());
									totalPedido.add(comensal);
									
									String str = "";
									for (String totales : totalPedido) {
										str+= totales;
									}
									
									System.out.println(str);
									
									System.out.println("\n¿Quiere sumar una pizza a su pedido?\n0. Terminar pedido\n1. Pedir otra pizza.");
									bucle = lector.nextInt();
									
									if(bucle == 0) {
										System.out.println("\nGenial, ya solo falta una cosa. ¿Pulsa 1 si vas a comer en el restaurante o 2 si el pedido es a domicilio");
										System.out.println("\nPedido generado: ");
										pedido.nuevoPedido(str);
									}
								}
							break;
								
							case 7:
								
								int tipoVehiculo = 0, numeroDeRepartidores = 0;
								double distancia = 0, precioGasolina = 0;

								System.out.println("Tipo de vehículo: ");
								try {
									tipoVehiculo = lector.nextInt();
								} catch (Exception e) {
									System.out.println("Revisa el tipo de vehículo: [1]moto [2]coche");
								}

								System.out.println("Distancia en kilómetros: ");
								try {
									distancia = lector.nextDouble();
								} catch (Exception e) {
									System.out.println("Revisa los kilómetros");
								}

								System.out.println("Precio litro gasolina: ");
								try {
									precioGasolina = lector.nextDouble();
								} catch (Exception e) {
									System.out.println("Revisa el precio de la gasolina");
								}

								System.out.println("Número de repartidores: ");
								try {
									numeroDeRepartidores = lector.nextInt();
								} catch (Exception e) {
									System.out.println("Revisa el número de repartidores");
								}

								Reparto reparto = new Reparto(tipoVehiculo, distancia, precioGasolina, numeroDeRepartidores);

								System.out.println("El tiempo de entrega estimado es de " + reparto.tiempoDeEntrega() + " minutos");
								System.out.println("El consumo de gasolina para el reparto es de " + reparto.calcular() + "€");
								
							case 8:{
								Reserva reserva = new Reserva();
									System.out.println("Introduce una nueva reserva:");
								int reservaUno = lector.nextInt();
								reserva.nuevaReserva();
									System.out.println("El número de reservas es: " + reservaUno);
							}
							case 9:{
								Reserva reserva1 = new Reserva();
									System.out.println("Indica cuántas reservas quieres quitar:");
								int reservaDos = lector.nextInt();
								reserva1.quitarReserva();
									System.out.println("El número de reservas es: " + reservaDos);
							}
							case 10:{
								Reserva reserva2 = new Reserva();
									System.out.println("Introduce el numero de personas de la reserva: ");
								int personas = lector.nextInt();
								reserva2.modReserva();
									System.out.println("El número de personas de la reseva es: " + personas);
							}
							case 11:{
								Inventario invent = new Inventario();
									System.out.println("Ver si hay suficiente iventario en el almacén");
								invent.reponer();
									System.out.println(invent);
							}
							case 12:{
								Inventario inventUno = new Inventario();
									System.out.println("Ver las bebidas y masas.");
								inventUno.almacen();
									System.out.println("Las bebidas y masas son: " + inventUno);
							}
							case 13:{
								Inventario inventDos = new Inventario();
									System.out.println("Modificar el almacén.");
									System.out.println("Introduce número de bebidas.");
								int bebidas = 0;
								bebidas = lector.nextInt();
									System.out.println("Introduce el número de masas");
								int numMasa = 0;
								numMasa = lector.nextInt();
								inventDos.modAlmacen(); 
									System.out.println("El almacén queda: " + inventDos);
							}
							case 14{
								Cliente cliente = new Cliente();
								cliente.descuento();
									System.out.println("El descuento del cliente es: " + cliente);
							}
							case 15: {
								System.exit(0);
							}
						}
						
						
					} while (opcion != 15);
				
				}
			}
			
		});
		
		
		
		
		
		
		
		lector.close();
	}

}
