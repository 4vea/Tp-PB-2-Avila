package ar.edu.unlam.herencia;
import java.util.Arrays;

public abstract class Vehiculo {
	protected Double limiteVolumen;
	protected Double limiteCapacidadKg;
	protected Integer cantidadDestinos;
	protected Paquete[] cantidadDePaquetes;

	abstract protected Boolean puedeTransportar(Paquete paquete);

	abstract public Boolean agregarPaquete(Paquete paquete);

	public String getDestinos() {
	    String resultado = "";
	    for (Paquete p : cantidadDePaquetes) {
	        if (p != null) {
	            resultado += " \n" + p.getDestino().getCiudad() + " - " + p.getDestino().getDireccion() + "\n";
	        }
	    }
	    return resultado;
	}
	
	protected Boolean calcularPesoDePaquetes() {
		if (cantidadDePaquetes[0] != null && cantidadDePaquetes[1] != null) {
			if (cantidadDePaquetes[0].getPeso() + cantidadDePaquetes[1].getPeso() > limiteCapacidadKg) {
				return false;
			}
		}
		return true;
	}
}
