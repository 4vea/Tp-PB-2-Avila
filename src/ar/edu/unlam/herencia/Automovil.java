package ar.edu.unlam.herencia;

public class Automovil extends Vehiculo {
	private Integer cantidadDeCiudades = 0;
	
	public Automovil() {
		this.limiteVolumen = 2.0;
		this.cantidadDestinos = 3;
		this.limiteCapacidadKg = 500.0;
		this.cantidadDePaquetes = new Paquete[10];
	}
	
	@Override
	protected Boolean puedeTransportar(Paquete paquete) {
		Boolean entraEnLosLimites = true;
		Boolean hayEspacioParaPaquetes = false;
		
		if(paquete.getDestino() == null) {
			return false;
		}
		
		if (paquete.calcularVolumen() >= limiteVolumen || paquete.getPeso() >= limiteCapacidadKg
				|| !calcularPesoDePaquetes()) {
			entraEnLosLimites = false;
		}

		for(int i = 0; i < cantidadDePaquetes.length; i++) {
			Boolean ciudadRepetida = false;
			if(cantidadDePaquetes[i] != null && cantidadDePaquetes[i].getCiudad().equals((paquete).getCiudad()) && !ciudadRepetida) {
				ciudadRepetida = true;
				cantidadDeCiudades += 1;
			}
			if(cantidadDePaquetes[i] != null && cantidadDePaquetes[i].getCiudad().equals(paquete.getCiudad()) && 
					cantidadDePaquetes[i].getDireccion().equals(paquete.getDireccion())) {
				return false;
			}
			if(cantidadDeCiudades > 3) {
				return false;
			}
		}

		for (Paquete p : cantidadDePaquetes) {
			if (p == null) {	
				hayEspacioParaPaquetes = true;
				break;
			}
		}

		return entraEnLosLimites && hayEspacioParaPaquetes;
	}

	@Override
	public Boolean agregarPaquete(Paquete paquete) {
		if (puedeTransportar(paquete)) {
			for (int i = 0; i < cantidadDePaquetes.length; i++) {
				if (cantidadDePaquetes[i] == null) {
					cantidadDePaquetes[i] = paquete;
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Automóvil";  
	}

	

}

