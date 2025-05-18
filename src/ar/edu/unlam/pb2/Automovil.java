package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public class Automovil extends Vehiculo {
    private String patente;
    private Set<String> destinos;

    public Automovil(String patente) {
        super(null); // No usa ID, pero debemos pasar algo al constructor padre
        this.patente = patente;
        this.volumenMaximo = 2.0;
        this.pesoMaximo = 500.0;
        this.destinos = new HashSet<String>();
    }

    public String getPatente() {
        return this.patente;
    }

    public boolean agregarDestino(String destino) {
        if (destinos.size() >= 3) return false;
        return destinos.add(destino); // HashSet evita repetidos
    }

    @Override
    public boolean puedeTransportar(Paquete paquete) {
        if (getVolumenTotalCargado() + paquete.getVolumen() > volumenMaximo) return false;
        if (getPesoTotalCargado() + paquete.getPeso() > pesoMaximo) return false;
        return agregarPaquete(paquete);
    }

    public Set<String> getDestinos() {
        return destinos;
    }
}
