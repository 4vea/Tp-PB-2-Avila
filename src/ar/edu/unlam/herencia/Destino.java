package ar.edu.unlam.herencia;

public class Destino {
	private String ciudad;
	private String direccion = null;
	
	public Destino(String ciudad, String direccion) {
		this.ciudad = ciudad;
		this.direccion = direccion;
	}
	


	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "La ciudad es " + ciudad + ", direccion " + direccion;
	}
	
	
}
