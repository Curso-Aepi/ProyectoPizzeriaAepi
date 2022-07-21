package es.pizzeriagestion;

public class Cliente {
private String nombre, telefono, apellido, direccion;
/**
 * 
 * Creamos las variables de la clase cliente.
 * 
 */
	public Cliente() {
		super();
	}
/**
 * 
 * @param nombre
 * @param telefono
 * @param apellido
 * @param direccion
 */
	public Cliente(String nombre, String telefono, String apellido, String direccion) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.apellido = apellido;
		this.direccion = direccion;
	}
/**
 * Creamos los getter y setter de nuestra clase vliente
 * @return
 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
/**
 * cremos el constructor ToString.
 */
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", telefono=" + telefono + ", apellido=" + apellido + ", direccion="
				+ direccion + "]";
	}
/**
 * Cremos un método "descuento" que descuenta  un 15% del precio final.
 */
	//añadir descuento 
	public void descuento() {
		int descuento = (pago - (15*pago/100));
			
	}
}

