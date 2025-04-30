package ar.edu.unlam.herencia;

import java.util.HashSet;
import java.util.Set;

public class Automovil extends Vehiculo {
    private Set<Destino> destinos = new HashSet<>();

    public Automovil() {
        this.volumenMaximo = 2;
        this.pesoMaximo = 500;
    }

    @Override
    public boolean agregarPaquete(Paquete p) {
        if (destinos.contains(p.getDestino()) || destinos.size() < 3) {
            destinos.add(p.getDestino());
            return super.agregarPaquete(p);
        }
        return false;
    }
}
