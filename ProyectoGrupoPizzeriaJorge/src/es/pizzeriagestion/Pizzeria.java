package es.pizzeriagestion;

public class Pizzeria {
	
	private String nombre;
	private String numeroDeTelefono;
	private String horario;
	private String direccion;
	private int numeroDeEmpleados;
	
	public Pizzeria() {
	}
	public Pizzeria(String nombre, String numeroDeTelefono, String horario, String direccion, int numeroDeEmpleados) {
		this.nombre = nombre;
		this.numeroDeTelefono = numeroDeTelefono;
		this.horario = horario;
		this.direccion = direccion;
		this.numeroDeEmpleados = numeroDeEmpleados;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumeroDeTelefono() {
		return numeroDeTelefono;
	}
	public void setNumeroDeTelefono(String numeroDeTelefono) {
		this.numeroDeTelefono = numeroDeTelefono;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getNumeroDeEmpleados() {
		return numeroDeEmpleados;
	}
	public void setNumeroDeEmpleados(int numeroDeEmpleados) {
		this.numeroDeEmpleados = numeroDeEmpleados;
	}
	@Override
	public String toString() {
		return "Pizzeria [nombre=" + nombre + ", numedoDeTelefono=" + numeroDeTelefono + ", horario=" + horario
				+ ", direccion=" + direccion + ", numeroDeEmpleados=" + numeroDeEmpleados + "]";
	}
	
	
}
