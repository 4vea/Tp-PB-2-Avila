package ar.edu.unlam.herencia;

public class Paquete {
	private Double alto;
	private Double ancho;
	private Double profundo;
	private Double peso;
	private Destino destino;
	
	public Paquete(Double alto, Double ancho, Double profundo, Double peso, Destino destino) {
	 this.alto = alto;
	 this.ancho = ancho;
	 this.profundo = profundo;
	 this.peso = peso;
	 this.destino = destino;
	}
	
	public Paquete(Double alto, Double ancho, Double profundo, Double peso) {
		 this.alto = alto;
		 this.ancho = ancho;
		 this.profundo = profundo;
		 this.peso = peso;
		}
	
	public Double calcularVolumen() {
		return alto * ancho * profundo;
	}

	public Double getAlto() {
		return alto;
	}

	public void setAlto(Double alto) {
		this.alto = alto;
	}

	public Double getAncho() {
		return ancho;
	}

	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}

	public Double getProfundo() {
		return profundo;
	}

	public void setProfundo(Double profundo) {
		this.profundo = profundo;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getCiudad() {
		return destino.getCiudad();
	}
	
	public String getDireccion() {
		return destino.getDireccion();
	}
	
	public String getDestinos() {
		return destino.toString();
	}
	
	public Destino getDestino() {
		return destino;
	}
	
	public void setDireccion(String direccion) {
		destino.setDireccion(direccion);
	}
	
	public void setCiudad(String ciudad) {
		destino.setCiudad(ciudad);
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	
}
